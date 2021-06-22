package org.model;

/**
 * BuyId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BuyId implements java.io.Serializable {

	// Fields

	private String userid;
	private String goodid;

	// Constructors

	/** default constructor */
	public BuyId() {
	}

	/** full constructor */
	public BuyId(String userid, String goodid) {
		this.userid = userid;
		this.goodid = goodid;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getGoodid() {
		return this.goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BuyId))
			return false;
		BuyId castOther = (BuyId) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null
				&& castOther.getUserid() != null && this.getUserid().equals(
				castOther.getUserid())))
				&& ((this.getGoodid() == castOther.getGoodid()) || (this
						.getGoodid() != null
						&& castOther.getGoodid() != null && this.getGoodid()
						.equals(castOther.getGoodid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getGoodid() == null ? 0 : this.getGoodid().hashCode());
		return result;
	}

}