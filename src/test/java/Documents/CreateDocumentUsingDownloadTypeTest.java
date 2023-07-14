package Documents;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.documents.CreateNewDocumentPage;
import object.repository.documents.DocumentsPage;
import object.repository.documents.DocumnetsInfoPage;

public class CreateDocumentUsingDownloadTypeTest extends BaseClass{
	@Test
	public void createDocumentTest() {
		int r = jutil.getRandom();
		String TITLE = "Test Case_" + r;
		String AssignedTo = "group";

		HomePage hp = new HomePage(d);
		hp.clickOnDocumentsLinkText();

		DocumentsPage dp = new DocumentsPage(d);
		dp.clickOnCreateDocumnetsLookUpIcon();

		CreateNewDocumentPage cnd = new CreateNewDocumentPage(d);
		cnd.createNewDocumentUsingDownloadType(d, TITLE, AssignedTo);

		DocumnetsInfoPage dip = new DocumnetsInfoPage(d);
		String header = dip.getDocumentsHeaderInfo();
		Assert.assertTrue(header.contains(TITLE));
	}
}
