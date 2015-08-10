package net.hoyoung.app.wfp_searcher.dao;

import net.hoyoung.app.wfp_searcher.entity.NewItem;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class NewItemDao extends ParentDao{
	private Logger logger = LoggerFactory.getLogger(getClass());
	public void save(NewItem newItem){
		logger.info("保存newItem...");
		System.err.println(newItem.toString());
		getSession().save(newItem);
	}
}
