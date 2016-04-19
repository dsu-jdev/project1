package day5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Article {

	private String url;
	
	public Article(String url) {
		this.url = url;
	}
	
	Thread process = new Thread() {
		
		@Override
		public void run() {
			
			String text;
			try {
				Document doc = Jsoup.connect(url).get();
				Elements element = doc.select("div[class=zoomMe]");
				text = element.text();
			} catch (IOException e) {
				text = "";
				e.printStackTrace();
			}
			
			String[] sentences = text.split("\\. ");
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for (String sentence : sentences) {
				sentence = sentence.trim();
				
				int space = sentence.indexOf(' ');
				sentence = sentence.substring(space + 1);
	
				while (sentence.length() > 0) {
					space = -1;
					while (!Character.isUpperCase(sentence.charAt(space + 1))) {
						space = sentence.indexOf(' ', space + 1);
						if (space == -1) {
							space = sentence.length() - 1;
							break;
						}
					}
					sentence = sentence.substring(space + 1);
					if (sentence.length() == 0) {
						break;
					}
					
					space = sentence.indexOf(' ');
					while (Character.isUpperCase(sentence.charAt(space + 1))) {
						
						if (space > 1 && !Character.isAlphabetic(sentence.charAt(space - 1))) {
							break;
						}
						
						space = sentence.indexOf(' ', space + 1);
						if (space == -1) {
							space = sentence.length();
							break;
						}
					}
					
					String name = sentence.substring(0, space);
					
					while (!Character.isAlphabetic(name.charAt(space - 1))) {
						name = name.substring(0, --space);
					}
					
					if (map.containsKey(name)) {
						map.put(name, map.get(name) + 1);
					} else {
						map.put(name, 1);
					}
					
					try {
						sentence = sentence.substring(space + 1);
					} catch (StringIndexOutOfBoundsException e) {
						sentence = "";
					}
				}
				
			}
			
			System.out.println("==========" + process.getName() + "==========");
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				System.out.println(entry);
			}
			System.out.println();
			
		}
		
	};
	
}
