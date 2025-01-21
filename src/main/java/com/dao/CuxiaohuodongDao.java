package com.dao;

import com.entity.CuxiaohuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CuxiaohuodongVO;
import com.entity.view.CuxiaohuodongView;


/**
 * 促销活动
 * 
 * @author 
 * @email 
 * @date 2022-04-09 16:49:04
 */
public interface CuxiaohuodongDao extends BaseMapper<CuxiaohuodongEntity> {
	
	List<CuxiaohuodongVO> selectListVO(@Param("ew") Wrapper<CuxiaohuodongEntity> wrapper);
	
	CuxiaohuodongVO selectVO(@Param("ew") Wrapper<CuxiaohuodongEntity> wrapper);
	
	List<CuxiaohuodongView> selectListView(@Param("ew") Wrapper<CuxiaohuodongEntity> wrapper);

	List<CuxiaohuodongView> selectListView(Pagination page,@Param("ew") Wrapper<CuxiaohuodongEntity> wrapper);
	
	CuxiaohuodongView selectView(@Param("ew") Wrapper<CuxiaohuodongEntity> wrapper);
	

}
