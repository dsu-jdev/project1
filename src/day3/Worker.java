package day3;

import java.util.HashMap;
import java.util.Map;

public class Worker extends Thread {

	private String fileName;
	private int size = Master.SIZE / 5;

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

	@Override
	public void run() {
		System.out.println(this.getName() + " start");

		FileIO read = new FileIO();
		String[] str = read.readFile(fileName).split(" ");

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		max = min = arr[0];
		for (int i = 0; i < size; i++) {
			max = (max > arr[i]) ? max : arr[i];
			min = (min < arr[i]) ? min : arr[i];
			
			if (!freq.containsKey(arr[i])) {
				freq.put(arr[i], 1);
			} else {
				freq.put(arr[i], freq.get(arr[i]) + 1);
			}
		}
	}
}
