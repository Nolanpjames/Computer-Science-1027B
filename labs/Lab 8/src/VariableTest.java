
public class VariableTest {

	private static int sNum = 0;
	private int iNum = 0;
	
	public VariableTest () {
		iNum = 5;
	}
	
	public void update (int num) {
		iNum = num;
	}
	
	public static void main(String[] args) {
		
		System.out.println(sNum);
		//System.out.println(iNum);
		
		VariableTest test = new VariableTest();
		System.out.println(test.iNum);
	}

}
