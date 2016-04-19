package day6;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Process {

	public static String getContent(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements element = doc.select("div[class=zoomMe]");
			return element.text();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getUrl(String urlSource) {
		String url;
		try {
			url = Jsoup.connect(urlSource).get().select("ul.bullet_orange li a").attr("href");
		} catch (IOException e) {
			url = null;
			e.printStackTrace();
		}
		return url;
	}
	
	public static Map<String, Integer> splitName(String content) {
		String[] sentences = content.split("\\. ");
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
		return map;
	}
	
	public static Map<String, Integer> addMap(Map<String, Integer> map1, Map<String, Integer> map2) {
		
		Map<String, Integer> sum = map1;
		for (Map.Entry<String, Integer> entry : map2.entrySet()) {
			if (sum.containsKey(entry.getKey())) {
				sum.put(entry.getKey(), sum.get(entry.getKey()) + entry.getValue());
			} else {
				sum.put(entry.getKey(), entry.getValue());
			}
		}
		
		return sum;
	}
}
