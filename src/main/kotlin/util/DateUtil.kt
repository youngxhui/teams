package util

import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by young on 2017/10/29.
 */
object DateUtil {

    fun utilDate2SqlDate(date: Date): java.sql.Date {
        return java.sql.Date(date.time)
    }

    fun getNowDate(): java.sql.Date {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val d1 = sdf.parse(Date().toString()) //先把字符串转为util.Date对象
        val d2:java.sql.Date = java.sql.Date(d1.time) //再转换为sql.Date对象
        return d2
    }
}