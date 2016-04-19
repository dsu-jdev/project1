package day3;

import java.util.Map;

public class Master {

	public static final int SIZE = 10000000; // 10 million
	public static final String[] FILE_NAME = {
			"random-0.txt",
			"random-1.txt",
			"random-2.txt",
			"random-3.txt",
			"random-4.txt"
	};

	Worker[] worker = new Worker[5];

	public void run() {
		System.out.println("Generating 10 million integers...");
		for (int i = 0; i < 5; i++) {
			new GenerateRandomNumber(FILE_NAME[i]);
			worker[i] = new Worker(FILE_NAME[i]);
		}
		System.out.println("Generated");

		System.out.println("Calculating");
		
		for (int i = 0; i < 5; i++) {
			worker[i].start();
		}

		while (workerAlive()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			System.out.print(".");
		}
		System.out.println();

		try {
			for (int i = 0; i < 5; i++) {
				worker[i].join();
			}
		} catch (InterruptedException e) {

		}

		saveResult();
		System.out.println("Results was saved into multithread-result.txt");
		System.out.println("==============================");
		System.out.println("Test with one thread");
		System.out.println("Joining parts into 1 file...");
		joinFile();
	}

	private boolean workerAlive() {
		return worker[0].isAlive()
			|| worker[1].isAlive()
			|| worker[2].isAlive()
			|| worker[3].isAlive()
			|| worker[4].isAlive();
	}

	public Map<Integer, Integer> add(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
		Map<Integer, Integer> sum = map1;
		for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
			if (!sum.containsKey(entry.getKey())) {
				sum.put(entry.getKey(), entry.getValue());
			} else {
				sum.put(entry.getKey(), sum.get(entry.getKey()) + entry.getValue());
			}
		}
		return sum;
	}

	public void saveResult() {
		int max = 0;
		int min = 0;

		Map<Integer, Integer> freq = worker[0].getFreq();
		for (int i = 1; i < 5; i++) {
			max = (max > worker[i].getMax()) ? max : worker[i].getMax();
			min = (min < worker[i].getMin()) ? min : worker[i].getMin();
			freq = add(freq, worker[i].getFreq());
		}
		
		int maxFreq = 0;
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			try {
				maxFreq = (freq.get(maxFreq) > entry.getValue()) ? maxFreq : entry.getKey();
			} catch (NullPointerException e) {
				maxFreq = entry.getKey();
			}
		}

		FileIO write = new FileIO();
		write.writeFile("multithread-result.txt",
				"Max: " + max + ", frequency: " + freq.get(max) + "\n"
				+ "Min: " + min + ", frequency: " + freq.get(min) + "\n"
				+ "Element has highest frequency: " + maxFreq + ", frequency: " + freq.get(maxFreq));
	}

	public void joinFile() {
		FileIO join = new FileIO();
		String str = "";
		for (int i = 0; i < 5; i++) {
			str += join.readFile(FILE_NAME[i]);
		}
		join.writeFile("random-number.txt", str);
	}

}
