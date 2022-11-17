package site.metacoding.firstapp.domain;

import java.util.List;

import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;


public interface MainAdminDao {

	public MainAdmin login(MainAdminLoginDto mainAdminLoginDto);

	public void insert(MainAdmin mainAdmin);

	public MainAdmin findById(Integer id);

	public List<MainAdmin> findAll();

	public int update(MainAdmin mainAdmin);

	public int deleteById(Integer id);

}

