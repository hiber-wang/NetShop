package org.dao;
import java.util.List;
import org.model.Good;
public interface GoodDao {
	public Good getOneGood(String goodid);
	public List getAll();
}
