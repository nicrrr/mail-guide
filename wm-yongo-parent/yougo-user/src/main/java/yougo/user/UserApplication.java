package yougo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * description:启动服务注册中心
 * date: 2018年5月16日 下午3:22:53
 * @author nicr
 */
@EnableEurekaServer
@SpringBootApplication
@ComponentScan(basePackages ={ "yougo"})
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
