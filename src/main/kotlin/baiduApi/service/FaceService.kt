package baiduApi.service

import util.BaiDuAuthUtil
import util.HttpUtil
import java.net.URLEncoder


/**
 * Created by young on 2017/11/23.
 */
class FaceService {

    /**
     * 人脸检测
     */
    fun detect(imgStr: String): String {
        val url = "https://aip.baidubce.com/rest/2.0/face/v1/detect"
        try {
            val imgParam = URLEncoder.encode(imgStr, "UTF-8")
            //"&face_fields=" + "age,beauty,expression,faceshape,gender,glasses,landmark,race,qualities" +
            val param = "max_face_num=" + 1 + "&face_fields" + "gender" + "&image=" + imgParam
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            val accessToken = BaiDuAuthUtil.auth
            return HttpUtil.post(url, accessToken, param)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    /**
     * @param imgStr BASE64图片
     * @param uid 用户id
     * @param email 电子邮箱
     * @param groupId 小组id 默认为0
     */
    fun add(imgStr: String, uid: String, email: String): String {
        val groupId = "test_group"
        val url = "https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/add"
        try {
            val imgParam = URLEncoder.encode(imgStr, "UTF-8")
            val param = "uid=$uid&user_info=$email&group_id=$groupId&images=$imgParam"

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            val accessToken = BaiDuAuthUtil.auth
            val logId = HttpUtil.post(url, accessToken, param)
            return logId
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    fun identify(imgStr: String): String {
        // 请求url
        val url = "https://aip.baidubce.com/rest/2.0/face/v2/identify"
        try {
            val imgParam = URLEncoder.encode(imgStr, "UTF-8")
            val param = "group_id=test_group&user_top_num=1&face_top_num=1&images=$imgParam"

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            val accessToken = BaiDuAuthUtil.auth

            val result = HttpUtil.post(url, accessToken, param)
            println(result)
            return result
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }
}