package day4;

import java.io.FileWriter;
import java.util.Random;

public class GenerateRandomNumber {

	int size = RandomNumber.SIZE / 5;

	public GenerateRandomNumber(String fileName) throws Exception {
		FileWriter fw = new FileWriter(fileName);
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			fw.write(random.nextInt(1000000) + "\n");
		}
		fw.close();
	}

}
