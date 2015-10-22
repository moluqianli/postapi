package blog.api;

import java.util.List;

import com.blade.Blade;
import com.blade.Bootstrap;
import com.blade.annotation.Inject;

import blade.kit.json.JSONKit;
import blade.kit.json.JSONValue;
import blade.kit.log.Logger;
import blade.plugin.sql2o.Sql2oPlugin;
import blog.api.model.NewCommentPayload;
import blog.api.model.NewPostPayload;
import blog.api.service.Service;

/**
 * 启动配置类
 * 
 * @author biezhi
 */
public class App extends Bootstrap {

	private static final Logger LOGGER = Logger.getLogger(App.class);
	
	private static final int HTTP_BAD_REQUEST = 400;
	
	@Inject
	private Service service;
	
	public static <T> String dataToJson(List<T> data) {
		return JSONValue.toJSONString(data);
	}
	
	@Override
	public void init() {
		
		Blade blade = Blade.me();
		
		// 配置路由
		blade.get("/posts", (request, response) -> {
			response.status(200);
			response.json(dataToJson(service.getAllPosts()));
			return null;
		});
		
		// 保存
		blade.post("/post/save", (request, response) ->{
			LOGGER.info(" request body = " + request.body());
			NewPostPayload creation = JSONKit.parse(request.body(), NewPostPayload.class);   
			if (!creation.isValid()) {
				response.status(HTTP_BAD_REQUEST);
				response.text("");
				return null;
			}
			
			String id = service.createPost(creation.getTitle(),
					creation.getContent(), creation.getCategories());
			response.status(200);
			response.text(id);
			return null;
		});
		
		// 添加一条评论
		blade.post("/posts/:post_id/comments", (request, response) ->{
			LOGGER.info(" request body = " + request.body());
			
			NewCommentPayload creation = JSONKit.parse(request.body(), NewCommentPayload.class);
			if (!creation.isValid()) {
				response.status(HTTP_BAD_REQUEST);
				response.json("");
				return null;
			}
			
			String post = request.param("post_id");
			
			if (!service.existPost(post)) {
				response.status(400);
				response.json("");
				return null;
			}
			
			String id = service.createComment(post, creation.getAuthor(),
					creation.getContent());
			response.status(200);
			response.json(id);
			
			return null;
		});
		
		blade.get("/posts/:post_id/comments", (request, response) -> {
			String post = request.param("post_id");
			if (!service.existPost(post)) {
				response.status(400);
				response.json("");
				return null;
			}
			response.status(200);
			response.json(dataToJson(service.getAllCommentsOn(post)));
			return null;
		});

		blade.ioc("blog.api.service.impl", "blog.api.route");

		// 配置数据库
		Sql2oPlugin sql2oPlugin = blade.plugin(Sql2oPlugin.class);
		sql2oPlugin.config("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/blog_api", "root", "root");
		sql2oPlugin.run();
		
	}
	
	public static void main(String[] args) throws Exception {
		Blade.me().app(App.class).start();
	}

}
