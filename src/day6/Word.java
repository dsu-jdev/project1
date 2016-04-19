package day6;

public class Word {

	private String name;
	private int freq;

	public String getName() {
		return name;
	}

	public int getFreq() {
		return freq;
	}

	public Word(String name, int freq) {
		super();
		this.name = name;
		this.freq = freq;
	}
	
	@Override
	public String toString() {
		return name + "=" + freq;
	}

}
