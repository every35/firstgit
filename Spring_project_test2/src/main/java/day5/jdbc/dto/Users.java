package day5.jdbc.dto;

import java.util.List;

public class Users {
	private String id;
	private String nickname;
	private String pass;
	private String email;
	private String cellphone;
	private String address;
	private String mail_no;
	private String roll;
	
	private List<Board> boards;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail_no() {
		return mail_no;
	}

	public void setMail_no(String mail_no) {
		this.mail_no = mail_no;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", nickname=" + nickname + ", pass=" + pass + ", email=" + email + ", cellphone="
				+ cellphone + ", address=" + address + ", mail_no=" + mail_no + ", roll=" + roll + ", boards=" + boards
				+ "]";
	}

	
}
