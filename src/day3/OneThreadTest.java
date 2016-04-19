package day3;

import java.util.HashMap;
import java.util.Map;

public class OneThreadTest {

	public static final String FILE_NAME = "random-number.txt";
	
	public OneThreadTest() {
		System.out.println("Calculating");
		FileIO file = new FileIO();
		String[] str = file.readFile(FILE_NAME).split(" ");
		
		int size = Master.SIZE;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		int max;
		int min;
		
		max = min = arr[0];
		
		for (int i : arr) {
			max = (max > i) ? max : i;
			min = (min < i) ? min : i;
			if (!freq.containsKey(i)) {
				freq.put(i, 1);
			} else {
				freq.put(i, freq.get(i) + 1);
			}
		}
		
		int maxFreq = 0;
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			maxFreq = (freq.get(maxFreq) > entry.getValue()) ? maxFreq : entry.getKey();
		}
		
		file.writeFile("one-thread-result.txt",
				"Max: " + max + ", frequency: " + freq.get(max) + "\n"
				+ "Min: " + min + ", frequency: " + freq.get(min) + "\n"
				+ "Element has highest frequency: " + maxFreq + ", frequency: " + freq.get(maxFreq));
		
		System.out.println("Done! Result was saved into one-thread-result.txt");
	}
}
