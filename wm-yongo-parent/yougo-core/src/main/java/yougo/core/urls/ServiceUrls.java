package yougo.core.urls;

public enum ServiceUrls {
	
	BIZSERVICE("http://localhost:9010/"), BIZWEB("http://localhost:9020/");
	
	private String port;
	
	private ServiceUrls(String port){
		this.port = port;
	}
	
	public String getPort(){
		return port;
	}

}
