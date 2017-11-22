package dao.daoImp

import dao.UserDao
import domain.User
import util.SessionFactory

/**
 * Created by young on 2017/10/27.
 */
class UserDaoImp : UserDao {

    override fun insert(user: User): Int {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val flag = session.save(user)
        transaction.commit()
        session.close()
        return flag as Int
    }

    override fun select(user: User): MutableList<User> {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val hql = "from User where email =?"
        val query = session.createQuery(hql)
        query.setString(0, user.email)
        val userList: MutableList<User> = query.list() as MutableList<User>
        transaction.commit()
        session.close()
        return userList
    }

}