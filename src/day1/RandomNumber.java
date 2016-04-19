package day1;

import java.util.Arrays;
import java.util.Random;

public class RandomNumber {

	public static final int N = 1000000;
	
	public static int indexOfMax(int[] a) {
		int index = 0;
		for (int i = 0; i < N; i++) {
			index = a[i] > a[index] ? i : index;
		}
		return index;
	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[N];

		System.out.println("Generating 1,000,000 integers in (-100,000; 100,000)...");
		
		// generate 1,000,000 integers in [-100,000; 100,000]
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt() % 100000;
		}
		
		System.out.println("Generated!");

		Arrays.sort(arr);

		int[] freq = new int[N];

		int i = 0;
		while (i < N) {
			int count = 1;
			int j = i + 1;
			while (j < N && arr[i] == arr[j]) {
				count++;
				j++;
			}

			freq[i] = count;
			i += count;
		}

		int max = indexOfMax(arr);
		System.out.println("The largest element is " + arr[max]
				+ " has a frequency of " + freq[max]);

		int maxFreq = indexOfMax(freq);
		System.out.println("Element has the highest frequency is " + arr[maxFreq]
				+ " with a frequency of " + freq[maxFreq]);
	}
}
