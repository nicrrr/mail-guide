package yougo.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * description:启动服务注册中心
 * date: 2018年5月16日 下午3:22:53
 * @author nicr
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}
}
