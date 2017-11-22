package service

import domain.Group
import domain.Page

/**
 * Created by young on 2017/11/20.
 */
interface PageService {
    fun createPage(page: Page): String

    fun getAllPageByGroupId(group: Group): MutableList<Page>

    fun getOnePage(page: Page): Page
}