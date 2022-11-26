package site.metacoding.firstapp.domain;

import java.util.List;

import site.metacoding.firstapp.web.dto.request.users.LoginDto;

public interface UsersDao {
	public Users login (LoginDto loginDto);

	public void insert(Users users);
	
	public Users findById(Integer usersId);
	
	public Users findByUsername(String username);

	public List<Users> findAll();

	public int update(Users users);

	public int deleteById(Integer users);
	
	public Users findByIdUserName(String username);

}
