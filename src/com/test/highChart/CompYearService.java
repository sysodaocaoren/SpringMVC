/*package com.ecode.land.service.deskTop;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecode.land.domain.contract.Contract;
import com.ecode.land.domain.deskTop.ComYearTable;
import com.ecode.land.domain.deskTop.ComYearZQ;
import com.ecode.land.exception.CRUDException;
import com.ecode.land.persistence.deskTop.ComYearMapper;
import com.ecode.land.persistence.page.impl.PageManager;
import com.ecode.land.util.Page;
*//**
 * 首页面 年度综合收支看板  左上角的表格
 * @author 朱玉猛
 * @since 2015年7月6日11:42:51
 *//*
@Service
@SessionAttributes("accountId")
public class CompYearService {
	private static Logger log = Logger.getLogger(CompYearService.class);
	@Autowired 
	private  ComYearMapper comYearMapper;
	@Autowired
	private PageManager<ComYearZQ> zqpageManager;
	public List<ComYearTable> queryTable(ComYearTable comYearTable0) throws CRUDException {
		int year=Integer.parseInt(comYearTable0.getYear());
		List<ComYearTable> comYearTables=new ArrayList<ComYearTable>();
		try {
			ComYearTable comYearTable=comYearMapper.queryTable(Integer.toString(year));
			ComYearTable comYearTable00=comYearMapper.queryContract(Integer.toString(year));
			if(comYearTable00!=null){
				comYearTable.setTotalContractMoney(comYearTable00.getTotalContractMoney());
				comYearTable.setLandCount(comYearTable00.getLandCount());
			}
			ComYearTable comYearTable1=comYearMapper.queryTable(Integer.toString(year-1));
			ComYearTable comYearTable11=comYearMapper.queryContract(Integer.toString(year-1));
			if(comYearTable11!=null){
				comYearTable1.setTotalContractMoney(comYearTable11.getTotalContractMoney());
				comYearTable1.setLandCount(comYearTable11.getLandCount());
			}
			
			ComYearTable comYearTable2=comYearMapper.queryTable(Integer.toString(year-2));
			ComYearTable comYearTable22=comYearMapper.queryContract(Integer.toString(year-2));
			if(comYearTable22!=null){
				comYearTable2.setTotalContractMoney(comYearTable22.getTotalContractMoney());
				comYearTable2.setLandCount(comYearTable22.getLandCount());
			}
			if("chart".equals(comYearTable0.getCondition())){
				comYearTables.add(comYearTable2);
				comYearTables.add(comYearTable1);
				comYearTables.add(comYearTable);
			}else{
				comYearTables.add(comYearTable);
				comYearTables.add(comYearTable1);
				comYearTables.add(comYearTable2);
			}
			return comYearTables;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 查询出地王信息
	 * @param comYearTable
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<Contract> loadSearchLandKing(ComYearTable comYearTable) throws CRUDException {
		try {
//			//日期格式化
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Calendar cal = Calendar.getInstance();
//			String currTime = format.format(new Date());
//			String upTime = cal.get(Calendar.YEAR)-1+"-01-01";
//			comYearTable.setDateTimeStart(upTime);
//			comYearTable.setDateTimeEnd(currTime);
			List<Contract> contracts=comYearMapper.loadSearchLandKing(comYearTable);
			return contracts;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 宗地数量钻取
	 * @param comYearTable
	 * @param page 
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<ComYearZQ> viewlandCount(ComYearTable comYearTable, Page page) throws CRUDException {
		try {
			List<ComYearZQ> comYearZQs = this.zqpageManager.selectPage(comYearTable, page, ComYearMapper.class.getName() + ".viewlandCount");
//			List<ComYearZQ> comYearZQs=comYearMapper.viewlandCount(comYearTable);
			return comYearZQs;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 宗地数量钻取
	 * @param comYearTable
	 * @param page 
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<ComYearZQ> viewlandCounttt(ComYearTable comYearTable) throws CRUDException {
		try {
//			List<ComYearZQ> comYearZQs = this.zqpageManager.selectPage(comYearTable, page, ComYearMapper.class.getName() + ".viewlandCount");
			List<ComYearZQ> comYearZQs=comYearMapper.viewlandCount(comYearTable);
			return comYearZQs;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 计算出各个熟化主体应收尽收进度
	 * @param comYearTable6
	 * @return
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月8日15:13:19
	 *//*
	public List<ComYearTable> loadPlan(ComYearTable comYearTable6) throws CRUDException {
		
		try {
			return comYearMapper.loadPlan(comYearTable6);
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 查询出全部的比例
	 * @param comYearTable6
	 * @return
	 * @throws CRUDException 
	 *//*
	public ComYearTable findTotalComTable(ComYearTable comYearTable6) throws CRUDException {
		try {
			return comYearMapper.findTotalComTable(comYearTable6);
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 月度综合看板
	 * @param comYearTable6
	 * @return
	 * @throws CRUDException
	 *//*
	public Map<String,Object> comMonth(ComYearTable comYearTable6) throws CRUDException {
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			List<ComYearTable> comYearTablesIncom= comYearMapper.incom(comYearTable6);//查询出每个月的收入
			List<ComYearTable> comYearTablesCostQS= comYearMapper.costQSD(comYearTable6);//查询出每个月的清算单支出
			List<ComYearTable> comYearTablesIncomAllocation= comYearMapper.costAllocation(comYearTable6);//查询出每个月的至今分配支出
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH);
			//声明收入支出list
			List<ComYearTable> comYearTablesIncoms=new ArrayList<ComYearTable>();
			List<ComYearTable> comYearTablesCost=new ArrayList<ComYearTable>();
			for(int i=0;i<month+1;i++){
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
							totalCostByMonth=totalCostByMonth.add(comYearTablesCostQS.get(qs).getCostMoneyQS()==null?BigDecimal.ZERO:comYearTablesCostQS.get(qs).getCostMoneyQS());
						}
					}
				}
				if(comYearTablesIncomAllocation.size()!=0){
					for(int fp=0;fp<comYearTablesIncomAllocation.size();fp++){
						if(Integer.parseInt(comYearTablesIncomAllocation.get(fp).getMonth())==i+1){
							costFlagfp=true;
							totalCostByMonth=totalCostByMonth.add(comYearTablesIncomAllocation.get(fp).getCostMoneyFP()==null?BigDecimal.ZERO:comYearTablesIncomAllocation.get(fp).getCostMoneyFP());
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
			
			 *将数据封装成json格式传到前台图表 
			 
			List<String> months= new ArrayList<String>();
			List<Object> incomeByMonthArray =new ArrayList<Object>();
			if(comYearTablesIncoms !=null && !comYearTablesIncoms.isEmpty()){
				for(ComYearTable analyseYear: comYearTablesIncoms){
					months.add(analyseYear.getMonth());
					incomeByMonthArray.add(analyseYear.getIncomBym());
				}
			}
			List<Object> paymentArray =new ArrayList<Object>();
			if(comYearTablesCost !=null && !comYearTablesCost.isEmpty()){
				for(ComYearTable analyseYear: comYearTablesCost){
					paymentArray.add(analyseYear.getCostByMonth());
				}
			}
			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			Map<String,Object> contentMap=new HashMap<String,Object>();
			
			contentMap.put("name", "收入");
			contentMap.put("data",incomeByMonthArray);
			
			Map<String,Object> contentMaps=new HashMap<String,Object>();
			
			contentMaps.put("name", "支出");
			contentMaps.put("data",paymentArray);
			
			list.add(contentMap);
			list.add(contentMaps);

			map.put("months", months);
			map.put("seriesIncome", list);
			return map;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
		
	}
	*//**
	 * 获取所有的熟化主体的名称
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<String> getCurmainName() throws CRUDException {
		try {
			return  comYearMapper.getCurmainName();
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}	
	}
}
*/