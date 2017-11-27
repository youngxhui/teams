package service.serviceImp

import baiduApi.bean.FaceDeteceResult
import baiduApi.service.FaceService
import dao.UserDao
import dao.daoImp.UserDaoImp
import domain.User
import org.apache.struts2.ServletActionContext
import service.UserService
import util.DateUtil
import util.GsonUtils
import java.io.File
import java.util.*

/**
 * Created by young on 2017/10/27.
 */
class UserServiceImp : UserService {


    var userDao: UserDao = UserDaoImp()
    private val faceService = FaceService()

    override fun register(user: User): Int {
        return userDao.insert(user)
    }

    override fun login(user: User): List<User>? {
        val userList = userDao.select(user)
        var passwordOfSql = ""

        for (users in userList) {
            passwordOfSql = users.password
        }

        if (user.password == passwordOfSql) {
            val birthday = userList[0].birthday
            val sqlDate = DateUtil.utilDate2SqlDate(birthday)
            userList[0].birthday = sqlDate
            return userList
        }
        return null
    }

    override fun update(user: User, headPic: File, headFileName: String): User {
        val path = ServletActionContext.getServletContext().getRealPath("/head/")
        val fileSuffix = headFileName.substringAfter('.')
        val newFileName = UUID.randomUUID().toString() + "." + fileSuffix
        val file = File(path + newFileName)
        if (!file.exists()) {
            file.mkdir()
        }
        headPic.copyTo(file, true)
        user.headPicPath = newFileName
        userDao.update(user)
        return user

    }

    private fun faceDelect(facePic: String): Boolean {
        val result = faceService.detect(facePic)
        println(result)
        val faceDeteceResult = GsonUtils.fromJson(result, FaceDeteceResult::class.java)

        if (result.isEmpty() || faceDeteceResult.resultNum == 0) {
            return false
        }

        // 人脸可信度至少大于0.9
        if (faceDeteceResult.result[0].faceProbability >= 0.9) {
            println("这TMD是人脸没错")
            return true
        }
        return false
    }

    /**
     * 人脸注册
     * @param facePic BASE64 图片格式
     * @return 返回示例
     * 0 表示返回失败
     * 1 表示成功
     */
    override fun addFace(facePic: String, user: User): Int {
        val faceDelect = faceDelect(facePic)
        return if (faceDelect) {
            // 注册人脸
            val result = faceService.add(facePic, user.uid.toString(), user.email)
            println(result)
            1
        } else {
            0
        }
    }

    override fun getUser(uid: Int): User = userDao.findUserById(uid)


}