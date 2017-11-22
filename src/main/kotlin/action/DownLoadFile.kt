package action

import com.opensymphony.xwork2.ActionSupport
import java.io.FileInputStream
import java.io.InputStream
import java.net.URLEncoder

/**
 * Created by young on 2017/11/6.
 */
class DownLoadFile : ActionSupport() {
    /**
     * 文件下载
     */
    var downFileName: String = ""
        set(downFileName) {
            field = String(downFileName.toByteArray(charset("UTF-8")))
        }
        get() = URLEncoder.encode(field, "UTF-8")
    var contentType: String = ""

    var inputPath: String = ""
        set(inputPath) {
            field = String(inputPath.toByteArray(charset("UTF-8")))
        }

    fun getTargetFile(): InputStream {
        val inputStream: InputStream?
        inputStream = FileInputStream(inputPath)
        return inputStream
    }

}
