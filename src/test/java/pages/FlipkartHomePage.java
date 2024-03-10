package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generics.BasePage;

public class FlipkartHomePage extends BasePage
{
	
	public WebDriver driver;
	
	//To locate search bar textfield in flipkart home page
	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	private WebElement searchbartextfield;
	
	//To locate acer Laptop from search results
	@FindBy(xpath = "//div[contains(text(),'Acer Extensa (2023) AMD Ryzen 5 Quad Core 7520U - ')]")
	private WebElement acerlaptop;
	
	//To locate add to cart button after selecting laptop in child window
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	private WebElement addtocart;
	
	//To locate cart button
	@FindBy(xpath = "//span[normalize-space()='Cart']")
	private WebElement cartbutton;
	
	//To locate enter delivery pin code button
	@FindBy(xpath = "//button[normalize-space()='Enter Delivery Pincode']")
	private WebElement enterdeliverypincodebutton;
	
	//To locate change pin code textbar
	@FindBy(xpath = "//input[@placeholder='Enter pincode']")
	private WebElement checkpincodetextbar;
	
	//To locate place order button
	@FindBy(xpath = "//span[normalize-space()='Place Order']")
	private WebElement placeorderbutton;
	
	//To locate Enter mobile number/Email textbar
	@FindBy(xpath = "//input[@type='text']")
	private WebElement entermobilenumbertextbar;
	
	//To locate continue button for login
	@FindBy(xpath = "//span[normalize-space()='CONTINUE']")
	private WebElement continuebutton;
	
	
	public FlipkartHomePage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//To verify Home Page is loaded successfully
	public void openflipkartmethod()
	{
		validateCurrentURL(driver, "https://www.flipkart.com/");
	}
	
	//To highlight searchbar textbox and enter laptop then press enter and then click on acer laptop from search options and switch to child window.
	public void SearchLaptopmethod() throws Exception
	{
		
		waitVisibilityofElement(driver, searchbartextfield);
		javascriptHighlightElement(driver, searchbartextfield);
		searchbartextfield.sendKeys("laptop");
		enter(searchbartextfield, driver);
		
		waitVisibilityofElement(driver, acerlaptop);
		clickOnElement(driver, acerlaptop);
		
		allWindows(driver, "Acer Extensa (2023) AMD Ryzen 5 Quad Core 7520U - (8 GB/512 GB SSD/Windows 11 Home) EX215-23 Thin and Light Laptop Rs.51999  Price in India - Buy Acer Extensa (2023) AMD Ryzen 5 Quad Core 7520U - (8 GB/512 GB SSD/Windows 11 Home) EX215-23 Thin and Light Laptop Steel Gray Online - Acer : Flipkart.com", "Acer Extensa (2023) AMD Ryzen 5 Quad Core 7520U - (8 GB/512 GB SSD/Windows 11 Home) EX215-23 Thin and Light Laptop Rs.51999  Price in India - Buy Acer Extensa (2023) AMD Ryzen 5 Quad Core 7520U - (8 GB/512 GB SSD/Windows 11 Home) EX215-23 Thin and Light Laptop Steel Gray Online - Acer : Flipkart.com");
	}
	
	//click on add to cart button then go to cart by clicking on cart button then check on delivery pincode by entering valid pincode then click on place order button
	public void Cartmethod() throws InterruptedException
	
	{
		waitVisibilityofElement(driver, addtocart);
		clickOnElement(driver, addtocart);
		
		waitVisibilityofElement(driver, cartbutton);
		clickOnElement(driver, cartbutton);
		
		waitVisibilityofElement(driver, enterdeliverypincodebutton);
		clickOnElement(driver, enterdeliverypincodebutton);
		
		waitVisibilityofElement(driver, checkpincodetextbar);
		javascriptHighlightElement(driver, checkpincodetextbar);
		checkpincodetextbar.sendKeys("751024");
		enter(checkpincodetextbar, driver);
		
		waitVisibilityofElement(driver, placeorderbutton);
		javascriptClick(driver, placeorderbutton);
	}
	
	//User authentication
	public void FlipkartLoginmethod() throws InterruptedException
	{
		waitVisibilityofElement(driver, entermobilenumbertextbar);
		javascriptHighlightElement(driver, entermobilenumbertextbar);
		entermobilenumbertextbar.sendKeys("8340495995");
		clickOnElement(driver, continuebutton);
	}
	
	
	
	
	
	
	
	
	
}