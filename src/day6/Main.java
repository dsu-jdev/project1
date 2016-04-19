package day6;

import java.util.*;

public class Main {
	
	public static final String[] URL = {
		"http://www.voanews.com/content/syria-palmyra-will-be-launching-point-carry-new-historical-significance/3257516.html",
		"http://www.voanews.com/content/panama-papers-hit-great-firewall-of-china/3269740.html",
		"http://www.voanews.com/content/petition-for-republican-convention-let-them-carry-guns/3256706.html",
		"http://www.voanews.com/content/suvs-dominate-at-new-york-auto-show/3256652.html",
		"http://www.voanews.com/content/hackers-allegedly-leak-data-fifty-million-turks/3269122.html"
	};

	public static void main(String[] args) {

		Article[] arcl = new Article[5];
		
		for (int i = 0; i < 5; i++) {
			arcl[i] = new Article(URL[i]);
			arcl[i].start();
		}
		
		for (int i = 0; i < 5; i++) {
			try {
				arcl[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<Word> nameList = new ArrayList<Word>();
		List<Word> name1List = new ArrayList<Word>();
		
		for (Map.Entry<String, Integer> entry : Article.name.entrySet()) {
			nameList.add(new Word(entry.getKey(), entry.getValue()));
		}
		
		for (Map.Entry<String, Integer> entry : Article.name1.entrySet()) {
			name1List.add(new Word(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(nameList, new WordComparator());
		Collections.sort(name1List, new WordComparator());
		
		for (Word word : nameList) {
			System.out.print(word.toString() + ", ");
		}
		System.out.println();
		
		Word max = name1List.get(0);
		System.out.println(max.toString());
		
	}
	
}
