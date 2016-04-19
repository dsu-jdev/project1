package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	public String readFile(String fileName) {
		String fileContents;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			fileContents = br.readLine();
			fr.close();
		} catch (IOException e) {
			fileContents = null;
		}

		return fileContents;
	}

	public void writeFile(String fileName, String str) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.append(str);
			fw.close();
		} catch (IOException e) {

		}
	}
}
