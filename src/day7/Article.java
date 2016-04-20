package day7;

import java.util.ArrayList;
import java.util.List;

public class Article extends Thread {

	private String url;
	
	public Article(String url) {
		this.url = url.substring(url.indexOf("/content"));
	}
	
	private static int numberOfSentences = 0;

	public static List<String> listOfSentences = new ArrayList<String>();
	
	@Override
	public void run() {
		
		while (url != "" && numberOfSentences < 300) {
			
			url = "http://www.voanews.com" + url;
		
			String[] sentences = Process.getContent(url).split("\\.[^\\w,\\d]");
			
			for (String str : sentences) {
				listOfSentences.add(str.trim());
			}
			
			numberOfSentences += sentences.length;
			
			url = Process.getUrl(url);
			
		}
		
	}
	
}
