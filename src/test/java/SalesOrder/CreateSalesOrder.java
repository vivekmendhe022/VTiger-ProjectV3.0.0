package SalesOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.salesorder.SalesOrderPage;

public class CreateSalesOrder extends BaseClass {

	@FindBy(name = "subject")
	private WebElement SubjectTextField;

	@FindBy(name = "sostatus")
	private WebElement StatusDropDownList;

	@FindBy(xpath = "(//img[@title='Select'])[4]")
	private WebElement OrgNameLookUpImg;

	@FindBy(name = "invoicestatus")
	private WebElement InvoiceStatusDropDownList;

	@FindBy(name = "bill_street")
	private WebElement BillingAddressTextField;

	@FindBy(name = "ship_street")
	private WebElement ShippingAddressTextField;

	@FindBy(id = "searchIcon1")
	private WebElement ProductLookUpImg;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	@Test
	public void createSalesOrderTest() throws InterruptedException {

		String SUBJECT = "Hp Laptop";
		String STATUS = "Approved";
		String ORGNAME = "395Microsoft";
		String INSTATUS = "Created";
		String BillingAddress = "White Street";
		String ShippingAddress = "White Street";
		String PRODUCT = "Gandhi394";
		String QTY = "12";

		HomePage hp = new HomePage(d);
		hp.clickOnSalesOrderLinkText(d);

		SalesOrderPage sop = new SalesOrderPage(d);
		sop.clickOnSalesOrderLookUpImg();

		d.findElement(By.name("subject")).sendKeys(SUBJECT);
		d.findElement(By.name("sostatus")).sendKeys(STATUS);
		d.findElement(By.xpath("(//img[@title='Select'])[4]")).click();
		
		wutil.switchToWindow(d, "Accounts");
		d.findElement(By.name("search_text")).sendKeys(ORGNAME);
		d.findElement(By.name("search")).click();
		d.findElement(By.xpath("//a[normalize-space()='" + ORGNAME + "']")).click();
		wutil.acceptAlert(d);
		
		Thread.sleep(2000);
		wutil.switchToWindow(d, "Sales");
		Thread.sleep(2000);
		
		d.findElement(By.name("invoicestatus")).sendKeys(INSTATUS);
		

	}

}
