package blog.api.model;

import java.io.Serializable;

public class NewCommentPayload implements Serializable {

	private static final long serialVersionUID = 1L;
	private String author;
	private String content;

	public boolean isValid() {
		return author != null && !author.isEmpty() && content != null
				&& !content.isEmpty();
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

}