package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusscuxiaohuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusscuxiaohuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusscuxiaohuodongView;


/**
 * 促销活动评论表
 *
 * @author 
 * @email 
 * @date 2022-04-09 16:49:05
 */
public interface DiscusscuxiaohuodongService extends IService<DiscusscuxiaohuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusscuxiaohuodongVO> selectListVO(Wrapper<DiscusscuxiaohuodongEntity> wrapper);
   	
   	DiscusscuxiaohuodongVO selectVO(@Param("ew") Wrapper<DiscusscuxiaohuodongEntity> wrapper);
   	
   	List<DiscusscuxiaohuodongView> selectListView(Wrapper<DiscusscuxiaohuodongEntity> wrapper);
   	
   	DiscusscuxiaohuodongView selectView(@Param("ew") Wrapper<DiscusscuxiaohuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusscuxiaohuodongEntity> wrapper);
   	

}

