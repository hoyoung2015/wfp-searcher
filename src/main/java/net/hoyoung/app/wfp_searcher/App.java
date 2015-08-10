package net.hoyoung.app.wfp_searcher;

import java.io.IOException;
import java.net.MalformedURLException;

import us.codecraft.webmagic.selector.Html;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	WebClient webClient = new WebClient(BrowserVersion.CHROME);
    	webClient.getOptions().setCssEnabled(false);
    	webClient.getOptions().setJavaScriptEnabled(false);
    	try {
    		HtmlPage htmlPage = webClient.getPage("http://news.baidu.com/advanced_news.html");
    		HtmlForm form = htmlPage.getFormByName("f");
    		HtmlInput kwInput = form.getInputByName("q1");
    		kwInput.setValueAttribute("武汉钢铁 绿色");
    		
    		HtmlSelect pageSelect = form.getSelectByName("rn");
    		pageSelect.setSelectedAttribute("50", true);
    		
    		HtmlInput submitButton = form.getInputByName("submit");
    		
    		Page newsPage = submitButton.click();
    		
    		Html html = new Html(newsPage.getWebResponse().getContentAsString());
    		
    		String s = html.xpath("//p[@id='page']").toString();
    		System.out.println(s);
    		System.err.println(webClient.getWebWindows().size());
    		
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
