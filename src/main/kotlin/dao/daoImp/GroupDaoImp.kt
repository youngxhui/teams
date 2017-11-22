package dao.daoImp

import dao.GroupDao
import domain.Group
import domain.User
import org.intellij.lang.annotations.Language
import util.SessionFactory

/**
 * Created by young on 2017/11/19.
 */
class GroupDaoImp : GroupDao {

    override fun insertGroup(group: Group): String {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val flag = session.save(group)
        transaction.commit()
        session.close()
        return flag.toString()
    }

    override fun queryGroupByUserInfo(user: User): MutableList<Group> {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        @Language("HQL")
        val hql = "from Group where user.uid=?"
        val query = session.createQuery(hql)
        query.setInteger(0, user.uid)
        val list = query.list()
        transaction.commit()
        session.close()
        return list as MutableList<Group>
    }

    override fun updateGroup(group: Group) {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        session.update(group)
        transaction.commit()
        session.close()
    }

    override fun addPeople(group: Group): String {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val id = session.save(group)
        transaction.commit()
        session.close()
        return id as String
    }

    override fun queryGroupByAdminId(adminId: String): Group {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val hql = "from Group where adminId = ?"
        val query = session.createQuery(hql)
        query.setString(0, adminId)
        val list = query.list()
        transaction.commit()
        session.close()
        return if (list.size != 0) {
            list[0] as Group
        } else {
            val groups = Group()
            groups.gid = -1
            groups
        }
    }

    override fun getGroupMenber(adminId: String): MutableList<Group> {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val hql = "from Group  where  adminId = ?"
        val sql = ""
        val query = session.createQuery(hql)
        query.setString(0, adminId)
        var groupList = query.list()
        transaction.commit()
        session.close()
        return groupList as MutableList<Group>
    }
}