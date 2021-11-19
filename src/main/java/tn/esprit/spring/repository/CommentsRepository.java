package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comments;


@Repository
public interface CommentsRepository extends  CrudRepository <Comments,Long>
{
	@Query(value="SELECT  * FROM Comments where posts_id_post= ?1 ",nativeQuery =true)
	public List<Comments> commentofposts(Long IdPost);
}
