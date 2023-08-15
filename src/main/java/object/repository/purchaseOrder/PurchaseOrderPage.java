package object.repository.purchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {

	@FindBy(xpath = "//img[@title='Create Purchase Order...'")
	private WebElement CreateNewPurchaseOrderLookUpImg;

	public PurchaseOrderPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnCreateNewPurchaseOrderLookUpImg() {
		CreateNewPurchaseOrderLookUpImg.click();
	}
}
