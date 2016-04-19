package day3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomNumber {

	int size = Master.SIZE / 5;

	public GenerateRandomNumber(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			Random random = new Random();
			for (int i = 0; i < size; i++) {
				fw.write(random.nextInt(500000) + "\n");
			}
			fw.close();
		} catch (IOException e) {

		}
	}

}
