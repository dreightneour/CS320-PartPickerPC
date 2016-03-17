
package partPickerPC;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Search{

	
    public static void main(String[] args) throws Exception {
        String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).get();

        String question = document.select("#question .post-text").text();
        System.out.println("Question: " + question);

        Elements answerers = document.select("#answers .user-details a");
        for (Element answerer : answerers) {
            System.out.println("Answerer: " + answerer.text());
	        }
	 }

}

