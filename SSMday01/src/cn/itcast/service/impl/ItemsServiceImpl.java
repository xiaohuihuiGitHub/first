package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.ItemsMapper;
import cn.itcast.pojo.Items;
import cn.itcast.pojo2.QueryVo;
import cn.itcast.service.ItemsService;
/**
 * service层，事务在配置文件中已经声明
 * @author 小灰灰才是最骚的
 * date 2017年12月25日
 */
@Service
public class ItemsServiceImpl implements ItemsService {

	//注入dao层Mapper
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> findItemsList() throws Exception {
		//items中含有text大对象，使用该方法。
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public Items getItemsDetailById(Integer id) throws Exception {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateitem(Items items) throws Exception {
		itemsMapper.updateByPrimaryKeySelective(items);
	}

	@Override
	public void deleteItem(QueryVo vo) throws Exception {
		Integer[] ids = vo.getIds();
		for (Integer id : ids) {
			itemsMapper.deleteByPrimaryKey(id);
		}
	}

}
