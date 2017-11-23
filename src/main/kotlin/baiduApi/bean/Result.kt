package baiduApi.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by young on 2017/11/23.
 */
data class Result(
        var location: Location,
        @SerializedName("face_probability")
        var faceProbability: Double,
        @SerializedName("rotation_angle")
        var rotationAngle: Int,
        var yaw: Double,
        var pitch: Double,
        var roll: Double
) {
}