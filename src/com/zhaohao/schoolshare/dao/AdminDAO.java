package com.zhaohao.schoolshare.dao;

import java.sql.ResultSet;
import java.util.List;

import com.zhaohao.schoolshare.bean.Admin;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.Order;
import com.zhaohao.schoolshare.bean.User;

public interface AdminDAO {
	// �ս���ʱ��ѯ���й���Ա
	public List<Admin> findAlladmin() throws Exception;

	// �ս���ʱ��֤����Ա���
	public boolean checkAdmin(String adminId, String adminPassword) throws Exception;

	// ɾ���û�
	public boolean deleteUser(String userId) throws Exception;

	// ��ѯ�û�
	public User findUserByUserId(String userId) throws Exception;

	// �����û�
	public boolean updateUser(User user) throws Exception;

	// ��������뵽ѧ������
	public boolean insertNotice(Notice notice) throws Exception;

	// �鿴ÿ���˵�������Ϣ
	public ResultSet findUserLease(String userId) throws Exception;

	// ͨ�����鿴��Դ��Ϣ
	public ResultSet findGoodsByType(String categoryName) throws Exception;

	// ͨ�����鿴��Դ��Ϣ
	public ResultSet findGoodsByName(String goodsName) throws Exception;
}