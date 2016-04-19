package day7;

import java.util.*;

public class ddd {

	static double cosine(List<Integer> v1, List<Integer> v2) {
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
	
	static List<List<Integer>> toList(String s, String t) {
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
	
	static String[] standardizeString(String[] s) {
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "e s o c k d o i l e d c d e s i d﻿";
		String s2 = "d i l o i d n k h e x c d g";
		
		System.out.println(toList(s1, s2));
		
		System.out.println(cosine(toList(s1, s2).get(0), toList(s1, s2).get(1)));
		
	}
}
