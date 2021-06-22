package org.dao;
import org.model.Login;
public interface LoginDao {
	public Login validate(String username, String pwd);
	public void insert(Login login);
}
