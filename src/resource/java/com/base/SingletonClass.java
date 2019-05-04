package com.base;

import org.openqa.selenium.WebDriver;

import com.adactin.HomePage;
import com.adactin.SearchPage;

public class SingletonClass {
	public static WebDriver driver;
	public SingletonClass(WebDriver idriver) {
		this.driver=idriver;
	}
	private HomePage hp=null;
	private SearchPage sp=null;
	
	public HomePage getHomePage() {
		if(hp==null) {
			hp=new HomePage(driver);
			
		}
		return hp;
		}
		public SearchPage getSearchPage() {
			if(sp==null) {
				sp=new SearchPage(driver);
				}
			return sp;
		}
	}
	
	


