package baiduApi.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by young on 2017/11/27.
 */
data class FaceIdentifyResult(
        @SerializedName("result")
        var sesult: IdentifyResult,
        @SerializedName("result_num")
        var resultNum: Int,
        @SerializedName("log_id")
        var logId: Long
) {


}