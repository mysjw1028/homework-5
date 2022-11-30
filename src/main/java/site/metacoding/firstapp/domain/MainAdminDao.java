package site.metacoding.firstapp.domain;

import java.util.List;

import site.metacoding.firstapp.web.dto.request.mainadmin.AdminListDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminJoinDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.UsersListDto;


public interface MainAdminDao {
	public MainAdmin login(MainAdminLoginDto mainAdminLoginDto);
	public void insert(MainAdmin mainadmins);
	public MainAdmin findById(Integer id);
	public List<MainAdmin> findAll();
	public int update(MainAdmin mainAdmin);
	public int deleteById(Integer id);
	public MainAdmin findByIdMainAdminName(String MainAdminName);
	public List<AdminListDto> adminList(Integer id);//관리자 목록보기
	public List<UsersListDto> usersList(Integer id);//구매자 목혹보기

}

