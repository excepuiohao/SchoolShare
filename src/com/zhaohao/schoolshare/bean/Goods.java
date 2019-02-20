package com.zhaohao.schoolshare.bean;

public class Goods {
	private String goodsId;
	private String goodsName;
	private int goodsCredit;
	private int goodsIntegral;
	private String goodsTypeId;
	private String goodsStatus;
	private String userId;
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsCredit() {
		return goodsCredit;
	}
	public void setGoodsCredit(int goodsCredit) {
		this.goodsCredit = goodsCredit;
	}
	public int getGoodsIntegral() {
		return goodsIntegral;
	}
	public void setGoodsIntegral(int goodsIntegral) {
		this.goodsIntegral = goodsIntegral;
	}
	public String getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsCredit=" + goodsCredit
				+ ", goodsIntegral=" + goodsIntegral + ", goodsTypeId=" + goodsTypeId + ", goodsStatus=" + goodsStatus
				+ "]";
	}

}
