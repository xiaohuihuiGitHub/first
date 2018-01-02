package cn.itcast.pojo2;

import java.util.List;

import cn.itcast.pojo.Items;

public class QueryVo {

	private Items items;

	private Integer[] ids;

	private List<Items> updateItemsList;

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public List<Items> getUpdateItemsList() {
		return updateItemsList;
	}

	public void setUpdateItemsList(List<Items> updateItemsList) {
		this.updateItemsList = updateItemsList;
	}

}
