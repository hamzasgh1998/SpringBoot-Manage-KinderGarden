package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Comments;

import tn.esprit.spring.service.CommentsService;

@RestController
public class CommentsRestController {
	@Autowired
	CommentsService CommentsService;
	
	//http://localhost:8082/SpringMVC/servlet/getComments
	@GetMapping("/getComments")
	 @ResponseBody
	 public List<Comments> getComments() {
	 return CommentsService.retrieveAllComments();
	
	 }
	
	//http://localhost:8082/SpringMVC/servlet/getComments
		@GetMapping("/getCommentsofPosts/{id-post}")
		 @ResponseBody
		 public List<Comments> getCommentsofPosts(@PathVariable("id-post")Long idpost) {
		 return CommentsService.commentofposts(idpost);
		
		 }
		
	
	//http://localhost:8082/SpringMVC/servlet/getCommentsParId/
		@GetMapping("/getCommentsParId/{id-comment}")
		 @ResponseBody
		 public Comments getCommentsParId(@PathVariable("id-comment") Long idcomment) {
		 return CommentsService.retrieveComments(idcomment);
		
		 }
	
		//http://localhost:8082/SpringMVC/servlet/addCommentsytim
		 @PostMapping("/addCommentsytim")
		 @ResponseBody
		 public Comments addComments( @RequestBody Comments comment) {
			 CommentsService.addCommentytim(comment);

		 return comment;
		 }
	
	//http://localhost:8082/SpringMVC/servlet/addComments/(numpost)
	 @PostMapping("/addComments/{post-id}")
	 @ResponseBody
	 public Comments addComments(@PathVariable("post-id") Long postid, @RequestBody Comments comment) {
		 CommentsService.addComments(comment,postid);

	 return comment;
	 }
	 
	 
	// http://localhost:8082/SpringMVC/servlet/removeComments/{}
	  @DeleteMapping("/removeComments/{comment-id}")
	  @ResponseBody
	  public void removeComment(@PathVariable("comment-id") Long commentid) {
		 CommentsService.deleteComments(commentid);
	  }
	  
	  
	// http://localhost:8082/SpringMVC/servlet/modifyComment
	  @PutMapping("/modifyComment")
	  @ResponseBody
	  public Comments modifyPost(@RequestBody Comments comment) {
		  CommentsService.addOrUpdateComment(comment);
	  return comment;
	 
	  }
	  
	  
	//http://localhost:8082/SpringMVC/servlet/TranslateComment
		@GetMapping("/TranslateComment/{comment-id}")
		 @ResponseBody
		 public String TranslateComment(@PathVariable("comment-id") Long idcomment) {
		 return CommentsService.translatecomment(idcomment);
		
		 }
		
		
		
		//http://localhost:8082/SpringMVC/servlet/BadWordFilterComment/
		 @GetMapping("/BadWordFilterComment/{comment-id}")
		 @ResponseBody
		 public String BadWordsFilterComment(@PathVariable("comment-id") Long idcomment) {
			 if(CommentsService.BadWordsFilter(idcomment))
			 {
				 return "Bad Words Found ";
			 }

		return "no bad words found";
		 }
	  
	

}
