package search.BreathFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	private Queue<String> websiteQueue;
	private List<String> discoveredWebsites;
	
	public WebCrawler() {
		this.websiteQueue = new LinkedList<>();
		this.discoveredWebsites = new ArrayList<>();
	}

	public void discover(String root) {
		websiteQueue.add(root);
		discoveredWebsites.add(root);
		
		while(!websiteQueue.isEmpty()) {
			String url = websiteQueue.remove();
			String rawHtml = readUrl(url);
			String regex = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHtml);
			while(matcher.find()) {
				String theUrl = matcher.group();
				if(!discoveredWebsites.contains(theUrl)) {
					discoveredWebsites.add(theUrl);
					System.out.println(url+" ->website found -> "+theUrl);
					websiteQueue.add(theUrl);
				}
			}
		}
	}

	private String readUrl(String urlStr) {
		String rawHtml = "";
		try {
			URL url = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String line="";
			while((line = br.readLine()) != null) {
				rawHtml += line;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rawHtml;
	}
	
	public static void main(String[] args) {
		WebCrawler wc = new WebCrawler();
		String site = "http://www.amazon.co.in/";
		wc.discover(site);
	}
}
