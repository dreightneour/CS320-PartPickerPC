
package partPickerPC;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Search{

	
    /*public static void main(String[] args) throws Exception {
        String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).get();

       
	}*/
    
    //public Search(PartType type)
    //{
    //	
    //}
    
    public CpuPart getCPU() throws IOException
    {
        String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).get();
        
        String html = document.toString();
        for(int i = 0; i < html.length(); i++)
        {
        	if(html.substring(i, i+4) == "specs")
        	{
        		if(html.substring(i - 4, i-3) == "id")
        		{
        			
        		}
        	}
        }
        
    	return new CpuPart(html, html, html, html, html, html);
    }

}

