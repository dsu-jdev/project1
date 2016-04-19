package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class FileIO {

	public static final int N = 1000000;
	public static final String FILE_NAME = "random-number.txt";

	public static int indexOfMax(int[] a) {
		int index = 0;
		for (int i = 0; i < N; i++) {
			index = a[i] > a[index] ? i : index;
		}
		return index;
	}
	
	public static int indexOfMin(int[] a) {
		int index = 0;
		for (int i = 0; i < N; i++) {
			index = a[i] < a[index] ? i : index;
		}
		return index;
	}

	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(FILE_NAME);

		Random random = new Random();

		for (int i = 0; i < N; i++) {
			fw.write(random.nextInt() % 100000 + " ");
		}

		fw.close();

		FileReader fr = new FileReader(FILE_NAME);
		BufferedReader br = new BufferedReader(fr);

		String[] str = br.readLine().split(" ");

		fr.close();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

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
		
		
		int min = indexOfMin(arr);
		System.out.println("The smallest element is " + arr[min]
				+ " has a frequency of " + freq[min]);

		int max = indexOfMax(arr);
		System.out.println("The largest element is " + arr[max]
				+ " has a frequency of " + freq[max]);

		int maxFreq = indexOfMax(freq);
		System.out.println("Element has the highest frequency is " + arr[maxFreq]
				+ " with a frequency of " + freq[maxFreq]);
	}
}
