package util

/**
 * Created by young on 2017/11/5.
 */
object IconUtil {
    fun getIcon(suffix: String): String {


        val iconType = when (suffix.toLowerCase()) {
            "png" -> "img.png"
            "jpg" -> "img.png"
            "ppt" -> "ppt.png"
            "pptx" -> "ppt.png"
            "xls" -> "excle.png"
            "xlsx" -> "excle.png"
            "doc" -> "word.png"
            "docx" -> "word.png"
            "md" -> "markdown.png"
            "py" -> "python.png"
            "sql" -> "sql.png"
            "txt" -> "txt.png"
            "zip" -> "zip.png"
            "7z" -> "zip.png"
            "pdf" -> "pdf.png"
            "c" -> "cpp.png"
            "cpp" -> "cpp.png"
            "java" -> "java.png"
            "swift" -> "swift.png"
            "xml" -> "xml.png"
            else -> "na.png"
        }

        return "icon/$iconType"
    }
}