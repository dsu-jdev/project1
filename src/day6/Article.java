package day6;

import java.util.HashMap;
import java.util.Map;

public class Article extends Thread {

	private String url;
	
	public Article(String url) {
		this.url = url.substring(url.indexOf("/content"));
	}
	
	static Map<String, Integer> name = new HashMap<String, Integer>();
	static Map<String, Integer> name1 = new HashMap<String, Integer>();
	
	private static int numberOfArticle = 0;
	
	@Override
	public void run() {
		
		while (url != "" && numberOfArticle < 150) {
			
			numberOfArticle++;
			
			System.out.println("Reading the " + numberOfArticle + "th article");
			
			url = "http://www.voanews.com" + url;
		
			String content = Process.getContent(url);
			
			Map<String, Integer> map = Process.splitName(content);
			
			name = Process.addMap(name, map);
			
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				entry.setValue(1);
			}
			
			name1 = Process.addMap(name1, map);
			
			url = Process.getUrl(url);
			
		}
		
	}
	
}
