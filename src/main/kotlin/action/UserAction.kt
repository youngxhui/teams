package action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.ModelDriven
import domain.User
import service.UserService
import service.serviceImp.UserServiceImp
import java.io.File


/**
 * Created by young on 2017/10/24.
 */

class UserAction : ActionSupport(), ModelDriven<User> {

    var user = User()
    lateinit var pic: String

    lateinit var headPic: File
    lateinit var headPicFileName: String

    private var userService: UserService = UserServiceImp()

    override fun getModel(): User = user

    fun login(): String {
        val bool = userService.login(user)
        var result: String = Action.ERROR
        val user = bool?.get(0)
        if (user != null) {
            ActionContext.getContext().session.put("userInfo", user)
            result = Action.SUCCESS
        } else {
            ActionContext.getContext().put("loginError", this.getText("loginError"))
        }
        return result
    }

    fun register(): String {
        val flag = userService.register(user)
        return if (flag != 0) {
            Action.LOGIN
        } else {
            Action.ERROR
        }
    }

    fun clear(): String {
        val session = ActionContext.getContext().session
        session.remove("userInfo")
        return Action.SUCCESS
    }

    fun updateUserInfo(): String {
        val userInSession: User = ActionContext.getContext().session.get("userInfo") as User
        user.uid = userInSession.uid
        val userNew = userService.update(user, headPic, headPicFileName)
        ActionContext.getContext().session.clear()
        println("")
        ActionContext.getContext().session.put("userInfo", userNew)
        return Action.SUCCESS
    }

    fun registerPicture(): String {
        if (pic.isEmpty()) {
            return Action.ERROR
        }
        val userInfo: User = ActionContext.getContext().session["userInfo"] as User
        val flag = userService.addFace(pic, userInfo)
        if (flag == 0) {
            ActionContext.getContext().put("faceError", "请让脸部位于摄像头中间")
            return Action.ERROR
        }
        return Action.SUCCESS
    }

    fun findUser(): String {
        val userInfo = ActionContext.getContext().session["userInfo"] as User
        val user = userService.getUser(userInfo.uid)
        ActionContext.getContext().session.put("userInfo", user)
        return Action.SUCCESS
    }
}