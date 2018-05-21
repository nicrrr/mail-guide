package yougo.core.enums;

public enum ServiceEnums {
	
	/**
	 * 测试post请求
	 */
	BIZSERVICETEST("service/postForObject1");
	
	private String serverName;
	
	private ServiceEnums(String serverName){
		this.serverName = serverName;
	}
	
	public String getServerName(){
		return serverName;
	}

}
