package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Posts;
@Repository
public interface PostsRepository extends CrudRepository <Posts,Long> {
	@Query(value="SELECT nbr_like FROM Posts where id_post= ?1",nativeQuery =true)
	public int CountLikesParPosts(Long IdPost);
	
	@Query(value="SELECT nbr_dislike FROM Posts where id_post= ?1",nativeQuery =true)
	public int CountDisLikesParPosts(Long IdPost);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Posts p  SET NBR_LIKE = nbr_like+1 where p.ID_POST = :id_post",nativeQuery = true)
	public int addlike(@Param ("id_post")Long IdPost);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Posts p  SET NBR_LIKE = nbr_like-1 where p.ID_POST = :id_post",nativeQuery = true)
	public int droplike(@Param ("id_post")Long IdPost);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Posts p  SET NBR_DISLIKE = nbr_dislike+1 where p.ID_POST = :id_post",nativeQuery = true)
	public int addDislike(@Param ("id_post")Long IdPost);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Posts p  SET NBR_DISLIKE = nbr_dislike-1 where p.ID_POST = :id_post",nativeQuery = true)
	public int dropDislike(@Param ("id_post")Long IdPost);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Posts p  SET NBR_SIGNAL = nbr_signal+1 where p.ID_POST = :id_post",nativeQuery = true)
	public int addSignal(@Param ("id_post")Long IdPost);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Posts p  SET IMG = :img where p.ID_POST = :id_post",nativeQuery = true)
	public int addPhoto(@Param ("id_post")Long IdPost,@Param ("img") String img);
	
	@Query(value="SELECT * FROM Posts ORDER BY nbr_like DESC ",nativeQuery =true)
	public List<Posts> Reacts();
	
}
