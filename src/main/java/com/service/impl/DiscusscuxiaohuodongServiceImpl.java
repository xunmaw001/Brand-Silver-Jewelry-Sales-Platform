package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusscuxiaohuodongDao;
import com.entity.DiscusscuxiaohuodongEntity;
import com.service.DiscusscuxiaohuodongService;
import com.entity.vo.DiscusscuxiaohuodongVO;
import com.entity.view.DiscusscuxiaohuodongView;

@Service("discusscuxiaohuodongService")
public class DiscusscuxiaohuodongServiceImpl extends ServiceImpl<DiscusscuxiaohuodongDao, DiscusscuxiaohuodongEntity> implements DiscusscuxiaohuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusscuxiaohuodongEntity> page = this.selectPage(
                new Query<DiscusscuxiaohuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusscuxiaohuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscuxiaohuodongEntity> wrapper) {
		  Page<DiscusscuxiaohuodongView> page =new Query<DiscusscuxiaohuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusscuxiaohuodongVO> selectListVO(Wrapper<DiscusscuxiaohuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusscuxiaohuodongVO selectVO(Wrapper<DiscusscuxiaohuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusscuxiaohuodongView> selectListView(Wrapper<DiscusscuxiaohuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusscuxiaohuodongView selectView(Wrapper<DiscusscuxiaohuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
