package com.zhaohao.schoolshare.dao;

import java.sql.ResultSet;
import java.util.List;

import com.zhaohao.schoolshare.bean.Admin;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.Order;
import com.zhaohao.schoolshare.bean.User;

public interface AdminDAO {
	// 刚进入时查询所有管理员
	public List<Admin> findAlladmin() throws Exception;

	// 刚进入时验证管理员身份
	public boolean checkAdmin(String adminId, String adminPassword) throws Exception;

	// 删除用户
	public boolean deleteUser(String userId) throws Exception;

	// 查询用户
	public User findUserByUserId(String userId) throws Exception;

	// 更新用户
	public boolean updateUser(User user) throws Exception;

	// 将公告插入到学生表中
	public boolean insertNotice(Notice notice) throws Exception;

	// 查看每个人的租赁信息
	public ResultSet findUserLease(String userId) throws Exception;

	// 通过类别查看资源信息
	public ResultSet findGoodsByType(String categoryName) throws Exception;

	// 通过类别查看资源信息
	public ResultSet findGoodsByName(String goodsName) throws Exception;
}