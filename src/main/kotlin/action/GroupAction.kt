package action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.ModelDriven
import domain.Group
import domain.User
import service.GroupService
import service.serviceImp.GroupServiceImp

/**
 * Created by young on 2017/11/19.
 */
class GroupAction : ActionSupport(), ModelDriven<Group> {

    var group = Group()

    override fun getModel(): Group = group

    private var groupService: GroupService = GroupServiceImp()

    fun registerGroup(): String {
        val userInfo: User = ActionContext.getContext().session["userInfo"] as User
        group.user = userInfo
        group.adminId = userInfo.uid.toString()
        return groupService.registerGroup(group)
    }

    fun getGroups(): String {
        val userInfo: User = ActionContext.getContext().session["userInfo"] as User
        val group = groupService.queryGroupByUserId(userInfo)
        return if (group != null) {
            ActionContext.getContext().session.put("group", group)
            Action.SUCCESS
        } else {
            Action.ERROR
        }
    }

    fun updateNote(): String {
        val userInfo: User = ActionContext.getContext().session["userInfo"] as User

        val flag = groupService.updateNote(group, userInfo)
        return if (flag) {
            Action.SUCCESS
        } else {
            Action.ERROR
        }
    }

    fun updateLoc(): String {
        val userInfo: User = ActionContext.getContext().session["userInfo"] as User

        val flag = groupService.updateLoc(group, userInfo)
        return if (flag) {
            Action.SUCCESS
        } else {
            ActionContext.getContext().put("updateError", "更新失败")
            Action.ERROR
        }
    }

    fun addGroup(): String {
        var adminId = group.adminId
        var userInfo: User = ActionContext.getContext().session["userInfo"] as User
        val flag = groupService.addPeople(adminId, userInfo)
        return if (flag) {
            println("success")
            Action.SUCCESS
        } else {
            println("Error")
            Action.ERROR
        }
    }

    fun getMember(): String {
        var group = ActionContext.getContext().session["group"] as Group
        var userList = groupService.getGroupMenber(group.adminId)
        ActionContext.getContext().session.put("menber", userList)
        return Action.SUCCESS
    }
}