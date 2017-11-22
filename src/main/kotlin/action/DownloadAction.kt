package action

import com.opensymphony.xwork2.ActionSupport

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream
import java.io.UnsupportedEncodingException

/**
 * @author young
 * @date 2017/11/7
 */
class DownloadAction : ActionSupport() {

    //文件名
    //用UTF-8重新编码文件名,解决中文乱码
    var fileName: String? = null
        @Throws(UnsupportedEncodingException::class)
        set(fileName) {
            if (fileName != null) {
                field = String(fileName.toByteArray(charset("UTF-8")))
            }
        }

    val targetFile: InputStream
        @Throws(UnsupportedEncodingException::class, FileNotFoundException::class)
        get() = FileInputStream(fileName!!)

    companion object {
        private val serialVersionUID = -3036349171314867490L
    }

}
