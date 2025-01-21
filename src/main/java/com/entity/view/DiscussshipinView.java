package com.entity.view;

import com.entity.DiscussshipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 饰品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-09 16:49:05
 */
@TableName("discussshipin")
public class DiscussshipinView  extends DiscussshipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshipinView(){
	}
 
 	public DiscussshipinView(DiscussshipinEntity discussshipinEntity){
 	try {
			BeanUtils.copyProperties(this, discussshipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
