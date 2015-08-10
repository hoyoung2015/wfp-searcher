package net.hoyoung.app.wfp_searcher.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParentDao {
	@Autowired
	protected SessionFactory sessionFactory;
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
