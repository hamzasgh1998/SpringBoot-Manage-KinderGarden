package tn.esprit.spring.controller;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.mail.imap.protocol.Item;
import com.vdurmont.emoji.*;


import tn.esprit.spring.entities.Posts;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.PostsService;
import tn.esprit.spring.service.UserService;

@RestController
public class PostsRestController {
	@Autowired
	PostsService PostsService;
	
	
	@Autowired
	UserService UserService;
	//private static final Logger l = Logger.getLogger(PostsRestController.class);
	
	
	
	//AFFICHER LES POSTS POST
	//http://localhost:8082/SpringMVC/servlet/getPosts
	@GetMapping("/getPosts")
	 @ResponseBody
	 public List<Posts> getPosts() {
	 return PostsService.retrieveAllPosts();
	
	 }
	
	//AFFICHER LES POSTS POST
		//http://localhost:8082/SpringMVC/servlet/getPosts
		@GetMapping("/getPostsPop")
		 @ResponseBody
		 public List<Posts> getPostsPop() {
		 return PostsService.Reacts();
		
		 }
	
	//AFFICHER LES POSTS POST
		//http://localhost:8082/SpringMVC/servlet/getPosts
		@GetMapping("/getPostsParId/{post-id}")
		 @ResponseBody
		 public Posts getPostsParId(@PathVariable("post-id") Long postid) {
		 return PostsService.retrievePosts(postid);
		
		 }
	//AJOUTER UN POST
	//http://localhost:8082/SpringMVC/servlet/addPosts
		 @PostMapping("/addPosts/{user-id}")
		 @ResponseBody
		 public Posts addPosts(@RequestBody Posts post,@PathVariable("user-id") Long userid) {
			User u= UserService.getUserId(userid);
			 PostsService.addOrUpdatePosts(post,u);

		 return post;
		 }
		//AJOUTER UN POST
		//http://localhost:8082/SpringMVC/servlet/addPosts
			 @PostMapping("/addPostsAdmin/{user-id}")
			 @ResponseBody
			 public Posts addPostsAdmin(@RequestBody Posts post,@PathVariable("user-id") Long userid) {
				User u= UserService.getUserId(userid);
				 PostsService.addOrUpdatePostsAdmin(post, u);

			 return post;
			 }
			  
		 
		//upload file
			//http://localhost:8082/SpringMVC/servlet/upload/file/{post-id}
			@PostMapping(value = "/upload/file/{post-id}",
				     consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
				     produces = {MediaType.APPLICATION_JSON_VALUE} )
			 @ResponseBody
				public ResponseEntity<String> uploadSingleFile(@RequestParam MultipartFile file ,@PathVariable("post-id") Long postid)  {
				//  l.info("Request contains, File: " + file.getOriginalFilename());
				  // Add your processing logic here
				  
				  String s=("D:/PI4SAE/image/"+file.getOriginalFilename());
				
				  PostsService.addphoto(postid, s);
				  return ResponseEntity.ok("Success");
				}
		 
			
				
		 
		// trraduction post
			//http://localhost:8082/SpringMVC/servlet/TranslatePost
				@GetMapping("/TranslatePost/{post-id}")
				 @ResponseBody
				 public String TranslatePost(@PathVariable("post-id") Long postid) {
				 return PostsService.TranslatePostDesc(postid);
				
				 }
				
				
				 //Modifier Post
				// http://localhost:8082/SpringMVC/servlet/modifyPost
				  @PutMapping("/modifyPost")
				  @ResponseBody
				  public Posts modifyPost(@RequestBody Posts post,@RequestBody User user) {
					  PostsService.addOrUpdatePosts(post,user);
				  return post;
				 
				  }
				  
				  
				  
				//FILTER BAD WORDS
					//http://localhost:8082/SpringMVC/servlet/BadWordFilter/
				  		@PutMapping("/BadWordFilter/{post-id}")
						 @ResponseBody
						 public String BadWordsFilter(@PathVariable("post-id") Long postid) {
							 if(PostsService.BadWordsFilter(postid))
							 { 
								 for (int i = 0; i < 5; i++) {
									 PostsService.addSignal(postid);									
									 }
								 return "bad words found and post signaled +5 signals";
								 	
								 	}
							 return "this post have no bad words"; 
								 
							 

						 }
			 
			 
			//DELETE POST PAR ID
				// http://localhost:8082/SpringMVC/servlet/removePosts/{post-id}
				  @DeleteMapping("/removePosts/{post-id}")
				  @ResponseBody
				  public void removePost(@PathVariable("post-id") Long postid) {
					  PostsService.deletePosts(postid);
				  }
				
				
				
					 
					 
					  
					  //Signaler un post
					// http://localhost:8082/SpringMVC/servlet/Signaler
					  @PutMapping("/Signaler/{post-id}")
					  @ResponseBody
					  public void SignalPost(@PathVariable("post-id") Long postid) {
						  PostsService.addSignal(postid);
						  
					 
					 
					  }
					  
					  //add like
					// http://localhost:8082/SpringMVC/servlet/Like/
					  @PutMapping("/Like/{post-id}")
					  @ResponseBody
					  public void addlikePost(@PathVariable("post-id") Long postid) {
						  PostsService.addLike(postid);

					  }
					  
					  
					  //add dislike
					// http://localhost:8082/SpringMVC/servlet/Dislike/
					  @PutMapping("/Dislike/{post-id}")
					  @ResponseBody
					  public void adddislikePost(@PathVariable("post-id") Long postid) {
						  PostsService.addDislike(postid);
						 
					  }
					  
					  //droplike
					// http://localhost:8082/SpringMVC/servlet/droplike/
					  @PutMapping("/droplike/{post-id}")
					  @ResponseBody
					  public void DroplikePost(@PathVariable("post-id") Long postid) {
						  PostsService.dropLike(postid);
						  
					 
					  }
					  
					  //drop dislike
					// http://localhost:8082/SpringMVC/servlet/dropdislike/
					  @PutMapping("/dropdislike/{post-id}")
					  @ResponseBody
					  public void DropdislikePost(@PathVariable("post-id") Long postid) {
						  PostsService.dropDislike(postid);
						  
					 
					  }
					  
						 // afficher nbr like et dislike par post id
						// http://localhost:8082/SpringMVC/servlet/Reacts/
						  @GetMapping("/Reacts/{post-id}")
						  @ResponseBody
						  public String CountReacts(@PathVariable("post-id") Long postid) {
							int Dislikes= PostsService.CountDisLikesParPosts(postid);
							int Likes=PostsService.CountLikesParPosts(postid);
							
							System.out.println(Dislikes+EmojiParser.parseToUnicode(":-1:")+"   "+Likes+EmojiParser.parseToUnicode(":+1:"));
							return Dislikes+EmojiParser.parseToUnicode(":-1:")+"Dislikes  👍 "+Likes+EmojiParser.parseToUnicode(":+1:")+"Likes";
								
						 
						  }
						  
						  //delete and send mail to user's signaled post
							// http://localhost:8082/SpringMVC/servlet/removeSignaledPost/{post-id}/
						  @DeleteMapping("/removeSignaledPost/{post-id}")
						  @ResponseBody
						  public String removeSignaledPost(@PathVariable("post-id") Long postid) {
							Long userid = PostsService.retrievePosts(postid).getParent().getIdUser();
							System.out.println(userid);
							
							 
								if( PostsService.deleteSignaledPost(postid))
								{
									 PostsService.Sendmail(userid);
									 return "This Post is Signaled more than 2 times,a Mail Sent to The User";
								}
								return "The post's signal is lower than 2 Signals";
								
							
						  }
							  
							  
							//Send mail
								//http://localhost:8082/SpringMVC/servlet/sendmail/
								@GetMapping("/sendmail/{user-id}")
								 @ResponseBody
								 public String SendMail(@PathVariable("user-id") Long userid) {
								 if(PostsService.Sendmail(userid))
									 return "mail sent";
								 return "not sent";
								
								 }
		 
						
		  
		  
						
						  


		  
		
		  
		  
		  
			
		/*	
			//system notifcation
			//http://localhost:8082/SpringMVC/servlet/notif
			@GetMapping("/notif/{post-id}")
			 @ResponseBody
			 public String notif(@PathVariable("post-id") Long postid) throws AWTException {
				
				if (SystemTray.isSupported()) {
					return "supporta";
					//PostsRestController td = new PostsRestController();
		             //td.displayTray();
		             
		         } else {
		             return "System tray not supported!";
		         }
				
				
					
			 }
			
			public void displayTray() throws AWTException {
		        //Obtain only one instance of the SystemTray object
		        SystemTray tray = SystemTray.getSystemTray();

		        //If the icon is a file
		        Image image = Toolkit.getDefaultToolkit().createImage("image/notif.png");
		        //Alternative (if the icon is on the classpath):
		        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

		        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		        //Let the system resize the image if needed
		        trayIcon.setImageAutoSize(true);
		        //Set tooltip text for the tray icon
		        trayIcon.setToolTip("Jardin d'enfant");
		        tray.add(trayIcon);
		        
		        
		        

		        trayIcon.displayMessage("Hello", "You post have been signaled 3 or more times it may be deleted by the admin", MessageType.WARNING);
		    }
			*/
		
			
			
			
				 
					/*
					//http://localhost:8082/SpringMVC/servlet/imageDisplay
					@RequestMapping(value = "/imageDisplay/{post-id}", method = RequestMethod.GET)
					 @ResponseBody
					  public void showImage(@RequestParam("post-id") Long postId, HttpServletResponse response,HttpServletRequest request) 
					          throws ServletException, IOException{

						Posts post=PostsService.retrievePosts(postId);
					    //Item item = itemService.get(itemId);        
					    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
					    response.getOutputStream().write(post.getImg().getBytes());


					    response.getOutputStream().close();
				  
					  }*/
			
			
			
			
			
		  
		  

}
