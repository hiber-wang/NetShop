package org.action;
import java.util.Map;
import org.dao.LoginDao;
import org.dao.imp.LoginDaoImp;
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
		Login user = loginDao.validate(login.getUserid(), login.getPwd());
		if(user != null) {
			Map session = (Map) ActionContext.getContext().getSession();
			session.put("login", login);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
