/*package com.ecode.land.web.controller.deskTop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecode.land.domain.contract.Contract;
import com.ecode.land.domain.system.Account;
import com.ecode.land.domain.system.User;
import com.ecode.land.exception.CRUDException;
import com.ecode.land.service.contract.LastInsService;
import com.ecode.land.service.dataquery.PaymentRemService;
import com.ecode.land.util.Page;

*//**
 * 缴款提醒看板后台Controller
 * @author 朱玉猛
 * @since 2015年7月14日14:54:43
 *
 *//*
@Controller
@RequestMapping({"paymentReminder"})
public class PaymentReminderController {
	private static Logger log = Logger.getLogger(PaymentReminderController.class);
	 @Autowired
	  private LastInsService lastInsService;
	 @Autowired
	  private PaymentRemService paymentRemService;
	*//**
	 * 已到账list
	 * @param modelMap
	 * @author 朱玉猛
	 * @since 2015年7月14日14:54:23
	 * @return
	 * @throws CRUDException 
	 *//*
	@RequestMapping("YDXpayList")
	public ModelAndView YDXpayList(ModelMap modelMap,Contract contract, Page page, HttpSession session, HttpServletRequest requ) throws CRUDException{
		try {
			Account accout = new Account();
			accout.setId(session.getAttribute("accountId").toString());
			contract.setCreateAccount(accout);
			page.setPageSize(18);
			Map map=this.lastInsService.findAllComp(contract, page);
			//封装饼状图的数据
			BigDecimal finish=new BigDecimal(map.get("finished").toString());
			BigDecimal unfinish=new BigDecimal(map.get("notFinish").toString());
			BigDecimal total=finish.add(unfinish);
			//////////////////////////
			modelMap.put("map",map);
			modelMap.put("finish", finish);
			modelMap.put("unfinish", unfinish);
			modelMap.put("total", total);
			modelMap.put("pageobj", page);
			modelMap.put("queryobj", contract);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return new ModelAndView("desktop/paymentReminder/alreadDZ",modelMap);
	}
	*//**
	 * 未到账list
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月14日14:54:10
	 *//*
	@RequestMapping("WDZPaylist")
	public ModelAndView WDZPaylist(ModelMap modelMap, Contract contract, Page page, String state, HttpSession session, HttpServletRequest requ) throws CRUDException{
		try {
			Account accout = new Account();
			accout.setId(session.getAttribute("accountId").toString());
			contract.setCreateAccount(accout);

			String createAccountName = requ.getParameter("createAccountName");
			User userSelect = new User();
			userSelect.setName(createAccountName);
			accout.setUser(userSelect);
			contract.setCreateAccount(accout);

			String editAccountName = requ.getParameter("editAccountName");

			User userSelectEdit = new User();
			userSelectEdit.setName(editAccountName);
			Account accout1 = new Account();
			accout1.setUser(userSelectEdit);
			contract.setEditAccount(accout1);

			List list = this.paymentRemService.listContract(contract, page, state);
			int listSize = list.size();

			modelMap.put("pageNum", Integer.valueOf((listSize + 17) / 18));
			modelMap.put("listSize", Integer.valueOf(listSize));
			modelMap.put("paymentRemList", list);

			modelMap.put("pageobj", page);
			modelMap.put("queryobj", contract);

			return new ModelAndView("desktop/paymentReminder/neverDZ",modelMap);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 缴款提醒看板 饼状图
	 * @throws CRUDException 
	 *//*
	@RequestMapping("loadpie")
	@ResponseBody
	public Object loadpie(Contract contract, Page page, HttpSession session, HttpServletRequest requ) throws CRUDException{
		try {
			Account accout = new Account();
			accout.setId(session.getAttribute("accountId").toString());
			contract.setCreateAccount(accout);
			page.setPageSize(18);
			Map map=this.lastInsService.queryPiedata(contract, page);
			//封装饼状图的数据
			List<Object> pieData=new ArrayList<Object>();
			Map<String,Object> dataMap=new HashMap<String,Object>();
			Map<String,Object> dataMap1=new HashMap<String,Object>();
			BigDecimal finish=new BigDecimal(map.get("finished").toString());
			BigDecimal unfinish=new BigDecimal(map.get("notFinish").toString());
			BigDecimal total=finish.add(unfinish);
			dataMap.put("name", "合同额缴清");
			dataMap.put("y", total==BigDecimal.ZERO?BigDecimal.ZERO:finish.divide(total,4,BigDecimal.ROUND_HALF_DOWN));
			dataMap1.put("name", "合同额未缴清");
			dataMap1.put("y", total==BigDecimal.ZERO?BigDecimal.ZERO:unfinish.divide(total,4,BigDecimal.ROUND_HALF_DOWN));
			pieData.add(dataMap);
			pieData.add(dataMap1);
			//////////////////////////
			return pieData;
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 提醒缴款看板中间的表的数据查询
	 * @throws CRUDException 
	 *//*
	@RequestMapping("countCount")
	@ResponseBody
	public Map<String,Object> countCount(Contract contract, HttpSession session,Page page, HttpServletRequest requ) throws CRUDException{
		try {
			Account accout = new Account();
			accout.setId(session.getAttribute("accountId").toString());
			contract.setCreateAccount(accout);
			page.setPageSize(18);
			Map map=this.lastInsService.queryPiedata(contract, page);
			//封装饼状图的数据
			Map<String,Object> data=new HashMap<String,Object>();
			BigDecimal finish=new BigDecimal(map.get("finished").toString());
			BigDecimal unfinish=new BigDecimal(map.get("notFinish").toString());
			BigDecimal total=finish.add(unfinish);
			data.put("finish", finish);
			data.put("unfinish", unfinish);
			data.put("total", total);
			return data;
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 未到账饼状图
	 * @param modelMap
	 * @param contract
	 * @param page
	 * @param state
	 * @param session
	 * @param requ
	 * @return
	 * @throws CRUDException
	 *//*
	@RequestMapping("loadpiewdz")
	@ResponseBody
	public Object loadpiewdz(ModelMap modelMap, Contract contract, Page page, String state, HttpSession session, HttpServletRequest requ) throws CRUDException{
	     List<Object> resultList=new ArrayList<Object>();
		try {
			Account accout = new Account();
			accout.setId(session.getAttribute("accountId").toString());
			contract.setCreateAccount(accout);

			String createAccountName = requ.getParameter("createAccountName");
			User userSelect = new User();
			userSelect.setName(createAccountName);
			accout.setUser(userSelect);
			contract.setCreateAccount(accout);

			String editAccountName = requ.getParameter("editAccountName");

			User userSelectEdit = new User();
			userSelectEdit.setName(editAccountName);
			Account accout1 = new Account();
			accout1.setUser(userSelectEdit); 
			contract.setEditAccount(accout1);
			Map<String,Object> map=paymentRemService.queryPie(contract,state);
			Map<String,Object> map1=new HashMap<String, Object>();
			BigDecimal total=new BigDecimal(map.get("total").toString());
			BigDecimal calc=new BigDecimal(map.get("calc").toString());
			BigDecimal calt=new BigDecimal(map.get("calt").toString());
			BigDecimal ref=new BigDecimal(map.get("ref").toString());
			BigDecimal ret=new BigDecimal(map.get("ret").toString());
			map1.put("name", "逾期未缴");
			map1.put("y",total==null?BigDecimal.ZERO:calt.divide(total,4,BigDecimal.ROUND_HALF_DOWN));
			resultList.add(map1);
			Map<String,Object> map2=new HashMap<String, Object>();
			map2.put("name", "临近缴帐");
			map2.put("y", total==null?BigDecimal.ZERO:ret.divide(total,4,BigDecimal.ROUND_HALF_DOWN));
			resultList.add(map2);
			Map<String,Object> map3=new HashMap<String, Object>();
			map3.put("name", "缴款未到账");
			map3.put("y", total==null?BigDecimal.ZERO:calc.divide(total,4,BigDecimal.ROUND_HALF_DOWN));
			resultList.add(map3);
			Map<String,Object> map4=new HashMap<String, Object>();
			map4.put("name", "未到期");
			map4.put("y", total==null?BigDecimal.ZERO:ref.divide(total,4,BigDecimal.ROUND_HALF_DOWN));
			resultList.add(map4);
			return resultList;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 查询出未到账的各个状态的数量
	 * @author 朱玉猛
	 * @return 
	 * @throws CRUDException 
	 * @since 2015年7月15日16:09:40
	 *//*
	@RequestMapping("countCountwdz")
	@ResponseBody
	public Map<String, Object> countCountwdz(ModelMap modelMap, Contract contract, Page page, String state, HttpSession session, HttpServletRequest requ) throws CRUDException{
		try {
			Account accout = new Account();
			accout.setId(session.getAttribute("accountId").toString());
			contract.setCreateAccount(accout);

			String createAccountName = requ.getParameter("createAccountName");
			User userSelect = new User();
			userSelect.setName(createAccountName);
			accout.setUser(userSelect);
			contract.setCreateAccount(accout);

			String editAccountName = requ.getParameter("editAccountName");

			User userSelectEdit = new User();
			userSelectEdit.setName(editAccountName);
			Account accout1 = new Account();
			accout1.setUser(userSelectEdit); 
			contract.setEditAccount(accout1);
			Map<String,Object> map=paymentRemService.queryPie(contract,state);
			return map;
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
}
*/