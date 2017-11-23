package util

import com.baidu.aip.face.AipFace

/**
 * Created by young on 2017/11/22.
 */
object FaceUtil {

    private val APP_ID: String = "10422861"
    private val API_KEY: String = "nzjkDnqjXptsw2vG4besa7jx"
    private val SECRET_KEY: String = "2GPlHQwO3OrbMDuv6kAb3E28iaABq9aI"

    fun getClient(): AipFace {
        val client = AipFace(APP_ID, API_KEY, SECRET_KEY)
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000)
        client.setSocketTimeoutInMillis(60000)
        return client
    }

}


