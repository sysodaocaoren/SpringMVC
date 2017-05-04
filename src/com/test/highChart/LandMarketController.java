/*package com.ecode.land.web.controller.deskTop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecode.land.domain.contract.Contract;
import com.ecode.land.domain.deskTop.LandMarket;
import com.ecode.land.domain.deskTop.LandUsion;
import com.ecode.land.exception.CRUDException;
import com.ecode.land.service.deskTop.CompYearService;
import com.ecode.land.service.deskTop.LandMarketService;
*//**
 * 土地市场看板后台Controller
 * @author lining
 *
 *//*
@Controller
@RequestMapping({"landMarket"})
@SessionAttributes("user")
public class LandMarketController {
	private static Logger log = Logger.getLogger(LandMarketController.class);
	
	private final String landTypeId03 = "00000000000000000000000000000003";
	private final String landTypeId04 = "00000000000000000000000000000004";
	
	@Autowired
	private LandMarketService landMarketService ;
	@Autowired
	private CompYearService compYearService;
	@RequestMapping("landMarketPie")
	@ResponseBody
	public Object landMarketPie(LandMarket landMarket) throws CRUDException{
		List<Object> landMarketPies=new ArrayList<Object>();
		try {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			landMarket.setYear(Integer.toString(year));
			List<LandMarket> landMarkets=landMarketService.queryPie(landMarket);//土地市场看板饼图第一层数据
			List<LandUsion> landUsionsGY=landMarketService.queryPieGY(landMarket);//工业用地钻取
			List<LandUsion> landUsionsJY=landMarketService.queryPieJY(landMarket);//经营性用地钻取
			if("landCount".equals(landMarket.getCondition())){
				for(LandMarket lt:landMarkets){
					Map<String,Object> map=new HashMap<String,Object>();
					if("国有出让-经营性".equals(lt.getLandUse())){
						List<Object> landMarketPiesJY=new ArrayList<Object>();
						for(LandUsion landUsion:landUsionsJY){
							Map<String,Object> mapJY=new HashMap<String,Object>();
							mapJY.put("name", landUsion.getLandUser());
							mapJY.put("y", landUsion.getUlandCountRatio());
							landMarketPiesJY.add(mapJY);
						}
						map.put("name", lt.getLandUse());
						map.put("y", lt.getLandCountRatio());
						map.put("drilldown", landMarketPiesJY);
						landMarketPies.add(map);
					}else{
						List<Object> landMarketPiesGY=new ArrayList<Object>();
						for(LandUsion landUsion:landUsionsGY){
							Map<String,Object> mapGY=new HashMap<String,Object>();
							mapGY.put("name", landUsion.getLandUser().equals("工业用地")?"一般/综合"+landUsion.getLandUser():landUsion.getLandUser());
							mapGY.put("y", landUsion.getUlandCountRatio());
							landMarketPiesGY.add(mapGY);
						}
						map.put("name", lt.getLandUse());
						map.put("y", lt.getLandCountRatio());
						map.put("drilldown", landMarketPiesGY);
						landMarketPies.add(map);
					}
					
				}
				
			}
			if("sellArea".equals(landMarket.getCondition())){
				for(LandMarket lt:landMarkets){
					if("国有出让-经营性".equals(lt.getLandUse())){
						List<Object> landMarketPiesJY=new ArrayList<Object>();
						for(LandUsion landUsion:landUsionsJY){
							Map<String,Object> mapJY=new HashMap<String,Object>();
							mapJY.put("name", landUsion.getLandUser().equals("工业用地")?"一般/综合"+landUsion.getLandUser():landUsion.getLandUser());
							mapJY.put("y", landUsion.getUlandAreaRatio());
							landMarketPiesJY.add(mapJY);
						}
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("name", lt.getLandUse());
						map.put("y", lt.getLandAreaRatio());
						map.put("drilldown", landMarketPiesJY);
						landMarketPies.add(map);
					}else{
						List<Object> landMarketPiesGY=new ArrayList<Object>();
						for(LandUsion landUsion:landUsionsGY){
							Map<String,Object> mapGY=new HashMap<String,Object>();
							mapGY.put("name", landUsion.getLandUser().equals("工业用地")?"一般/综合"+landUsion.getLandUser():landUsion.getLandUser());
							mapGY.put("y", landUsion.getUlandAreaRatio());
							landMarketPiesGY.add(mapGY);
						}
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("name", lt.getLandUse());
						map.put("y", lt.getLandAreaRatio());
						map.put("drilldown", landMarketPiesGY);
						landMarketPies.add(map);
					}
				}
			}
			if("contractMoney".equals(landMarket.getCondition())){
				for(LandMarket lt:landMarkets){
					if("国有出让-经营性".equals(lt.getLandUse())){
						List<Object> landMarketPiesJY=new ArrayList<Object>();
						for(LandUsion landUsion:landUsionsJY){
							Map<String,Object> mapJY=new HashMap<String,Object>();
							mapJY.put("name", landUsion.getLandUser().equals("工业用地")?"一般/综合"+landUsion.getLandUser():landUsion.getLandUser());
							mapJY.put("y", landUsion.getUcontractMoneyRatio());
							landMarketPiesJY.add(mapJY);
						}
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("name", lt.getLandUse());
						map.put("y", lt.getCountractMoneyRatio());
						map.put("drilldown", landMarketPiesJY);
						landMarketPies.add(map);
					}else{
						List<Object> landMarketPiesGY=new ArrayList<Object>();
						for(LandUsion landUsion:landUsionsGY){
							Map<String,Object> mapGY=new HashMap<String,Object>();
							mapGY.put("name", landUsion.getLandUser().equals("工业用地")?"一般/综合"+landUsion.getLandUser():landUsion.getLandUser());
							mapGY.put("y", landUsion.getUcontractMoneyRatio());
							landMarketPiesGY.add(mapGY);
						}
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("name", lt.getLandUse());
						map.put("y", lt.getCountractMoneyRatio());
						map.put("drilldown", landMarketPiesGY);
						landMarketPies.add(map);
					}
				}
			}
			
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		} 
		return landMarketPies;
	}
	*//**
	 * 土地市场看板左上角的柱状图
	 * @param landMarket
	 * @return
	 * @throws CRUDException
	 *//*
	@RequestMapping("loadLeftTop")
	@ResponseBody
	public Object loadLeftTop(LandMarket landMarket) throws CRUDException{
		Map<String, List<Object>> resultMap;
		List<Object> series = new ArrayList<Object>();
		Map<String, Object> gycrgyMap = new HashMap<String,Object>();   //国有出让-工业
		Map<String, Object> gycrjyxMap = new HashMap<String,Object>();	//国有出让-经营性
		List<Object> landCountArrayGY = new ArrayList<Object>();		//国有出让-工业list
		List<Object> landCountArrayJYX = new ArrayList<Object>();		//国有出让-经营性list
		Calendar cal = Calendar.getInstance();
		
		try {
			//当前年份
			int year = cal.get(Calendar.YEAR);
			//x轴数据，当前年份，上一年份
			List<Object> years = new ArrayList<Object>();
			years.add(year-1);
			years.add(year);
			resultMap = new HashMap<String,List<Object>>();//声明返回的数据
			//查询当前年份和上一年份的数据
			for(int i = 0;i<years.size();i++){
				//封装查询条件
				landMarket.setYear(years.get(i).toString());
				List<LandMarket> landMarkets =landMarketService.queryLeftTop(landMarket);
				
				if("landCount".equals(landMarket.getCondition())){
					for(LandMarket lt:landMarkets){
						if("国有出让-工业".equals(lt.getLandUse())){
							gycrgyMap.put("name", lt.getLandUse());
							landCountArrayGY.add(lt.getLandCount()==null?BigDecimal.ZERO:lt.getLandCount());
						}else{
							gycrjyxMap.put("name", lt.getLandUse());
							landCountArrayJYX.add(lt.getLandCount()==null?BigDecimal.ZERO:lt.getLandCount());
						}
					}
				}
				if("sellArea".equals(landMarket.getCondition())){
					for(LandMarket lt:landMarkets){
						if("国有出让-工业".equals(lt.getLandUse())){
							gycrgyMap.put("name", lt.getLandUse());
							landCountArrayGY.add(lt.getLandArea()==null?BigDecimal.ZERO:lt.getLandArea());
						}else{
							gycrjyxMap.put("name", lt.getLandUse());
							landCountArrayJYX.add(lt.getLandArea()==null?BigDecimal.ZERO:lt.getLandArea());
						}
					}
				}
				if("contractMoney".equals(landMarket.getCondition())){
					
					for(LandMarket lt:landMarkets){
						java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.00");
						String contractMoney = myformat.format(lt.getContractMoney().doubleValue());
						lt.setContractMoney(BigDecimal.valueOf(Double.parseDouble(contractMoney)));
						if("国有出让-工业".equals(lt.getLandUse())){
							gycrgyMap.put("name", lt.getLandUse());
							landCountArrayGY.add(lt.getContractMoney()==null?BigDecimal.ZERO:lt.getContractMoney());
						}else{
							gycrjyxMap.put("name", lt.getLandUse());
							landCountArrayJYX.add(lt.getContractMoney()==null?BigDecimal.ZERO:lt.getContractMoney());
						}
					}
				}
				
			}
			
			gycrgyMap.put("data", landCountArrayGY);
			gycrjyxMap.put("data", landCountArrayJYX);
			series.add(gycrgyMap);
			series.add(gycrjyxMap);
			resultMap.put("series", series);
			resultMap.put("years", years);
			
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		} 
		return resultMap;
	}
	*//**
	 * 土地市场看板右上角的曲线图
	 *//*
	@RequestMapping("loadRightTop")
	@ResponseBody
	public Object loadRightTop(LandMarket landMarket) throws CRUDException{
		List<Object> landMarketLeftTop=new ArrayList<Object>();
		Map loadRightMap = new HashMap();
		List<Object> series = new ArrayList<Object>();
		Map<String, Object> gycrgyMap = new HashMap<String,Object>();   //国有出让-工业
		Map<String, Object> gycrjyxMap = new HashMap<String,Object>();	//国有出让-经营性
		List<Object> landCountArrayGY = new ArrayList<Object>();		//国有出让-工业list
		List<Object> landCountArrayJYX = new ArrayList<Object>();		//国有出让-经营性list
		try {
			List<LandMarket> landMarkets=landMarketService.loadRightTop(landMarket);
			if("landCount".equals(landMarket.getCondition())){
				for(LandMarket lt:landMarkets){
					if(lt!=null){
						if("国有出让-工业".equals(lt.getLandUse())){
							gycrgyMap.put("name", lt.getLandUse());
							landCountArrayGY.add(lt.getLandCount()==null?BigDecimal.ZERO:lt.getLandCount());
						}else{
							gycrjyxMap.put("name", lt.getLandUse());
							landCountArrayJYX.add(lt.getLandCount()==null?BigDecimal.ZERO:lt.getLandCount());
						}
					}
					
//					Map<String,Object> map=new HashMap<String,Object>();
//					if(lt==null){
//						map.put("y", BigDecimal.ZERO);
//					}else{
//						map.put("y", lt.getLandCount()==null?BigDecimal.ZERO:lt.getLandCount());
//					}
//					landMarketLeftTop.add(map);
				}
			}
			if("sellArea".equals(landMarket.getCondition())){
				for(LandMarket lt:landMarkets){
					if(lt!=null){
						if("国有出让-工业".equals(lt.getLandUse())){
							gycrgyMap.put("name", lt.getLandUse());
							landCountArrayGY.add(lt.getLandArea()==null?BigDecimal.ZERO:lt.getLandArea());
						}else{
							gycrjyxMap.put("name", lt.getLandUse());
							landCountArrayJYX.add(lt.getLandArea()==null?BigDecimal.ZERO:lt.getLandArea());
						}
					}
//					Map<String,Object> map=new HashMap<String,Object>();
//					if(lt==null){
//						map.put("y", BigDecimal.ZERO);
//					}else{
//						map.put("y", lt.getLandArea()==null?BigDecimal.ZERO:lt.getLandArea().divide(new BigDecimal("666.667"),2));
//					}
//					landMarketLeftTop.add(map);
					
				}
			}
			if("contractMoney".equals(landMarket.getCondition())){
				for(LandMarket lt:landMarkets){
					if(lt!=null){
						if("国有出让-工业".equals(lt.getLandUse())){
							gycrgyMap.put("name", lt.getLandUse());
							landCountArrayGY.add(lt.getContractMoney()==null?BigDecimal.ZERO:lt.getContractMoney());
						}else{
							gycrjyxMap.put("name", lt.getLandUse());
							landCountArrayJYX.add(lt.getContractMoney()==null?BigDecimal.ZERO:lt.getContractMoney());
						}
					}
//					Map<String,Object> map=new HashMap<String,Object>();
//					if(lt==null){
//						map.put("y", BigDecimal.ZERO);
//					}else{
//						map.put("y", lt.getContractMoney()==null?BigDecimal.ZERO:lt.getContractMoney().setScale(2,BigDecimal.ROUND_HALF_EVEN));
//					}
//					landMarketLeftTop.add(map);
					
				}
			}
			gycrgyMap.put("data", landCountArrayGY);
			gycrjyxMap.put("data", landCountArrayJYX);
			series.add(gycrgyMap);
			series.add(gycrjyxMap);
			//将list放入map
			loadRightMap.put("loadRightTop", series);
			loadRightMap.put("x", getMonths());//x轴显示的季度
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		} 
		
		return loadRightMap;
	}
	*//**
	 * 根据当前月份判断需要显示到那一季度
	 * @return
	 *//*
	public List getMonths(){
		//获取当前月份
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		List months = new ArrayList();
		if(month >= 1 && month <= 3 || month > 3){
			months.add("第一季度");
		}
		if((month >= 4 && month <= 6) || month > 6){
			months.add("第二季度");
		}
		if((month >= 7 && month <= 9) || month > 9){
			months.add("第三季度");
		}
		if(month >= 10 && month <= 12){
			months.add("第四季度");
		}
		return months;
	}
	*//**
	 * 土地市场看板  下面的柱状图
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月13日14:03:01
	 *//*
	@RequestMapping("loadButtom3")
	@ResponseBody
	public Map<String,Object> loadButtom2(LandMarket landMarket) throws CRUDException{
		Map<String, Object> map;
		try {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			landMarket.setYear(Integer.toString(year));
			//获取所有的熟化主体的名称
			List<String> curmainNames=compYearService.getCurmainName();
			//查询出数据，并且封装到list中
			List<LandMarket> landMarkets=landMarketService.loadButtom(landMarket);
			map = new HashMap<String,Object>();
			//声明map，并且插入数据
			Map<String,Object> contractMoneyMap=new HashMap<String,Object>();
			Map<String,Object> areasMap=new HashMap<String,Object>();
			Map<String,Object> lanCountMap=new HashMap<String,Object>();
			contractMoneyMap.put("name","合同价款（亿元）");
			areasMap.put("name", "地块面积（亩）");
			lanCountMap.put("name", "宗地数（宗）");
			List<Object> contractMoneys=new LinkedList<Object>();
			List<Object> areas=new LinkedList<Object>();
			List<Object>  landCOunt=new LinkedList<Object>();
			
			List<Object> series=new LinkedList<Object>();
			List<Object> comPanyNames=new LinkedList<Object>();
			for(String curmainName:curmainNames){
				boolean flag=false;
				for(LandMarket landMarket2:landMarkets){
					if(curmainName.equals(landMarket2.getCurmainName())){
						flag=true;
						contractMoneys.add(landMarket2.getContractMoney()==null?BigDecimal.ZERO:landMarket2.getContractMoney().setScale(2,BigDecimal.ROUND_HALF_EVEN));
						areas.add(landMarket2.getLandArea()==null?BigDecimal.ZERO:landMarket2.getLandArea().divide(new BigDecimal("666.667"),2));
						landCOunt.add(landMarket2.getLandCount()==null?BigDecimal.ZERO:landMarket2.getLandCount());
						comPanyNames.add(curmainName);
					}
				}
				if(!flag){
					contractMoneys.add(BigDecimal.ZERO);
					areas.add(BigDecimal.ZERO);
					landCOunt.add(BigDecimal.ZERO);
					comPanyNames.add(curmainName);
				}
			}
			
			contractMoneyMap.put("data", contractMoneys);
			areasMap.put("data", areas);
			lanCountMap.put("data", landCOunt);
			//判断是通过哪种口径查询的返回数据
			String titleName="";
			if("contractMoney".equals(landMarket.getCondition())){
				titleName="合同金额按熟化主体分析";
				map.put("titleName", titleName);
				series.add(contractMoneyMap);
			}
			if("sellArea".equals(landMarket.getCondition())){
				titleName="供地面积按熟化主体分析";
				map.put("titleName", titleName);
				series.add(areasMap);
			}
			if("landCount".equals(landMarket.getCondition())){
				titleName="供地宗数按熟化主体分析";
				map.put("titleName", titleName);
				series.add(lanCountMap);
			}
			map.put("companyName", comPanyNames);
			map.put("series", series);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return map;
	}
	
	@RequestMapping("loadButtom")
	@ResponseBody
	public Map<String,Object> loadButtom(LandMarket landMarket) throws CRUDException{
		Map<String, Object> map;
		try {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			landMarket.setYear(Integer.toString(year));
			//获取所有的熟化主体的名称
			List<String> curmainNames=compYearService.getCurmainName();
			//查询出工业，并且封装到list中
			landMarket.setLandTypeId(this.landTypeId03);
			List<LandMarket> landMarketsGY=landMarketService.loadButtom(landMarket);
			//查询出经营性数据
			landMarket.setLandTypeId(this.landTypeId04);
			List<LandMarket> landMarketsJYX=landMarketService.loadButtom(landMarket);
			map = new HashMap<String,Object>();
			Map<String,Object> buttomMapGY = new HashMap<String,Object>();
			Map<String,Object> buttomMapJYX = new HashMap<String,Object>();
//			//声明map，并且插入数据
//			Map<String,Object> contractMoneyMap=new HashMap<String,Object>();
//			Map<String,Object> areasMap=new HashMap<String,Object>();
//			Map<String,Object> lanCountMap=new HashMap<String,Object>();
//			contractMoneyMap.put("name","合同价款（亿元）");
//			areasMap.put("name", "地块面积（亩）");
//			lanCountMap.put("name", "宗地数（宗）");
			//工业
			List<Object> contractMoneysGY=new LinkedList<Object>();
			List<Object> areasGY=new LinkedList<Object>();
			List<Object>  landCountGY=new LinkedList<Object>();
			//经营性
			List<Object> contractMoneysJYX=new LinkedList<Object>();
			List<Object> areasJYX=new LinkedList<Object>();
			List<Object>  landCountJYX=new LinkedList<Object>();
			
			List<Object> series=new LinkedList<Object>();
			List<Object> comPanyNames=new LinkedList<Object>();
			//处理工业数据
			for(String curmainName:curmainNames){
				buttomMapGY.put("name", "国有出让-工业");
				boolean flag=false;
				for(LandMarket landMarket2:landMarketsGY){
					System.out.println(curmainName+" = "+landMarket2.getCurmainName());
					if(curmainName.equals(landMarket2.getCurmainName())){
						flag=true;
						contractMoneysGY.add(landMarket2.getContractMoney()==null?BigDecimal.ZERO:landMarket2.getContractMoney().setScale(2,BigDecimal.ROUND_HALF_EVEN));
						areasGY.add(landMarket2.getLandArea()==null?BigDecimal.ZERO:landMarket2.getLandArea().divide(new BigDecimal("666.667"),2));
						landCountGY.add(landMarket2.getLandCount()==null?BigDecimal.ZERO:landMarket2.getLandCount());
						comPanyNames.add(curmainName);
					}
				}
				if(!flag){
					contractMoneysGY.add(BigDecimal.ZERO);
					areasGY.add(BigDecimal.ZERO);
					landCountGY.add(BigDecimal.ZERO);
					comPanyNames.add(curmainName);
				}
			}
			//处理经营性数据
			for(String curmainName:curmainNames){
				buttomMapJYX.put("name", "国有出让-经营性");
				boolean flag=false;
				for(LandMarket landMarket2:landMarketsJYX){
					System.out.println(curmainName+" = "+landMarket2.getCurmainName());
					if(curmainName.equals(landMarket2.getCurmainName())){
						flag=true;
						contractMoneysJYX.add(landMarket2.getContractMoney()==null?BigDecimal.ZERO:landMarket2.getContractMoney().setScale(2,BigDecimal.ROUND_HALF_EVEN));
						areasJYX.add(landMarket2.getLandArea()==null?BigDecimal.ZERO:landMarket2.getLandArea().divide(new BigDecimal("666.667"),2));
						landCountJYX.add(landMarket2.getLandCount()==null?BigDecimal.ZERO:landMarket2.getLandCount());
						comPanyNames.add(curmainName);
					}
				}
				if(!flag){
					contractMoneysJYX.add(BigDecimal.ZERO);
					areasJYX.add(BigDecimal.ZERO);
					landCountJYX.add(BigDecimal.ZERO);
					comPanyNames.add(curmainName);
				}
			}
			
			//判断是通过哪种口径查询的返回数据
			String titleName="";
			if("contractMoney".equals(landMarket.getCondition())){
				titleName="合同金额按熟化主体分析";
				map.put("titleName", titleName);
				buttomMapGY.put("data", contractMoneysGY);
				buttomMapJYX.put("data", contractMoneysJYX);
				series.add(buttomMapGY);
				series.add(buttomMapJYX);
			}
			if("sellArea".equals(landMarket.getCondition())){
				titleName="供地面积按熟化主体分析";
				map.put("titleName", titleName);
				buttomMapGY.put("data",areasGY);
				buttomMapJYX.put("data", areasJYX);
				series.add(buttomMapGY);
				series.add(buttomMapJYX);
			}
			if("landCount".equals(landMarket.getCondition())){
				titleName="供地宗数按熟化主体分析";
				map.put("titleName", titleName);
				buttomMapGY.put("data",landCountGY);
				buttomMapJYX.put("data", landCountJYX);
				series.add(buttomMapGY);
				series.add(buttomMapJYX);
			}
			map.put("companyName", comPanyNames);
			map.put("series", series);
		} catch (CRUDException e) {
			log.error(e);
			throw new CRUDException(e);
		}
		return map;
	}
}
*/