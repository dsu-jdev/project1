package day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
	
	
	private static String[] standardizeString(String[] s) {
		for (int i = 0; i < s.length; i++) {
			int j = 0;
			while (!Character.isAlphabetic(s[i].charAt(j))) {
				j++;
			}
			
			int k = s[i].length();
			while (!Character.isAlphabetic(s[i].charAt(k - 1))) {
				k--;
			}
			s[i] = s[i].substring(j, k).toLowerCase();
		}
		
		return s;
	}
	
	
	public static List<List<Integer>> toList(String s, String t) {
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
		
		Set<String> set = new TreeSet<String>(sList);
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
	
	
	public static double cosine(List<Integer> v1, List<Integer> v2) {
		double s = 0;
		double t1 = 0;
		double t2 = 0;
		for (int i = 0; i < v1.size(); i++) {
			s += v1.get(i) * v2.get(i);
			t1 += v1.get(i) * v1.get(i);
			t2 += v2.get(i) * v2.get(i);
		}
		
		return s / (Math.sqrt(t1) * Math.sqrt(t2));
	}
}

