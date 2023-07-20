package object.repository.salesorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {

	@FindBy(xpath = "//img[@title='Create Sales Order...']")
	private WebElement SalesOrderLookUpImg;

	public SalesOrderPage(WebDriver d) {
		PageFactory.initElements(d, this);		
	}

	public WebElement getSalesOrderLookUpImg() {
		return SalesOrderLookUpImg;
	}
	
	public void clickOnSalesOrderLookUpImg() {
		SalesOrderLookUpImg.click();
	}
}
