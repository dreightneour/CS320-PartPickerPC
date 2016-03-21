
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
    	cpu = getCPU("http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369");
    	MotherboardPart mother;
    	mother = getMotherboard("http://www.newegg.com/Product/Product.aspx?Item=N82E16813130770");
    }
    
    //public Search(PartType type)
    //{
    //	
    //}
    
    public static CpuPart getCPU(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).get();
        
        String html = document.toString();
        
        String socketType= new String();
        String name = new String();
        String brand= new String();
        String series= new String();
        String frequency= new String();
        String cores= new String();
        
        int startSub = 0;
        int endSub = 0;
        
        //Find where the specs are and retrieve
        for(int i = 0; i < html.length(); i++)
        {
        	if(i == 10000)
        	{
        		html = html.substring(i, html.length());
        		i = 0;             
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
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					brand = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 6).equals("Series"))
        				{
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					series = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 10).equals("# of Cores"))
        				{
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					cores = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 19).equals("Operating Frequency"))
        				{
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					frequency = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 11).equals("Socket Type"))
        				{
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					socketType = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 7).equals("   Name"))
        				{
        					for(int k = j; k < j + 100; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					name = html.substring(startSub , endSub);
        				}
        				
        			}
        			break;
        		}
        	}
        	
        }

        //return the CPUPART
    	return new CpuPart(socketType, name, brand, series, frequency, cores);
    }
    
    public static MotherboardPart getMotherboard(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).get();
        
        String html = document.toString();
        
        String socketType= new String();
        String brand= new String();
        String model = new String();
        
        int startSub = 0;
        int endSub = 0;
        
        //Find where the specs are and retrieve
        for(int i = 0; i < html.length(); i++)
        {
        	if(i == 10000)
        	{
        		html = html.substring(i, html.length());
        		i = 0;             
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
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					brand = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 5).equals("Model"))
        				{
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					model = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 11).equals("Socket Type"))
        				{
        					for(int k = j; k < j + 200; k++)
        					{
        						if(html.substring(k, k + 4).equals("<dd>"))
        						{
        							startSub = k + 20;
        						}
        						if(html.substring(k, k + 5).equals("</dd>"))
        						{
        							endSub = k - 15;
        							break;
        						}
        					}
        					socketType = html.substring(startSub , endSub);
        				}
        				
        			}
        			break;
        		}
        	}
        	
        }

        //return the CPUPART
    	return new MotherboardPart(brand, model, socketType);
    }

}

