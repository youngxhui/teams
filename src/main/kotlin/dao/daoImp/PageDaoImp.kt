package dao.daoImp

import dao.PageDao
import domain.Group
import domain.Page
import org.intellij.lang.annotations.Language
import util.SessionFactory

/**
 * Created by young on 2017/11/20.
 */
class PageDaoImp : PageDao {
    override fun insertPage(page: Page): String {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val serializable = session.save(page)
        transaction.commit()
        session.close()
        return serializable.toString()
    }

    override fun getAllPageByGroupInfo(group: Group): MutableList<Page> {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        @Language("HQL")
        val hql = "from Page where group.gid = ?"
        val query = session.createQuery(hql)
        query.setInteger(0, group.gid)
        val list = query.list()
        transaction.commit()
        session.close()
        return list as MutableList<Page>
    }

    override fun getOnePage(page: Page): Page {
        val session = SessionFactory.getSession()
        val transaction = session.beginTransaction()
        val page: Page = session.get(Page::class.java, page.pid) as Page
        transaction.commit()
        session.close()
        return page
    }
}