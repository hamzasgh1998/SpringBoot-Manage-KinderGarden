package tn.esprit.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkprograms.speech.translator.GoogleTranslate;

import tn.esprit.spring.entities.Comments;

import tn.esprit.spring.repository.CommentsRepository;
import tn.esprit.spring.repository.PostsRepository;



@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	CommentsRepository CommentsRepository;
	@Autowired
	PostsRepository PostsRepository;
	
	
	@Override
	public List<Comments> retrieveAllComments() {
		return (List<Comments>) CommentsRepository.findAll();

	}

	@Override
	public Comments addComments(Comments a,long idpost) {
		
		a.setPosts(PostsRepository.findById(idpost).get());
		return CommentsRepository.save(a);
	}

	@Override
	public void deleteComments(Long id) {
		CommentsRepository.deleteById(id);		
	}

	@Override
	public Comments updateComments(Comments u) {
		return CommentsRepository.save(u);

	}

	@Override
	public Comments retrieveComments(Long id) {
		return CommentsRepository.findById(id).get();

	}
	
	@Override
	public Long addOrUpdateComment(Comments Comment) {
		CommentsRepository.save(Comment);
		return Comment.getIdComment();
	}

	@Override
	public String translatecomment(Long idcomment) {
		String ToTranslate=CommentsRepository.findById(idcomment).get().getContent();
		String S="";
		try {
			 S=GoogleTranslate.translate("en",ToTranslate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ToTranslate+"  ----->"+" traduction:  "+S;
		
	}

	@Override
	public Boolean BadWordsFilter(long idcomment) {
		Boolean found=false;
		List<String> BadWords = new ArrayList<String>();
		BadWords.add("test1"); BadWords.add("test2"); BadWords.add("test3");BadWords.add("test4");BadWords.add("test5");BadWords.add("test5");BadWords.add("test6");BadWords.add("test7");BadWords.add("test8");BadWords.add("test9");
		String Content=CommentsRepository.findById(idcomment).get().getContent();
		
		
		 for(int i=0; i<BadWords.size(); i++)
	     {
	    	  System.out.println(BadWords.get(i).toUpperCase());
		if( found = Arrays.asList(Content.toUpperCase().split(" ")).contains(BadWords.get(i).toUpperCase()))
		 {break;}
	     }
		if(found){
		      System.out.println("bad words detected");
		      return true;
		}
		else
			System.out.println("not found");
		
		return false;
	}

	@Override
	public Comments addCommentytim(Comments c) {
		 return CommentsRepository.save(c);
	}

	@Override
	public List<Comments> commentofposts(Long idpost) {
		
		return CommentsRepository.commentofposts(idpost);
	}

	

	
	


}
