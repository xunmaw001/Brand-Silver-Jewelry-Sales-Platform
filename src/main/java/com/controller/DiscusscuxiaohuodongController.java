package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusscuxiaohuodongEntity;
import com.entity.view.DiscusscuxiaohuodongView;

import com.service.DiscusscuxiaohuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 促销活动评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-09 16:49:05
 */
@RestController
@RequestMapping("/discusscuxiaohuodong")
public class DiscusscuxiaohuodongController {
    @Autowired
    private DiscusscuxiaohuodongService discusscuxiaohuodongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusscuxiaohuodongEntity discusscuxiaohuodong, 
		HttpServletRequest request){

        EntityWrapper<DiscusscuxiaohuodongEntity> ew = new EntityWrapper<DiscusscuxiaohuodongEntity>();
		PageUtils page = discusscuxiaohuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusscuxiaohuodong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusscuxiaohuodongEntity discusscuxiaohuodong, 
		HttpServletRequest request){
        EntityWrapper<DiscusscuxiaohuodongEntity> ew = new EntityWrapper<DiscusscuxiaohuodongEntity>();
		PageUtils page = discusscuxiaohuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusscuxiaohuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusscuxiaohuodongEntity discusscuxiaohuodong){
       	EntityWrapper<DiscusscuxiaohuodongEntity> ew = new EntityWrapper<DiscusscuxiaohuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusscuxiaohuodong, "discusscuxiaohuodong")); 
        return R.ok().put("data", discusscuxiaohuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusscuxiaohuodongEntity discusscuxiaohuodong){
        EntityWrapper< DiscusscuxiaohuodongEntity> ew = new EntityWrapper< DiscusscuxiaohuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusscuxiaohuodong, "discusscuxiaohuodong")); 
		DiscusscuxiaohuodongView discusscuxiaohuodongView =  discusscuxiaohuodongService.selectView(ew);
		return R.ok("查询促销活动评论表成功").put("data", discusscuxiaohuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusscuxiaohuodongEntity discusscuxiaohuodong = discusscuxiaohuodongService.selectById(id);
        return R.ok().put("data", discusscuxiaohuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusscuxiaohuodongEntity discusscuxiaohuodong = discusscuxiaohuodongService.selectById(id);
        return R.ok().put("data", discusscuxiaohuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusscuxiaohuodongEntity discusscuxiaohuodong, HttpServletRequest request){
    	discusscuxiaohuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusscuxiaohuodong);

        discusscuxiaohuodongService.insert(discusscuxiaohuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusscuxiaohuodongEntity discusscuxiaohuodong, HttpServletRequest request){
    	discusscuxiaohuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusscuxiaohuodong);

        discusscuxiaohuodongService.insert(discusscuxiaohuodong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusscuxiaohuodongEntity discusscuxiaohuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusscuxiaohuodong);
        discusscuxiaohuodongService.updateById(discusscuxiaohuodong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusscuxiaohuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusscuxiaohuodongEntity> wrapper = new EntityWrapper<DiscusscuxiaohuodongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusscuxiaohuodongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
