package Opportunities;

import java.io.IOException;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.ContactPage;
import object.repository.CreateNewContactPage;
import object.repository.HomePage;
import object.repository.opportunities.CreatingNewOpportunityPage;
import object.repository.opportunities.OpportunitiesPage;

public class CreateOpprtunitiesWithContactsTest extends BaseClass {

	@Test
	public void createOpprtunitiesWithContactsTest() throws InterruptedException, IOException {

		int r = jutil.getRandom();

		String OPNAME = "Gates";
		String LASTNAME = r + "Lastname";
		String SALESSTAGE = "Needs Analysis";
		String AssignedTo = "group";

		HomePage hp = new HomePage(d);
		hp.clickOnContactLink();

		ContactPage cp = new ContactPage(d);
		cp.clickOnCreateContactLookUpImg();

		CreateNewContactPage cnp = new CreateNewContactPage(d);
		cnp.createNewContact(d, LASTNAME);

		hp.clickOnOpportunitiesLink();

		OpportunitiesPage op = new OpportunitiesPage(d);
		op.clickOnCreateOpportunitiesLookUpIcon();

		CreatingNewOpportunityPage cno = new CreatingNewOpportunityPage(d);
		cno.createOpprtunitiesWithContactsUser(d, OPNAME, LASTNAME, AssignedTo,SALESSTAGE);

	}
}
