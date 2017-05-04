/*package com.ecode.land.service.deskTop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecode.land.domain.contract.Contract;
import com.ecode.land.domain.deskTop.LandMarket;
import com.ecode.land.domain.deskTop.LandUsion;
import com.ecode.land.exception.CRUDException;
import com.ecode.land.persistence.deskTop.LandMarketMapper;
*//**
 * 土地市场看板 Service
 * @author 朱玉猛
 * @since 2015年7月10日10:00:02
 *
 *//*
@Service
@SessionAttributes("accountId")
public class LandMarketService {
	
	private final String landTypeId03 = "00000000000000000000000000000003";
	private final String landTypeId04 = "00000000000000000000000000000004";
	
	@Autowired
	private LandMarketMapper landMarketMapper; 
	
	private static Logger log = Logger.getLogger(LandMarketService.class);
	*//**
	 * 土地市场看板
	 * @param landMarket
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<LandMarket> queryTable(LandMarket landMarket) throws CRUDException {
		try {
			return landMarketMapper.querytable(landMarket);
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 查询出土地市场看板  饼图需要的数据
	 * @param landMarket
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<LandMarket> queryPie(LandMarket landMarket) throws CRUDException {
		try {
			List<LandMarket> landMarkets= landMarketMapper.queryPie(landMarket);
			BigDecimal totalLandCount=new BigDecimal("0");
			BigDecimal totalArea=new BigDecimal("0");
			BigDecimal totalContractMoney=new BigDecimal("0");
			for(LandMarket landMark:landMarkets){
				totalLandCount=totalLandCount.add(landMark.getLandCount()==null?BigDecimal.ZERO:landMark.getLandCount());
				totalArea=totalArea.add(landMark.getLandArea()==null?BigDecimal.ZERO:landMark.getLandArea());
				totalContractMoney=totalContractMoney.add(landMark.getContractMoney()==null?BigDecimal.ZERO:landMark.getContractMoney());
			}
			for(LandMarket landMarket2:landMarkets){
				landMarket2.setLandCountRatio(landMarket2.getLandCount()==null?BigDecimal.ZERO:(totalLandCount==BigDecimal.ZERO?BigDecimal.ZERO:(landMarket2.getLandCount().divide(totalLandCount,4,BigDecimal.ROUND_HALF_DOWN))));
				landMarket2.setLandAreaRatio(landMarket2.getLandArea()==null?BigDecimal.ZERO:(totalArea==BigDecimal.ZERO?BigDecimal.ZERO:landMarket2.getLandArea().divide(totalArea,4,BigDecimal.ROUND_HALF_DOWN)));
				landMarket2.setCountractMoneyRatio(landMarket2.getContractMoney()==null?BigDecimal.ZERO:(totalContractMoney==BigDecimal.ZERO?BigDecimal.ZERO:landMarket2.getContractMoney().divide(totalContractMoney,4,BigDecimal.ROUND_HALF_DOWN)));
			}
			return landMarkets;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 
	 * 土地市场看板左上角的柱状图
	 * @param landMarket
	 * @return
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月13日10:17:46
	 *//*
	public List<LandMarket> queryLeftTop(LandMarket landMarket) throws CRUDException {
//		Map<String,Object> map = new HashMap<String,Object>();
		List<LandMarket> landMarkets=new ArrayList<LandMarket>();
//		List<LandMarket> landMarkets04=new ArrayList<LandMarket>();
//		List<Object> objList1 = new ArrayList<Object>();
		try {
			
			//数据查询--国有出让-工业用地
			landMarket.setLandTypeId("00000000000000000000000000000003");
			LandMarket landMarket03 =landMarketMapper.queryLeftTop(landMarket);
			if(landMarket03!=null){
				landMarkets.add(landMarket03);
			}
			
			
			//数据查询--国有出让-经营性用地
			landMarket.setLandTypeId("00000000000000000000000000000004");
			LandMarket landMarket04 = landMarketMapper.queryLeftTop(landMarket);
			if(landMarket04!=null){
				landMarkets.add(landMarket04);
			}
			

//			LandMarket landMarket3 =landMarketMapper.queryLeftTop(landMarket);
//			landMarkets.add(0,landMarket3);
//			landMarkets.add(1,landMarket03);
			return landMarkets;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 
	 * 土地市场看板右上角的曲线图
	 * @param landMarket
	 * @return
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月13日10:17:46
	 *//*
	public List<LandMarket> loadRightTop(LandMarket landMarket) throws CRUDException {
		List<LandMarket> landMarkets=new ArrayList<LandMarket>();
		try {
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			landMarket.setYear(Integer.toString(year));
			if(month >= 1 && month <= 3 || month > 3){
				landMarket.setQuarter("1");
				landMarket.setLandTypeId(this.landTypeId03);
				LandMarket landMarkets1 = landMarketMapper.loadRightTop(landMarket);
				if(landMarkets1!=null){
					landMarkets.add(checkLandMarket(landMarkets1,"国有出让-工业"));
				}
				landMarket.setLandTypeId(this.landTypeId04);
				LandMarket landMarkets2 = landMarketMapper.loadRightTop(landMarket);
				if(landMarkets2!=null){
					landMarkets.add(checkLandMarket(landMarkets2,"国有出让-经营性"));
				}
			}
			if((month >= 4 && month <= 6) || month > 6){
				landMarket.setQuarter("2");
				landMarket.setLandTypeId(this.landTypeId03);
				LandMarket landMarkets2 = landMarketMapper.loadRightTop(landMarket);
				if(landMarkets2!=null){
					landMarkets.add(checkLandMarket(landMarkets2,"国有出让-工业"));
				}
				
				landMarket.setLandTypeId(this.landTypeId04);
				LandMarket landMarkets3 = landMarketMapper.loadRightTop(landMarket);
				if(landMarkets3!=null){
					landMarkets.add(checkLandMarket(landMarkets3,"国有出让-经营性"));
				}
			}
			if((month >= 7 && month <= 9) || month > 9){
				landMarket.setQuarter("3");
				landMarket.setLandTypeId(this.landTypeId03);
				LandMarket landMarkets3=landMarketMapper.loadRightTop(landMarket);
				if(landMarkets3!=null){
					landMarkets.add(checkLandMarket(landMarkets3,"国有出让-工业"));
				}
				landMarket.setLandTypeId(this.landTypeId04);
				LandMarket landMarkets4 = landMarketMapper.loadRightTop(landMarket);
				if(landMarkets4!=null){
					landMarkets.add(checkLandMarket(landMarkets4,"国有出让-经营性"));
				}
			}
			if(month >= 10 && month <= 12){
				landMarket.setQuarter("4");
				landMarket.setLandTypeId(this.landTypeId03);
				LandMarket landMarkets4=landMarketMapper.loadRightTop(landMarket);
				if(landMarkets4!=null){
					landMarkets.add(checkLandMarket(landMarkets4,"国有出让土地"));
				}
				landMarket.setLandTypeId(this.landTypeId04);
				LandMarket landMarkets5=landMarketMapper.loadRightTop(landMarket);
				if(landMarkets5!=null){
					landMarkets.add(checkLandMarket(landMarkets5,"国有出让-经营性"));
				}
			}
			return landMarkets;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 判断如果返回对象为null，则当前为0
	 * @param landMarkets
	 * @param landUse
	 * @return
	 *//*
	public LandMarket checkLandMarket(LandMarket landMarkets,String landUse){
		LandMarket lm = new LandMarket();
		if(landMarkets==null){
			lm.setLandUse(landUse);
			lm.setLandCount(BigDecimal.ZERO);
		}else{
			lm=landMarkets;
		}
		return lm;
	}
	*//**
	 * 土地市场看板下面的柱状图
	 * @param landMarket
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<LandMarket> loadButtom(LandMarket landMarket) throws CRUDException {
		try {
			List<LandMarket> landMarkets=landMarketMapper.loadButtom(landMarket);
			return landMarkets;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
		
	}
	*//**
	 * 
	 * 工业用地的钻取
	 * @param landMarket
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<LandUsion> queryPieGY(LandMarket landMarket) throws CRUDException {
		try {
			List<LandUsion> landUsions=landMarketMapper.queryGY(landMarket);
			BigDecimal TotalLandCount=new BigDecimal("0");
			BigDecimal TotalLandArea=new BigDecimal("0");
			BigDecimal TotalContractMoney=new BigDecimal("0");
			//算出宗数
			for(LandUsion landUsion:landUsions){
				TotalLandCount=TotalLandCount.add(landUsion.getUlandCount()==null?BigDecimal.ZERO:landUsion.getUlandCount());
				TotalLandArea=TotalLandArea.add(landUsion.getUlandArea()==null?BigDecimal.ZERO:landUsion.getUlandArea());
				TotalContractMoney=TotalContractMoney.add(landUsion.getUcontractMoney()==null?BigDecimal.ZERO:landUsion.getUcontractMoney());
			}
			//算数宗地数，出让面积，合同价款的比例
			for(LandUsion landUsion:landUsions){
				landUsion.setUlandCountRatio(TotalLandCount==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUlandCount()==null?BigDecimal.ZERO:landUsion.getUlandCount().divide(TotalLandCount,4,BigDecimal.ROUND_HALF_DOWN)));
				landUsion.setUlandAreaRatio(TotalLandArea==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUlandArea()==null?BigDecimal.ZERO:landUsion.getUlandArea().divide(TotalLandArea,4,BigDecimal.ROUND_HALF_DOWN)));
				landUsion.setUcontractMoneyRatio(TotalContractMoney==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUcontractMoney()==null?BigDecimal.ZERO:landUsion.getUcontractMoney().divide(TotalContractMoney,4,BigDecimal.ROUND_HALF_DOWN)));
			}
			return landUsions;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}
	*//**
	 * 经营性用地的钻取
	 * @param landMarket
	 * @return
	 * @throws CRUDException 
	 *//*
	public List<LandUsion> queryPieJY(LandMarket landMarket) throws CRUDException {
		try {
			List<LandUsion> landUsions=landMarketMapper.queryJY(landMarket);
			List<LandMarket> landMarkets= landMarketMapper.queryPie(landMarket);
			BigDecimal TotalLandCount=new BigDecimal("0");
			BigDecimal TotalLandArea=new BigDecimal("0");
			BigDecimal TotalContractMoney=new BigDecimal("0");
			for(LandMarket landMark:landMarkets){
				TotalLandCount=TotalLandCount.add(landMark.getLandCount()==null?BigDecimal.ZERO:landMark.getLandCount());
				TotalLandArea=TotalLandArea.add(landMark.getLandArea()==null?BigDecimal.ZERO:landMark.getLandArea());
				TotalContractMoney=TotalContractMoney.add(landMark.getContractMoney()==null?BigDecimal.ZERO:landMark.getContractMoney());
			}
			BigDecimal TotalLandCount2=new BigDecimal("0");
			BigDecimal TotalLandArea2=new BigDecimal("0");
			BigDecimal TotalContractMoney2=new BigDecimal("0");
			//算出宗数
			for(LandUsion landUsion:landUsions){
				if("住宅用地".equals(landUsion.getLandUser())||"商服用地".equals(landUsion.getLandUser())){
					TotalLandCount2=TotalLandCount2.add(landUsion.getUlandCount()==null?BigDecimal.ZERO:landUsion.getUlandCount());
					TotalLandArea2=TotalLandArea2.add(landUsion.getUlandArea()==null?BigDecimal.ZERO:landUsion.getUlandArea());
					TotalContractMoney2=TotalContractMoney2.add(landUsion.getUcontractMoney()==null?BigDecimal.ZERO:landUsion.getUcontractMoney());
				}
			}
			for(LandUsion landUsion:landUsions){
				if("住宅用地".equals(landUsion.getLandUser())){
					landUsion.setUlandCountRatio(TotalLandCount==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUlandCount()==null?BigDecimal.ZERO:landUsion.getUlandCount().divide(TotalLandCount,4,BigDecimal.ROUND_HALF_DOWN)));
					landUsion.setUlandAreaRatio(TotalLandArea==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUlandArea()==null?BigDecimal.ZERO:landUsion.getUlandArea().divide(TotalLandArea,4,BigDecimal.ROUND_HALF_DOWN)));
					landUsion.setUcontractMoneyRatio(TotalContractMoney==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUcontractMoney()==null?BigDecimal.ZERO:landUsion.getUcontractMoney().divide(TotalContractMoney,4,BigDecimal.ROUND_HALF_DOWN)));
				}else if("商服用地".equals(landUsion.getLandUser())){
					landUsion.setUlandCountRatio(TotalLandCount==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUlandCount()==null?BigDecimal.ZERO:landUsion.getUlandCount().divide(TotalLandCount,4,BigDecimal.ROUND_HALF_DOWN)));
					landUsion.setUlandAreaRatio(TotalLandArea==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUlandArea()==null?BigDecimal.ZERO:landUsion.getUlandArea().divide(TotalLandArea,4,BigDecimal.ROUND_HALF_DOWN)));
					landUsion.setUcontractMoneyRatio(TotalContractMoney==BigDecimal.ZERO?BigDecimal.ZERO:(landUsion.getUcontractMoney()==null?BigDecimal.ZERO:landUsion.getUcontractMoney().divide(TotalContractMoney,4,BigDecimal.ROUND_HALF_DOWN)));
				}else{
					landUsion.setLandUser("其他用地");
					landUsion.setUlandCountRatio(TotalLandCount==BigDecimal.ZERO?BigDecimal.ZERO:((TotalLandCount.subtract(TotalLandCount2)).divide(TotalLandCount,4,BigDecimal.ROUND_HALF_DOWN)));
					landUsion.setUlandAreaRatio(TotalLandArea==BigDecimal.ZERO?BigDecimal.ZERO:((TotalLandArea.subtract(TotalLandArea2)).divide(TotalLandArea,4,BigDecimal.ROUND_HALF_DOWN)));
					landUsion.setUcontractMoneyRatio(TotalContractMoney==BigDecimal.ZERO?BigDecimal.ZERO:((TotalContractMoney.subtract(TotalContractMoney2)).divide(TotalContractMoney,4,BigDecimal.ROUND_HALF_DOWN)));
				}
			}
			return landUsions;
		} catch (Exception e) {
			log.error(e);
			throw new CRUDException(e);
		}
	}

}
*/