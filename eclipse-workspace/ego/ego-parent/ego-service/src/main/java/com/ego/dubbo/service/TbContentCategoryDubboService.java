package com.ego.dubbo.service;

import java.util.List;

import com.ego.pojo.TbContentCategory;

public interface TbContentCategoryDubboService {
	/**
	 * 根据父id查询所有子类目
	 * @param id
	 * @return
	 */
	List<TbContentCategory> selByPid(long id);
	
	/**
	 * 新增类目
	 * @param cate
	 * @return
	 */
	int insTbContentCategory(TbContentCategory cate);
	
	/**
	 * 修改修改isparent通过id
	 * @param cate
	 * @return
	 */
	int updIsParentById(TbContentCategory cate);
	
	/**
	 * 通过id查询内容类目详细信息
	 */
	TbContentCategory selById(long id);
	

}
