package yougo.log.factory.logFactory.util;

/**
 * 
 * description:获取调用方法类名和方法名
 * date: 2018年6月22日 上午11:05:39
 * @author nicr
 */
public class GetTransferInfo {
	
	public static String getClassName() {
		return Thread.currentThread().getStackTrace()[1].getClassName();
	}
	
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}
	
}
