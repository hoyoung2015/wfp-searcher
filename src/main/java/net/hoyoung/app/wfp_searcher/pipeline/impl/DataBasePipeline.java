package net.hoyoung.app.wfp_searcher.pipeline.impl;

import net.hoyoung.app.wfp_searcher.dao.NewItemDao;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class DataBasePipeline implements Pipeline {
	private NewItemDao newItemDao;
	
	public void setNewItemDao(NewItemDao newItemDao) {
		this.newItemDao = newItemDao;
	}

	@Override
	public void process(ResultItems resultItems, Task task) {
		// System.err.println(resultItems.getRequest().getUrl());
		newItemDao.insertTargetHtml(resultItems.getRequest().getUrl(),
				resultItems.get("body").toString());
	}
}
