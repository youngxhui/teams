package service.serviceImp

import dao.FileDao
import dao.daoImp.FileDaoImp
import domain.Files
import domain.User
import org.apache.struts2.ServletActionContext
import service.FileService
import util.IconUtil
import java.io.File
import java.io.Serializable
import java.util.*


/**
 * Created by young on 2017/11/5.
 */
class FileServiceImp : FileService {

    lateinit var file: File
    private lateinit var fileDao: FileDao
    override fun uploadFile(files: Array<File>, contentType: Array<String>, fileName: Array<String>, uid: String, type: Int) {
        fileDao = FileDaoImp()
        val user = User()
        user.uid = uid.toInt()
        val realPath = ServletActionContext.getServletContext().getRealPath("/files")
        for (i in 0 until files.size) {
            val fileSuffix = fileName[i].substringAfter('.')
            val icon = IconUtil.getIcon(fileSuffix)
            val name = UUID.randomUUID().toString() + "." + fileName[i].substringAfter('.')
            val file = File("$realPath/$name")
            val path = file.canonicalPath
            val saveFile: Files = Files()
            saveFile.path = path.replace("\\", "/")
            saveFile.icon = icon
            saveFile.name = fileName[i]
            saveFile.contentType = contentType[i]
            saveFile.type = type
            saveFile.user = user
            saveFile.size = (files[i].length() / 1024f / 1024f)
            fileDao.uploadFile(saveFile)
            files[i].copyTo(file, true)
        }
    }

    override fun downLoadFile(id: Int): Files {
        fileDao = FileDaoImp()
        return fileDao.downLoadFile(id as Serializable)
    }

    override fun getAllFiles(uid: String): MutableList<Files> {
        fileDao = FileDaoImp()
        return fileDao.getAllFiles(uid)
    }

    override fun deleteFile(id: Int): String {
        fileDao = FileDaoImp()
        val fileInDatabase = fileDao.getFile(id)
        val f = File(fileInDatabase.path)
        var flag = false
        if (f.isFile && f.exists()) {
            f.delete()
            flag = true
        }
        return if (flag) {
            fileDao.deleteFile(id)
            "success"
        } else {
            "error"
        }
    }

    override fun getOwnerFiles(uid: String): MutableList<Files> {
        fileDao = FileDaoImp()
        return fileDao.getOwnerFile(uid)
    }
}