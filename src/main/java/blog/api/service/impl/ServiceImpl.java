package blog.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.blade.annotation.Component;

import blade.plugin.sql2o.Model;
import blog.api.model.Comment;
import blog.api.model.Post;
import blog.api.model.PostCategories;
import blog.api.service.Service;

@Component
public class ServiceImpl implements Service {
	
	private Model<Post> postModel = new Model<Post>(Post.class);
	private Model<PostCategories> catModel = new Model<PostCategories>(PostCategories.class);
	private Model<Comment> commentModel = new Model<Comment>(Comment.class);
	
	@Override
    public String createPost(String title, String content, List<String> categories) {
    	
    	UUID postUuid = UUID.randomUUID();
        
    	postModel.insert()
    	.param("post_uuid", postUuid.toString())
    	.param("title", title)
    	.param("content", content)
    	.param("publishing_date", new Date()).executeAndCommit();
    	
    	for(String category : categories){
    		catModel.insert()
        	.param("post_uuid", postUuid.toString())
        	.param("category", category).executeAndCommit();
    	}
    	
        return postUuid.toString();
    }

    @Override
    public String createComment(String post, String author, String content) {
        UUID commentUuid = UUID.randomUUID();
        
        commentModel.insert()
        .param("comment_uuid", commentUuid.toString())
        .param("post_uuid", post)
        .param("author", author)
        .param("content", content)
        .param("approved", false)
        .param("date", new Date()).executeAndCommit();
        
        return commentUuid.toString();
    }

    @Override
    public List<Post> getAllPosts() {
    	List<Post> postList = postModel.select().fetchList();
    	if(null != postList && postList.size() > 0){
    		for(Post post : postList){
    			List<String> cats = getCategoriesFor(post.getPost_uuid());
    			System.out.println(cats);
    			post.setCategories(cats);
    		}
    	}
    	return postList;
    }

    private List<String> getCategoriesFor(String post_uuid) {
    	return catModel.select("select category from posts_categories")
    	.eq("post_uuid", post_uuid).executeAndFetch(String.class);
    }

    @Override
    public List<Comment> getAllCommentsOn(String post) {
    	return commentModel.select().eq("post_uuid", post).fetchList();
    }

    @Override
    public boolean existPost(String post) {
    	return postModel.count().eq("post_uuid", post).fetchCount() > 0;
    }

}
