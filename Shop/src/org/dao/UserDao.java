package org.dao;
import java.util.List;
import org.model.Usr;
public interface UserDao {
	public Usr getOneUser(String userid);
	public void update(Usr user);
	public void insert(Usr user);
	public void delete(Usr user);
	public List getAll();
}
