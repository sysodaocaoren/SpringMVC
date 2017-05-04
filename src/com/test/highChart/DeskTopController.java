/*package com.ecode.land.web.controller.deskTop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ecode.land.domain.contract.Contract;
import com.ecode.land.domain.deskTop.ComYearTable;
import com.ecode.land.domain.deskTop.ComYearZQ;
import com.ecode.land.domain.deskTop.LandMarket;
import com.ecode.land.exception.CRUDException;
import com.ecode.land.persistence.deskTop.ComYearMapper;
import com.ecode.land.service.basicsInfo.CurMainService;
import com.ecode.land.service.deskTop.CompYearService;
import com.ecode.land.service.deskTop.LandMarketService;
import com.ecode.land.util.Page;

*//**
 * 桌面看板controller
 * @author 朱玉猛
 *@since 2015年7月2日09:45:38
 *//*
@Controller
@RequestMapping({"deskTop"})
@SessionAttributes("user")
public class DeskTopController {
	private static Logger log = Logger.getLogger(DeskTopController.class);
	@Autowired
	private CompYearService compYearService;
	@Autowired
	private LandMarketService landMarketService ;
	@Autowired 
	private  ComYearMapper comYearMapper;
    @Autowired
    private CurMainService curMainService;
	*//**
	 * 年度综合看板首页
	 *//*
	@RequestMapping("index")
	public ModelAndView index(ModelMap modelMap){
		
		
		
		return new ModelAndView("desktop/desktopMain",modelMap);
	}
	*//**
	 * 年度综合看板
	 * @throws CRUDException 
	 *//*
	@RequestMapping("comYear")
	public ModelAndView comYear(ModelMap modelMap) throws CRUDException{
		ComYearTable comYearTable=new ComYearTable();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		comYearTable.setYear(Integer.toString(year));
		try {
			List<ComYearTable> comYearTables = compYearService.queryTable(comYearTable);
			modelMap.put("comYearTables", comYearTables);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		
		return new ModelAndView("desktop/viewComYear",modelMap);
	}
	*//**
	 * 土地市场看板
	 * @param modelMap
	 * @return
	 * @throws CRUDException 
	 *//*
	@RequestMapping("landMarket")
	public ModelAndView landMarket(ModelMap modelMap) throws CRUDException{
		try {
			List<LandMarket> landMarkets=new ArrayList<LandMarket>();
			LandMarket landMarket=new LandMarket();
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			landMarket.setYear(Integer.toString(year));
			landMarkets=landMarketService.queryTable(landMarket);
			modelMap.put("landMarkets", landMarkets);
			modelMap.put("year", year);
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return new ModelAndView("desktop/viewLandMarket",modelMap);
	}
	*//**
	 * 缴款提醒看板
	 * @param modelMap
	 * @return
	 * @throws CRUDException 
	 *//*
	@RequestMapping("PaymentReminder")
	public ModelAndView PaymentReminder(ModelMap modelMap) throws CRUDException{
		try {
			Calendar cal = Calendar.getInstance();
			int fullYear = cal.get(Calendar.YEAR);  //获取当前年份
			Date date=new Date();
			modelMap.put("date", date);
			modelMap.put("timeStart", fullYear-1+"-01-01");//起始日期在当前日期往前推2年
			modelMap.put("curMainlist", this.curMainService.listCurMain());
			return new ModelAndView("desktop/viewPaymentReminder",modelMap);
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 地王柱状图
	 * @return
	 * @throws CRUDException 
	 *//*
	@RequestMapping("loadSearchLandKing")
	@ResponseBody
	public Object loadSearchLandKing(ComYearTable comYearTable) throws CRUDException{
		Map<String, Object> map;
		try {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			comYearTable.setYear(Integer.toString(year));
			//查询出数据，并且封装到list中
			List<Contract> contracts=compYearService.loadSearchLandKing(comYearTable);
			map = new HashMap<String,Object>();
			//声明map，并且插入数据
			Map<String,Object> contractMoneyMap=new HashMap<String,Object>();
			Map<String,Object> areasMap=new HashMap<String,Object>();
			Map<String,Object> unitPriceMap=new HashMap<String,Object>();
			Map<String,Object> trafRatioMap=new HashMap<String,Object>();
			contractMoneyMap.put("name","合同价款（亿元）");
			areasMap.put("name", "地块面积（平方米）");
			unitPriceMap.put("name", "单位地价（元）");
			trafRatioMap.put("name", "溢价率（%）");
			List<Object> contractMoneys=new LinkedList<Object>();
			List<Object> areas=new LinkedList<Object>();
			List<Object>  unitPrice=new LinkedList<Object>();
			List<Object>  trafRatio=new LinkedList<Object>();
			List<Object> series=new LinkedList<Object>();
			List<Object> comPanyNames=new LinkedList<Object>();
			
			for(Contract contract:contracts){
				if(contract!=null){
					comPanyNames.add(contract.getLandLocation());
					contractMoneys.add(contract.getContractMoney().setScale(2, BigDecimal.ROUND_HALF_UP));
					areas.add(contract.getSellArea().setScale(2, BigDecimal.ROUND_HALF_UP));
					unitPrice.add(contract.getUnitPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
					trafRatio.add(new BigDecimal(contract.getTrafRatio()).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP));
				}
			}
			contractMoneyMap.put("data", contractMoneys);
			areasMap.put("data", areas);
			unitPriceMap.put("data", unitPrice);
			trafRatioMap.put("data", trafRatio);
			//判断是通过哪种口径查询的返回数据
			String titleName="";
			if("contractmoney".equals(comYearTable.getCondition())){
				titleName=year+"年度地王（合同额）top（5）排名";
				map.put("titleName", titleName);
				series.add(contractMoneyMap);
			}
			if("sellarea".equals(comYearTable.getCondition())){
				titleName=year+"年度地王（供地面积）top（5）排名";
				map.put("titleName", titleName);
				series.add(areasMap);
			}
			if("unitprice".equals(comYearTable.getCondition())){
				titleName=year+"年度地王（单位地价）top（5）排名";
				map.put("titleName", titleName);
				series.add(unitPriceMap);
			}
			if("trafRatio".equals(comYearTable.getCondition())){
				titleName=year+"年度地王（溢价率）top（5）排名";
				map.put("titleName", titleName);
				series.add(trafRatioMap);
			}
			map.put("companyName", comPanyNames);
			map.put("series", series);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return map;
	}
	*//**
	 * 年度综合看板
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月7日13:55:51
	 *//*
	@RequestMapping("loadAnnualSummary")
	@ResponseBody
	public Object loadAnnualSummary() throws CRUDException{
		Map<String, List<Object>> map;
		try {
			map = new HashMap<String,List<Object>>();//声明返回的数据
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			ComYearTable comYearTable6 =new ComYearTable();
			comYearTable6.setYear(Integer.toString(year));
			comYearTable6.setCondition("chart");
			List<ComYearTable> comYearTables = compYearService.queryTable(comYearTable6);//从数据库中查询出原始的数据
			List<Object> years = new ArrayList<Object>();
			List<Object> series = new ArrayList<Object>();
			
			//封装数据
			Map<String, Object> landCount = new HashMap<String,Object>();
			landCount.put("type", "spline");
			landCount.put("name", "出让宗地数");

			Map<String, Object> contractMoney = new HashMap<String,Object>();
			contractMoney.put("type", "column");
			contractMoney.put("name", "合同价款");

			Map<String, Object> income = new HashMap<String,Object>();
			income.put("type", "column");
			income.put("name", "出让总收入");

			Map<String, Object> back = new HashMap<String,Object>();
			back.put("type", "column");
			back.put("name", "已返成本");

			Map<String, Object> allocation = new HashMap<String,Object>();
			allocation.put("type", "column");
			allocation.put("name", "分配金额");
			
			List<Object> landCountArray = new ArrayList<Object>();
			List<Object> contractMomeyArray = new ArrayList<Object>();
			List<Object> incomeArray = new ArrayList<Object>();
			List<Object> backArray = new ArrayList<Object>();
			List<Object> allocationArray = new ArrayList<Object>();
			for(ComYearTable comYearTable:comYearTables){
				if(comYearTable!=null){
					years.add(comYearTable.getYear());
					landCountArray.add(Integer.parseInt(comYearTable.getLandCount()));//heightChart只能用数字，字符串不识别
					contractMomeyArray.add(comYearTable.getTotalContractMoney());
					incomeArray.add(comYearTable.getTotalIncomeMoney());
					backArray.add(comYearTable.getBackMoney());
					allocationArray.add(comYearTable.getGuessMoney());
				}
			}
			landCount.put("data", landCountArray);
			contractMoney.put("data", contractMomeyArray);
			income.put("data", incomeArray);
			back.put("data", backArray);
			allocation.put("data", allocationArray);
			
			series.add(contractMoney);
			series.add(landCount);
			series.add(income);
			series.add(back);
			series.add(allocation);
			map.put("years", years);
			map.put("series", series);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return map;
	}
	*//**
	 * 年度综合看板表格钻取
	 * @throws CRUDException 
	 * 
	 *//*
	@RequestMapping("viewlandCount")
	public ModelAndView viewlandCount(ModelMap modelMap,ComYearTable comYearTable,Page page) throws CRUDException{
		String returnView="";
		try {
			if("viewlandCount".equals(comYearTable.getCondition())){
				returnView="desktop/comYear/viewLandCount";
				
			}else if("viewIncomeMoney".equals(comYearTable.getCondition())){
				returnView="desktop/comYear/viewToTalIncome";
				comYearTable.setIfYear("1");
			}else if("viewContractMoney".equals(comYearTable.getCondition())){
				returnView="desktop/comYear/viewContractMoney";
			}else if("viewBackMoney".equals(comYearTable.getCondition())){
				returnView="desktop/comYear/viewBackMoney";
				comYearTable.setIfYear("2");
			}else{
				returnView="desktop/comYear/viewAllocationMoney";
				comYearTable.setIfYear("3");
			}
 			List<ComYearZQ> comYearZQs=compYearService.viewlandCount(comYearTable,page);
 			List<ComYearZQ> totalcomYearZQs=compYearService.viewlandCounttt(comYearTable);//不按分页查询，计算出合计
 			//计算合计
 			BigDecimal allContractMoney=new BigDecimal("0");//合同价款总计
 			BigDecimal allallocationMoney=new BigDecimal("0");//分配金额合计
 			BigDecimal allincomeMoney=new BigDecimal("0");//收入总计
 			BigDecimal allbackMoney=new BigDecimal("0");//已返成本总计
 			BigDecimal allDZmoney=new BigDecimal("0");//到账收入总计
 			BigDecimal allLXmoney=new BigDecimal("0");//利息金额总计
 			BigDecimal allZNJmoney=new BigDecimal("0");//滞纳金总计
 			for(ComYearZQ ComYearZQ:totalcomYearZQs){
 				allContractMoney=allContractMoney.add(ComYearZQ.getContractMoney()==null?BigDecimal.ZERO:ComYearZQ.getContractMoney());
 				allallocationMoney=allallocationMoney.add(ComYearZQ.getAllocationMoney()==null?BigDecimal.ZERO:ComYearZQ.getAllocationMoney());
 				allincomeMoney=allincomeMoney.add(ComYearZQ.getIncomeMoney()==null?BigDecimal.ZERO:ComYearZQ.getIncomeMoney());
 				allbackMoney=allbackMoney.add(ComYearZQ.getBackMoney()==null?BigDecimal.ZERO:ComYearZQ.getBackMoney());
 				allDZmoney=allDZmoney.add(ComYearZQ.getDZmoney()==null?BigDecimal.ZERO:ComYearZQ.getDZmoney());
 				allLXmoney=allLXmoney.add(ComYearZQ.getLXmoney()==null?BigDecimal.ZERO:ComYearZQ.getLXmoney());
 				allZNJmoney=allZNJmoney.add(ComYearZQ.getZNJmoney()==null?BigDecimal.ZERO:ComYearZQ.getZNJmoney());
 			}
			modelMap.put("allContractMoney", allContractMoney.divide(new BigDecimal("100000000")));
			modelMap.put("allallocationMoney", allallocationMoney.divide(new BigDecimal("100000000")));
			modelMap.put("allincomeMoney", allincomeMoney.divide(new BigDecimal("100000000")));
			modelMap.put("allbackMoney", allbackMoney.divide(new BigDecimal("100000000")));
			modelMap.put("allDZmoney", allDZmoney.divide(new BigDecimal("100000000")));
			modelMap.put("allLXmoney", allLXmoney.divide(new BigDecimal("100000000")));
			modelMap.put("allZNJmoney", allZNJmoney.divide(new BigDecimal("100000000")));
			modelMap.put("comYearZQs", comYearZQs);
			modelMap.put("pageobj", page);
			modelMap.put("queryObject", comYearTable);
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		} 
		return new ModelAndView(returnView,modelMap);
		
	}
	*//**
	 * 看板下面的仪表盘
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月8日15:05:15
	 *//*
	@RequestMapping("loadPlan")
	@ResponseBody
	public List<ComYearTable> loadPlan() throws CRUDException{
		List<ComYearTable> result =new ArrayList<ComYearTable>();
		try {
			//获取所有的熟化主体的名称
			List<String> curmainNames=compYearService.getCurmainName();
			List<ComYearTable> comYearTables = new ArrayList<ComYearTable>();
			//添加查询条件
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			ComYearTable comYearTable6 =new ComYearTable();
			comYearTable6.setYear(Integer.toString(year));
			comYearTables=compYearService.loadPlan(comYearTable6);
			
			ComYearTable comYearTablel=compYearService.findTotalComTable(comYearTable6);
			comYearTablel.setRatio(comYearTablel.getTotalRatio().setScale(2, BigDecimal.ROUND_HALF_UP));
			comYearTablel.setCurmainName("综合应收尽收进度");
			result.add(0, comYearTablel);
			for(int cs=0;cs<curmainNames.size();cs++){
				boolean flag=false;
				for(int i=0;i<comYearTables.size();i++){
					if(curmainNames.get(cs).equals(comYearTables.get(i).getCurmainName())){
						flag=true;
						ComYearTable comYearTable=new ComYearTable();
						comYearTable.setRatio(comYearTables.get(i).getRatio()==null? new BigDecimal("0"):comYearTables.get(i).getRatio().setScale(2, BigDecimal.ROUND_HALF_UP));
						comYearTable.setCurmainName(comYearTables.get(i).getCurmainName());
						comYearTable.setFinishMoney(comYearTables.get(i).getFinishMoney()==null?BigDecimal.ZERO:comYearTables.get(i).getFinishMoney());
						comYearTable.setTotalMoney(comYearTables.get(i).getTotalMoney()==null?BigDecimal.ZERO:comYearTables.get(i).getTotalMoney());
						result.add(cs+1, comYearTable);
					}
				}
				if(!flag){
					ComYearTable comYearTable=new ComYearTable();
					comYearTable.setRatio(new BigDecimal("0"));
					comYearTable.setFinishMoney(BigDecimal.ZERO);
					comYearTable.setTotalMoney(BigDecimal.ZERO);
					comYearTable.setCurmainName(curmainNames.get(cs));
					result.add(cs+1, comYearTable);
				}
			}
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return result;
	}
	*//**
	 * 月度分析图后台controller
	 * @throws CRUDException 
	 *//*
	@RequestMapping("loadIncome")
	@ResponseBody
	public Object loadIncome() throws CRUDException{
		//添加查询条件
		Map<String, Object> map;
		try {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			ComYearTable comYearTable6 =new ComYearTable();
			comYearTable6.setYear(Integer.toString(year));
			
			map = new HashMap<String,Object>();
			map=compYearService.comMonth(comYearTable6);
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return map;
	}
	*//**
	 * 地王点击查看详细
	 * @throws CRUDException 
	 * @author 朱玉猛
	 * @since 2015年7月9日14:01:00
	 *//*
	@RequestMapping("viewlandKingDetail")
	public ModelAndView viewlandKingDetail(ComYearTable comYearTable,ModelMap modelMap,Page page) throws CRUDException{
		try {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			comYearTable.setYear(Integer.toString(year));
			//查询出数据，并且封装到list中
			List<Contract> contracts=compYearService.loadSearchLandKing(comYearTable);
			modelMap.put("contracts", contracts);
			modelMap.put("page", page);
			modelMap.put("comYearTable", comYearTable);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return new ModelAndView("desktop/comYear/viewDetailLandKing",modelMap); 
	}
	*//**
	 * 月度收支查看详细
	 * @throws CRUDException 
	 *//*
	@RequestMapping("viewInoutDetail")
	public ModelAndView viewInoutDetail(ModelMap modelMap) throws CRUDException{
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		ComYearTable comYearTable6 =new ComYearTable();
		comYearTable6.setYear(Integer.toString(year));
			List<ComYearTable> comYearTablesIncom= comYearMapper.incom(comYearTable6);//查询出每个月的收入
			List<ComYearTable> comYearTablesCostQS= comYearMapper.costQSD(comYearTable6);//查询出每个月的清算单支出
			List<ComYearTable> comYearTablesIncomAllocation= comYearMapper.costAllocation(comYearTable6);//查询出每个月的至今分配支出
			
			//声明收入支出list
			List<ComYearTable> comYearTablesIncoms=new ArrayList<ComYearTable>();
			List<ComYearTable> comYearTablesCost=new ArrayList<ComYearTable>();
			
			for(int i=0;i<12;i++){
				boolean incomFlag=false;
				boolean costFlagqs=false;
				boolean costFlagfp=false;
				BigDecimal totalCostByMonth=new BigDecimal("0");//声明每个月的总支出
				
				 *按月份循环查看每个月的收入，这个月有收入则加入list，没有这个月的收入为零 
				 
				if(comYearTablesIncom.size()!=0){
					for(int in=0;in<comYearTablesIncom.size();in++){
						if(Integer.parseInt(comYearTablesIncom.get(in).getMonth())==i+1){//查询出来的月份有当前循环的月份
							incomFlag=true;
							comYearTablesIncoms.add(i,comYearTablesIncom.get(in));
						}
					}
					if(!incomFlag){
						ComYearTable comYearTable=new ComYearTable();
						comYearTable.setMonth(String.valueOf(i+1));
						comYearTable.setIncomBym(new BigDecimal("0"));
						comYearTablesIncoms.add(i,comYearTable);
					}
				}
				if(comYearTablesCostQS.size()!=0){
					for(int qs=0;qs<comYearTablesCostQS.size();qs++){
						if(Integer.parseInt(comYearTablesCostQS.get(qs).getMonth())==i+1){
							costFlagqs=true;
							totalCostByMonth=totalCostByMonth.add(comYearTablesCostQS.get(qs).getCostMoneyQS()==null?BigDecimal.ZERO:comYearTablesCostQS.get(qs).getCostMoneyQS().setScale(3, BigDecimal.ROUND_HALF_EVEN));
						}
					}
				}
				if(comYearTablesIncomAllocation.size()!=0){
					for(int fp=0;fp<comYearTablesIncomAllocation.size();fp++){
						if(Integer.parseInt(comYearTablesIncomAllocation.get(fp).getMonth())==i+1){
							costFlagfp=true;
							totalCostByMonth=totalCostByMonth.add(comYearTablesIncomAllocation.get(fp).getCostMoneyFP()==null?BigDecimal.ZERO:comYearTablesIncomAllocation.get(fp).getCostMoneyFP().setScale(3, BigDecimal.ROUND_HALF_EVEN));
						}
					}
				}
				if(!costFlagqs&&!costFlagfp){
					ComYearTable comYearTable2=new ComYearTable();
					comYearTable2.setMonth(String.valueOf(i+1));
					comYearTable2.setCostByMonth(new BigDecimal("0"));
					comYearTablesCost.add(i,comYearTable2);
				}else{
					ComYearTable comYearTable2=new ComYearTable();
					comYearTable2.setMonth(String.valueOf(i+1));
					comYearTable2.setCostByMonth(totalCostByMonth);
					comYearTablesCost.add(i,comYearTable2);
				}
			}
			modelMap.put("incomList", comYearTablesIncoms);
			modelMap.put("costList", comYearTablesCost);
			modelMap.put("fullYear", year+"年度");
		return new ModelAndView("desktop/comYear/viewInoutDetail",modelMap);
	}
	*//**
	 * 仪表盘查看详细
	 * @param modelMap
	 * @return
	 * @throws CRUDException
	 *//*
	@RequestMapping("viewPlanDetail")
	public ModelAndView viewPlanDetail(ModelMap modelMap) throws CRUDException{
		try {
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			List<ComYearTable> comYearTables=loadPlan();
			List<String> curmains=new ArrayList<String>();
			List<BigDecimal> finishMoney=new ArrayList<BigDecimal>();
			List<BigDecimal> totalMoney=new ArrayList<BigDecimal>();
			List<BigDecimal> ratios=new ArrayList<BigDecimal>();
			List<BigDecimal> unfinish=new ArrayList<BigDecimal>();
			if(comYearTables.size()!=0){
				for(int i=1;i<comYearTables.size();i++){
					curmains.add(i-1,comYearTables.get(i).getCurmainName());
					finishMoney.add(i-1,comYearTables.get(i).getFinishMoney()==null?BigDecimal.ZERO:comYearTables.get(i).getFinishMoney());
					totalMoney.add(i-1,comYearTables.get(i).getTotalMoney()==null?BigDecimal.ZERO:comYearTables.get(i).getTotalMoney());
					ratios.add(i-1,comYearTables.get(i).getRatio()==null?BigDecimal.ZERO:comYearTables.get(i).getRatio());
					unfinish.add(i-1,(comYearTables.get(i).getTotalMoney()==null?BigDecimal.ZERO:comYearTables.get(i).getTotalMoney()).subtract(comYearTables.get(i).getFinishMoney()==null?BigDecimal.ZERO:comYearTables.get(i).getFinishMoney()));
				}
				
			}
			modelMap.put("curmains", curmains);
			modelMap.put("finishMoney", finishMoney);
			modelMap.put("totalMoney", totalMoney);
			modelMap.put("ratios", ratios);
			modelMap.put("unfinish", unfinish);
			modelMap.put("fullYear", year+"年度");
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return new ModelAndView("desktop/comYear/viewPlanDetail",modelMap);
	}

}
*/