package action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.ModelDriven
import domain.User
import service.UserService
import service.serviceImp.UserServiceImp


/**
 * Created by young on 2017/10/24.
 */
class UserAction : ActionSupport(), ModelDriven<User> {

    var user = User()

    lateinit var userService: UserService

    override fun getModel(): User = user
//
//    fun registerValidate() {
//        if (user.username.length in 5..9) {
//
//        } else {
//
//        }
//    }


    fun login(): String {
        userService = UserServiceImp()
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
        userService = UserServiceImp()
        val flag = userService.register(user)
        return if (flag == 1) {
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
        userService = UserServiceImp()
        return Action.SUCCESS
    }
}