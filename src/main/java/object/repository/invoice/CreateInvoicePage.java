package object.repository.invoice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateInvoicePage extends WebDriverUtility {

	@FindBy(name = "subject")
	private WebElement SubjectTextField;

	@FindBy(xpath = "(//img[@title='Select'])[3]")
	private WebElement OrganizationNameLookUpImg;

	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement BillingAddressTextField;

	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement ShippingAddressTextField;

	@FindBy(xpath = "//img[@id='searchIcon1']")
	private WebElement ProductLookUpImg;

	@FindBy(xpath = "//input[@id='qty1']")
	private WebElement QualityTextField;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateInvoicePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewInvoice(WebDriver d, String SUBJECT, String ORG, String BillingAddress, String ShippingAddress,
			String PRODUCT, String QTY) {
		SubjectTextField.sendKeys(SUBJECT);
		OrganizationNameLookUpImg.click();
		switchToWindow(d, "Accounts");
		SearchTextField.sendKeys(ORG);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + ORG + "']")).click();
		acceptAlert(d);
		switchToWindow(d, "Invoice");
		BillingAddressTextField.sendKeys(BillingAddress);
		ShippingAddressTextField.sendKeys(ShippingAddress);
		switchToWindow(d, "Products");
		SearchTextField.sendKeys(PRODUCT);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + PRODUCT + "']")).click();
		acceptAlert(d);
		switchToWindow(d, "Invoice");
		QualityTextField.sendKeys(QTY);
		SaveBtn.click();
	}

}
