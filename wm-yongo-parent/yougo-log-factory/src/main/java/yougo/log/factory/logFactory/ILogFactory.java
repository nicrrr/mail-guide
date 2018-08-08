package yougo.log.factory.logFactory;

public interface ILogFactory {
	
	public void showRequestParams(Object object);
	
	public void showReturnParams(Object object);
	
	public void showObjectInfo(Object object);
	
	public void info(String msg);

}
