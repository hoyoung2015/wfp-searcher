package net.hoyoung.app.wfp_searcher;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.selector.Html;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
@Component
public class Searcher {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static String BAIDU_NEWS_URL = "http://news.baidu.com/advanced_news.html";
	private Set<String> keywords;
	private WebClient webClient;
	@Autowired
	private SaveHandler saveHandler;
	public Searcher() {
		super();
		keywords = new TreeSet<String>();
	}
	public Searcher addKeyword(String key){
		keywords.add(key);
		return this;
	}
	
	public void run(){
		String query = getQurey();
		if(query==null){
			logger.warn("关键词是空的");
			System.exit(0);
		}
		logger.info("搜索关键字："+query);
		webClient = new WebClient(BrowserVersion.CHROME);
		try {
			HtmlPage htmlPage = webClient.getPage(BAIDU_NEWS_URL);
			HtmlForm form = htmlPage.getFormByName("f");
			HtmlInput kwInput = form.getInputByName("q1");
			kwInput.setValueAttribute(query);
			
			HtmlSelect pageSelect = form.getSelectByName("rn");
			pageSelect.setSelectedAttribute("50", true);
			
			HtmlInput submitButton = form.getInputByName("submit");
			
			HtmlPage resultPage = submitButton.click();
			
			if(resultPage.getWebResponse().getStatusCode()==200){
				Html resultHtml = new Html(resultPage.getWebResponse().getContentAsString());
				//开线程来保存
				saveHandler.save(resultHtml);
				
//				Selectable selectable = resultHtml.xpath("//div[@class='result']");
//				List<Selectable> nodes = selectable.nodes();
//				for (Selectable sele : nodes) {
//					Selectable titleSele = sele.xpath("//h3[@class='c-title']/a");
//					String title = titleSele.get().replaceAll("(</?em[^>]*>)|(</?a[^>]*>)", "");
//					String targetUrl = titleSele.xpath("//*/@href").get();
//					Selectable sumSele = sele.xpath("//div[@class='c-summary']");
//					String sourceAndDate = sumSele.xpath("//p/text()").get();
//					
//					String[] ss = sourceAndDate.split("\\u00A0\\u00A0");
//					String sourceName = ss[0];
//					
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
//					Date publishDate = sdf.parse(ss[1]);
//					
//					String summary = sumSele.get().replaceAll("(<span.*/span>)|(<p.*/p>)|(</?div[^>]*>)|(</?em[^>]*>)", "");
//					
//					NewItem newItem = new NewItem();
//					newItem.setCreateDate(new Date());
//					newItem.setPublishDate(publishDate);
//					newItem.setSourceName(sourceName);
//					newItem.setTargetUrl(targetUrl);
//					newItem.setTitle(title);
//					newItem.setSummary(summary);
//					
//				}
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String getQurey(){
		if(keywords.size()==0){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (String key : keywords) {
			if(StringUtils.isEmpty(key)){
				continue;
			}
			sb.append(" "+key.replace(" ", ""));
		}
		String s = sb.toString();
		return StringUtils.isEmpty(s)?null:s;
	}
}
