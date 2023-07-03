package object.repository.opportunities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreatingNewOpportunityPage extends WebDriverUtility {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement CreatingNewOpportunityTitle;

	@FindBy(name = "potentialname")
	private WebElement OpportunityNameTextField;

	@FindBy(id = "related_to_type")
	private WebElement RelatedToDropDownList;

	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
	private WebElement SelectContactOrganizationLookUpImg;

	@FindBy(xpath = "//input[@value='U']")
	private WebElement AssignedToUserRadioBtn;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement AssignedToGroupRadioBtn;

	@FindBy(name = "closingdate")
	private WebElement ExpectedCloseDateTextField;

	@FindBy(name = "sales_stage")
	private WebElement SalesStageDropDownList;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	public CreatingNewOpportunityPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreatingNewOpportunityTitle() {
		return CreatingNewOpportunityTitle;
	}

	public String createNewOpportunityHeader() {
		return CreatingNewOpportunityTitle.getText();
	}

	public void createOpprtunitiesWithOrgUser(WebDriver d, String OPNAME, String ORGNAME, String SALESSTAGE) throws InterruptedException {

		OpportunityNameTextField.sendKeys(OPNAME);
		selectByIndex(d, RelatedToDropDownList, 0);
		SelectContactOrganizationLookUpImg.click();
		switchToWindow(d, "Accounts");
		SearchTextField.sendKeys(ORGNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		switchToWindow(d, "Potentials");
		AssignedToUserRadioBtn.click();
		ExpectedCloseDateTextField.clear();
		Thread.sleep(3000);
		ExpectedCloseDateTextField.sendKeys(dateAfter15Days());
		selectByIndex(d, SalesStageDropDownList, SALESSTAGE);
		SaveBtn.click();
	}

	public static String dateAfter15Days() {
		LocalDate startDate = LocalDate.now();
		LocalDate selectedDate = selectDateAfter15Days(startDate);

		String formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return formattedDate;
	}

	public static LocalDate selectDateAfter15Days(LocalDate startDate) {
		LocalDate selectedDate = startDate.plusDays(15);
		return selectedDate;
	}

	public static String date() {
		String main = dateAfter15Days();
		return main;
	}

}
