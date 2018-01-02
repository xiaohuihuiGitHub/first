package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Items;
import cn.itcast.pojo2.QueryVo;

public interface ItemsService {

	public List<Items> findItemsList() throws Exception;
	
	public Items getItemsDetailById(Integer id) throws Exception;
	
	public void updateitem(Items items) throws Exception;
	
	public void deleteItem(QueryVo vo) throws Exception;
}
