
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
        		html = html.substring(i, html.length());
        		i = 0;
        		int b = html.length();
        		b = b;
              
            } 
        	if(html.substring(i, i+5).equals("Specs"))
        	{
        		String id = html.substring(i - 4, i-2);
        		if(id.equals("id"))
        		{
        			for(int j = i; j < i + 5000; j++)
        			{
        				if(html.substring(j, j + 5).equals("Brand"))
        				{
        					brand = html.substring(j+60 , j+ 65);
        				}
        				
        				if(html.substring(j, j + 6).equals("Series"))
        				{
        					series = html.substring(j+61 , j+ 68);
        				}
        				
        				if(html.substring(j, j + 10).equals("# of Cores"))
        				{
        					cores = html.substring(j+69 , j+ 78);
        				}
        				
        				if(html.substring(j, j + 19).equals("Operating Frequency"))
        				{
        					frequency = html.substring(j+78 , j+ 85);
        				}
        				
        				if(html.substring(j, j + 11).equals("Socket Type"))
        				{
        					socketType = html.substring(j+70 , j+ 78);
        				}
        				
        				if(html.substring(j, j + 7).equals("   Name"))
        				{
        					name = html.substring(j+67 , j+ 75);
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

