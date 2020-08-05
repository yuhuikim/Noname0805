package notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.controller.CommandHandler;

public class ListNoticeHandler implements CommandHandler {
	private ListNoticeService listService = new ListNoticeService();

	@Override
	public String process(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		NoticePage articlePage = listService.getArticlePage(pageNo);
		req.setAttribute("articlePage", articlePage);
		
		return "/WEB-INF/view/listArticle.jsp";
	}
}
