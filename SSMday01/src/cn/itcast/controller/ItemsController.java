package cn.itcast.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.Items;
import cn.itcast.pojo2.QueryVo;
import cn.itcast.service.ItemsService;

/**
 * 控制层
 * @author 小灰灰才是最骚的
 * date 2017年12月25日
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
	
	//注入service层
	@Autowired
	private ItemsService itemsService;
	
	//查询所有items返回结果集
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		System.out.println("进来了");
		List<Items> itemsList = itemsService.findItemsList();
		model.addAttribute("itemList", itemsList);
		return "itemList";
	}
	
	@RequestMapping("/itemEdit")
	public String itemEdit(HttpServletRequest request,Model model) throws Exception{
		Integer id = Integer.valueOf(request.getParameter("id"));
		Items items = itemsService.getItemsDetailById(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	
	@RequestMapping("/updateitem")
	public String updateitem(Items items) throws Exception{
		itemsService.updateitem(items);
		return "success";
	}
	
	@RequestMapping("queryitem")
	public String queryitem(QueryVo vo) throws Exception{
		
		return "success";
	}
	
	@RequestMapping("/listForDel")
	public String listForDel(Model model) throws Exception{
		List<Items> itemsList = itemsService.findItemsList();
		model.addAttribute("itemList", itemsList);
		return "itemListDel";
	}
	
	@RequestMapping("deleteitem")
	public String deleteitem(QueryVo vo) throws Exception{
		itemsService.deleteItem(vo);
		return "success";
	}
	
	@RequestMapping("/listForUp")
	public String listForUpdate(Model model) throws Exception{
		List<Items> itemsList = itemsService.findItemsList();
		model.addAttribute("itemList", itemsList);
		return "itemListUpdate";
	}
	
	@RequestMapping("updateAll")
	public String toEdit(QueryVo vo)throws Exception{
		
		return "success";
	}
}
