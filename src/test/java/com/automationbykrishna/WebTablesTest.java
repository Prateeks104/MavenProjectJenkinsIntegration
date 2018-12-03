package com.automationbykrishna;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class WebTablesTest {

	@Test
	public static void Example() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Prateek/Downloads/chromedriver.exe");
		
		System.out.println();
		
		LinkedHashSet<String> hs=new LinkedHashSet<String>();
	
		HashMap<String, Integer> hMapOfEmp=new HashMap<String, Integer>();
		
		// HashSet<String> hs=new HashSet<String>();
		
		WebDriver d=new ChromeDriver();
		d.manage().deleteAllCookies();
		
		d.get("http://automationbykrishna.com/");
		
		d.findElement(By.linkText("Demo Tables")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> ListOfRows=d.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("The rows present in the current table are : "+ListOfRows.size());
		
		String[] DeptName=new String[ListOfRows.size()+1];
		
		for(int i=1;i<=ListOfRows.size();i++){
	
		DeptName[i]=d.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[5]")).getText();
		System.out.println(DeptName[i]);
		hs.add(DeptName[i]);
		
		//Below is also possible
		//hs.add(d.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[5]")).getText());
		
		//For hashSet this Code goes well too Button insertion order is not preserved
	
		}		
		System.out.println(hs);
		
		String[] DeptValues=new String[hs.size()];
		int index=0;		
		
		Iterator itr=hs.iterator();
			
		while(itr.hasNext()) {
			DeptValues[index]=(String)itr.next();
			
			hMapOfEmp.put(DeptValues[index], 0);
			
			index++;
		}
	
		/*String[] admin=new String[ListOfRows.size()/2];
		String[] finance=new String[ListOfRows.size()/2];
		String[] hr=new String[ListOfRows.size()/2];
		String[] IT=new String[ListOfRows.size()/2];*/
		
		int NoOfDept = hs.size();
		
		
		for(int x=0;x<NoOfDept;x++) {
			
			for(int y=1;y<=ListOfRows.size();y++) {
				
				String val=d.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+y+"]/td[5]")).getText();
				
				if(val.equals(DeptValues[x])) {
					
					hMapOfEmp.put(DeptValues[x], hMapOfEmp.get(DeptValues[x]) + 1);
				}
			}
		}
		
		System.out.println(hMapOfEmp);
		
		d.close();	
		
		}

		
}
