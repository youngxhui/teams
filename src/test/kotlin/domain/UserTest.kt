package domain

import org.junit.Test
import javax.validation.ConstraintViolation
import javax.validation.Validation

/**
 * Created by young on 2017/11/26.
 */
class UserTest {


    @Test
    fun testVali() {
        val factory = Validation.buildDefaultValidatorFactory()
        val validator = factory.validator
        var user = User()
        user.username = "4"

        var validate: Set<ConstraintViolation<User>> = validator.validate(user)
        validate.map { println(it.message) }


    }
}