package cucumber.stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import utility.*;

import java.util.Arrays;
import java.util.Collections;


public class Cart_Step extends Base {

    private String username;
    private String password;
    private String numOfitems;
    private String smallTitle;
    private String itemNames [];
    private Float itemPrices [];

    @Given("^User should login to swag labs using correct <Username> and <Password>$")
    public void User_should_login_to_swag_labs_using_correct(String Username, String Password) {
        username = Username;
        password = Password;
        Helper H1 = new Helper(driver);
        H1.typeUserName().sendKeys(Username);
        H1.typePassword().sendKeys(Password);

    }

    @When("User click the add to cart button (\\d+)$")
    public void user_click_the_add_to_cart_button(int itemNumber) throws InterruptedException {



        Helper H1 = new Helper(driver);
        numOfitems = H1.CartBadgeContainer().getText();
        //System.out.println("Button text before is : "+H1.AddToCartButton().get(0).getText());
        H1.AddToCartButton().get(itemNumber).click();
        //Thread.sleep(3000);
        //System.out.println("Button text after is : "+H1.RemoveButton().get(0).getText());
        System.out.println("Button is " +itemNumber );


    }

    @Then("User should see the updated cart badge")
    public void user_should_see_the_updated_cart_badge() {
        Helper H1 = new Helper(driver);
        //numOfitems = H1.CartBadgeContainer().getText();
        if(numOfitems.equals("") ) {
            numOfitems = "0";
        }

        String numOfitemsNew = H1.CartBadgeContainer().getText();

        System.out.println("Number of items in the cart is : "+numOfitems);
        System.out.println("Number of items in the cart new is : "+numOfitemsNew);

        if(Integer.parseInt(numOfitemsNew) == Integer.parseInt(numOfitems)+1) {
            System.out.println("Cart badge is updated successfully");
        }
        else {
            System.out.println("Fail to upadted");
        }
        driver.quit();
    }

    @When("User click the add to cart buttons")
    public void user_click_the_add_to_cart_buttons() {

        Helper H1 = new Helper(driver);

        for(int i = 0;i<=5;i++) {
            H1.AddToCartButton().get(0).click();
        }

    }

    @Then("User should see the remove button")
    public void user_should_see_the_remove_button() {

        Helper H1 = new Helper(driver);
        for(int i=0;i<=5;i++) {
            if(H1.RemoveButton().get(i).getText().equals("Remove")) {
                System.out.println("Remove button"+ i +"is displyed");
            }
            else {
                System.out.println("Remove button"+ i +"is not displyed");
            }
        }
        driver.quit();
    }


    @When("User click the product title (\\d+)$")
    public void user_click_the_product_title(int itemNumber) {
        Helper H1 = new Helper(driver);
        smallTitle = H1.TitleButtons().get(itemNumber).getText();
        H1.TitleButtons().get(itemNumber).click();
    }

    @Then("User should see the full product view")
    public void user_should_see_the_full_product_view() {

        Helper H1 = new Helper(driver);
        if(H1.ProductLargeTitle().getText().equals(smallTitle)) {
            System.out.println("Navigated to large product view Correctly");
        }
        else {
            System.out.println("Incorrect Navigation to large product view");
        }
        driver.quit();

    }

    @When("User click the cart icon")
    public void user_click_the_cart_icon() {
        Helper H1 = new Helper(driver);
        H1.CartBadgeContainer().click();

    }

    @Then("User should see the cart items added to cart")
    public void user_should_see_the_cart_items_added_to_cart() {

        Helper H1 = new Helper(driver);
        String [] cartItemNames = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};

        for (int i =0;i<=5;i++) {

            if(H1.CartItem().get(i).getText().equals(cartItemNames[i])) {
                System.out.println(cartItemNames[i]+" : Add to cart successfully");
            }
            else {
                System.out.println(cartItemNames[i]+" : Fail to add to cart");
            }
        }
        driver.quit();
    }

    @When("User click the remove buttons")
    public void user_click_the_remove_buttons() {
        Helper H1 = new Helper(driver);

        for(int i = 0;i<=5;i++) {
            H1.RemoveCartButton().get(0).click();
        }
    }

    @Then("User should see the cart without removed item")
    public void user_should_see_the_cart_without_removed_item() {
        Helper H1 = new Helper(driver);
        //String [] cartItemNames = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};

        if(H1.CartItem().size()!=0) {
            for (int i =0;i<=H1.CartItem().size();i++) {

                System.out.println(H1.CartItem().get(i).getText()+" : Fail to removed from cart");
            }
        }

        else {

            System.out.println("All the items removed from cart successfully");

        }
        driver.quit();
    }

    @When("User click the back to products button")
    public void user_click_the_back_to_products_button() {
        Helper H1 = new Helper(driver);
        H1.BackToProductsButton().click();
    }

    @Then("User should see the product page")
    public void user_should_see_the_product_page() {
        Helper H1 = new Helper(driver);
        boolean titleProduct = H1.TitleProduct().isDisplayed();

        if(titleProduct) {

            System.out.println("Navigated successfully");

        }
        else {

            System.out.println("Not navigated");
        }
        driver.quit();
    }

    @When("User click the continue shopping button")
    public void user_click_the_continue_shopping_button() {
        Helper H1 = new Helper(driver);
        H1.ContinueShopingButton().click();
    }

    @When("User click the checkout button")
    public void user_click_the_checkout_button() {
        Helper H1 = new Helper(driver);
        H1.CheckoutButton().click();
    }

    @Then("User should see the checkout info page")
    public void user_should_see_the_checkout_info_page() {
        Helper H1 = new Helper(driver);
        boolean CheckoutInfo = H1.TitleProduct().isDisplayed();
        if(CheckoutInfo) {

            System.out.println("Navigated successfully");

        }
        else {

            System.out.println("Not navigated");
        }
        driver.quit();
    }

    @When("User click the sort ZA")
    public void user_click_the_sort_za() {

        itemNames = new String[6];
        Helper H1 = new Helper(driver);

        for (int i=0;i<=5;i++) {
            itemNames[i] = H1.ItemNames().get(i).getText();
            System.out.println("before sort Item name : "+itemNames[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("za");
    }

    @When("User click the sort AZ")
    public void user_click_the_sort_az() {

        itemNames = new String[6];
        Helper H1 = new Helper(driver);

        for (int i=0;i<=5;i++) {
            itemNames[i] = H1.ItemNames().get(i).getText();
            System.out.println("before sort Item name : "+itemNames[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("az");
    }

    @Then("User should see the ZA sorted products")
    public void user_should_see_the_ZA_sorted_products() {

        Helper H1 = new Helper(driver);
        String itemNamesAfterSort [] = new String[6];

        for (int i=0;i<=5;i++) {
            itemNamesAfterSort[i] = H1.ItemNames().get(i).getText();
            System.out.println("After clicked sort Item name : "+itemNamesAfterSort[i]);
        }
        //Arrays.sort(itemNames);
        Arrays.sort(itemNames, Collections.reverseOrder());

        if(Arrays.equals(itemNames, itemNamesAfterSort)) {

            System.out.println("Sorted correctly Z-A");
        }
        else{
            System.out.println("Incorrectly sorted Z-A");
        }
        driver.quit();
    }

    @Then("User should see the AZ sorted products")
    public void user_should_see_the_AZ_sorted_products() {

        Helper H1 = new Helper(driver);
        String itemNamesAfterSort [] = new String[6];

        for (int i=0;i<=5;i++) {
            itemNamesAfterSort[i] = H1.ItemNames().get(i).getText();
            System.out.println("After clicked sort Item name : "+itemNamesAfterSort[i]);
        }
        Arrays.sort(itemNames);
        if(Arrays.equals(itemNames, itemNamesAfterSort)) {

            System.out.println("Sorted correctly A-Z");
        }
        else{
            System.out.println("Incorrectly sorted A-Z");
        }
        driver.quit();
    }

    @Then("User should see the correct products images")
    public void user_should_see_the_correct_products_images() {

        Helper H1 = new Helper(driver);
        String [] imgSrcNames = {"sauce-backpack","bike-light","bolt-shirt","sauce-pullover","red-onesie","red-tatt"};

        int j = 1;
        for(int i=1;i<=12;i+=2) {
            String imgsrc = H1.ItemImg().get(i).getAttribute("src").toString();


            if(imgsrc.contains(imgSrcNames[i-j])) {
                System.out.println("Image is correct : "+imgSrcNames[i-j]);
            }

            else {
                System.out.println("Image source is wrong : "+imgsrc);
            }
            j++;
        }
        driver.quit();
    }

    @When("User click the sort low to high")
    public void user_click_the_sort_low_to_high() {
        itemPrices = new Float[6];
        Helper H1 = new Helper(driver);

        for (int i=0;i<=5;i++) {
            itemPrices[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("before sort Item price : "+itemPrices[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("lohi");
    }

    @Then("User should see the low to high sorted products")
    public void user_should_see_the_low_to_high_sorted_products() {
        Helper H1 = new Helper(driver);
        Float itemPricesAfterSort [] = new Float[6];

        for (int i=0;i<=5;i++) {
            itemPricesAfterSort[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("After clicked sort Item price : "+itemPricesAfterSort[i]);
        }

        Arrays.sort(itemPrices);

        if(Arrays.equals(itemPrices, itemPricesAfterSort)) {

            System.out.println("Sorted correctly price low to high");
        }
        else{
            System.out.println("Incorrectly sorted price low to high");
        }
        for (int i=0;i<=5;i++) {

            System.out.println("Aftersort Item price : "+itemPrices[i]);
        }
        driver.quit();
    }

    @When("User click the sort high to low")
    public void user_click_the_sort_high_to_low() {
        itemPrices = new Float[6];
        Helper H1 = new Helper(driver);

        for (int i=0;i<=5;i++) {
            itemPrices[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("before sort Item price : "+itemPrices[i]);
        }

        Select se = new Select(H1.SortDropDown());

        se.selectByValue("hilo");
    }

    @Then("User should see the high to low sorted products")
    public void user_should_see_the_high_to_low_sorted_products() {
        Helper H1 = new Helper(driver);
        Float itemPricesAfterSort [] = new Float[6];

        for (int i=0;i<=5;i++) {
            itemPricesAfterSort[i] = Float.parseFloat(H1.ItempRrice().get(i).getText().substring(1));
            System.out.println("After clicked sort Item price : "+itemPricesAfterSort[i]);
        }


        Arrays.sort(itemPrices, Collections.reverseOrder());
        if(Arrays.equals(itemPrices, itemPricesAfterSort)) {

            System.out.println("Sorted correctly price high to low");
        }
        else{
            System.out.println("Incorrectly sorted price high to low");
        }
        for (int i=0;i<=5;i++) {

            System.out.println("Aftersort Item price : "+itemPrices[i]);
        }
        driver.quit();
    }


}
