package blog.api.model;

import java.io.Serializable;

import blade.plugin.sql2o.Table;

@Table(value = "posts_categories", PK = "post_uuid")
public class PostCategories implements Serializable {

	private static final long serialVersionUID = -3754339405000559442L;
	private String post_uuid;
	private String category;

	public String getPost_uuid() {
		return post_uuid;
	}

	public void setPost_uuid(String post_uuid) {
		this.post_uuid = post_uuid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
