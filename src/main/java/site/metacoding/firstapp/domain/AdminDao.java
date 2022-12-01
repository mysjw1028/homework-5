package site.metacoding.firstapp.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface AdminDao {

	public Admin login(@Param("password") String password, @Param("userName") String userName);

	public void insert(Admin admin);

	public Admin findById(Integer id);

	public List<Admin> findAll();

	public void update(Admin admin);
	
	public int deleteById(Integer id);
	
	public Admin findByIdAdminName(String admintName);
	
}
