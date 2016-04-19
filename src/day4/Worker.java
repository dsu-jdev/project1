package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Worker {

	private String fileName;
	private int size = RandomNumber.SIZE / 5;

	private int max;
	private int min;

	private Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

	public Worker(String fileName) {
		this.fileName = fileName;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public Map<Integer, Integer> getFreq() {
		return freq;
	}

	Thread worker = new Thread() {
		@Override
		public void run() {
			int[] arr = new int[size];
			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
	
				int progress = 0;
	
				for (int i = 0; i < size; i++) {
					arr[i] = Integer.parseInt(br.readLine());
	
					progress = (i + 1) / (size / 50);
	
					switch (this.getName()) {
					case "Worker-0":
						RandomNumber.progressBar0.setValue(progress);
						break;
	
					case "Worker-1":
						RandomNumber.progressBar1.setValue(progress);
						break;
	
					case "Worker-2":
						RandomNumber.progressBar2.setValue(progress);
						break;
	
					case "Worker-3":
						RandomNumber.progressBar3.setValue(progress);
						break;
	
					case "Worker-4":
						RandomNumber.progressBar4.setValue(progress);
						break;
					}
				}
	
				br.close();
			} catch (IOException e) {
	
			}
	
			RandomNumber.status.setText("Calculating...");
	
			max = min = arr[0];
			int progress = 0;
	
			for (int i = 0; i < size; i++) {
				max = (max > arr[i]) ? max : arr[i];
				min = (min < arr[i]) ? min : arr[i];
	
				if (!freq.containsKey(arr[i])) {
					freq.put(arr[i], 1);
				} else {
					freq.put(arr[i], freq.get(arr[i]) + 1);
				}
	
				progress = 50 + (i + 1) / (size / 50);
				switch (this.getName()) {
				case "Worker-0":
					RandomNumber.progressBar0.setValue(progress);
					break;
	
				case "Worker-1":
					RandomNumber.progressBar1.setValue(progress);
					break;
	
				case "Worker-2":
					RandomNumber.progressBar2.setValue(progress);
					break;
	
				case "Worker-3":
					RandomNumber.progressBar3.setValue(progress);
					break;
	
				case "Worker-4":
					RandomNumber.progressBar4.setValue(progress);
					break;
				}
			}
		}
	};
}
