package jenkinsParameterization;

import org.testng.annotations.Test;

public class Practice1 {

	@Test
	public void demo() {
		System.out.println(System.getProperty("browser"));
	}
}
