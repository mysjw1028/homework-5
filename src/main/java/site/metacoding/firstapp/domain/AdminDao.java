package site.metacoding.firstapp.domain;

import java.util.List;

import site.metacoding.firstapp.web.dto.request.admin.AdminLoginDto;

public interface AdminDao {

	public Admin login(AdminLoginDto adminLoginDto);

	public void insert(Admin admin);

	public Admin findById(Integer id);

	public List<Admin> findAll();

	public void update(Admin admin);

	public int deleteById(Integer id);
}
