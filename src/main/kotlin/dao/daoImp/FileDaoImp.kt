package dao.daoImp

import dao.FileDao
import domain.Files
import util.SessionFactory
import java.io.Serializable

/**
 * Created by young on 2017/11/5.
 */
class FileDaoImp : FileDao {

    override fun uploadFile(file: Files): Int {

        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val flag = session.save(file)
        transaction.commit()
        session.close()
        return flag as Int
    }

    override fun downLoadFile(id: Serializable): Files {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val file: Files = session.get(Files::class.java, id) as Files
        transaction.commit()
        session.close()
        return file
    }

    override fun getAllFiles(uid: String): MutableList<Files> {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val hql = "from Files where type = 0 or user.uid = ?"
        val query = session.createQuery(hql)
        query.setString(0, uid)
        val fileList = query.list()
        transaction.commit()
        session.close()
        return fileList as MutableList<Files>
    }

    override fun deleteFile(id: Serializable) {

        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val file = session.get(Files::class.java, id)
        session.delete(file)
        transaction.commit()
        session.close()
    }

    override fun getFile(id: Serializable): Files {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val file = session.get(Files::class.java, id)
        transaction.commit()
        session.close()
        return file as Files
    }

    override fun getOwnerFile(uid: String): MutableList<Files> {
        println("dao uid is $uid")
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val hql = "from Files Where user.uid = ?"
        val query = session.createQuery(hql)
        query.setString(0, uid)
        val fileList = query.list()
        transaction.commit()
        session.close()
        return fileList as MutableList<Files>
    }
}