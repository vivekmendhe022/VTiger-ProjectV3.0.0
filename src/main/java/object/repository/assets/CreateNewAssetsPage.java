package object.repository.assets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewAssetsPage extends WebDriverUtility {

	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement ProductLookUpIcon;

	@FindBy(name = "serialnumber")
	private WebElement SerialNumberTextField;

	@FindBy(xpath = "(//img[@title='Select'])[3]")
	private WebElement CustomerLookUpIcon;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(name = "assetname")
	private WebElement AssetNameTextField;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	public CreateNewAssetsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	/**
	 * This method will create new asset with Product &
	 * 
	 * @param d
	 * @param PRODUCT
	 * @param SRNUM
	 * @param ASSETNAME
	 */
	public void createNewAsset(WebDriver d, String PRODUCT, String SRNUM, String ACCOUNT, String ASSETNAME) {
		ProductLookUpIcon.click();
		switchToWindow(d, "Products");
		SearchTextField.sendKeys(PRODUCT);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + PRODUCT + "']")).click();
		switchToWindow(d, "Assets");
		SerialNumberTextField.sendKeys(SRNUM);
		CustomerLookUpIcon.click();
		switchToWindow(d, "Accounts");
		SearchTextField.sendKeys(ACCOUNT);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + ACCOUNT + "']")).click();
		switchToWindow(d, "Assets");
		AssetNameTextField.sendKeys(ASSETNAME);
		SaveBtn.click();
	}

}
