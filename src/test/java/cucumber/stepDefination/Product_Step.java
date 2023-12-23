package cucumber.stepDefination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.*;

public class Product_Step extends Base {

    private String username;
    private String password;
    private String numOfitems;
    private String smallTitle;
    private String itemNames [];
    private Float itemPrices [];

    @Then("User should see the product title label")
    public void user_should_see_the_product_label() {

        Helper H1 = new Helper(driver);
        String TitleProduct = H1.TitleProduct().getAttribute("innerText");

        if(TitleProduct.equals("Products")) {

            System.out.println("Product title label is correct");

        }
        else {

            System.out.println("Product title label is not correct");
        }
        driver.quit();

    }

    @Then("User should see the product sort option")
    public void user_should_see_the_product_sort_option() {

        Helper H1 = new Helper(driver);
        Boolean var1 = H1.ProductSortOpt().isDisplayed();

        if(var1 == true) {

            System.out.println("Product sort option is displayed");

        }
        else {
            System.out.println("Not displayed");
        }
        driver.quit();
    }

    @Then("User should see the products correctly")
    public void user_should_see_the_products_correctly() {

        Helper H1 = new Helper(driver);
        List<WebElement> items = H1.InventoryItem();

        String [] itemDetailNames = {"name","description","price","button text"};
        String [] itemDetailsRecieved;
        //items.get(1).getText().split("\\R");

        String [][] itemDetailsCorrect = {
                {"Sauce Labs Backpack", "Carry all the things with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","$29.99","Add to cart"},
                {"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.","$9.99","Add to cart"},
                {"Sauce Labs Bolt T-Shirt","Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.","$15.99","Add to cart"},
                {"Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.","$49.99","Add to cart"},
                {"Sauce Labs Onesie","Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.","$7.99","Add to cart"},
                {"Sauce Labs T-Shirt (Red)","This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.","$15.99","Add to cart"},
        };

        //itemDetailsRecieved = items.get(1).getText().split("\\R");
        System.out.println("Number of product items :" + items.size());

        for (int i=0; i<=5; i++) {

            itemDetailsRecieved = items.get(i).getText().split("\\R");

            for (int j=0; j<=3; j++) {

                if(itemDetailsCorrect[i][j].equals(itemDetailsRecieved[j]) ) {

                    System.out.println("Product "+(i+1)+ " "+itemDetailNames[j] +" is correct: "+ itemDetailsRecieved[j] );
                }
                else {

                    System.out.println("Product "+(i+1)+ " "+itemDetailNames[j] +" is wrong: "+ "Received --> "+itemDetailsRecieved[j]+" Expected --> "+itemDetailsCorrect[i][j] );
                }
            }
        }
        driver.quit();
    }


}
