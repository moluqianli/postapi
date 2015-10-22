package blog.api.model;

import java.io.Serializable;
import java.util.Date;

import blade.plugin.sql2o.Table;

@Table(value = "comments", PK = "comment_uuid")
public class Comment implements Serializable {
	private static final long serialVersionUID = 6762239138343566885L;
	private String comment_uuid;
	private String post_uuid;
	private String author;
	private String content;
	private boolean approved;
	private Date submission_date;

	public String getComment_uuid() {
		return comment_uuid;
	}

	public void setComment_uuid(String comment_uuid) {
		this.comment_uuid = comment_uuid;
	}

	public String getPost_uuid() {
		return post_uuid;
	}

	public void setPost_uuid(String post_uuid) {
		this.post_uuid = post_uuid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Date getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}

}
