package service.serviceImp

import dao.PageDao
import dao.daoImp.PageDaoImp
import domain.Group
import domain.Page
import service.PageService

/**
 * Created by young on 2017/11/20.
 */
class PageServiceImp : PageService {

    private lateinit var pageDao: PageDao

    override fun createPage(page: Page): String {
        pageDao = PageDaoImp()
        val flag = pageDao.insertPage(page)
        return if (flag.isEmpty()) {
            "error"
        } else {
            "success"
        }
    }

    override fun getAllPageByGroupId(group: Group): MutableList<Page> {
        pageDao = PageDaoImp()
        return pageDao.getAllPageByGroupInfo(group)
    }

    override fun getOnePage(page: Page): Page {
        pageDao = PageDaoImp()
        val page = pageDao.getOnePage(page)
        return page
    }
}