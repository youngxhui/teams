package action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import service.FileService
import service.serviceImp.FileServiceImp
import java.io.File

/**
 * Created by young on 2017/11/5.
 */
class FileAction : ActionSupport() {

    var fileId: Int = 0
    var uid: String = ActionContext.getContext().session["uid"].toString()
    var type: Int = 0
    lateinit var upload: Array<File>
    lateinit var uploadContentType: Array<String>
    lateinit var uploadFileName: Array<String>
    lateinit var fileService: FileService

    fun uploadFile(): String {
        println("uid is $uid and file name is $upload type is $type")
        fileService = FileServiceImp()
        fileService.uploadFile(upload, uploadContentType, uploadFileName, uid, type)
        return Action.SUCCESS
    }

    fun showAllFiles(): String {
        fileService = FileServiceImp()
        ActionContext.getContext().put("files", fileService.getAllFiles(uid))
        return Action.SUCCESS
    }

    fun deleteFile(): String {
        fileService = FileServiceImp()
        return fileService.deleteFile(fileId)
    }

    fun getOwnerFiles(): String {
        println("uid is $uid")
        fileService = FileServiceImp()
        ActionContext.getContext().put("files", fileService.getOwnerFiles(uid))
        println("request is ${fileService.getOwnerFiles(uid)}")
        return Action.SUCCESS
    }
}