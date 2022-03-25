import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import static java.util.Map;

public class Main {

	public static void main(String [] args) {
		int p = 3;
		int parent = (int) (Math.ceil((double)p/2) - 1);
//		System.out.println(parent);
		List<Integer> arr = new ArrayList<Integer>();
//		new ArrayList().addAll(arr);
		String strArr[] = {"Hello", "world"};
		
		String str = "Hello";
//		str.toCharArray
		
		System.out.println(str.startsWith("HelloWorld"));
		System.out.println(str.startsWith("Hell"));
		System.out.println(str.startsWith("DimuthHoHelloWorld"));
		System.out.println(str.startsWith("Jill"));
		System.out.println(str.startsWith("Hello"));
		
		Map<String, String> map = new HashMap<>();
		
	}
}
