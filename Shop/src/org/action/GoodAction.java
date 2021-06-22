package org.action;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.File;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.model.Type;
import org.model.Good;
import org.dao.GoodDao;
import org.dao.TypeDao;
import org.dao.imp.GoodDaoImp;
import org.dao.imp.TypeDaoImp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class GoodAction extends ActionSupport{
	private Type type;
	GoodDao goodDao;
	private File zpFile;
	private Good good;
	
	public GoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public File getZpFile() {
		return zpFile;
	}

	public void setZpFile(File zpFile) {
		this.zpFile = zpFile;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String execute() throws Exception {
		GoodDao goodDao = new GoodDaoImp();
		List list = goodDao.getAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	
	public String getGoodImage() throws Exception {
		goodDao = new GoodDaoImp();
		byte[] zp = goodDao.getOneGood(good.getGoodid()).getPhoto();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		ServletOutputStream os = response.getOutputStream();
		if(zp != null && zp.length > 0) {
			for(int i = 0; i < zp.length; i++) {
				os.write(zp[i]);
			}
		}
		return NONE;
	}

}
