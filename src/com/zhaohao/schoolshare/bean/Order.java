package com.zhaohao.schoolshare.bean;

public class Order {
	private String leaseId;
	private String userID;
	private String goodsId;
	private String goodsStatus;
	public String getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(String leaseId) {
		this.leaseId = leaseId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [leaseId=" + leaseId + ", userID=" + userID + ", goodsId=" + goodsId + ", goodsStatus="
				+ goodsStatus + "]";
	}

}
