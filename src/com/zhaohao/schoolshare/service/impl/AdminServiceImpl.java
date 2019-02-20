package com.zhaohao.schoolshare.service.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhaohao.schoolshare.bean.Admin;
import com.zhaohao.schoolshare.bean.Notice;
import com.zhaohao.schoolshare.bean.User;
import com.zhaohao.schoolshare.dao.AdminDAO;
import com.zhaohao.schoolshare.dao.UserDAO;
import com.zhaohao.schoolshare.dao.impl.AdminDAOImpl;
import com.zhaohao.schoolshare.dao.impl.UserDAOImpl;
import com.zhaohao.schoolshare.dbc.DataBaseConnection;
import com.zhaohao.schoolshare.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private DataBaseConnection dbc = null;
	private AdminDAO dao = null;
	public AdminServiceImpl() throws ClassNotFoundException, SQLException, IOException {
		this.dbc = new DataBaseConnection();
		this.dao = new AdminDAOImpl(this.dbc.getConnection());
	}
	
	@Override
	public List<Admin> findAlladmin() throws Exception {
		List <Admin> all= new ArrayList<Admin>();
		try {
			all=this.dao.findAlladmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return all;
	}

	@Override
	public boolean checkAdmin(String adminId, String adminPassword) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.checkAdmin(adminId, adminPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return flag;
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			flag=this.dao.deleteUser(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return flag;
	}

	@Override
	public User findUserByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		
		User user=new User();
		try {
			user=this.dao.findUserByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			flag=this.dao.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.dbc.closedriver();
		}
		return flag;
	}

	@Override
	public boolean insertNotice(Notice notice) throws Exception {
		// TODO Auto-generated method stub
				boolean flag=false;
				try {
					flag=this.dao.insertNotice(notice);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					this.dbc.closedriver();
				}
				return flag;
	}

	@Override
	public ResultSet findUserLease(String userId) throws Exception {
		ResultSet rs=null;
		try {
			rs=this.dao.findUserLease(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	
	
	}

	@Override
	public ResultSet findGoodsByType(String categoryName) throws Exception {
		ResultSet rs=null;
		try {
			rs=this.dao.findGoodsByType(categoryName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet findGoodsByName(String goodsName) throws Exception {
		ResultSet rs=null;
		try {
			rs=this.dao.findGoodsByName(goodsName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
