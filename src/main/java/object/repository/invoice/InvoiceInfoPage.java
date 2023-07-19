package object.repository.invoice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement InvoiceHeaderText;

	public InvoiceInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getInvoiceHeaderText() {
		return InvoiceHeaderText;
	}

	public String getInvoiceHeaderInfo() {
		return InvoiceHeaderText.getText();
	}

}
