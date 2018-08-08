package yougo.log.factory.logFactory.logger;

import java.io.Serializable;

import org.slf4j.Logger;

import yougo.log.factory.logFactory.ILogFactory;

public class Slf4jLogger implements ILogFactory, Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7488505793084099116L;
	
	private static Logger logger;
	
	private static String className;
	
	public static void setClassName(String className) {
		Slf4jLogger.className = className;
	}
	
	private static String methodName;
	
	public static void setMethodName(String methodName) {
		Slf4jLogger.methodName = methodName;
	}
	
	public Slf4jLogger(Logger logger) {
		Slf4jLogger.logger = logger;
	}

	@Override
	public void showRequestParams(Object object) {
		logger.info("[" + className + "." + methodName + "] request params are : " + object.toString() + "]");
	}

	@Override
	public void showReturnParams(Object object) {
		logger.info("[" + className + "." + methodName + "] return params are : " + object.toString() + "]");
	}

	@Override
	public void showObjectInfo(Object object) {
		logger.info("[" + object.getClass().getName() + " contains : " + object.toString() + "]");
	}
	
	@Override
	public void info(String msg) {
		logger.info(msg);
	}

}
