package service.serviceImp

import dao.GroupDao
import dao.daoImp.GroupDaoImp
import domain.Group
import domain.User
import service.GroupService

/**
 * Created by young on 2017/11/19.
 */
class GroupServiceImp : GroupService {
    private var groupDao: GroupDao = GroupDaoImp()

    override fun registerGroup(group: Group): String {
        val flag = groupDao.insertGroup(group)
        return if (flag.isEmpty()) {
            "error"
        } else {
            "success"
        }
    }

    override fun queryGroupByUserId(user: User): Group? {
        val list = groupDao.queryGroupByUserInfo(user)
        return if (list.size == 0) {
            null
        } else {
            val group = list[0]
            group
        }
    }

    override fun updateNote(group: Group, user: User): Boolean {
        val groups = queryGroupByUserId(user)
        return if (groups == null) {
            false
        } else {
            groups.note = group.note
            groupDao.updateGroup(groups)
            true
        }
    }

    override fun updateLoc(group: Group, user: User): Boolean {
        val groups = queryGroupByUserId(user)
        return if (groups == null) {
            false
        } else {
            if (group.locError < 1) {
                group.locError = 1
            }
            groups.locError = group.locError
            groups.lat = group.lat
            groups.lng = group.lng
            groupDao.updateGroup(groups)
            true
        }
    }

    override fun addPeople(adminId: String, user: User): Boolean {
        val group = groupDao.queryGroupByAdminId(adminId)
        println("gid is ${group.gid}")
        return if (group.gid != -1) {
            group.user = user
            groupDao.insertGroup(group)
            true
        } else {
            false
        }
    }

    override fun getGroupMenber(adminId: String): MutableList<User> {
        val groupList = groupDao.getGroupMenber(adminId)
        var userList: MutableList<User> = ArrayList()
        groupList.map { userList.add(it.user) }
        return userList
    }
}
