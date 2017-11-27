package util

import java.util.*
import javax.validation.ConstraintViolation
import javax.validation.Validation

/**
 * Created by young on 2017/11/26.
 */
object Validator {

    /**
     * @param clazz 传入一个类
     * @return 返回错误信息的list
     */
    fun <T> getMessage(clazz: T): ArrayList<String> {
        val messageList = ArrayList<String>()
        val factory = Validation.buildDefaultValidatorFactory()
        val validator = factory.validator
        val validate: Set<ConstraintViolation<T>> = validator.validate(clazz)
        validate.map { messageList.add(it.message) }
        return messageList
    }
}