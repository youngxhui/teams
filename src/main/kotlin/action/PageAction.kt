package action

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.ModelDriven
import domain.Group
import domain.Page
import service.PageService
import service.serviceImp.PageServiceImp

/**
 * Created by young on 2017/11/19.
 */
class PageAction : ActionSupport(), ModelDriven<Page> {
    var page = Page()

    override fun getModel(): Page = page

    private lateinit var pageService: PageService

    private val groupInfo: Group = ActionContext.getContext().session["group"] as Group

    fun createPage(): String {
        page.group = groupInfo
        pageService = PageServiceImp()
        return pageService.createPage(page)
    }

    fun getGroupPage(): String {
        pageService = PageServiceImp()
        val pages = pageService.getAllPageByGroupId(groupInfo)
        ActionContext.getContext().put("pageList", pages)
        return Action.SUCCESS
    }

    fun getOnePage(): String {
        pageService = PageServiceImp()
        val page = pageService.getOnePage(page)
        ActionContext.getContext().put("pages", page)
        return Action.SUCCESS
    }
}