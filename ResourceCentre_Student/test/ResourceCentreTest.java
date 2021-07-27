import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void testAddChromebook() {
		// write your code here.
		
		//Test if there is an available Chromebook ArrayList to add to
		assertNotNull("Test if there is an available Chromebook ArrayList to add to", chromebookList);
		
		//Test that the Chromebook ArrayList increases in size after a Chromebook has been added
		ResourceCentre.addChromebook(chromebookList, cb1);		
		assertEquals("Test that the Chromebook ArrayList increases in size after a Chromebook has been added", 
				1, chromebookList.size());
		
		//Test that the new Chromebook is added as the first item of the ArrayList 
		assertSame("Test that the new Chromebook is added as the first item of the ArrayList ", 
				cb1, chromebookList.get(0));
		
		//Test that the size of the Chromebook ArrayList is now 2 
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that the size of the Chromebook ArrayList is now 2 ", 
				2, chromebookList.size());
	}
	
	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void testRetrieveAllChromebook() {
		//fail("Not yet implemented");
		// write your code here
		
		// Test if the Item List is not null but empty so that the items can be properly retrieves
		assertNotNull("Test if there is a valid ArrayList to retrieve items from", chromebookList);
		
		// Test that viewing an item list that is empty will not output any items
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		assertEquals("Test if viewing an empty list will not output any items", "", allChromebook);
		
		// Test that viewing an item list with 2 items inside will show 2 items
		// asset tag, description, available, due date, os
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		String testRetrieveOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testRetrieveOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
		assertEquals("Test if ArrayList matches displayed list", allChromebook, testRetrieveOutput);
		
		
	}

	@Test
	public void testDoLoanCamcorder() {
		//Test that the items list are not null before loaning
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Test that the status updates when an item goes on loan
		camcorderList.add(cc1);
		camcorderList.get(0).setIsAvailable(false);
		assertEquals("Test that the status updates when an item goes on loan", camcorderList.get(0).getIsAvailable(), false);
		
		//Test that the item(s) can be loaned upon availability
		camcorderList.add(cc1);
		camcorderList.get(0).setIsAvailable(false);
		boolean loaned = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "10/06/21");
		assertEquals("Test that the item(s) can be loaned upon availability", loaned, false);
		
		
	}
	
	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		
		// Test that the item list is not null before loaning
		assertNotNull("Test if there is valid Camcorder arraylist", camcorderList);
		
		// Test that the status updates when item is loaned
		ResourceCentre.addChromebook(chromebookList, cb1);
		boolean doLoan = ResourceCentre.doLoanChromebook(chromebookList, cb1.getAssetTag(), "27/07/2022");
		assertTrue("Chromebook not loaned out", doLoan);
		
		// Test that the item(s) unavailable cannot be loaned
		boolean isLoaned = ResourceCentre.doLoanChromebook(chromebookList, cb1.getAssetTag(), "28/07/2022");
		assertFalse("Item can still be loaned", isLoaned);
		
}
	
	@Test
	public void testDoReturnCamcorder() {
		System.out.print("Camcorder Returned Successfully!");
		//fail("Not yet implemented");
		// write your code here
		
		ResourceCentre.addCamcorder(camcorderList, cc1);
		
		// Test that a loaned camcorder can be returned
		camcorderList.get(0).setIsAvailable(false);
		boolean returnCC = ResourceCentre.doReturnCamcorder(camcorderList, cc1.getAssetTag());
		assertTrue("Loaned camcorder cannot be returned", returnCC);
		
		// Test that an available camcorder cannot be returned
		boolean returnAvailCC = ResourceCentre.doReturnCamcorder(camcorderList, cc1.getAssetTag());
		assertFalse("Available camcorder can be returned", returnAvailCC);
		
		// Test that an invalid camcorder (asset tag) cannot be returned
		boolean returnInvalidCC = ResourceCentre.doReturnCamcorder(camcorderList, "CC0001");
		assertFalse("Invalid camcorder can be returned", returnInvalidCC);
		
		
		
		
	}
	@Test
	public void testDoReturnChromebook() {
		System.out.print("Chromebook Returned Successfully!");
		//fail("Not yet implemented");
		// write your code here
		
		chromebookList.add(cb1);
		
		// Test that a loaned chromebook can be returned
		chromebookList.get(0).setIsAvailable(false);
		boolean returnCB = ResourceCentre.doReturnChromebook(chromebookList, cb1.getAssetTag());
		assertTrue("Loaned chromebook cannot be returned", returnCB);
		
		// Test that an available chromebook cannot be returned
		boolean returnAvailCB = ResourceCentre.doReturnChromebook(chromebookList, cb1.getAssetTag());
		assertFalse("Available chromebook can be returned", returnAvailCB);
		
		// Test that an invalid chromebook (asset tag) cannot be returned
		boolean returnInvalidCB = ResourceCentre.doReturnChromebook(chromebookList, "CB0001");
		assertFalse("Invalid chromebook can be returned", returnInvalidCB);
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
