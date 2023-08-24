package object.repository.servceContract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewSericeContractPage extends WebDriverUtility{

	@FindBy(name = "subject")
	private WebElement SubjectTextField;

	@FindBy(name = "contract_status")
	private WebElement StatusDropDownList;

	@FindBy(name = "contract_priority")
	private WebElement PriorityDropDownList;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewSericeContractPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	// Status="In Planning"
	// Priority="Normal"	
	
	public void createNewSericeContract(String Subject, String Status, String Priority) {
		SubjectTextField.sendKeys(Subject);
		handleDropDown(StatusDropDownList, Status);
		handleDropDown(PriorityDropDownList, Priority);
		SaveBtn.click();
	}

}
