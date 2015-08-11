package net.hoyoung.app.wfp_searcher.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="new_item")
public class NewItem {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String summary;
	@Column(name="target_url")
	private String targetUrl;
	@Column(name="target_html")
	private String targetHtml;
	//创建时间
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	public String getTargetHtml() {
		return targetHtml;
	}
	public void setTargetHtml(String targetHtml) {
		this.targetHtml = targetHtml;
	}
	//新闻发布时间
	@Column(name="publish_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishDate;
	
	//新闻来源
	private String sourceName;
	
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "NewItem [id=" + id + ", title=" + title + ", summary="
				+ summary + ", targetUrl=" + targetUrl + ", createDate="
				+ createDate + ", publishDate=" + publishDate + ", sourceName="
				+ sourceName + "]";
	}
	
}
