package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.KinderGarten;
import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends CrudRepository <User,Long> {
	
	public User getUserByEmailAndPassword(String login, String password);
	@Query(value="SELECT * FROM user where name=:name and password=:password",nativeQuery =true)
	public User getUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

	
	@Query(value="SELECT * FROM user Order By name",nativeQuery =true)
	public List<User> FindUserSortedByNameUser();
	
	@Query(value="SELECT * FROM user where dtype = 'Parent' ",nativeQuery =true)
	public List<User> FindUserSortedByTypeParent();
	
	@Query(value="SELECT * FROM user where dtype = 'KinderGartenAdmin' ",nativeQuery =true)
	public List<User> FindUserSortedByTypeKinderGartenAdmin();

	@Query(value="SELECT * FROM user where dtype = 'User' ",nativeQuery =true)
	public List<User> FindUserSortedByTypeUser();
	
	
	
	
	@Query(value="SELECT * FROM user where name=:name",nativeQuery =true)
	public User getUserByName(@Param("name") String name);
	
	
	
	@Query(value="SELECT * FROM user where id_user=?1",nativeQuery =true)
	public User getUserId(Long userid);

	
	


}
