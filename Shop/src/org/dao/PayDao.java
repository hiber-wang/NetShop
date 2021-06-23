package org.dao;
import org.model.Pay;
import java.util.List;
public interface PayDao {
	public void insert(Pay pay);
	public List getUserPay(String userid);
	public void delete(Pay pays);
	public Pay getOnePay(int id);
}
