package cn.test.mapper;





import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.test.entity.Admin;
import cn.test.entity.Vip;


public interface AdminMapper {
	
	public void insertBean(Admin bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Admin bean);
	
	public Admin userlogin(
			@Param("username") String username,
			@Param("password") String password,
			@Param("role") int role
			);
	
	
	public Admin useryz(
			@Param("username") String username
			);
	
	
	public Admin sfzyz(
			@Param("sfz") String sfz
			);
	
	
	
	public Admin selectBeanById(
			@Param("id") int id
			);
	
	public Admin selectBeanByUsername(
			@Param("username") String username
			);
	
	
	public List<Admin> selectBeanList(
			@Param("start") int start,
			@Param("limit") int limit,
			@Param("username") String username
			);
	
	
	public int selectBeanCount(
			@Param("username") String username
			);
	
	
	public List<Admin> selectBeanList2(
			@Param("start") int start,
			@Param("limit") int limit,
			@Param("username") String username
			);
	public int selectBeanCount2(
			@Param("username") String username
			);

	
	
	public List<Vip> selectBeanList3(
			@Param("start") int start,
			@Param("limit") int limit,
			@Param("username") String username
			);
	
	public int selectBeanCount3(
			@Param("username") String username
			);
	
	public List<Admin> selectBeanList4(
			@Param("start") int start,
			@Param("limit") int limit,
			@Param("username") String username
			);
	
	public int selectBeanCount4(
			@Param("username") String username
			);
	
}
