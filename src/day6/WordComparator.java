package day6;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {

	@Override
	public int compare(Word o1, Word o2) {
		
		if (o1.getFreq() > o2.getFreq()) {
			return -1;
		}
		
		if (o1.getFreq() < o2.getFreq()) {
			return 1;
		}
		
		return 0;
	}

}
