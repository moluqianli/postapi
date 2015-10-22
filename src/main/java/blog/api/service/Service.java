package blog.api.service;

import java.util.List;

import blog.api.model.Comment;
import blog.api.model.Post;

public interface Service {
	
	String createPost(String title, String content, List<String> categories);

	String createComment(String post, String author, String content);

	List<Post> getAllPosts();

	List<Comment> getAllCommentsOn(String post);

	boolean existPost(String post);
}
