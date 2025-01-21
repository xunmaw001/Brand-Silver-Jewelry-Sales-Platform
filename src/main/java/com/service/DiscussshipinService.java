package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshipinView;


/**
 * 饰品评论表
 *
 * @author 
 * @email 
 * @date 2022-04-09 16:49:05
 */
public interface DiscussshipinService extends IService<DiscussshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshipinVO> selectListVO(Wrapper<DiscussshipinEntity> wrapper);
   	
   	DiscussshipinVO selectVO(@Param("ew") Wrapper<DiscussshipinEntity> wrapper);
   	
   	List<DiscussshipinView> selectListView(Wrapper<DiscussshipinEntity> wrapper);
   	
   	DiscussshipinView selectView(@Param("ew") Wrapper<DiscussshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshipinEntity> wrapper);
   	

}

