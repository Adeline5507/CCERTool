package com.thomsonreuters.ccertool.vo.emerald;

import com.thomsonreuters.ccertool.vo.PartnersVo;

public interface partnersMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.PARTNERS
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int deleteByPrimaryKey(Short partnerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.PARTNERS
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int insert(PartnersVo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.PARTNERS
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int insertSelective(PartnersVo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.PARTNERS
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	PartnersVo selectByPrimaryKey(Short partnerId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.PARTNERS
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int updateByPrimaryKeySelective(PartnersVo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.PARTNERS
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int updateByPrimaryKey(PartnersVo record);
}