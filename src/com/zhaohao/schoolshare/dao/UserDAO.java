package com.zhaohao.schoolshare.dao;

import java.sql.ResultSet;
import java.util.List;

import com.zhaohao.schoolshare.bean.Goods;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.User;

public interface UserDAO {
	// �ս���ʱ��ѯ���в˵���Ϣ
	public List<User> findAllUser() throws Exception;

	// �ս���ʱ��ѯ���в˵���Ϣ
	public boolean checkUser(String userId, String password) throws Exception;

	// ��ѧ�����뵽ѧ������
	public boolean insertUser(User user) throws Exception;

	// �һ�����
	public String findUserPassword(String userId, String userName) throws Exception;

	// �鿴���еĹ���
	public List<Notice> findNotice() throws Exception;

	// �鿴��������Դ
	public ResultSet findgoods(String userId) throws Exception;

	// �鿴��Դ�����˵�����
	public int findCredit(String userId) throws Exception;

	// ͨ��id�鿴��������Դ
	public ResultSet findGoodsByGoodsId(String goodsId) throws Exception;

	// ������Ʒ
	public boolean UserUpdateGoods(Goods goods) throws Exception;

	// �õ�������Ʒ����
	public int findGoodsCount() throws Exception;

	// ������Ʒ
	public boolean insertGoods(Goods goods) throws Exception;

	// �����û�����
	public boolean UserUpdateIntegral(String userId) throws Exception;

	// �鿴��Դ�����˵Ļ���
	public int findIntegral(String userId) throws Exception;

	/////////
	// �趫����
	// �鿴�����˵�����
	// �鿴�����˵Ļ���
	// �鿴��Ʒ�Ļ���
	public int findGoodsIntegral(String goodsId) throws Exception;

	// �鿴��Ʒ������
	public int findGoodsCredit(String goodsId) throws Exception;

	// ������Ʒ���е���Ʒ״̬��
	public boolean UpdateGoodsStatus(String goodsId,String goodsStatus) throws Exception;

	// ���������˻���
	public boolean UpdateUsersIntegral(String userId, int integral) throws Exception;

	// �������ޱ���
	public boolean InsertOrder(String userId, String goodsId) throws Exception;

	// �õ��������ޱ�������
	public int findOrdersCount() throws Exception;

	// �������ޱ�
	public boolean UpdateOrder(String goodsId) throws Exception;

	// ������Ʒ��
	public boolean UpdateGoods(String goodsId) throws Exception;
}
