package org.model;
import java.util.HashSet;
import java.util.Set;


/**
 * Good entity. @author MyEclipse Persistence Tools
 */

public class Good  implements java.io.Serializable {


    // Fields    

     private Integer goodid;
     private String goodname;
     private Double goodprice;
     private String typeid;
     private Type type;
     private Set users = new HashSet();

    // Constructors

    public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	/** default constructor */
    public Good() {
    }

    
    /** full constructor */
    public Good(String goodname, Double goodprice, String typeid) {
        this.goodname = goodname;
        this.goodprice = goodprice;
        this.typeid = typeid;
    }

   
    // Property accessors

    public Integer getGoodid() {
        return this.goodid;
    }
    
    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return this.goodname;
    }
    
    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Double getGoodprice() {
        return this.goodprice;
    }
    
    public void setGoodprice(Double goodprice) {
        this.goodprice = goodprice;
    }

    public String getTypeid() {
        return this.typeid;
    }
    
    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }


	public Set getUsers() {
		return users;
	}


	public void setUsers(Set users) {
		this.users = users;
	}

}