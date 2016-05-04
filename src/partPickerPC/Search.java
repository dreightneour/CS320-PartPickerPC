
package partPickerPC;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import Parts.CpuPart;
import Parts.GpuPart;
import Parts.MotherboardPart;
import Parts.RamPart;

public class Search{

	private static ArrayList<CpuPart> cpuList = new ArrayList<CpuPart>();
	private static ArrayList<MotherboardPart> motherList = new ArrayList<MotherboardPart>();
	private static ArrayList<GpuPart> gpuList = new ArrayList<GpuPart>();
	private static ArrayList<RamPart> ramList = new ArrayList<RamPart>();
	
	public static void getThisTestThing() throws Exception
	{
		setCpuList(getArrayCpu("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007671%208000%204814&IsNodeId=1&page=1&bop=And&Pagesize=90"));
		setGpuList(getArrayGpu("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007709+8000+4814&IsNodeId=1&bop=And&ActiveSearchResult=True&Page=1"));
		setMotherList(getArrayMotherboard("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007625%204814&IsNodeId=1&bop=And&Pagesize=30&Page=1"));
    	ArrayList<MotherboardPart> mother2 = getArrayMotherboard("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007627%204814%208000&IsNodeId=1&bop=And&page=1");
    	for(int i = 0; i < mother2.size(); i++)
    	{
    		motherList.add(mother2.get(i));
    	}
		setRamList(getArrayRam("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007611%208000%204814&IsNodeId=1&bop=And&ActiveSearchResult=True&Pagesize=90&Page=1"));
		
	}

    public static void main(String[] args) throws Exception {
    	// String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        //Document document = Jsoup.connect(url).get();
    	
    	getThisTestThing();
    	//setCpuList(getArrayCpu("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007671%208000%204814&IsNodeId=1&page=1&bop=And&Pagesize=90"));
    	//motherList = getArrayMotherboard("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007625%204814&IsNodeId=1&bop=And&Pagesize=30&Page=1");
    	//ArrayList<MotherboardPart> mother2 = getArrayMotherboard("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007627%204814%208000&IsNodeId=1&bop=And&page=1");
    	//for(int i = 0; i < mother2.size(); i++)
    	//{
    	//	motherList.add(mother2.get(i));
    	//}
    	//gpuList = getArrayGpu("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007709+8000+4814&IsNodeId=1&bop=And&ActiveSearchResult=True&Page=1");    	
    	//ramList = getArrayRam("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&N=100007611%208000%204814&IsNodeId=1&bop=And&ActiveSearchResult=True&Pagesize=90&Page=1");
    	//int b = 0;
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
	        
	        //String html = document.toString();
	    	
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
        Document document = Jsoup.connect(url).timeout(500000).get();
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
        		String id;
        		if(i > 5)
        		{
        			id = html.substring(i - 4, i-2);
        		}
        		else
        		{
        			id = "id";
        		}
        		
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
    	
    	double priceD = Double.parseDouble(price);
    	double saleD = Double.parseDouble(salePrice);
    	//double priceD = Double.parseDouble(price);
    	/*
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
    	*/
    	
    	CpuPart cpu = new CpuPart(socketType, name, brand, series, frequency, cores, url, priceD, saleD);
    	return cpu;
    }
    
    public static ArrayList<MotherboardPart> getArrayMotherboard(String url) throws IOException
    {
     	boolean next = true;
    	ArrayList<MotherboardPart> motherList = new ArrayList<MotherboardPart>();
    	while(next == true)
    	{
    		next = false;
	        Document document = Jsoup.connect(url).timeout(50000).get();
	        
	        //String html = document.toString();
	    	
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
						motherList.add(getMotherboard(urlList));
						//found = true;
					}
					
	               //System.out.println("-------------------");            
	           	}
	    	   	
	        }
	        
	        scriptElements = document.getElementsByTag("script");
	        
	        urlList = new String();
	        String page = new String();
	        String endPage = new String();
        	for (Element element :scriptElements ){ 
           		for (DataNode node : element.dataNodes()) {
                   //System.out.println(node.getWholeData());
        	   		String priceHtml = node.getWholeData();
        	   		for(int i = 0; i < priceHtml.length() - 20; i++)
        	   		{
    	    	   		if(priceHtml.substring(i, i + 8).equals("pageIdex"))
    	    	   		{
    	    	   			for(int k = i; k < i + 50; k++)
    						{
    							if(priceHtml.substring(k, k + 1).equals(":"))
    							{
    								startSub = k + 1;
    							}
    							if(priceHtml.substring(k, k + 1).equals(","))
    							{
    								endSub = k;
    								break;
    							}
    						}
    						page = priceHtml.substring(startSub , endSub);
    					}
    	    	   		
    	    	   		if(priceHtml.substring(i, i + 9).equals("pageCount") && endPage.equals(""))
    	    	   		{
    	    	   			for(int k = i; k < priceHtml.length() - 2; k++)
    						{
    	    	   				endSub = priceHtml.length();
    							if(priceHtml.substring(k, k + 1).equals(":"))
    							{
    								startSub = k + 1;
    							}
    							if(priceHtml.substring(k, k + 1).equals(","))
    							{
    								endSub = k;
    								break;
    							}
    						}
    						endPage = priceHtml.substring(startSub , endSub);
    					}
    	    	   		if(!endPage.equals(page) && !endPage.equals("") && !page.equals("") && Integer.valueOf(page) <= 2)
    	    	   		{
    	    	   			next = true;
    	    	   			break;
    	    	   		}
    	    	   		
        	   		}
                   //System.out.println("-------------------");            
               	}
		   		if(next == true)
		   		{
		   			int pageNum = Integer.parseInt(url.substring(url.length() - 1, url.length()));
		   			pageNum++;
		   			String pageNumS = Integer.toString(pageNum);
		   			url = url.substring(0, url.length() - 1) + pageNumS;
		   			break;
		   		}
	    	   	
	        }
	        
	        
    	}
    	//cpuList = cpuList;
    	return motherList;
    }
    
    public static MotherboardPart getMotherboard(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).timeout(500000).get();
        
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
        		String id;
        		if(i > 4)
        		{
        			id = html.substring(i - 4, i-2);
        		}
        		else
        		{
        			id = "id";
        		}
        		
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
        				
        				if(html.substring(j, j + 5).equals("Model") && model.equals(""))
        				{
        					for(int k = j; k < j + 300; k++)
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
        					if(model.length() > 150)
        					{
        						int b = 0;
        					}
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
        
    	double priceD = 0.0;
    	double saleD = 0.0;
    	
    	if(!price.equals("MAP"))
    	{
    		priceD = Double.parseDouble(price);
    		saleD = Double.parseDouble(salePrice);
    	}
    	//double priceD = Double.parseDouble(price);
    	/*
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
    	*/
    	MotherboardPart mother = new MotherboardPart(brand, model, socketType, url, priceD, saleD);
        //return the CPUPART
    	return mother;
    }
    
    public static ArrayList<GpuPart> getArrayGpu(String url) throws IOException
    {
    	int pageSpots = 1;
     	boolean next = true;
    	ArrayList<GpuPart> gpuList = new ArrayList<GpuPart>();
    	while(next == true)
    	{
    		next = false;
	        Document document = Jsoup.connect(url).timeout(50000).get();
	        
	        //String html = document.toString();
	    	
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
						gpuList.add(getGpu(urlList));
						//found = true;
					}
					
	               //System.out.println("-------------------");            
	           	}
	    	   	
	        }
	        
	        scriptElements = document.getElementsByTag("script");
	        
	        urlList = new String();
	        String page = new String();
	        String endPage = new String();
        	for (Element element :scriptElements ){ 
           		for (DataNode node : element.dataNodes()) {
                   //System.out.println(node.getWholeData());
        	   		String priceHtml = node.getWholeData();
        	   		for(int i = 0; i < priceHtml.length() - 20; i++)
        	   		{
    	    	   		if(priceHtml.substring(i, i + 8).equals("pageIdex"))
    	    	   		{
    	    	   			for(int k = i; k < i + 50; k++)
    						{
    							if(priceHtml.substring(k, k + 1).equals(":"))
    							{
    								startSub = k + 1;
    							}
    							if(priceHtml.substring(k, k + 1).equals(","))
    							{
    								endSub = k;
    								break;
    							}
    						}
    						page = priceHtml.substring(startSub , endSub);
    					}
    	    	   		
    	    	   		if(priceHtml.substring(i, i + 9).equals("pageCount") && endPage.equals(""))
    	    	   		{
    	    	   			for(int k = i; k < priceHtml.length() - 2; k++)
    						{
    	    	   				endSub = priceHtml.length();
    							if(priceHtml.substring(k, k + 1).equals(":"))
    							{
    								startSub = k + 1;
    							}
    							if(priceHtml.substring(k, k + 1).equals(","))
    							{
    								endSub = k;
    								break;
    							}
    						}
    						endPage = priceHtml.substring(startSub , endSub);
    					}
    	    	   		if(!endPage.equals(page) && !endPage.equals("") && !page.equals("")&& Integer.valueOf(page) <= 2)
    	    	   		{
    	    	   			next = true;
    	    	   			break;
    	    	   		}
    	    	   		
        	   		}
                   //System.out.println("-------------------");            
               	}
           		int pageNum = 0;
		   		if(next == true)
		   		{
		   			pageNum = Integer.parseInt(url.substring(url.length() - pageSpots, url.length()));
		   			pageNum++;
		   			String pageNumS = Integer.toString(pageNum);
		   			url = url.substring(0, url.length() - 1) + pageNumS;
		   			break;
		   		}
		   		if(pageNum % Math.pow(10.0, pageSpots) == 0 && pageNum > 0)
		   		{
		   			pageSpots++;
		   		}
	    	   	
	        }
	        
	        
    	}
    	//cpuList = cpuList;
    	return gpuList;
    }
   
    
    public static GpuPart getGpu(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).timeout(500000).get();
        
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
        		String id;
        		if(i > 4)
        		{
        			id = html.substring(i - 4, i-2);
        		}
        		else
        		{
        			id = "id";
        		}
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
        				
        				if(html.substring(j, j + 5).equals("Model") && !brand.equals("") && model.equals(""))
        				{
        					for(int k = j; k < j + 300; k++)
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
        					if(startSub > endSub)
        					{
        						int b = 0;
        					}
        					model = html.substring(startSub , endSub);
        					if(model.length() > 150)
        					{
        						int b = 0;
        					}
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
        				
        				if(html.substring(j, j + 4).equals(">GPU"))
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

        double priceD = 0.0;
        double saleD = 0.0;
        //return the CPUPART
    	if(!price.equals("MAP"))
    	{
    		priceD = Double.parseDouble(price);
    		saleD = Double.parseDouble(salePrice);
    	}

    	//double priceD = Double.parseDouble(price);
    	
    	/*if(saleD != priceD)
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
    	*/
    	GpuPart gpu = new GpuPart(brand, model, slotType, gpuBase, memorySize, url, priceD, saleD);
    	return gpu;
    }
    
    public static ArrayList<RamPart> getArrayRam(String url) throws IOException
    {
     	boolean next = true;
    	ArrayList<RamPart> ramList = new ArrayList<RamPart>();
    	while(next == true)
    	{
    		next = false;
	        Document document = Jsoup.connect(url).timeout(500000).get();
	        
	        //String html = document.toString();
	    	
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
						ramList.add(getRam(urlList));
						//found = true;
					}
					
	               //System.out.println("-------------------");            
	           	}
	    	   	
	        }
	        
	        scriptElements = document.getElementsByTag("script");
	        
	        urlList = new String();
	        String page = new String();
	        String endPage = new String();
        	for (Element element :scriptElements ){ 
           		for (DataNode node : element.dataNodes()) {
                   //System.out.println(node.getWholeData());
        	   		String priceHtml = node.getWholeData();
        	   		for(int i = 0; i < priceHtml.length() - 20; i++)
        	   		{
    	    	   		if(priceHtml.substring(i, i + 8).equals("pageIdex"))
    	    	   		{
    	    	   			for(int k = i; k < i + 50; k++)
    						{
    							if(priceHtml.substring(k, k + 1).equals(":"))
    							{
    								startSub = k + 1;
    							}
    							if(priceHtml.substring(k, k + 1).equals(","))
    							{
    								endSub = k;
    								break;
    							}
    						}
    						page = priceHtml.substring(startSub , endSub);
    					}
    	    	   		
    	    	   		if(priceHtml.substring(i, i + 9).equals("pageCount") && endPage.equals(""))
    	    	   		{
    	    	   			for(int k = i; k < priceHtml.length() - 2; k++)
    						{
    	    	   				endSub = priceHtml.length();
    							if(priceHtml.substring(k, k + 1).equals(":"))
    							{
    								startSub = k + 1;
    							}
    							if(priceHtml.substring(k, k + 1).equals(","))
    							{
    								endSub = k;
    								break;
    							}
    						}
    						endPage = priceHtml.substring(startSub , endSub);
    					}
    	    	   		if(!endPage.equals(page) && !endPage.equals("") && !page.equals("") && Integer.valueOf(page) <= 2)
    	    	   		{
    	    	   			next = true;
    	    	   			break;
    	    	   		}
    	    	   		
        	   		}
                   //System.out.println("-------------------");            
               	}
		   		if(next == true)
		   		{
		   			int pageNum = Integer.parseInt(url.substring(url.length() - 1, url.length()));
		   			pageNum++;
		   			String pageNumS = Integer.toString(pageNum);
		   			url = url.substring(0, url.length() - 1) + pageNumS;
		   			break;
		   		}
	    	   	
	        }
	        
	        
    	}
    	//cpuList = cpuList;
    	return ramList;
    }
   
    
    public static RamPart getRam(String url) throws IOException
    {
    	//open the webpage
        //String url = "http://www.newegg.com/Product/Product.aspx?Item=N82E16819117369";
        Document document = Jsoup.connect(url).timeout(500000).get();
        
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
        		String id;
        		if(i > 4)
        		{
        			id = html.substring(i - 4, i-2);
        		}
        		else
        		{
        			id = "id";
        		}
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
        					for(int k = j; k < j + 300; k++)
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
        					if(model.length() > 150)
        					{
        						int b = 0;
        					}
        				}
        				
        				if(html.substring(j, j + 6).equals("Series") && series.equals(""))
        				{
        					if(html.substring(j-7, j).contains("<dd>"))
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
        				}
        				
        				if(html.substring(j, j + 8).equals("Capacity") && capacity.equals(""))
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
        				
        				if(html.substring(j, j + 4).equals("Type") && type.equals(""))
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
    	
    	
    	//double priceD = Double.parseDouble(price);
    	//double saleD = Double.parseDouble(salePrice);
    	//double priceD = Double.parseDouble(price);
    	/*
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
    	*/
        double priceD = 0.0;
        double saleD = 0.0;
        //return the CPUPART
    	if(!price.equals("MAP"))
    	{
    		priceD = Double.parseDouble(price);
    		saleD = Double.parseDouble(salePrice);
    	}
    	
    	if(brand.contains("</dd>") || brand.contains("\n") || series.contains("\n") || series.contains("</dd>") || model.contains("\n") || model.contains("</dd>") || capacity.contains("\n") || capacity.contains("</dd>") 
    			|| type.contains("\n") || type.contains("</dd>") || multichannelType.contains("</dd>") || multichannelType.contains("</dd>"))
    	{
    		//int b = 0;
            brand= new String();
            model = new String();
            series = new String();
            capacity = new String();
            type = new String();
            multichannelType = new String();
    	}
    	
    	RamPart ram = new RamPart(brand, series, model, capacity, type, multichannelType, url, priceD, saleD);
    	return ram;
    }
    
    
    public double getPrice(String url) throws IOException
    {
        Document document = Jsoup.connect(url).timeout(500000).get();
        String html = document.toString();
        
        Elements scriptElements = document.getElementsByTag("script");
        
        String price = new String();
        int startSub = 0;
        int endSub = 0;
        
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
	    	   		
    	   		}
               //System.out.println("-------------------");            
           	}
        }
        
    	
    	 double priceD = 0.0;
         double saleD = 0.0;
         //return the CPUPART
     	if(!price.equals("MAP"))
     	{
     		priceD = Double.parseDouble(price);
     	}
     	
    	return priceD;
    }
	public static ArrayList<CpuPart> getCpuList() {
		return cpuList;
	}
	public static void setCpuList(ArrayList<CpuPart> cpuList) {
		Search.cpuList = cpuList;
	}
	public static ArrayList<MotherboardPart> getMotherList() {
		return motherList;
	}
	public static void setMotherList(ArrayList<MotherboardPart> motherList) {
		Search.motherList = motherList;
	}
	public static ArrayList<GpuPart> getGpuList() {
		return gpuList;
	}
	public static void setGpuList(ArrayList<GpuPart> gpuList) {
		Search.gpuList = gpuList;
	}
	public static ArrayList<RamPart> getRamList() {
		return ramList;
	}
	public static void setRamList(ArrayList<RamPart> ramList) {
		Search.ramList = ramList;
	}

}

