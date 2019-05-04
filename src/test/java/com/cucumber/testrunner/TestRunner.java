package com.cucumber.testrunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\java\\com\\cucumber\\feature"},glue="com.cucumber.stepdefinition")

public class TestRunner {
	public static WebDriver driver;
@BeforeClass
public static void setup() throws Exception {
	driver=BaseClass.getBrowserLaunch("chrome");
}
	

}
