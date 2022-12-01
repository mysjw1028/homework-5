package site.metacoding.firstapp.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsersDao {
	public Users login(@Param("password") String password, @Param("userName") String userName );

	public void insert(Users users);

	public Users findById(Integer usersId);

	public Users findByUsername(String username);

	public List<Users> findAll();

	public int update(Users users);

	public int deleteById(Integer users);

	public Users findByIdUserName(String username);

}
