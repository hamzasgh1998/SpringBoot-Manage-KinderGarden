package tn.esprit.spring.service;

import java.awt.AWTException;
import java.util.List;


import tn.esprit.spring.entities.Posts;
import tn.esprit.spring.entities.User;

public interface PostsService {
	public List<Posts> retrieveAllPosts();
	Posts addPosts(Posts p);
	 void deletePosts(Long id);
	 Posts updatePosts(Posts u);
	 Posts retrievePosts(Long id);
	 void affecterCommentsAPost(Long IdComment,Long IdPost);
	 public int CountLikesParPosts(Long IdPost);
	public int CountDisLikesParPosts(Long IdPost);
	public Long addOrUpdatePosts(Posts Post,User u) ;

	public Long addOrUpdatePostsAdmin(Posts Post,User u) ;

	
	public int addLike(Long IdPost);
	public void addDislike(Long IdPost);
	public void dropDislike(Long IdPost);
	public void dropLike(Long IdPost);
	public void addSignal(Long IdPost);
	public boolean deleteSignaledPost(Long IdPost);
	public String TranslatePostDesc(Long IdPost);
	public String notifyUser() throws AWTException;
	public void addphoto(long idpost,String img);
	public boolean Sendmail(long userid);
	public Posts addPosts2(Posts p,String img);
	public Boolean BadWordsFilter(long idpost);
	public List<Posts> Reacts();
	

}
