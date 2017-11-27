package util

import domain.User
import org.junit.Test

/**
 * Created by young on 2017/11/26.
 */
class ValidatorTest {
    @Test
    fun test() {
        var user = User()
        user.username = "zzz"
        var message = Validator.getMessage(user)
        message.map { println(it) }
    }
}