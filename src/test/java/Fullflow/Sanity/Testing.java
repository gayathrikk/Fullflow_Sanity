package Fullflow.Sanity;



import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class Testing {

    private RemoteWebDriver driver;

    @BeforeTest
    public void setup() throws Exception {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        URL url = new URL("http://172.12.20.99:4444/wd/hub");
        driver = new RemoteWebDriver(url, dc);
    }

    @Parameters("URL")
    @Test(priority=1)
    public void Home_page(@Optional("defaultURL") String URL) throws InterruptedException {
       driver.get(URL);
    	//public void Home_page() throws InterruptedException {
    	//driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
        driver.manage().window().maximize();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        checkIcon("Home", wait);
        checkIcon("LIMS", wait);
        checkIcon("Imaging & Cropping", wait);
        checkIcon("Viewer", wait);
        checkIcon("Ontology Editor", wait);
        checkIcon("PACS", wait);
        checkIcon("DashBoard", wait);
        checkIcon("Management", wait);
        driver.switchTo().frame(0);
        
        
        // Sudha Gopalakrishnan Brain Centre 
        validateElement("//h2[@class='head']", "Sudha Gopalakrishnan Brain Centre");
        
     // Indian Institute of Technology Madras heading
        validateElement("(//h1[@class='head m-0']//following::h5)[1]", "Indian Institute of Technology Madras");

        // Home option
        validateElement("(//a[text()='HOME'])[1]", "HOME");

        // PEOPLE option
        validateElement("(//a[text()='PEOPLE'])[1]", "PEOPLE");

        // PROJECT option
        //validateElement("(//a[text()='PROJECT'])[1]", "PROJECT");
        
        //  HIGHLIGHTS option 
        validateElement("(//a[text()='HIGHLIGHTS'])[1]", "HIGHLIGHTS");

        // DATA PORTAL option
        validateElement("((//a[text()='NEWS & EVENTS'])//preceding::a[1])[1]", "DATA PORTAL");

        // NEWS & EVENTS option
        validateElement("(//a[text()='NEWS & EVENTS'])[1]", "NEWS & EVENTS");

        // CAREER option
        validateElement("(//a[text()='CAREER'])[1]", "CAREER");

        // GALLERY option
        validateElement("(//a[text()='GALLERY'])[1]", "GALLERY");

        // CONTACTS option
        validateElement("(//a[text()='CONTACTS'])[1]", "CONTACTS");
        
        
//        validateElementText("//h3[text()='Our Vision']", "Our Vision", "Our Vision heading");
//        validateElementText("//h3[text()='Our Vision']//following::p[1]", "To become a world-renowned brain research enterprise that generates globally sought other human brain data and technology tools.", "Our Vision paragraph");
//        validateElementText("//h3[text()='About']", "About", "About heading");
//        validateElementText("//h3[text()='About']//following::p[1]", "The Sudha Gopalakrishan Brain centre at IIT Madras is developing a high throughput computational and experimental pipeline to study cellular architecture, connectivity and molecular architecture in human brains. This effort is supported by the Office of the Principal Scientific Advisor, Government of India along with contributions from Mr. Kris Gopalakrishnan, Co-founder, Infosys and Distinguished Alumnus of IITM.", "About paragraph 1");
//        validateElementText("//h3[text()='About']//following::p[2]", "Our aim is to establish an integrated histology-imaging-compute pipeline at IIT Madras to acquire petabyte sized image data volumes, including from postmortem brains of subjects deceased from natural and medical causes. These datasets can also provide important and rare insights into neuronal pathways in the brain. for example, a brain with rabies infection can uniquely reveal neuronal pathways at a single neuron level in contrast with previous methods.", "About paragraph 2");
//        validateElementText("//h3[text()='About']//following::p[3]", "In parallel, the project aims to develop technologies including high throughput slide scanner and digitizer technology, 10-100X faster than currently available instruments and a computation engine to handle Gigapixel and Terapixel level images and hundreds of Terabytes of neurohistology data. With a renewed interest in the understanding of the brain across the world as evidenced by the US Brain Initiative and the EU Human Brain Project, this project leverages expertise across-IITM, national, and international collaborations for results that would have significant impact on medicine, science and engineering. We anticipate that the project, in the near future, will seed an Indian Brain Initiative centered around the human brain.", "About paragraph 3");
//        validateElementText("//h3[text()='About']//following::p[4]", "Specifically, following are the project objectives:", "About paragraph 4");
//        validateElementText("//h3[text()='About']//following::li[1]", "Development of a high throughput data capture and computational pipeline for imaging whole human brains (Terapixels and Petavoxels) at a light microscopic resolution", "About point 1");
//        validateElementText("//h3[text()='About']//following::li[2]", "Technology development for high throughput neurohistology pipeline with cellular resolution", "About point 2");
//        validateElementText("//h3[text()='About']//following::li[3]", "Identification and analysis of neuronal architecture and pathways at a single neuron level", "About point 3");
//        validateElementText("//h3[text()='About']//following::li[4]", "Generation of Visible data resources including the light-microscopic atlas of the human brain.", "About point 4");
//        validateElementText("//h3[text()='About']//following::h5[1]", "Brain Research through Advanced Integrated Neuroanatomy", "Footer heading 1");
//        validateElementText("//h3[text()='About']//following::p[6]", "Whole human brain neuro mapping at cellular resolution.", "Footer paragraph 1");
//        validateElementText("//h3[text()='About']//following::h5[2]", "ADDRESS", "Footer heading 2");
//        validateElementText("//h3[text()='About']//following::p[7]", "Sudha Gopalakrishnan BRAIN Centre\nStilt floor, NAC-1 Building\nIIT Madras, Chennai - 600036, India\nEmail: contact@humanbrainiitm.in\nPhone: +91-44-2257-8892", "Footer paragraph 2");
//        validateElementText("//h3[text()='About']//following::p[8]", "© All Rights Reserved. Designed by HTML Codex", "Footer paragraph 3");

        checkConsoleLog();
        HOMEpage_API();
       System.out.println("************************Home page validation done*************************");
    }

    @Test(priority = 2)
      
    public void login() throws InterruptedException {
    
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	driver.switchTo().defaultContent(); // Switch back to default content
    	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
    	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
    	    viewerElement.click();
    	    System.out.println("Viewer icon is clicked");
    	} else {
    	    System.out.println("Viewer icon is not clickable");
    	}
    	checkConsoleLog();

        String parentWindow = driver.getWindowHandle();
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
        if (loginButton != null) {
            loginButton.click();
            System.out.println("Login button clicked successfully.");
        } else {
            System.out.println("Login button is not clicked.");
        }
        checkConsoleLog();
	  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	  Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        if (emailInput != null && emailInput.isDisplayed()) {
            emailInput.sendKeys("softwareteam45@gmail.com");
            System.out.println("Email was entered successfully.");
        } else {
           System.out.println("Email was not entered.");
        }
        checkConsoleLog();

        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        if (nextButton1 != null) {
            nextButton1.click();
            System.out.println("Next button 1 is clicked.");
        } else {
            System.out.println("Next button 1 is not clicked.");
        }
        checkConsoleLog();
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
        passwordInput.sendKeys("Health#123");
        if (passwordInput.getAttribute("value").equals("Health#123")) {
            System.out.println("Password was entered successfully.");
        } else {
            System.out.println("Password was not entered.");
        }
        checkConsoleLog();
        
        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        if (nextButton2 != null) {
            nextButton2.click();
            System.out.println("Next button 2 is clicked.");
        } else {
            System.out.println("Next button 2 is not clicked.");
        }
        checkConsoleLog();

        driver.switchTo().window(parentWindow);
        System.out.println("Login successfully");
        checkConsoleLog();
        Loginpage_API();
        System.out.println("************************Login validation done***********************");
       
    }
    @Test(priority=3)
    public void series_set()
    {
    	 driver.switchTo().defaultContent();
    	 WebDriverWait wait = new WebDriverWait(driver, 10);
    	 //chicken brain
    	 validateElementTextAndClick("//a[text()=' chicken (Gallus gallus domesticus) ']", "chicken (Gallus gallus domesticus)", "chicken brain");
    	 validateElementTextAndClick("//a[text()=' demo ']", "demo", "Demo brain");
    	 validateElementTextAndClick("//a[text()=' Duck(Anas platyrhynchos) ']", "Duck(Anas platyrhynchos)", "Duck(Anas platyrhynchos) brain");
    	 validateElementTextAndClick("//a[text()=' Goat ']", "Goat", "Goat brain");
    	 validateElementTextAndClick("//a[text()=' Human ']", "Human", "Human brain");
    	 validateElementTextAndClick("//a[text()=' Human fetus ']", "Human fetus", "Human fetus brain");
    	 validateElementTextAndClick("//a[text()=' Mouse ']", "Mouse", "Mouse brain");
    	 validateElementTextAndClick("//a[text()=' Quail(Coturnix japonica) ']", "Quail(Coturnix japonica)", "Quail brain");

    	 clickElementByXpath("//table[@role='grid']//tr[6]", "Human fetus");
    	 clickElementByXpath("//table[@role='grid']//tr[7]//td[2]", "Brain");
    	 clickElementByXpath("//table[@role='grid']//tr[25]//td[3]", "FB40");
    	 
    	 String parentWindow = driver.getWindowHandle();
    	 
    	 clickElementByXpath("//nb-icon[@nbtooltip='Viewer']", "viewer icon");
    	 
    	 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
    	 
    	seriesset_API();
        checkConsoleLog();
        System.out.println("*********************************Series set validation done**********************************");
    }
    @Test(priority=4)
    public void HD() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	driver.switchTo().defaultContent(); // Switch back to default content
    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='883'])[1]")));
    	if (section.isEnabled() && section.isDisplayed()) {
    	    section.click();
    	    System.out.println("section is selected");
    	} else {
    	    System.out.println("section is not selected");
    	}
    	Thread.sleep(3000);
    	checkConsoleLog();
    
    	WebElement hd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View High Resolution Image']")));
    	if (hd.isEnabled() && hd.isDisplayed()) {
    	    hd.click();
    	    System.out.println("High resolution page is opened");
    	} else {
    	    System.out.println("High resolutin page is not opened");
    	}
    	Thread.sleep(5000);
    	checkConsoleLog();
    
    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='back']")));
     	if (back.isEnabled() && back.isDisplayed()) {
     	    back.click();
     	    System.out.println("Back to viewer page");
     	} else {
     	    System.out.println("Back to viewer page");
     	}
     	Thread.sleep(6000);
     	checkConsoleLog();
     	 HD_API();
     	 System.out.println("********************************Hd page validation done*****************************");
    	
    }
    @Test(priority=5)
    public void Atlas_Editor() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	driver.switchTo().defaultContent(); // Switch back to default content
    	WebElement series = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NISSL']")));
    	    if (series.isEnabled() && series.isDisplayed()) {
        	    series.click();
        	    System.out.println("series is selected");
        	} else {
        	    System.out.println("series is not selected");
        	}
    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='883'])[1]")));
    	if (section.isEnabled() && section.isDisplayed()) {
    	    section.click();
    	    System.out.println("section is selected");
    	} else {
    	    System.out.println("section is not selected");
    	}
    	Thread.sleep(3000);
    	checkConsoleLog();
    
    	WebElement atlas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Atlas Editor']")));
    	if (atlas.isEnabled() && atlas.isDisplayed()) {
    	    atlas.click();
    	    System.out.println("Atlas Editor page is opened");
    	} else {
    	    System.out.println("Atlas Editor page is not opened");
    	}
    	Thread.sleep(5000);
    	checkConsoleLog();
    	
    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']")));
     	if (back.isEnabled() && back.isDisplayed()) {
     	    back.click();
     	    System.out.println("Back to viewer page");
     	} else {
     	    System.out.println("Back to viewer page");
     	}
     	Thread.sleep(5000);
     	checkConsoleLog();
     	Atlas_API();
     	System.out.println("*******************************Atlas editor validation done*****************************");
     	
    	
    }
    
    @Test(priority=6)
    public void Cell_annotation() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	driver.switchTo().defaultContent(); // Switch back to default content
    	WebElement series = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NISSL']")));
	    if (series.isEnabled() && series.isDisplayed()) {
    	    series.click();
    	    System.out.println("series is selected");
    	} else {
    	    System.out.println("series is not selected");
    	}
    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='883'])[1]")));
    	if (section.isEnabled() && section.isDisplayed()) {
    	    section.click();
    	    System.out.println("section is selected");
    	} else {
    	    System.out.println("section is not selected");
    	}
    	Thread.sleep(3000);
    	checkConsoleLog();
    
    	WebElement atlas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Cell Annotation']")));
    	if (atlas.isEnabled() && atlas.isDisplayed()) {
    	    atlas.click();
    	    System.out.println("Cell annotation page is opened");
    	} else {
    	    System.out.println("Cell annotation page is not opened");
    	}
    	Thread.sleep(5000);
    	checkConsoleLog();
    	
    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']")));
     	if (back.isEnabled() && back.isDisplayed()) {
     	    back.click();
     	    System.out.println("Back to viewer page");
     	} else {
     	    System.out.println("Back to viewer page");
     	}
     	Thread.sleep(5000);
     	checkConsoleLog();
     	Cell_API();
     	System.out.println("*******************************Cell annotation validation done*****************************");
    	
    	
    }
    
    @Test(priority=7)
    public void Manual_Registration() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	driver.switchTo().defaultContent(); // Switch back to default content
    	WebElement series = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='NISSL']")));
	    if (series.isEnabled() && series.isDisplayed()) {
    	    series.click();
    	    System.out.println("series is selected");
    	} else {
    	    System.out.println("series is not selected");
    	}
    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='883'])[1]")));
    	if (section.isEnabled() && section.isDisplayed()) {
    	    section.click();
    	    System.out.println("section is selected");
    	} else {
    	    System.out.println("section is not selected");
    	}
    	Thread.sleep(3000);
    	checkConsoleLog();
    
    	WebElement atlas = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Manual Registration']")));
    	if (atlas.isEnabled() && atlas.isDisplayed()) {
    	    atlas.click();
    	    System.out.println("Manual Registration page is opened");
    	} else {
    	    System.out.println("Manual Registration page is not opened");
    	}
    	Thread.sleep(5000);
    	checkConsoleLog();
    	
    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']")));
     	if (back.isEnabled() && back.isDisplayed()) {
     	    back.click();
     	    System.out.println("Back to viewer page");
     	} else {
     	    System.out.println("Back to viewer page");
     	}
     	Thread.sleep(5000);
     	checkConsoleLog();
     	Reg_API();
     	System.out.println("*******************************Manual Registration validation done*****************************");
    	
    }
    
    
   private void checkIcon(String title, WebDriverWait wait) {
        WebElement icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='" + title + "']")));
        if (icon.isDisplayed()) {
            System.out.println(title + " Icon is present.");
        } else {
            System.out.println(title + " Icon is not present.");
            Assert.fail(title + " Icon is not present.");
        }
        }
    private void validateElement(String xpath, String elementName) {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        if (element.isDisplayed()) {
            System.out.println(elementName + " is present.");
        } else {
            System.out.println(elementName + " is not present.");
            Assert.fail(elementName + " is not present.");
        }
    }
    private void validateElementText(String xpath, String expectedText, String elementName) {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, elementName + " is not displayed correctly");
        System.out.println(elementName + " is displayed");
    }
    private void validateElementTextAndClick(String xpath, String expectedText, String elementName) {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, elementName + " is not displayed correctly");
        System.out.println(elementName + " is displayed");
        
    }

    private void clickElementByXpath(String xpath, String elementName) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();
            System.out.println(elementName + " clicked successfully.");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(elementName + " not clicked: " + e.getMessage());
        }
    }
   
   
  private void HOMEpage_API()
    {
    	  Response response = RestAssured.get("https://apollo2.humanbrain.in/public/footer.html");
          int statusCode = response.getStatusCode();
          if (statusCode == 200) {
              System.out.println("API request to the footer page passed. Status code: " + statusCode);
          } else {
              System.out.println("API request to the footer page failed. Status code: " + statusCode);
          }
          Assert.assertEquals(statusCode, 200, "API request to the footer page failed");
    
    }
    private void Loginpage_API()
    {	
    	//getLoginUser API
    	 String jsonBody = "{\"user_name\":\"software team\",\"user_hash\":\"106900966448254245591\",\"email\":\"teamsoftware457@gmail.com\",\"image\":\"https://lh3.googleusercontent.com/a/ACg8ocJ98wDtdlOS-ADlQ2n_WnL1iY7vWcGr8bWfkxU-9ntv=s96-c\"}";
    	 Response response = RestAssured
             .given()
                 .auth()
                 .preemptive()
                 .basic("admin", "admin")
                 .contentType(ContentType.JSON)
                 .body(jsonBody)
             .when()
                 .post("https://apollo2.humanbrain.in/CC/getLoginUser");
    	 int statusCode = response.getStatusCode();
    	 if (statusCode == 200) {
             System.out.println("API request to getLoginUser passed. Status code: " + statusCode);
         } else {
             System.out.println("API request to getLoginUser failed. Status code: " + statusCode);
         }
         Assert.assertEquals(statusCode, 200, "API request to getLoginUser failed");
         
        //Activity API
         String jsonBody1 = "{\"user\":\"124\",\"action\":\"Login\",\"info\":\" \"}";
    	 Response response1 = RestAssured
             .given()
                 .auth()
                 .preemptive()
                 .basic("admin", "admin")
                 .contentType(ContentType.JSON)
                 .body(jsonBody1)
             .when()
                 .post("https://apollo2.humanbrain.in/activities/Activity/");
    	 int statusCode1 = response1.getStatusCode();
    	 if (statusCode1 == 201) {
             System.out.println("API request to Activity passed. Status code: " + statusCode1);
         } else {
             System.out.println("API request to Activity failed. Status code: " + statusCode1);
         }
         Assert.assertEquals(statusCode1, 201, "API request to Activity failed");  
         
         
    }
    
    private void seriesset_API()
    {	
    	//series set
    	 Response response = RestAssured.get("https://apollo2.humanbrain.in/CC/getDetailsOfSeriesStatsAllRestricted/106900966448254245591");
         int statusCode = response.getStatusCode();
         if (statusCode == 200) {
             System.out.println("API request to the series set page passed. Status code: " + statusCode);
         } else {
             System.out.println("API request to the series set failed. Status code: " + statusCode);
         }
         Assert.assertEquals(statusCode, 200, "API request to the series set failed");
         
         
         //Brain access activity
         String jsonBody1 = "{\"user\":124,\"action\":\"Brain Access\",\"info\":\"Brain Id - 16\"}";
    	 Response response1 = RestAssured
             .given()
                 .auth()
                 .preemptive()
                 .basic("admin", "admin")
                 .contentType(ContentType.JSON)
                 .body(jsonBody1)
             .when()
                 .post("https://apollo2.humanbrain.in/activities/Activity/");
    	 int statusCode1 = response1.getStatusCode();
    	 if (statusCode1 == 201) {
             System.out.println("API request to Brainaccess Activity passed. Status code: " + statusCode1);
         } else {
             System.out.println("API request to Brainaccess Activity failed. Status code: " + statusCode1);
         }
         Assert.assertEquals(statusCode1, 201, "API request to Brainaccess Activity failed");  
         
         //Get thumbnails details
         Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainThumbNailDetails/IIT/V1/SS-15:-1:-1");
         int statusCode2 = response2.getStatusCode();
         if (statusCode2 == 200) {
             System.out.println("API request to the thumbnails details of series set page passed. Status code: " + statusCode2);
         } else {
             System.out.println("API request to the thumbnails details of series set failed. Status code: " + statusCode2);
         }
         Assert.assertEquals(statusCode2, 200, "API request to the thumbnails details of series set failed");
         
         //Get brain viewer deatils
         Response response3 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:-1:-1");
         int statusCode3 = response3.getStatusCode();
         if (statusCode3 == 200) {
             System.out.println("API request to the brain viewer details of series set page passed. Status code: " + statusCode3);
         } else {
             System.out.println("API request to the brain viewer details of series set failed. Status code: " + statusCode3);
         }
         Assert.assertEquals(statusCode3, 200, "API request to the brain viewer details of series set failed");
         
    }
    
    private void HD_API()
    {
    	// Get brain viewer details
    	Response response1 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
        int statusCode1 = response1.getStatusCode();
        if (statusCode1 == 200) {
            System.out.println("API request to the brain viewer details of HD page passed. Status code: " + statusCode1);
        } else {
            System.out.println("API request to the brain viewer details of HD page failed. Status code: " + statusCode1);
        }
        Assert.assertEquals(statusCode1, 200, "API request to the brain viewer details of HD page failed");
        
        //Get annotation type
        Response response2 = RestAssured.get("https://apollo2.humanbrain.in/BR/getAnnotationTypesMin");
        int statusCode2 = response2.getStatusCode();
        if (statusCode2 == 200) {
            System.out.println("API request to the get annotation type of HD page passed. Status code: " + statusCode2);
        } else {
            System.out.println("API request to the get annotation type of HD page failed. Status code: " + statusCode2);
        }
        Assert.assertEquals(statusCode2, 200, "API request to the get annotation type of HD page failed");
        
        //Details of series set
        Response response3 = RestAssured.get("https://apollo2.humanbrain.in/CC/getDetailsOfSeriesStatsAllRestricted/108775719029651384883");
        int statusCode3 = response3.getStatusCode();
        if (statusCode3 == 200) {
            System.out.println("API request to the series set of HD page passed. Status code: " + statusCode3);
        } else {
            System.out.println("API request to the series set of HD page failed. Status code: " + statusCode3);
        }
        Assert.assertEquals(statusCode3, 200, "API request to the series set of HD page failed");
        
        //Activity
        String jsonBody1 = "{\"user\":57,\"action\":\"High Resolution\",\"info\":\"SS-15:10:1006\"}";
   	 Response response4 = RestAssured
            .given()
                .auth()
                .preemptive()
                .basic("admin", "admin")
                .contentType(ContentType.JSON)
                .body(jsonBody1)
            .when()
                .post("https://apollo2.humanbrain.in/activities/Activity/");
   	 int statusCode4 = response4.getStatusCode();
   	 if (statusCode4 == 201) {
            System.out.println("API request to Brainaccess Activity of HD passed. Status code: " + statusCode4);
        } else {
            System.out.println("API request to Brainaccess Activity of HD failed. Status code: " + statusCode4);
        }
        Assert.assertEquals(statusCode4, 201, "API request to Activity of HD failed");  
        
    }
    
    private void Atlas_API()
    {
    	//app atlas registration
    	Response response1 = RestAssured
    		    .given()
    		    .auth()
    		    .basic("admin", "admin")
    		    .when()
    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/7832/");

        int statusCode1 = response1.getStatusCode();
        if (statusCode1 == 200) {
            System.out.println("API request to the appatlas registration of Atlas Editor passed. Status code: " + statusCode1);
        } else {
            System.out.println("API request to the appatlas registration of Atlas Editor failed. Status code: " + statusCode1);
        }
        Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Atlas Editor failed");
        
        //Atlas brain viewer details
        Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
        int statusCode2 = response2.getStatusCode();
        if (statusCode2 == 200) {
            System.out.println("API request to the brain viewer details of Atlas page passed. Status code: " + statusCode2);
        } else {
            System.out.println("API request to the brain viewer details of Atlas page failed. Status code: " + statusCode2);
        }
        Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of Atlas page failed");
        
        //Get contributors details
        Response response3 = RestAssured
    		    .given()
    		    .auth()
    		    .basic("admin", "admin")
    		    .when()
    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/?externalkey=FlatTree::IIT:V1:SS-15:10:1006:1006&annotationtype=6");

        int statusCode3 = response3.getStatusCode();
        if (statusCode3 == 200) {
            System.out.println("API request to get contributors details of Atlas page passed. Status code: " + statusCode3);
        } else {
            System.out.println("API request to get contributors details of Atlas page failed. Status code: " + statusCode3);
        }
        Assert.assertEquals(statusCode3, 200, "API request to get contributors details of Atlas page failed");
        
       //Atlas app annotation type
        Response response4 = RestAssured
    		    .given()
    		    .auth()
    		    .basic("admin", "admin")
    		    .when()
    		    .get("https://apollo2.humanbrain.in/BR/AppAnnotationType/");
        int statusCode4 = response4.getStatusCode();
        if (statusCode4 == 200) {
            System.out.println("API request to get app annotation type details of Atlas page passed. Status code: " + statusCode4);
        } else {
            System.out.println("API request to get app annotation type details of Atlas page failed. Status code: " + statusCode4);
        }
        Assert.assertEquals(statusCode4, 200, "API request to get app annotation type details of Atlas page failed");
        
   }
    private void Cell_API()
    {
    	//App atlas Registration
    	Response response1 = RestAssured
    		    .given()
    		    .auth()
    		    .basic("admin", "admin")
    		    .when()
    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/11524/");
      int statusCode1 = response1.getStatusCode();
      if (statusCode1 == 200) {
          System.out.println("API request to the appatlas registration of Cell annotation passed. Status code: " + statusCode1);
      } else {
          System.out.println("API request to the appatlas registration of Cell annotation failed. Status code: " + statusCode1);
      }
      Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Cell annotation failed");
      
      //Get brain viewer details
      Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
      int statusCode2 = response2.getStatusCode();
      if (statusCode2 == 200) {
          System.out.println("API request to the brain viewer details of cell annotation passed. Status code: " + statusCode2);
      } else {
          System.out.println("API request to the brain viewer details of cell annotation failed. Status code: " + statusCode2);
      }
      Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of cell annotation failed");
      
      //App annotation type
      Response response3 = RestAssured
  		    .given()
  		    .auth()
  		    .basic("admin", "admin")
  		    .when()
  		    .get("https://apollo2.humanbrain.in/BR/AppAnnotationType/");
      
    int statusCode3 = response3.getStatusCode();
    if (statusCode3 == 200) {
        System.out.println("API request to get app annotation type details of Cell annotation page passed. Status code: " + statusCode3);
    } else {
        System.out.println("API request to get app annotation type details of Cell annotation page failed. Status code: " + statusCode3);
    }
    Assert.assertEquals(statusCode3, 200, "API request to get app annotation type details of Cell annotation page failed");
      
       //Contributors
    Response response4 = RestAssured
  		    .given()
  		    .auth()
  		    .basic("admin", "admin")
  		    .when()
  		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/?externalkey=PixelAnnotation::IIT:V1:SS-15:10:1006:1006&annotationtype=3");    
    
	  int statusCode4 = response4.getStatusCode();
	  if (statusCode4 == 200) {
	      System.out.println("API request to get contributors details of cell annotation passed. Status code: " + statusCode4);
	  } else {
	      System.out.println("API request to get contributors details of cell annotation failed. Status code: " + statusCode4);
	  }
	  Assert.assertEquals(statusCode4, 200, "API request to get contributors details of Cell annotation failed");
	  
	  //Annotated tile list
	  String jsonBody1 = "{\"bid\":37,\"sec\":1006,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
	   	 Response response5 = RestAssured
	            .given()
	                .auth()
	                .preemptive()
	                .basic("admin", "admin")
	                .contentType(ContentType.JSON)
	                .body(jsonBody1)
	            .when()
	                .post("https://apollo2.humanbrain.in/GW/listAnnotatedTiles");
	   	 int statusCode5 = response5.getStatusCode();
	   	 if (statusCode5 == 200) {
	            System.out.println("API request to list of annotated tiles  passed. Status code: " + statusCode5);
	        } else {
	            System.out.println("API request to list of annotated tiles failed. Status code: " + statusCode5);
	        }
	        Assert.assertEquals(statusCode5, 200, "API request to list of annotated tiles failed");  
	        
	        //WIP tile list
	        String jsonBody2 = "{\"bid\":37,\"sec\":1006,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
		   	 Response response6 = RestAssured
		            .given()
		                .auth()
		                .preemptive()
		                .basic("admin", "admin")
		                .contentType(ContentType.JSON)
		                .body(jsonBody2)
		            .when()
		                .post("https://apollo2.humanbrain.in/GW/listWipTiles");
		   	 int statusCode6 = response6.getStatusCode();
		   	 if (statusCode6 == 200) {
		            System.out.println("API request to list of wip tiles  passed. Status code: " + statusCode6);
		        } else {
		            System.out.println("API request to list of wip tiles failed. Status code: " + statusCode6);
		        }
		        Assert.assertEquals(statusCode6, 200, "API request to list of wip tiles failed");  
		        
		     //AG tile list
		        String jsonBody3 = "{\"bid\":37,\"sec\":1006,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
			   	 Response response7 = RestAssured
			            .given()
			                .auth()
			                .preemptive()
			                .basic("admin", "admin")
			                .contentType(ContentType.JSON)
			                .body(jsonBody3)
			            .when()
			                .post("https://apollo2.humanbrain.in/GW/listWipTiles");
			   	 int statusCode7 = response7.getStatusCode();
			   	 if (statusCode7 == 200) {
			            System.out.println("API request to list of AG tiles  passed. Status code: " + statusCode7);
			        } else {
			            System.out.println("API request to list of AG tiles failed. Status code: " + statusCode7);
			        }
			        Assert.assertEquals(statusCode7, 200, "API request to list of AG tiles failed");    
	  
	   
	    }
    private void Reg_API()
    {
    	Response response1 = RestAssured
    		    .given()
    		    .auth()
    		    .basic("admin", "admin")
    		    .when()
    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/11534/");
      int statusCode1 = response1.getStatusCode();
      if (statusCode1 == 200) {
          System.out.println("API request to the appatlas registration of Manual Registration passed. Status code: " + statusCode1);
      } else {
          System.out.println("API request to the appatlas registration of Manual Registration failed. Status code: " + statusCode1);
      }
      Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Manual Registration failed");
      
      //Get Brain viewer details
      Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-15:10:1006");
      int statusCode2 = response2.getStatusCode();
      if (statusCode2 == 200) {
          System.out.println("API request to the brain viewer details of Manual Registration   passed. Status code: " + statusCode2);
      } else {
          System.out.println("API request to the brain viewer details of Manual Registration failed. Status code: " + statusCode2);
      }
      Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of Manual Registration failed");
      
      //Get contributors
      Response response3 = RestAssured
    		    .given()
    		    .auth()
    		    .basic("admin", "admin")
    		    .when()
    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/?externalkey=Registration::IIT:V1:SS-15:10:1006:1006&annotationtype=1971");    
      
  	  int statusCode3 = response3.getStatusCode();
  	  if (statusCode3 == 200) {
  	      System.out.println("API request to get contributors details of Manual Registration passed. Status code: " + statusCode3);
  	  } else {
  	      System.out.println("API request to get contributors details of Manual Registration failed. Status code: " + statusCode3);
  	  }
  	  Assert.assertEquals(statusCode3, 200, "API request to get contributors details of Manual Registration failed");
      
    }
    
    

    private void checkConsoleLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.filter(Level.SEVERE);

        int severeLogCount = logs.size();
        System.out.println("Number of SEVERE-level logs: " + severeLogCount);

        for (LogEntry log : logs) {
            System.out.println("Level is : \n" + log.getLevel());
            System.out.println("Message is : \n" + log.getMessage());
        }

        //Assert.assertEquals(severeLogCount, 0, "SEVERE logs were found in the console.");
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
