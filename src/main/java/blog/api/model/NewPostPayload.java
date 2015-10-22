package blog.api.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
	
public class NewPostPayload implements Serializable {
		
		private static final long serialVersionUID = 1L;
		private String title;
		private List<String> categories = new LinkedList<String>();
		private String content;

		public boolean isValid() {
			return title != null && !title.isEmpty() && content != null
					&& !content.isEmpty();
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}