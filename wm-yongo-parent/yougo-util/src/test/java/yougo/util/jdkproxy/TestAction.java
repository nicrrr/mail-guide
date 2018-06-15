package yougo.util.jdkproxy;

/**
 * 
 * description:被代理类，目标对象
 * date: 2018年6月4日 上午10:35:46
 * @author nicr
 */
public class TestAction implements TestInterface{

	@Override
	public void dosomething() {
		
		System.out.println("TestAction do somethings");
		
	}

}
