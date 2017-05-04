/*package com.ecode.land.persistence.deskTop;

import java.util.List;

import com.ecode.land.domain.deskTop.LandMarket;
import com.ecode.land.domain.deskTop.LandUsion;
import com.ecode.land.exception.CRUDException;
*//**
 * 土地市场看板 Mapper
 * @author 朱玉猛
 * @since 2015年7月10日10:02:45
 *
 *//*
public interface LandMarketMapper {
	*//**
	 * 土地市场看板初始化时的图表
	 * @param landMarket
	 * @return
	 *//*
	List<LandMarket> querytable(LandMarket landMarket);
	*//**
	 * 查询出土地市场看板饼图需要的数据
	 * @param landMarket
	 * @return
	 *//*
	List<LandMarket> queryPie(LandMarket landMarket);
	*//**
	 * 
	 * 土地市场看板左上角的柱状图
	 * @param landMarket
	 * @return
	 * @author 朱玉猛
	 * @since 2015年7月13日10:17:46
	 *//*
	LandMarket queryLeftTop(LandMarket landMarket);
	*//**
	 * 
	 * 土地市场看板右上角的曲线图
	 * @param landMarket
	 * @return
	 * @author 朱玉猛
	 * @throws CRUDException 
	 * @since 2015年7月13日10:17:46
	 *//*
	LandMarket loadRightTop(LandMarket landMarket);
	*//**
	 * 土地市场看板 下面的熟化主体柱状图
	 * @param landMarket 
	 * @return
	 *//*
	List<LandMarket> loadButtom(LandMarket landMarket);
	*//**
	 * 工业用地饼图钻取
	 * @param landMarket
	 * @return
	 *//*
	List<LandUsion> queryGY(LandMarket landMarket);
	*//**
	 * 经营性用地饼图钻取
	 * @param landMarket
	 * @return
	 *//*
	List<LandUsion> queryJY(LandMarket landMarket);

}
*/