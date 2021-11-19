package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Posts;

public interface CommentsService {
	List<Comments> retrieveAllComments();
	Comments addComments (Comments a,long idpost);
	Comments addCommentytim(Comments c);
	 void deleteComments(Long id);
	 Comments updateComments(Comments u);
	 Comments retrieveComments(Long id);
	 public Long addOrUpdateComment(Comments Comment);
	 public String translatecomment(Long idcomment);
	 public Boolean BadWordsFilter(long idcomment);
	 public List<Comments> commentofposts(Long idpost);
	
	 

}
