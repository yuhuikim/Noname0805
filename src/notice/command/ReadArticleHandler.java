package notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ReadArticleService;
import mvc.controller.CommandHandler;

public class ReadNoticeHandler implements CommandHandler {
	private ReadNoticeService readService = new ReadNoticeService();
	
	@Override
	public String process(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		
		try {
			
		    NoticeData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData);
			return "/WEB-INF/view/readArticle.jsp";
			
		} catch (NoticeNotFoundException | NoticeContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
			return null;
		}
	}
}








