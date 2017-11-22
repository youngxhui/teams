package action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.ModelDriven
import domain.SignInfo
import domain.User
import service.SignService
import service.serviceImp.SignServiceImp

/**
 * Created by young on 2017/10/25.
 */
class SignAction : ActionSupport(), ModelDriven<SignInfo> {
    lateinit var uid: String
    var signInfo = SignInfo()
    private lateinit var signService: SignService

    override fun getModel(): SignInfo = signInfo

    override fun execute(): String {
        val user = User()
        user.uid = uid.toInt()
        signInfo.user = user
        signService = SignServiceImp()
        signService.sign(signInfo)
        return Action.SUCCESS
    }

}