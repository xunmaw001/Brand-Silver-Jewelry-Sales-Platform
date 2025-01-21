package com.dao;

import com.entity.DiscusscuxiaohuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusscuxiaohuodongVO;
import com.entity.view.DiscusscuxiaohuodongView;


/**
 * 促销活动评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-09 16:49:05
 */
public interface DiscusscuxiaohuodongDao extends BaseMapper<DiscusscuxiaohuodongEntity> {
	
	List<DiscusscuxiaohuodongVO> selectListVO(@Param("ew") Wrapper<DiscusscuxiaohuodongEntity> wrapper);
	
	DiscusscuxiaohuodongVO selectVO(@Param("ew") Wrapper<DiscusscuxiaohuodongEntity> wrapper);
	
	List<DiscusscuxiaohuodongView> selectListView(@Param("ew") Wrapper<DiscusscuxiaohuodongEntity> wrapper);

	List<DiscusscuxiaohuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusscuxiaohuodongEntity> wrapper);
	
	DiscusscuxiaohuodongView selectView(@Param("ew") Wrapper<DiscusscuxiaohuodongEntity> wrapper);
	

}
