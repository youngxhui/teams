package dao.daoImp

import dao.SignDao
import domain.SignInfo
import util.SessionFactory

/**
 * Created by young on 2017/11/9.
 */
class SignDaoImp : SignDao {


    override fun save(signInfo: SignInfo) {

        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val flag = session.save(signInfo)
        transaction.commit()
        session.close()
    }
}