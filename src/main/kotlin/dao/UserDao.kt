package dao

import domain.User

/**
 * Created by young on 2017/10/29.
 */
interface UserDao {
    /**
     * 保存用户信息
     * @param user 用户
     * @return 返回示例
     * 0 表示插入错误
     * 非0 表示插入成功
     */
    fun insert(user: User): Int

    /**
     * 查找用户信息
     * @param user
     * @return UserList 返回示例
     * userList.size == 0 表示没有结果
     * userList.size != 0 表示返回成功
     */
    fun select(user: User): MutableList<User>
}