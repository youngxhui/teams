package service.serviceImp

import com.opensymphony.xwork2.ActionContext
import dao.SignDao
import dao.daoImp.GroupDaoImp
import dao.daoImp.SignDaoImp
import domain.SignInfo
import domain.User
import service.SignService

/**
 * Created by young on 2017/11/9.
 */
class SignServiceImp : SignService {


    private val userInfo: User = ActionContext.getContext().session["userInfo"] as User
    private val ERROR = 2
    private var signDao: SignDao = SignDaoImp()
    private var defaultLatitude: Double = 0.0
    private var defaultLongitude: Double = 0.0
    private var rang: Int = 0


    override fun sign(signInfo: SignInfo): String {
        getData()
        // 计算范围
        val defaultLatitude = 38.012849
        val defaultLongitude = 112.457627
        val range = Math.sqrt(Math.pow((defaultLatitude - signInfo.latitude), 2.0)
                + Math.pow((defaultLongitude - signInfo.longitude), 2.0))
        // 每百米误差
        return if (range > 0.0015 * ERROR) {
            // 签到失败
            "error"
        } else {
            signDao.save(signInfo)
            "success"
        }
    }

    private fun getData(): Boolean {
        val groupDao = GroupDaoImp()
        var groupList = groupDao.queryGroupByUserInfo(userInfo)
        return if (groupList.size == 0) {
            false
        } else {
            val group = groupList[0]
            rang = group.locError
            defaultLatitude = group.lat
            defaultLongitude = group.lng
            true
        }
    }
}