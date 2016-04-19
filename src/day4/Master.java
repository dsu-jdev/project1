package day4;

import java.util.Map;

public class Master {

	Worker[] worker = new Worker[5];

	public Master() throws Exception {
		for (int i = 0; i < 5; i++) {
			worker[i] = new Worker(RandomNumber.FILE_NAME[i]);
			worker[i].worker.setName("Worker-" + i);
		}

		RandomNumber.status.setText("Reading data...");
		for (int i = 0; i < 5; i++) {
			worker[i].worker.start();
		}

		for (int i = 0; i < 5; i++) {
			worker[i].worker.join();
		}

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

		RandomNumber.multithreadResult.setText("Max: " + max + ", frequency: " + freq.get(max) + "\n"
				+ "Min: " + min + ", frequency: " + freq.get(min) + "\n"
				+ "Element has highest frequency: " + maxFreq + ", frequency: " + freq.get(maxFreq) + "\n");
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
}
