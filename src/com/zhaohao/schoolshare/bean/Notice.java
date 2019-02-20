package com.zhaohao.schoolshare.bean;

import java.util.Date;

public class Notice {
	private String noticeId;
	private String noticeContext;
	private String noticetime;
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeContext() {
		return noticeContext;
	}
	public void setNoticeContext(String noticeContext) {
		this.noticeContext = noticeContext;
	}
	
	
	public String getNoticetime() {
		return noticetime;
	}
	public void setNoticetime(String noticetime) {
		this.noticetime = noticetime;
	}
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeContext=" + noticeContext + ", noticetime=" + noticetime + "]";
	}

}
