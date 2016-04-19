package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class OneThread {
	public OneThread() throws Exception {
		if (!RandomNumber.isJoined) {
			RandomNumber.status.setText("Joining parts into one file...");
			join();
		}
		long start = System.currentTimeMillis();

		int[] arr = new int[RandomNumber.SIZE];
		RandomNumber.status.setText("Reading data...");
		FileReader fr = new FileReader("random-number.txt");
		BufferedReader br = new BufferedReader(fr);
		for (int i = 0; i < RandomNumber.SIZE; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (RandomNumber.isJoined) {
				RandomNumber.progressBar.setValue((i + 1) / (RandomNumber.SIZE / 40));
			} else {
				RandomNumber.progressBar.setValue(35 + (i + 1) / (RandomNumber.SIZE / 25));
			}
		}
		br.close();
		RandomNumber.status.setText("Calculating...");
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		int max;
		int min;

		max = min = arr[0];
		for (int i = 0; i < RandomNumber.SIZE; i++) {
			max = (max > arr[i]) ? max : arr[i];
			min = (min < arr[i]) ? min : arr[i];
			if (!freq.containsKey(arr[i])) {
				freq.put(arr[i], 1);
			} else {
				freq.put(arr[i], freq.get(arr[i]) + 1);
			}
			if (RandomNumber.isJoined) {
				RandomNumber.progressBar.setValue(40 + (i + 1) / (RandomNumber.SIZE / 60));
			} else {
				RandomNumber.progressBar.setValue(60 + (i + 1) / (RandomNumber.SIZE / 40));
			}
		}

		int maxFreq = 0;
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			maxFreq = (freq.get(maxFreq) > entry.getValue()) ? maxFreq : entry.getKey();
		}
		long end = System.currentTimeMillis();

		RandomNumber.oneThreadResult.setText("Max: " + max + ", frequency: " + freq.get(max) + "\n"
				+ "Min: " + min + ", frequency: " + freq.get(min) + "\n"
				+ "Element has highest frequency: " + maxFreq + ", frequency: " + freq.get(maxFreq) + "\n"
				+ "Total time: " + (end - start));
	}

	public void join() throws Exception {
		FileWriter fw = new FileWriter("random-number.txt");
		for (int i = 0; i < 5; i++) {
			FileReader fr = new FileReader(RandomNumber.FILE_NAME[i]);
			BufferedReader br = new BufferedReader(fr);
			for (int j = 0; j < RandomNumber.SIZE / 5; j++) {
				fw.write(br.readLine() + "\n");
				RandomNumber.progressBar.setValue(i * 7 + (j + 1) / (RandomNumber.SIZE / 35));
			}
			br.close();
		}
		fw.close();
	}
}
