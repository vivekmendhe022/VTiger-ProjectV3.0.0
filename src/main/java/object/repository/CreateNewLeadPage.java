package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewLeadPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement LastNameTextField;

	@FindBy(name = "company")
	private WebElement CompanyTextField;

	@FindBy(name = "leadsource")
	private WebElement LeadSourceDropDownList;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewLeadPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return CompanyTextField;
	}

	public WebElement getLeadSourceDropDownList() {
		return LeadSourceDropDownList;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void createNewLeadWithSource(String LASTNAME, String COMPANY, String LEADSOURCE) {
		LastNameTextField.sendKeys(LASTNAME);
		CompanyTextField.sendKeys(COMPANY);
		handleDropDown(LeadSourceDropDownList, LEADSOURCE);
		SaveBtn.click();
	}

}
