package com.thomsonreuters.ccertool.vo.emerald;

import com.thomsonreuters.ccertool.vo.MethodologiesVo;

public interface methodologiesMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.METHODOLOGIES
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int deleteByPrimaryKey(Short methodologyId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.METHODOLOGIES
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int insert(MethodologiesVo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.METHODOLOGIES
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int insertSelective(MethodologiesVo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.METHODOLOGIES
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	MethodologiesVo selectByPrimaryKey(Short methodologyId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.METHODOLOGIES
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int updateByPrimaryKeySelective(MethodologiesVo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table EMERALD.METHODOLOGIES
	 * @mbggenerated  Wed Mar 16 12:16:46 CST 2016
	 */
	int updateByPrimaryKey(MethodologiesVo record);
}