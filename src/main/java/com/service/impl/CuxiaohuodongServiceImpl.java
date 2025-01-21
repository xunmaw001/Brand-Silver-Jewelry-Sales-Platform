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


import com.dao.CuxiaohuodongDao;
import com.entity.CuxiaohuodongEntity;
import com.service.CuxiaohuodongService;
import com.entity.vo.CuxiaohuodongVO;
import com.entity.view.CuxiaohuodongView;

@Service("cuxiaohuodongService")
public class CuxiaohuodongServiceImpl extends ServiceImpl<CuxiaohuodongDao, CuxiaohuodongEntity> implements CuxiaohuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CuxiaohuodongEntity> page = this.selectPage(
                new Query<CuxiaohuodongEntity>(params).getPage(),
                new EntityWrapper<CuxiaohuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CuxiaohuodongEntity> wrapper) {
		  Page<CuxiaohuodongView> page =new Query<CuxiaohuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CuxiaohuodongVO> selectListVO(Wrapper<CuxiaohuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CuxiaohuodongVO selectVO(Wrapper<CuxiaohuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CuxiaohuodongView> selectListView(Wrapper<CuxiaohuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CuxiaohuodongView selectView(Wrapper<CuxiaohuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
