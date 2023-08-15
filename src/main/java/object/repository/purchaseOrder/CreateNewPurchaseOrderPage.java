package object.repository.purchaseOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewPurchaseOrderPage extends WebDriverUtility {

	@FindBy(name = "subject")
	private WebElement SubjectTextField;

	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement VendorNameLookUpImg;

	@FindBy(name = "postatus")
	private WebElement StatusDropDownList;

	@FindBy(name = "bill_street")
	private WebElement BillingAddressTextarea;

	@FindBy(name = "ship_street")
	private WebElement ShippingAddressTextarea;

	@FindBy(id = "searchIcon1")
	private WebElement ProductLookUpImg;

	@FindBy(id = "qty1")
	private WebElement QTYTextField;

	@FindBy(id = "listPrice1")
	private WebElement ListPriceTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	public CreateNewPurchaseOrderPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewPurchaseOrderLookUpImg(WebDriver d, String SUBJECT, String VENDORNAME, String STATUS,
			String BILLINGADDRESS, String SHIPPINGADDRESS, String PRODUCT, String QTY, String LISTPRICE) {
		SubjectTextField.sendKeys(SUBJECT);

		VendorNameLookUpImg.click();
		switchToWindow(d, "Vendors");
		SearchTextField.sendKeys(VENDORNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + VENDORNAME + "']")).click();
		acceptAlert(d);
		switchToWindow(d, "PurchaseOrder");

		handleDropDown(StatusDropDownList, STATUS);
		BillingAddressTextarea.sendKeys(BILLINGADDRESS);
		ShippingAddressTextarea.sendKeys(SHIPPINGADDRESS);

		ProductLookUpImg.click();
		switchToWindow(d, "Products");
		SearchTextField.sendKeys(PRODUCT);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + PRODUCT + "']")).click();
		acceptAlert(d);
		switchToWindow(d, "PurchaseOrder");

		QTYTextField.sendKeys(QTY);
		ListPriceTextField.clear();
		ListPriceTextField.sendKeys(LISTPRICE);

		SaveBtn.click();
	}

}
