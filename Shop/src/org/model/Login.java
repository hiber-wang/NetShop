package org.model;

/**
 * Login entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Login implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userid;
	private String pwd;
	private int authority;
	// Constructors

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	/** default constructor */
	public Login() {
	}

	/** full constructor */
	public Login(String userid, String pwd) {
		this.userid = userid;
		this.pwd = pwd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}