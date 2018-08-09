package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Util;

public class AmazonSearchResults {
	WebDriver driver;
	
	@FindBy(name="s-ref-checkbox-8080061011")
	WebElement plasticchkbox;
	//@FindBy(id="s-results-list-atf")
	@FindBy(xpath="//*[@id=\'atfResults\']")
	WebElement resultstable;
	
	public AmazonSearchResults(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void refine_search_by_material(String material) {
		switch(material) {
		case "plastic":
			plasticchkbox.click();
		}
	}
	
	public void output_items_name() {
		//Util util=new Util(driver);
		//util.wait_object(resultstable, 5);
		
		//List<WebElement> resultslinks=resultstable.findElements(By.tagName("li"));
		//int i=1;
		//System.out.println(resultslinks.size());
		/*for(WebElement r:resultslinks) {
			if(i==5) {
				break;
			}*/
		for(int i=0;i<5;i++) {
			WebElement item_name=driver.findElement(By.xpath("//li[@id='result_"+i+"']//h2"));
			WebElement item_price=driver.findElement(By.xpath("//li[@id='result_"+i+"']//a/span[@class='a-offscreen']"));
			WebElement item_score=driver.findElement(By.xpath("//li[@id='result_"+i+"']//a/i/span[@class='a-icon-alt']"));
			System.out.println(item_name.getText());
			System.out.println(item_price.getText());
			System.out.println(item_score.getText());
			//i++;
		}
		/*
		for(int j=0;j<resultslinks.size();j++) {
			System.out.println(resultslinks.get(j).getText());
			System.out.println("_______________________");
		}*/
	}

}
