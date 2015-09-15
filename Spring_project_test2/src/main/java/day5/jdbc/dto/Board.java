package day5.jdbc.dto;

import java.util.Date;

public class Board {
	private int commentNo;
	private String userId;
	private Date regDate;
	private String commentContent;
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	@Override
	public String toString() {
		return "Board [commentNo=" + commentNo + ", userId=" + userId + ", regDate=" + regDate + ", commentContent="
				+ commentContent + "]";
	}
	
	
}
