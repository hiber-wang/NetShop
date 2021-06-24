package org.action;
import java.util.List;
import java.util.Map;

import org.dao.GoodDao;
import org.dao.LoginDao;
import org.dao.TypeDao;
import org.dao.imp.GoodDaoImp;
import org.dao.imp.LoginDaoImp;
import org.dao.imp.TypeDaoImp;
import org.model.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String execute() throws Exception {
		LoginDao loginDao = new LoginDaoImp();
		Login login1 = loginDao.validate(login.getUserid(), login.getPwd());
		if(login1 != null) {
			Map session = (Map) ActionContext.getContext().getSession();
			session.put("login", login1);
			session.put("authority", login1.getAuthority());
			
			TypeDao typeDao = new TypeDaoImp();
			List list = typeDao.getAll();
			session.put("typelist", list);
			
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String logout() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		session.put("login", null);
		return SUCCESS;
	}
}
