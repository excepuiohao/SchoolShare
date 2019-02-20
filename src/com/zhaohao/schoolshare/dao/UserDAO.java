package com.zhaohao.schoolshare.dao;

import java.sql.ResultSet;
import java.util.List;

import com.zhaohao.schoolshare.bean.Goods;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.User;

public interface UserDAO {
	// 刚进入时查询所有菜单信息
	public List<User> findAllUser() throws Exception;

	// 刚进入时查询所有菜单信息
	public boolean checkUser(String userId, String password) throws Exception;

	// 将学生插入到学生表中
	public boolean insertUser(User user) throws Exception;

	// 找回密码
	public String findUserPassword(String userId, String userName) throws Exception;

	// 查看所有的公告
	public List<Notice> findNotice() throws Exception;

	// 查看发布的资源
	public ResultSet findgoods(String userId) throws Exception;

	// 查看资源所有人的信用
	public int findCredit(String userId) throws Exception;

	// 通过id查看发布的资源
	public ResultSet findGoodsByGoodsId(String goodsId) throws Exception;

	// 更新物品
	public boolean UserUpdateGoods(Goods goods) throws Exception;

	// 得到所有商品数量
	public int findGoodsCount() throws Exception;

	// 发布物品
	public boolean insertGoods(Goods goods) throws Exception;

	// 更新用户积分
	public boolean UserUpdateIntegral(String userId) throws Exception;

	// 查看资源所有人的积分
	public int findIntegral(String userId) throws Exception;

	/////////
	// 借东西：
	// 查看租赁人的信用
	// 查看租赁人的积分
	// 查看物品的积分
	public int findGoodsIntegral(String goodsId) throws Exception;

	// 查看物品的信用
	public int findGoodsCredit(String goodsId) throws Exception;

	// 更改物品表中的物品状态的
	public boolean UpdateGoodsStatus(String goodsId,String goodsStatus) throws Exception;

	// 更改租赁人积分
	public boolean UpdateUsersIntegral(String userId, int integral) throws Exception;

	// 插入租赁表中
	public boolean InsertOrder(String userId, String goodsId) throws Exception;

	// 得到所有租赁表中数量
	public int findOrdersCount() throws Exception;

	// 更改租赁表
	public boolean UpdateOrder(String goodsId) throws Exception;

	// 更改物品表
	public boolean UpdateGoods(String goodsId) throws Exception;
}
