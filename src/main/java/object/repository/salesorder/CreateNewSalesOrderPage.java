package object.repository.salesorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewSalesOrderPage extends WebDriverUtility {

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

	@FindBy(xpath = "//b[normalize-space()='Total After Discount :']")
	private WebElement Total;

	public CreateNewSalesOrderPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewSalesOrder(WebDriver d, String SUBJECT, String STATUS, String ORGNAME, String INSTATUS,
			String BillingAddress, String ShippingAddress, String PRODUCT) {
		SubjectTextField.sendKeys(SUBJECT);
		handleDropDown(StatusDropDownList, STATUS);

		OrgNameLookUpImg.click();
		switchToWindow(d, "Accounts");
		SearchTextField.sendKeys(ORGNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + ORGNAME + "']")).click();
		acceptAlert(d);
		switchToWindow(d, "Sales");

		handleDropDown(InvoiceStatusDropDownList, INSTATUS);
		BillingAddressTextField.sendKeys(BillingAddress);
		ShippingAddressTextField.sendKeys(ShippingAddress);

		ProductLookUpImg.click();
		switchToWindow(d, "Products");
		SearchTextField.sendKeys(PRODUCT);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + PRODUCT + "']")).click();
		acceptAlert(d);
		switchToWindow(d, "Sales");

//		d.findElement(By.id("qty1")).sendKeys(QTY);

//		moveByOffset(d, Total, 820, 173);
		
//		Total.click();

		SaveBtn.click();
	}

}
