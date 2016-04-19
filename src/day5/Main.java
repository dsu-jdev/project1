package day5;

public class Main {
	
	public static final String[] URL = {
		"http://www.voanews.com/content/syria-palmyra-will-be-launching-point-carry-new-historical-significance/3257516.html",
		"http://www.voanews.com/content/kurds-warn-of-post-is-fight-with-shiite-militias/3256998.html",
		"http://www.voanews.com/content/petition-for-republican-convention-let-them-carry-guns/3256706.html",
		"http://www.voanews.com/content/suvs-dominate-at-new-york-auto-show/3256652.html",
		"http://www.voanews.com/content/kurds-warn-of-post-is-fight-with-shiite-militias/3256998.html"
	};

	public static void main(String[] args) {
		Article[] article = new Article[5];
		
		for (int i = 0; i < 5; i++) {
			article[i] = new Article(URL[i]);
			article[i].process.start();
		}
	}
	
}
