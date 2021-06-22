package org.dao;
import java.util.List;
import org.model.Type;
public interface TypeDao {
	public Type getOneType(Integer typeid);
	public List getAll();
}
