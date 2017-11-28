package dao.daoImp

import domain.Group
import org.junit.Test

/**
 * Created by young on 2017/11/27.
 */
class PageDaoImpTest {
    @Test
    fun getAllPageByGroupInfo() {
        var pageDao = PageDaoImp()
        var group = Group()
        group.adminId = "6"
        val allPageByGroupInfo = pageDao.getAllPageByGroupInfo(group)
        allPageByGroupInfo.map {
            println(it)
        }
    }

}