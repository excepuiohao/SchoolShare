package com.zhaohao.schoolshare.service.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhaohao.schoolshare.bean.Goods;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.User;
import com.zhaohao.schoolshare.dao.UserDAO;
import com.zhaohao.schoolshare.dao.impl.UserDAOImpl;
import com.zhaohao.schoolshare.dbc.DataBaseConnection;
import com.zhaohao.schoolshare.service.UserService;

public class UserServiceImpl implements UserService {
	private DataBaseConnection dbc = null;
	private UserDAO dao = null;

	// 实例化一个数据库驱动类 并调用dbc包中的数据库类得到具体的数据库驱动连接
	public UserServiceImpl() throws ClassNotFoundException, SQLException, IOException {
		this.dbc = new DataBaseConnection();
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}

	@Override
	public List<User> findAllUser() throws Exception {
		List <User> all= new ArrayList<User>();
		try {
			all=this.dao.findAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return all;
	}

	@Override
	public boolean checkUser(String userId, String password) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.checkUser(userId, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return flag;
	}

	@Override
	public boolean insertUser(User user) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return flag;
	}

	@Override
	public String findUserPassword(String userId, String userName) throws Exception {
		// TODO Auto-generated method stub
		String userPassword=null;
		try {
			userPassword=this.dao.findUserPassword(userId, userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return userPassword;
	}

	@Override
	public List<Notice> findNotice() throws Exception {
		List <Notice> all= new ArrayList<Notice>();
		try {
			all=this.dao.findNotice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return all;
	}

	@Override
	public ResultSet findgoods(String userId) throws Exception {
		ResultSet rs=null;
		try {
			rs=this.dao.findgoods(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int findCredit(String userId) throws Exception {
		int credit=0;
		try {
			credit=this.dao.findCredit(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credit;
	}

	@Override
	public ResultSet findGoodsByGoodsId(String goodsId) throws Exception {
		ResultSet rs=null;
		try {
			rs=this.dao.findGoodsByGoodsId(goodsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean UserUpdateGoods(Goods goods) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.UserUpdateGoods(goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return flag;
	}

	@Override
	public int findGoodsCount() throws Exception {
		int  count=0;
		try {
			count=this.dao.findGoodsCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean insertGoods(Goods goods) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.insertGoods(goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean UserUpdateIntegral(String userId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			flag=this.dao.UserUpdateIntegral(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return flag;
	}

	@Override
	public int findGoodsIntegral(String goodsId) throws Exception {
		int integral=0;
		try {
			integral=this.dao.findGoodsIntegral(goodsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return integral;
	}

	@Override
	public int findGoodsCredit(String goodsId) throws Exception {
		int credit=0;
		try {
			credit=this.dao.findGoodsCredit(goodsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credit;
	}

	@Override
	public boolean UpdateGoodsStatus(String goodsId, String goodsStatus) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.UpdateGoodsStatus(goodsId, goodsStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean UpdateUsersIntegral(String userId, int integral) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.UpdateUsersIntegral(userId, integral);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean InsertOrder(String userId, String goodsId) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.InsertOrder(userId, goodsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int findOrdersCount() throws Exception {
		int count=0;
		try {
			count=this.dao.findGoodsCount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int findIntegral(String userId) throws Exception {
		int integral=0;
		try {
			integral=this.dao.findIntegral(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return integral;
	}

	@Override
	public boolean UpdateOrder(String goodsId) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.UpdateOrder(goodsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean UpdateGoods(String goodsId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			flag=this.dao.UpdateGoods(goodsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
