package yougo.log.factory.logFactory.impl;

import org.slf4j.Logger;
import org.slf4j.spi.LocationAwareLogger;

import yougo.log.factory.logFactory.ILogFactory;
import yougo.log.factory.logFactory.logger.Slf4jLocationLogger;
import yougo.log.factory.logFactory.logger.Slf4jLogger;
import yougo.util.transfer.GetTransferInfo;

/**
 * 
 * description:
 * date: 2018年6月15日 上午10:36:14
 * @author nicr
 */

public class LogFactory{
	
	private static volatile LogFactory defaultFactory = new LogFactory();

	public static ILogFactory getLogFactory(Class<?> cla) {
		if(cla != null) {
			Logger logger = org.slf4j.LoggerFactory.getLogger(cla);
			if(logger instanceof LocationAwareLogger) {
				Slf4jLocationLogger.setClassName(GetTransferInfo.getClassName());
				Slf4jLocationLogger.setMethodName(GetTransferInfo.getMethodName());
				return (ILogFactory)(new Slf4jLocationLogger((LocationAwareLogger) logger));
			}else {
				Slf4jLogger.setClassName(GetTransferInfo.getClassName());
				Slf4jLogger.setMethodName(GetTransferInfo.getMethodName());
				return (ILogFactory)(new Slf4jLogger(logger));
			}
		}else {
			return null;
		}
	}
	
}
