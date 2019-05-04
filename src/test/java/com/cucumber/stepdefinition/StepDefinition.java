package com.cucumber.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.base.SingletonClass;
import com.cucumber.testrunner.TestRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass{
	public static WebDriver driver=TestRunner.driver;
	public static SingletonClass s=new SingletonClass(driver);
	@Given("^user should be in adactin homepage$")
	public void user_should_be_in_adactin_homepage() throws Throwable {
		getUrl("https://www.adactin.com/HotelApp/");
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user enter the username in the username field$")
	public void user_enter_the_username_in_the_username_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		inputValuestoWebPage(s.getHomePage().getUsername(),"admingreens");
	   
	}

	@When("^user enter the password in the password field$")
	public void user_enter_the_password_in_the_password_field() throws Throwable {
		inputValuestoWebPage(s.getHomePage().getPassword(),"Secret@123");
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@When("^user clicks the login button$")
	public void user_clicks_the_login_button() throws Throwable {
		elementClick(s.getHomePage().getLogin());
	    // Write code here that turns the phrase above into concrete actions
	  
	}





@When("^user select the location from dropdown$")
public void user_select_the_location_from_dropdown() throws Throwable {
	selectValuesFromDD(s.getSearchPage().getLocation(),"selectByValue","Sydney");
    // Write code here that turns the phrase above into concrete actions
    
}

	


@When("^user select the hotels from the dropdown$")
public void user_select_the_hotels_from_the_dropdown() throws Throwable {
	selectValuesFromDD(s.getSearchPage().getHotels(),"selectByIndex","0");
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^user select the roomtype from the dropdown$")
public void user_select_the_roomtype_from_the_dropdown() throws Throwable {
	selectValuesFromDD(s.getSearchPage().getRoom_type(),"selectByVisibleText","standard");
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^user select the number of rooms from the dropdown$")
public void user_select_the_number_of_rooms_from_the_dropdown() throws Throwable {
	selectValuesFromDD(s.getSearchPage().getRoom_nos(),"select by value","1");
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^user enter the checkin the check in field$")
public void user_enter_the_checkin_the_check_in_field() throws Throwable {
	inputValuestoWebPage(s.getSearchPage().getDatepic_in(),"03-05-2019");
    // Write code here that turns the phrase above into concrete actions
    
}

	


@When("^user enter the checkout date in the checkout field$")
public void user_enter_the_checkout_date_in_the_checkout_field() throws Throwable {
	inputValuestoWebPage(s.getSearchPage().getDatepick_out(),"04-05-2019 ");
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^user select the no of adults per room from the dropdown$")
public void user_select_the_no_of_adults_per_room_from_the_dropdown() throws Throwable {
	selectValuesFromDD(s.getSearchPage().getAdult_room(),"SelectByValue","1");
	
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^user select the no of children per room from the drop down$")
public void user_select_the_no_of_children_per_room_from_the_drop_down() throws Throwable {
	selectValuesFromDD(s.getSearchPage().getChild_room(),"SelectByValue","1");
    // Write code here that turns the phrase above into concrete actions
    
}


	


@When("^user click on the search button$")
public void user_click_on_the_search_button() throws Throwable {
	elementClick(s.getSearchPage().getSearch());
    // Write code here that turns the phrase above into concrete actions
   
}

}
