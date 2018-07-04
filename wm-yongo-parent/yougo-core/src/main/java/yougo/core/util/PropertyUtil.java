package yougo.core.util;

import yougo.core.entity.SystemPropertyPO;
import yougo.core.mapper.SystemPropertyMapper;
import yougo.core.mybatis.DBConfig;

public class PropertyUtil {
	
	/**
	 * 
	 * description:获取value值
	 * @param key 数据库中的key
	 * @return
	 * @author nicr
	 * date: 2018年6月22日 下午3:01:01
	 * @throws Exception 
	 */
	public static String getProperties(String key) throws Exception {
		SystemPropertyPO systemPropertyPO = new SystemPropertyPO(); 
		systemPropertyPO.setSysKey("one");
		SystemPropertyPO systemPropertyPO1 = DBConfig.sqlSessionTemplate().getMapper(SystemPropertyMapper.class).queryByKey(systemPropertyPO);
		return systemPropertyPO1.getSysValue();
	}

}
