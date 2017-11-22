package interceptor

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionInvocation
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.interceptor.AbstractInterceptor

/**
 * Created by young on 2017/11/6.
 */
class LoginInterceptor : AbstractInterceptor() {
    override fun intercept(invocation: ActionInvocation?): String {
        val content = invocation?.invocationContext
        val userInfo = content?.session?.get("userInfo")
        var result: String = Action.LOGIN
        if (userInfo == null) {
            (invocation?.action as ActionSupport).addActionError("请先登录")
        } else {
            result = invocation.invoke()
        }
        return result
    }
}