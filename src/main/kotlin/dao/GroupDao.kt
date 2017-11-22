package dao

import domain.Group
import domain.User

/**
 * Created by young on 2017/11/19.
 */
interface GroupDao {
    /**
     * 向数据库增加Group
     * @param group 小组
     * @return 返回示例
     * 返回一个String，该Sting内容非0表示写入成功
     */
    fun insertGroup(group: Group): String

    /**
     * 通过人员信息查询小组
     * @param user
     * @return MutableList
     */
    fun queryGroupByUserInfo(user: User): MutableList<Group>

    fun updateGroup(group: Group)

    fun addPeople(group: Group): String

    fun queryGroupByAdminId(adminId: String): Group

    fun getGroupMenber(adminId: String): MutableList<Group>
}