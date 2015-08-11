package net.hoyoung.app.wfp_searcher.savehandler;

import java.util.List;

import net.hoyoung.app.wfp_searcher.entity.NewItem;
import us.codecraft.webmagic.selector.Html;

public interface SaveHandler {
	public List<NewItem> save(Html html);
}
