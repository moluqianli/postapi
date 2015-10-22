package blog.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import blade.plugin.sql2o.Table;

@Table(value = "posts", PK = "post_uuid")
public class Post implements Serializable{

	private static final long serialVersionUID = -3754339405000559442L;
	private String post_uuid;
	private String title;
	private String content;
	private Date publishing_date;
	private List<String> categories;

	public String getPost_uuid() {
		return post_uuid;
	}

	public void setPost_uuid(String post_uuid) {
		this.post_uuid = post_uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishing_date() {
		return publishing_date;
	}

	public void setPublishing_date(Date publishing_date) {
		this.publishing_date = publishing_date;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
