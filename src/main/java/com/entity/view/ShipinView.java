package com.entity.view;

import com.entity.ShipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 饰品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-09 16:49:04
 */
@TableName("shipin")
public class ShipinView  extends ShipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShipinView(){
	}
 
 	public ShipinView(ShipinEntity shipinEntity){
 	try {
			BeanUtils.copyProperties(this, shipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
