
package partPickerPC;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Search{

	
    public static void main(String[] args) throws Exception {
       // String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        //Document document = Jsoup.connect(url).get();
    	CpuPart cpu;// = getCPU();
       cpu = getCPU();
    }
    
    //public Search(PartType type)
    //{
    //	
    //}
    
    public static CpuPart getCPU() throws IOException
    {
    	//open the webpage
        String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).get();
        
        String html = document.toString();
        
        String socketType= new String();
        String name = new String();
        String brand= new String();
        String series= new String();
        String frequency= new String();
        String cores= new String();
        
        //Find where the specs are and retrieve
        for(int i = 0; i < html.length(); i++)
        {
        	if(i == 10000)
        	{
        		html = html.substring(i, html.length() - 1);
        		i = 0;
              
            } 
        	if(html.substring(i, i+4) == "specs")
        	{
        		if(html.substring(i - 4, i-3) == "id")
        		{
        			for(int j = i; j < i + 5000; j++)
        			{
        				if(html.substring(j, j + 4)== "Brand")
        				{
        					brand = html.substring(j + 13, j+18);
        				}
        			}
        			break;
        		}
        	}
        	
        }

        //return the CPUPART
    	return new CpuPart(socketType, name, brand, series, frequency, cores);
    }

}

