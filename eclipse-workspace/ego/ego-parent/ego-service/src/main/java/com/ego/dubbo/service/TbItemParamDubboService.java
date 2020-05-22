package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItemParam;

public interface TbItemParamDubboService {
	/**
	 * 规格参数，分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid showPage(int page,int rows);
	/**
	 * 根据商品类目id查询参数模板
	 * @param catId
	 * @return
	 */
	TbItemParam selByCatid(long catId);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int delByIds(String ids) throws Exception;
	/**
	 * 新增,支持主键自增
	 * @param param
	 * @return
	 */
	int insParam(TbItemParam param);

}
