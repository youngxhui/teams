package baiduApi.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by young on 2017/11/23.
 */
data class FaceDeteceResult(
        @SerializedName("result_num")
        var resultNum: Int,
        var result: MutableList<Result>,
        @SerializedName("log_id")
        var logId: Long
)