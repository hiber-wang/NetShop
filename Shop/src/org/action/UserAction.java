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
import org.dao.PayDao;
import org.dao.GoodDao;
import org.dao.imp.PayDaoImp;
import org.model.Login;
import org.model.Good;
import org.model.Usr;
import org.model.Pay;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	UserDao userDao;
	LoginDao loginDao;
	PayDao payDao;
	GoodDao goodDao;
	private Usr user;
	private Good good;
	private File zpFile;
	private String pwd;
	private String sex;
	private Pay pay;
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
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
		
		payDao = new PayDaoImp();
		List list = payDao.getUserPay(login.getUserid());
		request.put("paylist", list);
		
		goodDao = new GoodDaoImp();
		List list2 = goodDao.getAll();
		request.put("goodlist", list2);
		
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
	public String buyGoods() throws Exception {
		System.out.println("here");
		Map session = (Map)ActionContext.getContext().getSession();
		String userid = ((Login)session.get("login")).getUserid();
		userDao = new UserDaoImp();
		Usr user1 = userDao.getOneUser(userid);
		Set list = user1.getGoods();
		list.add(new GoodDaoImp().getOneGood(good.getGoodid()));
		user1.setGoods(list);
		userDao.update(user1);
		return SUCCESS;
	}
	
	public String getBuyGoods() throws Exception {
		Map session = (Map)ActionContext.getContext().getSession();
		Login login = (Login)session.get("login");
		userDao = new UserDaoImp();
		Usr user = userDao.getOneUser(login.getUserid());
		Map request = (Map)ActionContext.getContext().get("request");
		// 获取已购商品信息
		Set list = user.getGoods();
		request.put("buylist", list);
		return SUCCESS;
	}
	
	public String deleteGoods() throws Exception {
		Map session = (Map) ActionContext.getContext().getSession();
		String userid = ((Login)session.get("login")).getUserid();
		userDao = new UserDaoImp();
		Usr user1 = userDao.getOneUser(userid);
		Set list = user1.getGoods();
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			Good good1 = (Good) iter.next();
			if(good1.getGoodid().equals(good.getGoodid())) {
				iter.remove();
			}
		}
		user1.setGoods(list);
		userDao.update(user1);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("buylist", list);
		return SUCCESS;
	}
	
	public String payGoods() throws Exception {
		try{
			Map session = (Map) ActionContext.getContext().getSession();
			String userid = ((Login)session.get("login")).getUserid();
			payDao = new PayDaoImp();
			Pay pay = new Pay();
			pay.setGoodid(good.getGoodid());
			pay.setUserid(userid);
			pay.setDate(new Date());
			payDao.insert(pay);
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String deletePayGoods() throws Exception {
		try {
			payDao = new PayDaoImp();
			Pay pay1 = payDao.getOnePay(pay.getId());
			payDao.delete(pay1);
			execute();
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
