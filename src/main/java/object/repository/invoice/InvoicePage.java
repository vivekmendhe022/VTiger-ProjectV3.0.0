package object.repository.invoice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {

	@FindBy(xpath = "//img[@title='Create Invoice...']")
	private WebElement CreateInvoiceLookUpIcon;

	public InvoicePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnCreateInvoiceLookUpIcon() {
		CreateInvoiceLookUpIcon.click();
	}
}
