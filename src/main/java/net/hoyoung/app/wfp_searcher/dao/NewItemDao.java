package net.hoyoung.app.wfp_searcher.dao;

import java.util.List;

import net.hoyoung.app.wfp_searcher.entity.NewItem;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class NewItemDao extends ParentDao{
	private Logger logger = LoggerFactory.getLogger(getClass());
	public void save(NewItem newItem){
		logger.info("保存newItem...");
		System.err.println(newItem.toString());
		getSession().save(newItem);
	}
	public void insertTargetHtml(String targetUrl,String htmlContent){
		List<NewItem> list = this.getSession().createCriteria(NewItem.class)
		.add(Restrictions.eq("targetUrl", targetUrl))
		.list();
		for (NewItem newItem : list) {
			newItem.setTargetHtml(htmlContent);
		}
		/*this.getSession().createQuery("update NewItem n set n.targetHtml='"+htmlContent+"' where n.targetUrl='"+targetUrl+"'")
		.executeUpdate();*/
	}
}
