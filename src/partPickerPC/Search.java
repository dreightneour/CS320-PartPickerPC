
package partPickerPC;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class Search{

	private static ArrayList<CpuPart> cpuList = new ArrayList<CpuPart>();
	private ArrayList<MotherboardPart> motherList = new ArrayList<MotherboardPart>();
	private ArrayList<GpuPart> gpuList = new ArrayList<GpuPart>();
	private ArrayList<RamPart> ramList = new ArrayList<RamPart>();
	
	
    public static void main(String[] args) throws Exception {
    	// String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        //Document document = Jsoup.connect(url).get();
    	
    	
    	cpuList = getArrayCpu("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007671%208000%204814&IsNodeId=1&page=1&bop=And&Pagesize=90");
    	
    	/*CpuPart cpu;// = getCPU();
    	cpu = getCPU("http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369");
    	MotherboardPart mother;
    	mother = getMotherboard("http://www.newegg.com/Product/Product.aspx?Item=N82E16813130770");
    	GpuPart gpu;// = getCPU();
    	gpu = getGpu("http://www.newegg.com/Product/Product.aspx?Item=N82E16814487159");
    	RamPart ram;
    	ram = getRam("http://www.newegg.com/Product/Product.aspx?Item=N82E16820233144");
    	*/
    }
    

    
    //public Search(PartType type)
    //{
    //	
    //}
    
    public static ArrayList<CpuPart> getArrayCpu(String url) throws IOException
    {
    	boolean next = true;
    	ArrayList<CpuPart> cpuList = new ArrayList<CpuPart>();
    	while(next == true)
    	{
    		next = false;
	        Document document = Jsoup.connect(url).timeout(50000).get();
	        
	        String html = document.toString();
	    	
	        int startSub = 0;
	        int endSub = 0;      
	        
	        Elements scriptElements = document.getElementsByTag("a");
	        
	        String urlList = new String();
	        
	       //Element element = scriptElements.get(98);
	        for (Element element :scriptElements )
	        { 
	       		//for (DataNode node : element.dataNodes()) {
	               //System.out.println(node.getWholeData());
		   		String priceHtml = element.outerHtml();
		   		//boolean found = false;
		   		for(int i = 0; i < priceHtml.length() - 100; i++)
		   		{
		   			startSub = 0;
	    	   		/*if(priceHtml.substring(i, i + 22).equals("call-to-action-details"))// && found == false)
	    	   		{
	    	   			for(int k = i; k < i + 200; k++)
						{
							if(priceHtml.substring(k, k + 1).equals("=") && startSub == 0)
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 1).equals(">"))
							{
								endSub = k - 1;
								break;
							}
						}
						urlList = priceHtml.substring(startSub , endSub);
						cpuList.add(getCPU(urlList));
						//found = true;
					}
	    	   		*/
	    	   		if(priceHtml.substring(i, i + 9).equals("itemImage"))// && found == false)
	    	   		{
	    	   			for(int k = i; k < i + 500; k++)
						{
							if(priceHtml.substring(k, k + 5).equals("href=") && startSub == 0)
							{
								startSub = k + 6;
							}
							if(priceHtml.substring(k, k + 1).equals(">"))
							{
								endSub = k - 1;
								break;
							}
						}
						urlList = priceHtml.substring(startSub , endSub);
						cpuList.add(getCPU(urlList));
						//found = true;
					}
					
	               //System.out.println("-------------------");            
	           	}
	    	   	
	        }
	        
	        scriptElements = document.getElementsByTag("link");
	        
	        urlList = new String();
	        
	       //Element element = scriptElements.get(98);
	        for (Element element :scriptElements ){ 
	       		//for (DataNode node : element.dataNodes()) {
	               //System.out.println(node.getWholeData());
		   		String priceHtml = element.outerHtml();
		   		for(int i = 0; i < priceHtml.length() - 20; i++)
		   		{
		   			startSub = 0;
	    	   		if(priceHtml.substring(i, i + 4).equals("next"))
	    	   		{
	    	   			for(int k = i; k < i + 200; k++)
						{
							if(priceHtml.substring(k, k + 1).equals("=") && startSub == 0)
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 1).equals(">"))
							{
								endSub = k - 1;
								break;
							}
						}
	    	   			
						url = priceHtml.substring(startSub , endSub);
						next = true;
						break;
						//cpuList.add(getCPU(urlList));
	    	   		}
	               //System.out.println("-------------------");            
	           	}
		   		if(next == true)
		   		{
		   			break;
		   		}
	    	   	
	        }
	        
	        
    	}
    	//cpuList = cpuList;
    	return cpuList;
    }
    
    public static CpuPart getCPU(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).timeout(50000).get();
        String html = document.toString();
        

        

        
        String socketType= new String();
        String name = new String();
        String brand= new String();
        String series= new String();
        String frequency= new String();
        String cores= new String();
        

        
        int startSub = 0;
        int endSub = 0;        
        
        Elements scriptElements = document.getElementsByTag("script");
        
        String price = new String();
        String salePrice = new String();
        
       //Element element = scriptElements.get(98);
        for (Element element :scriptElements ){ 
       		for (DataNode node : element.dataNodes()) {
               //System.out.println(node.getWholeData());
    	   		String priceHtml = node.getWholeData();
    	   		for(int i = 0; i < priceHtml.length() - 100; i++)
    	   		{
	    	   		if(priceHtml.substring(i, i + 18).equals("product_unit_price"))
	    	   		{
	    	   			for(int k = i; k < i + 50; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						price = priceHtml.substring(startSub , endSub);
					}
	    	   		
	    	   		if(priceHtml.substring(i, i + 18).equals("product_sale_price"))
	    	   		{
	    	   			for(int k = i; k < i + 200; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						salePrice = priceHtml.substring(startSub , endSub);
					}
    	   		}
               //System.out.println("-------------------");            
           	}
        }
        
        //Find where the specs are and retrieve
        for(int i = 0; i < html.length() - 6; i++)
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
        				if(html.substring(j, j + 5).equals("Brand") && brand.equals(""))
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
        					name = html.substring(startSub , endSub);
        				}
        				
        			}
        			break;
        		}
        	}
        	
        }

        //return the CPUPART
    	CpuPart cpu = new CpuPart(socketType, name, brand, series, frequency, cores);
    	double priceD = Double.parseDouble(price);
    	double saleD = Double.parseDouble(salePrice);
    	//double priceD = Double.parseDouble(price);
    	
    	if(saleD != priceD)
    	{
    		cpu.setSale(true);
    		cpu.setSalePercentage((priceD - saleD) / priceD);
    	}
    	else
    	{
    		cpu.setSale(false);
    		cpu.setSalePercentage(0.0);
    	}

    	cpu.setPrice(priceD);
    	
    	return cpu;
    }
    
    public static MotherboardPart getMotherboard(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).timeout(50000).get();
        
        String html = document.toString();
        
        String socketType= new String();
        String brand= new String();
        String model = new String();
        
        int startSub = 0;
        int endSub = 0;
        
        Elements scriptElements = document.getElementsByTag("script");
        
        String price = new String();
        String salePrice = new String();
        
       //Element element = scriptElements.get(98);
        for (Element element :scriptElements ){ 
       		for (DataNode node : element.dataNodes()) {
               //System.out.println(node.getWholeData());
    	   		String priceHtml = node.getWholeData();
    	   		for(int i = 0; i < priceHtml.length() - 100; i++)
    	   		{
	    	   		if(priceHtml.substring(i, i + 18).equals("product_unit_price"))
	    	   		{
	    	   			for(int k = i; k < i + 50; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						price = priceHtml.substring(startSub , endSub);
					}
	    	   		
	    	   		if(priceHtml.substring(i, i + 18).equals("product_sale_price"))
	    	   		{
	    	   			for(int k = i; k < i + 200; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						salePrice = priceHtml.substring(startSub , endSub);
					}
    	   		}
               //System.out.println("-------------------");            
           	}
        }

        
        //Find where the specs are and retrieve
        for(int i = 0; i < html.length() - 6; i++)
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
        MotherboardPart mother = new MotherboardPart(brand, model, socketType);
    	double priceD = Double.parseDouble(price);
    	double saleD = Double.parseDouble(salePrice);
    	//double priceD = Double.parseDouble(price);
    	
    	if(saleD != priceD)
    	{
    		mother.setSale(true);
    		mother.setSalePercentage((priceD - saleD) / priceD);
    	}
    	else
    	{
    		mother.setSale(false);
    		mother.setSalePercentage(0.0);
    	}

    	mother.setPrice(priceD);
        //return the CPUPART
    	return mother;
    }
    
    public static GpuPart getGpu(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).get();
        
        String html = document.toString();
        
        String brand= new String();
        String model = new String();
        String slotType = new String();
        String gpuBase = new String();
        String memorySize = new String();
        
        int startSub = 0;
        int endSub = 0;
        
        Elements scriptElements = document.getElementsByTag("script");
        
        String price = new String();
        String salePrice = new String();
        
       //Element element = scriptElements.get(98);
        for (Element element :scriptElements ){ 
       		for (DataNode node : element.dataNodes()) {
               //System.out.println(node.getWholeData());
    	   		String priceHtml = node.getWholeData();
    	   		for(int i = 0; i < priceHtml.length() - 100; i++)
    	   		{
	    	   		if(priceHtml.substring(i, i + 18).equals("product_unit_price"))
	    	   		{
	    	   			for(int k = i; k < i + 50; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						price = priceHtml.substring(startSub , endSub);
					}
	    	   		
	    	   		if(priceHtml.substring(i, i + 18).equals("product_sale_price"))
	    	   		{
	    	   			for(int k = i; k < i + 200; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						salePrice = priceHtml.substring(startSub , endSub);
					}
    	   		}
               //System.out.println("-------------------");            
           	}
        }
        
        //Find where the specs are and retrieve
        for(int i = 0; i < html.length() - 6; i++)
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
        				
        				if(html.substring(j, j + 10).equals(">Interface"))
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
        					slotType = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 11).equals("Memory Size"))
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
        					memorySize = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 11).equals("Memory Type"))
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
        					gpuBase = html.substring(startSub , endSub);
        				}
        				
        			}
        			break;
        		}
        	}
        	
        }

        //return the CPUPART
    	GpuPart gpu = new GpuPart(brand, model, slotType, gpuBase, memorySize);
    	double priceD = Double.parseDouble(price);
    	double saleD = Double.parseDouble(salePrice);
    	//double priceD = Double.parseDouble(price);
    	
    	if(saleD != priceD)
    	{
    		gpu.setSale(true);
    		gpu.setSalePercentage((priceD - saleD) / priceD);
    	}
    	else
    	{
    		gpu.setSale(false);
    		gpu.setSalePercentage(0.0);
    	}

    	gpu.setPrice(priceD);
    	
    	return gpu;
    }
    
    public static RamPart getRam(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).timeout(50000).get();
        
        String html = document.toString();
        
        String brand= new String();
        String model = new String();
        String series = new String();
        String capacity = new String();
        String type = new String();
        String multichannelType = new String();
        
        int startSub = 0;
        int endSub = 0;
        
        Elements scriptElements = document.getElementsByTag("script");
        
        String price = new String();
        String salePrice = new String();
        
       //Element element = scriptElements.get(98);
        for (Element element :scriptElements ){ 
       		for (DataNode node : element.dataNodes()) {
               //System.out.println(node.getWholeData());
    	   		String priceHtml = node.getWholeData();
    	   		for(int i = 0; i < priceHtml.length() - 100; i++)
    	   		{
	    	   		if(priceHtml.substring(i, i + 18).equals("product_unit_price"))
	    	   		{
	    	   			for(int k = i; k < i + 50; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						price = priceHtml.substring(startSub , endSub);
					}
	    	   		
	    	   		if(priceHtml.substring(i, i + 18).equals("product_sale_price"))
	    	   		{
	    	   			for(int k = i; k < i + 200; k++)
						{
							if(priceHtml.substring(k, k + 2).equals("['"))
							{
								startSub = k + 2;
							}
							if(priceHtml.substring(k, k + 2).equals("']"))
							{
								endSub = k;
								break;
							}
						}
						salePrice = priceHtml.substring(startSub , endSub);
					}
    	   		}
               //System.out.println("-------------------");            
           	}
        }
        
        //Find where the specs are and retrieve
        for(int i = 0; i < html.length() - 6; i++)
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
        				if(html.substring(j, j + 5).equals("Brand") && brand.equals(""))
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
        				
        				if(html.substring(j, j + 8).equals("Capacity"))
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
        					capacity = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 4).equals("Type"))
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
        					type = html.substring(startSub , endSub);
        				}
        				
        				if(html.substring(j, j + 17).equals("Multi-channel Kit"))
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
        					multichannelType = html.substring(startSub , endSub);
        				}
        				
        			}
        			break;
        		}
        	}
        	
        }

        //return the CPUPART
    	RamPart ram = new RamPart(brand, series, model, capacity, type, multichannelType);
    	
    	double priceD = Double.parseDouble(price);
    	double saleD = Double.parseDouble(salePrice);
    	//double priceD = Double.parseDouble(price);
    	
    	if(saleD != priceD)
    	{
    		ram.setSale(true);
    		ram.setSalePercentage((priceD - saleD) / priceD);
    	}
    	else
    	{
    		ram.setSale(false);
    		ram.setSalePercentage(0.0);
    	}

    	ram.setPrice(priceD);
    	
    	return ram;
    }

}

