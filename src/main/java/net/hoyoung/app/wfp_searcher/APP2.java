package net.hoyoung.app.wfp_searcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class APP2 {
	private static String[] config = { "src/main/resources/spring.xml" };
	private static ApplicationContext context;
	static {
		context = new FileSystemXmlApplicationContext(config);
	}
	public static void main(String[] args) {
		
		Searcher searcher = context.getBean(Searcher.class);
		searcher.addKeyword("武汉钢铁")
		.addKeyword("绿色")
		.run();
	}

}
