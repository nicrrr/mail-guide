package yougo.biz.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * description:启动服务注册中心
 * date: 2018年5月16日 下午3:22:53
 * @author nicr
 */
//@EnableEurekaClient
//@EnableFeignClients(basePackages ="yougo.inter")
@SpringBootApplication
@ComponentScan(basePackages ={"yougo"})
public class BizWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(BizWebApplication.class, args);
	}
}
