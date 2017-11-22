package service.serviceImp

import dao.UserDao
import dao.daoImp.UserDaoImp
import domain.User
import service.UserService
import util.DateUtil

/**
 * Created by young on 2017/10/27.
 */
class UserServiceImp : UserService {


    lateinit var userDao: UserDao

    override fun register(user: User): Int {
        userDao = UserDaoImp()
        return userDao.insert(user)
    }

    override fun login(user: User): List<User>? {
        userDao = UserDaoImp()
        val userList = userDao.select(user)
        var passwordOfSql = ""

        for (users in userList) {
            passwordOfSql = users.password
        }

        if (user.password == passwordOfSql) {
            val birthday = userList[0].birthday
            val sqlDate = DateUtil.utilDate2SqlDate(birthday)
            userList[0].birthday = sqlDate
            return userList
        }
        return null
    }
}