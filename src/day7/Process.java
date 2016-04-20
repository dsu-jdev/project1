package day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Process {

	public static String getContent(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements element = doc.select("div.zoomMe");
			element.select("strong").remove();
			element.select("div.contentImage.floatNone").remove();
			element.select("div.mediaplayer.videoplayer").remove();
			element.select("div.html5Player.htmlPhg").remove();
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
	
	
	private static String[] standardizeString(String[] s) {
		for (int i = 0; i < s.length; i++) {
			try {
				int j = 0;
				while (!Character.isAlphabetic(s[i].charAt(j)) && !Character.isDigit(s[i].charAt(j))) {
					j++;
				}
				
				int k = s[i].length();
				while (!Character.isAlphabetic(s[i].charAt(k - 1)) && !Character.isDigit(s[i].charAt(k - 1))) {
					k--;
				}
				s[i] = s[i].substring(j, k).toLowerCase();
			} catch (StringIndexOutOfBoundsException e) {
				s[i] = "";
			}
		}
		
		return s;
	}
	
	
	private static List<List<Integer>> toList(String s, String t) {
		String[] sWord = standardizeString(s.split(" "));
		String[] tWord = standardizeString(t.split(" "));
		
		List<String> sList = new ArrayList<String>();
		List<String> tList = new ArrayList<String>();
		
		
		for (String str : sWord) {
			sList.add(str);
		}
		
		for (String str : tWord) {
			tList.add(str);
		}
		
		Set<String> set = new TreeSet<String>();
		set.addAll(sList);
		set.addAll(tList);
		
		Map<String, Integer> sMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> tMap = new LinkedHashMap<String, Integer>();
		
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			String str = it.next();
			sMap.put(str, Collections.frequency(sList, str));
			tMap.put(str, Collections.frequency(tList, str));
		}
		
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		list.add(new ArrayList<Integer>(sMap.values()));
		list.add(new ArrayList<Integer>(tMap.values()));
		
		return list;
	}
	
	
	private static double cosine(String s1, String s2) {
		List<Integer> l1 = toList(s1, s2).get(0);
		List<Integer> l2 = toList(s1, s2).get(1);
		
		double s = 0;
		double t1 = 0;
		double t2 = 0;
		for (int i = 0; i < l1.size(); i++) {
			s += l1.get(i) * l2.get(i);
			t1 += l1.get(i) * l1.get(i);
			t2 += l2.get(i) * l2.get(i);
		}
		
		return s / (Math.sqrt(t1) * Math.sqrt(t2));
	}
	

	public static void compareInList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (cosine(list.get(i), list.get(j)) >= 0.65) {
					System.out.println("\"" + list.get(i)
					+ "\" IS SIMILAR TO \"" + list.get(j) + "\"");
				}
			}
		}
		
		System.out.println();
	}
	
	public static void compareWithList(List<String> list) {
		System.out.print("Enter a new sentence to compare: ");
		String newSentence = new Scanner(System.in).nextLine();
		
		System.out.println("The sentence above is similar to:");
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (cosine(list.get(i), newSentence) >= 0.65) {
				System.out.println("\t\"" + list.get(i) + "\"");
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("Not found!");
		}
	}
	
}

