package object.repository.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditOrganizationsPage {

	@FindAll({ @FindBy(linkText = "accountname"), @FindBy(xpath = "//input[@name='accountname']") })
	private WebElement OrgNameTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public EditOrganizationsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void editOrganisation(String ORGNAME, String INDUSTRY) {
		OrgNameTextField.sendKeys(ORGNAME);
		SaveBtn.click();
	}

}
