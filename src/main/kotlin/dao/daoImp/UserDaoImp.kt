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

    /**
     * 更新用户信息
     * @param user user对象
     * @return 返回一个已经更新的user信息
     */
    override fun update(user: User): User {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        session.update(user)
        transaction.commit()
        session.close()
        return User()
    }

    /**
     * 通过id查询User
     * @param uid 查询id
     * @return User 返回一个用户
     */
    override fun findUserById(uid: Int): User {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        println("uid in dao is $uid")
        val user: User = session.get(User::class.java, uid) as User
        transaction.commit()
        session.close()
        return user
    }
}