package yougo.biz.web.util.mq;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class TestConsumer {
	
	/**
	 * 
	 * description:mq消费者
	 * @param map
	 * @author nicr
	 * date: 2018年6月29日 下午5:45:32
	 */
//	@JmsListener(destination="queue-test")
	public void test(String str) {
		System.out.println("##########################"+str);
		Map map1 = JSON.parseObject(str, Map.class);
		System.out.println("##########################"+map1.get("name"));
	}

}
