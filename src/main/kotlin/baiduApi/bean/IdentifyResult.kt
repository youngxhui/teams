package baiduApi.bean

/**
 * Created by young on 2017/11/27.
 */
data class IdentifyResult(
        var uid: String,
        var scores: Array<Double>,
        var groupId: String,
        var userInfo: String) {

}