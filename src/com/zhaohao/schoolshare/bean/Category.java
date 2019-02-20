package com.zhaohao.schoolshare.bean;

public class Category {
	private String categorId;
	private String categoryName;
	public String getCategorId() {
		return categorId;
	}
	public void setCategorId(String categorId) {
		this.categorId = categorId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [categorId=" + categorId + ", categoryName=" + categoryName + "]";
	}

}
