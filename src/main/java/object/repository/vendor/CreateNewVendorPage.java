package object.repository.vendor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewVendorPage extends WebDriverUtility {

	/*
	 * value="300-Sales-Software" value="302-Rental-Income"
	 * value="303-Interest-Income" value="304-Sales-Software-Support"
	 * value="305-Sales Other" value="306-Internet Sales"
	 * value="307-Service-Hardware Labor" value="308-Sales-Books"
	 */

	@FindBy(name = "vendorname")
	private WebElement VendorNameTextField;

	@FindBy(id = "email")
	private WebElement EmailTextField;

	@FindBy(id = "phone")
	private WebElement PhoneTextField;

	@FindBy(name = "glacct")
	private WebElement GLAccountDropDownList;

	@FindBy(name = "website")
	private WebElement WebsiteTextField;

	@FindBy(name = "category")
	private WebElement CategoryTextField;

	@FindBy(name = "street")
	private WebElement StreetTextArea;

	@FindBy(name = "pobox")
	private WebElement PoBoxTextArea;

	@FindBy(name = "city")
	private WebElement CityTextField;

	@FindBy(name = "state")
	private WebElement StateTextField;

	@FindBy(name = "postalcode")
	private WebElement PostalCodeTextField;

	@FindBy(name = "country")
	private WebElement CountryTextField;

	@FindBy(name = "description")
	private WebElement DescriptionTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewVendorPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewVendor(String vendorName, String email, String phone, String glAccount, String website,
			String category, String street, String poBox, String city, String state, String postalCode, String country,
			String description) {

		// Set values for the vendor
		VendorNameTextField.sendKeys(vendorName);
		EmailTextField.sendKeys(email);
		PhoneTextField.sendKeys(phone);
		handleDropDown(GLAccountDropDownList, glAccount);
		WebsiteTextField.sendKeys(website);
		CategoryTextField.sendKeys(category);
		StreetTextArea.sendKeys(street);
		PoBoxTextArea.sendKeys(poBox);
		CityTextField.sendKeys(city);
		StateTextField.sendKeys(state);
		PostalCodeTextField.sendKeys(postalCode);
		CountryTextField.sendKeys(country);
		DescriptionTextField.sendKeys(description);

		// Click the save button
		SaveBtn.click();
	}

}
