package site.metacoding.firstapp.domain;

import java.util.List;

import site.metacoding.firstapp.web.dto.request.mainadmin.AdminListDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.MainAdminLoginDto;
import site.metacoding.firstapp.web.dto.request.mainadmin.UsersListDto;


public interface MainAdminDao {
	public MainAdmin login(MainAdminLoginDto mainAdminLoginDto);
	public void insert(MainAdmin mainAdmin);
	public MainAdmin findById(Integer id);
	public List<MainAdmin> findAll();
	public int update(MainAdmin mainAdmin);
	public int deleteById(Integer id);
	public List<AdminListDto> adminList(Integer id);//구매목록보기 리스트 디티오 추가적으로 넣음
	public List<UsersListDto> usersList(Integer id);//구매목록보기 리스트 디티오 추가적으로 넣음

}

