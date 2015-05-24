
package nak.test;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;

public class CalculatorTest extends UiAutomatorTestCase { 

	public void testingCalculator() throws UiObjectNotFoundException {   
		// First we testing the press of the HOME button.
		getUiDevice().pressHome();
		 // using the uiautomatorviewer tool we foun that the button for the "applications" has
		 //the value “Apps” (screen9)
		 // so we usethis property to create a UiSelector to find the button.
		UiObject Applications = new UiObject(new UiSelector().description("Apps"));
		// testing the click to bring up the All Apps screen.
		Applications.clickAndWaitForNewWindow();
		// In the All Apps screen, the "Calculator" application is located in
		// the Apps tab. So, we create a UiSelector to find a tab with the text
		// label “Apps”.
		UiObject apps = new UiObject(new UiSelector().text("Apps"));
		// and then testing the click to this tab in order to enter the Apps tab.
		apps.click();
		// All the applications are in a scrollable list
		// so first we need to get a reference to that list
		UiScrollable ListOfapplications = new UiScrollable(new UiSelector().scrollable(true));
		// and then trying to find the application
		// with the name Calculator
		UiObject Calculator = ListOfapplications.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"European War 4: Napoleon");
		Calculator.clickAndWaitForNewWindow();
		// now the Calculator app is open
		// so we can test the press of button "7" using the ID "com.android.calculator2:id/digit7"
		//we found by using uiautomatorviewer
		
		
		UiObject seven = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit7"));
		seven.click();
		// now we test the press of button "+"
		UiObject plus = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/plus"));
		plus.click();
		// and then the press of button "1"
		UiObject one = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/digit1"));
		one.click();
		// we test the press of button "="
		UiObject equal  = new UiObject(new UiSelector().resourceId("com.android.calculator2:id/equal"));
		equal.click();
		UiObject result  = new UiObject(new UiSelector().className("android.widget.EditText"));
		String d = result.getText();
		result.clearTextField();
		if (d=="8"){getUiDevice().pressBack();}
		UiObject option  = new UiObject(new UiSelector().text("Copy"));
		option.click();
		getUiDevice().pressBack();
		
		
		
		}
}
