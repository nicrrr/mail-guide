package yougo.log.factory.logFactory.logger;

import java.io.Serializable;

import org.slf4j.spi.LocationAwareLogger;

import yougo.log.factory.logFactory.ILogFactory;

public class Slf4jLocationLogger implements ILogFactory, Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3539794700779754957L;

	private static LocationAwareLogger locationAwareLogger;
	
	private static String className;
	
	public static void setClassName(String className) {
		Slf4jLocationLogger.className = className;
	}
	
	private static String methodName;
	
	public static void setMethodName(String methodName) {
		Slf4jLocationLogger.methodName = methodName;
	}
	
	public Slf4jLocationLogger(LocationAwareLogger locationAwareLogger) {
		Slf4jLocationLogger.locationAwareLogger = locationAwareLogger;
	}
	
	@Override
	public void showRequestParams(Object object) {
		locationAwareLogger.info("[" + className + "." + methodName + "] request params are : " + object.toString() + "]");
	}

	@Override
	public void showReturnParams(Object object) {
		locationAwareLogger.info("[" + className + "." + methodName + "] return params are : " + object.toString() + "]");
	}

	@Override
	public void showObjectInfo(Object object) {
		locationAwareLogger.info("[" + methodName + "->" + object.getClass().getSimpleName() + " contains : " + object.toString() + "]");
	}
	
	@Override
	public void info(String msg) {
		locationAwareLogger.info(msg);
	}
	
}
