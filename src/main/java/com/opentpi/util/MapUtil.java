package com.opentpi.util;

import java.util.Map;

import cn.hutool.core.util.StrUtil;

public class MapUtil {

	public static String getMapString(Map<String, Object> map, String key) {
    	String value = StrUtil.EMPTY;
    	Object obj = map.get(key);
    	if (obj != null) {
    		value = (String)obj;
    	}
    	return value;
    }
}
