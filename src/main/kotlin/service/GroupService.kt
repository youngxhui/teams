package service

import domain.Group
import domain.User

/**
 * Created by young on 2017/11/19.
 */
interface GroupService {
    fun registerGroup(group: Group): String

    fun queryGroupByUserId(user: User): Group?

    fun updateNote(group: Group, user: User): Boolean

    fun updateLoc(group: Group, user: User): Boolean

    fun addPeople(adminId: String, user: User): Boolean

    fun getGroupMenber(adminId: String): MutableList<User>
}