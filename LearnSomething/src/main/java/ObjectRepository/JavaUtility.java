package ObjectRepository;

import java.util.Random;

public class JavaUtility {
	public int generateRandomNumber(int range) {
		Random r= new Random();
		return r.nextInt(range);
	}

}
