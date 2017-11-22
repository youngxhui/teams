package dao

import domain.Group
import domain.Page

/**
 * Created by young on 2017/11/20.
 */
interface PageDao {
    fun insertPage(page: Page): String
    fun getAllPageByGroupInfo(group: Group): MutableList<Page>
    fun getOnePage(page: Page): Page

}