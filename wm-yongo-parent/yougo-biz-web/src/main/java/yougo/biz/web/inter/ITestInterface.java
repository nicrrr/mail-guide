package yougo.biz.web.inter;

public interface ITestInterface {
	
	/**
	 * description: 实现此接口的类所需的公共方法
	 * @return string
	 * @author nicr
	 * date: 2018年7月4日 下午4:55:53
	 */
	default String getString() {
		System.out.println("before return");
		return "the is interface test method";
	}
	
	public void showString(String message);

}
