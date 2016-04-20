package day7;

public class Main {
	
	public static final String[] URL = {
			"http://www.voanews.com/content/syria-palmyra-will-be-launching-point-carry-new-historical-significance/3257516.html",
			"http://www.voanews.com/content/panama-papers-hit-great-firewall-of-china/3269740.html",
			"http://www.voanews.com/content/petition-for-republican-convention-let-them-carry-guns/3256706.html",
			"http://www.voanews.com/content/suvs-dominate-at-new-york-auto-show/3256652.html",
			"http://www.voanews.com/content/hackers-allegedly-leak-data-fifty-million-turks/3269122.html"
	};
	
	public static void main(String[] args) {
		Article[] article = new Article[5];
		for (int i = 0; i < 5; i++) {
			article[i] = new Article(URL[i]);
			article[i].start();
		}
		for (int i = 0; i < 5; i++) {
			try {
				article[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Process.compareInList(Article.listOfSentences);
		
		Process.compareWithList(Article.listOfSentences);
	}
}
