package org.action;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.File;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.model.Login;
import org.model.Type;
import org.model.Good;
import org.model.Usr;
import org.dao.GoodDao;
import org.dao.TypeDao;
import org.dao.imp.GoodDaoImp;
import org.dao.imp.LoginDaoImp;
import org.dao.imp.TypeDaoImp;
import org.dao.imp.UserDaoImp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class GoodAction extends ActionSupport{
	private Type type;
	GoodDao goodDao;
	private File zpFile;
	private Good good;
	private String searchContext;
	private Integer types;
	private int pageNow;

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getTypes() {
		return types;
	}

	public void setTypes(Integer types) {
		this.types = types;
	}

	public String getSearchContext() {
		return searchContext;
	}

	public void setSearchContext(String searchContext) {
		this.searchContext = searchContext;
	}

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
		try {
			GoodDao goodDao = new GoodDaoImp();
			List list = goodDao.getAll(this.getPageNow());
			System.out.println(this.getPageNow());
			List alllist = goodDao.getAll();
			int pageNum = alllist.size() / 6 + 2;
			Map request = (Map) ActionContext.getContext().get("request");
			List pageNumList = new ArrayList();
			for(int i = 1; i < pageNum; i++) {
				pageNumList.add(i);
			}
			
			request.put("list", list);
			request.put("pageNum", pageNumList);
			request.put("now", this.getPageNow());
			System.out.println("goodaction execute:" + this.getPageNow());
			System.out.println("listlength:" + list.size());
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error!");
			return ERROR;
		}
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
	
	public String searchGoods() throws Exception {
		GoodDao goodDao = new GoodDaoImp();
		System.out.println(this.getSearchContext());
		List list = goodDao.searchGoods(this.getSearchContext(), type.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("typeid", type.getId());
		return SUCCESS;
	}
	
	public String goodInsert() throws Exception {
		try {
			goodDao = new GoodDaoImp();
			Good good1 = new Good();
			good1.setGoodname(good.getGoodname());
			good1.setGoodprice(good.getGoodprice());
			TypeDao typeDao = new TypeDaoImp();
			System.out.println(type.getId());
			Type type1 = typeDao.getOneType(type.getId());
			good1.setType(type1);
			if(this.getZpFile() != null) {
				System.out.println("找到图片文件");
				FileInputStream fis = new FileInputStream(this.getZpFile());
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				good1.setPhoto(buffer);
			}else {
				System.out.println("未找到图片文件");
			}
			goodDao.insert(good1);
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
