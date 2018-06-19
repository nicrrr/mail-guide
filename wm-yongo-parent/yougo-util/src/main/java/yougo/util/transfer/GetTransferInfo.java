package yougo.util.transfer;

public class GetTransferInfo {
	
	public static String getClassName() {
		return Thread.currentThread().getStackTrace()[1].getClassName();
	}
	
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}
	
}
