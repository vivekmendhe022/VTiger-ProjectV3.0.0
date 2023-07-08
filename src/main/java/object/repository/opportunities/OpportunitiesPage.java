package object.repository.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class OpportunitiesPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement CreateOpportunitiesLookUpIcon;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement SearchTextField;

	@FindBy(xpath = "//select[@id='bas_searchfield']")
	private WebElement SearchFieldDropDownList;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement SearchBtn;

	@FindBy(xpath = "//a[normalize-space()='edit']")
	private WebElement EditLinkText;

	@FindBy(xpath = "//a[normalize-space()='Go to Advanced Search']")
	private WebElement AdvanceSearchLinkText;

	@FindBy(id = "fcol0")
	private WebElement AdvanceSearchDropDownList;

	@FindBy(id = "fop0")
	private WebElement AdvanceOperatorDropDownList;

	@FindBy(id = "fval0")
	private WebElement AdvanceSearchTextField;

	@FindBy(xpath = "(//input[@value=' Search Now '])[2]")
	private WebElement SearchNowBtn;

	public OpportunitiesPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateOpportunitiesLookUpIcon() {
		return CreateOpportunitiesLookUpIcon;
	}

	public void clickOnCreateOpportunitiesLookUpIcon() {
		CreateOpportunitiesLookUpIcon.click();
	}

	public void clickOnEditTextLink(WebDriver d, String OPPNAME, String OPPNAMEFIELD) {
		SearchTextField.sendKeys(OPPNAME);
		handleDropDown(SearchFieldDropDownList, OPPNAMEFIELD);
		SearchBtn.click();
		waitForElementClickable(d, EditLinkText);
		EditLinkText.click();
	}

	public void verifyCampaingsAddedToOpportunity(WebDriver d, String CSOURCE, String CAMPNAME) {
		AdvanceSearchLinkText.click();
		handleDropDown(AdvanceSearchDropDownList, CSOURCE);
		handleDropDown(AdvanceOperatorDropDownList, 1);
		d.findElement(By.id("fval0")).sendKeys(CAMPNAME);
		d.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
	}

}
