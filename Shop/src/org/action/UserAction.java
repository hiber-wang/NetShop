package org.action;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.dao.UserDao;
import org.dao.imp.GoodDaoImp;
import org.dao.imp.UserDaoImp;
import org.dao.LoginDao;
import org.dao.imp.LoginDaoImp;
import org.model.Login;
import org.model.Good;
import org.model.Usr;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	UserDao userDao;
	LoginDao loginDao;
	private Usr user;
	private Good good;
	private File zpFile;
	private String pwd;
	private String sex;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public Usr getUser() {
		return user;
	}
	public void setUser(Usr user) {
		this.user = user;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public File getZpFile() {
		return zpFile;
	}
	public void setZpFile(File zpFile) {
		this.zpFile = zpFile;
	}
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	public String execute() throws Exception {
		Map session = (Map)ActionContext.getContext().getSession();
		Login login = (Login)session.get("login");
		userDao = new UserDaoImp();
		System.out.println("before:" + login.getUserid());
		Usr user = userDao.getOneUser(login.getUserid());
		System.out.println("addr:" + user.getAddr());
		System.out.println("after:" + user.getUserid());
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("user", user);
		return SUCCESS;
	}
	public String getImage() throws Exception {
		System.out.println("进入获得图片");
		userDao = new UserDaoImp();
		byte[] zp = userDao.getOneUser(user.getUserid()).getPhoto();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		ServletOutputStream os = response.getOutputStream();
		if(zp != null && zp.length > 0) {
			System.out.println("数据库中发现图像");
			for(int i = 0; i < zp.length; i++) {
				os.write(zp[i]);
			}
		}else {
			System.out.println("未发现图片");
		}
		return NONE;
	}
	public String updateUserInfo() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		Login login = (Login) session.get("login");
		userDao = new UserDaoImp();
		Usr user = userDao.getOneUser(login.getUserid());
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("user", user);
		session.put("photo", user.getPhoto());
		return SUCCESS;
	}
	public String updateUser() throws Exception {
		userDao = new UserDaoImp();
		Usr user1 = new Usr();
		user1.setUserid(user.getUserid());
		Set list = userDao.getOneUser(user.getUserid()).getGoods();
		user1.setGoods(list);
		user1.setUsername(user.getUsername());
		user1.setSex(user.getSex());
		user1.setAddr(user.getAddr());
		user1.setDate(user.getDate());
		if(this.getZpFile() != null) {
			FileInputStream fis = new FileInputStream(this.getZpFile());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			user1.setPhoto(buffer);
		}else {
			byte[] photo = (byte[]) ActionContext.getContext().getSession().get("photo");
			user1.setPhoto(photo);
		}
		userDao.update(user1);
		return SUCCESS;
	}
	
	public String userInsert() throws Exception {
		try {
			userDao = new UserDaoImp();
			loginDao = new LoginDaoImp();
			Usr user1 = new Usr();
			System.out.println("userid" + user.getUserid());
			user1.setUserid(user.getUserid());
			user1.setUsername(user.getUsername());
			if(this.getSex() == "男") {
				user1.setSex((byte)1);
			}else {
				user1.setSex((byte)0);
			}
			user1.setAddr(user.getAddr());
			user1.setDate(new Date());
			Login login = new Login();
			login.setPwd(this.getPwd());
			login.setUserid(user.getUserid());
			if(this.getZpFile() != null) {
				System.out.println("找到图片文件");
				FileInputStream fis = new FileInputStream(this.getZpFile());
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				user1.setPhoto(buffer);
			}else {
				System.out.println("未找到图片文件");
			}
			userDao.insert(user1);
			loginDao.insert(login);
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
