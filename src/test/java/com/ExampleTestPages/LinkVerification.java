package com.ExampleTestPages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class LinkVerification extends BaseClass
{
	@Test(groups={"regression", "sanity"})
	public void verifyAmazonWebpageLinks() throws IOException
	{
		launchBrowser("edge");
		driver.navigate().to("https://www.amazon.in");
		List<WebElement> element = driver.findElements(By.tagName("a")); 
		for( WebElement e : element )
		{
			String link = e.getAttribute("href");
			if( link!=null && link.startsWith("http") )
			{
//				System.out.println(link);									//Prints links which are !Null & startsWith "http"
				URL url = new URL(link);										//Conversion of String link to actual URL
				URLConnection urlconn = url.openConnection();					//Open connection to connect to URL
				HttpsURLConnection connection = (HttpsURLConnection)urlconn;	
				connection.connect();											//connect with the Http
				int statusCode = connection.getResponseCode();
				if(statusCode!=200)
				{
					System.out.println(statusCode+" : Link - "+link);		//Prints links and their respective status code
				}
				connection.disconnect();
			}
		}
	}
}