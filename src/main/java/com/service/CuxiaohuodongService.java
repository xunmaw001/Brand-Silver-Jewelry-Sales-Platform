package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CuxiaohuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CuxiaohuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CuxiaohuodongView;


/**
 * 促销活动
 *
 * @author 
 * @email 
 * @date 2022-04-09 16:49:04
 */
public interface CuxiaohuodongService extends IService<CuxiaohuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CuxiaohuodongVO> selectListVO(Wrapper<CuxiaohuodongEntity> wrapper);
   	
   	CuxiaohuodongVO selectVO(@Param("ew") Wrapper<CuxiaohuodongEntity> wrapper);
   	
   	List<CuxiaohuodongView> selectListView(Wrapper<CuxiaohuodongEntity> wrapper);
   	
   	CuxiaohuodongView selectView(@Param("ew") Wrapper<CuxiaohuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CuxiaohuodongEntity> wrapper);
   	

}

