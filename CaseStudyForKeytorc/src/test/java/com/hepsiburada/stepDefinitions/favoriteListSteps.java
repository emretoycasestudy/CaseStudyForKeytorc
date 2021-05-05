package com.hepsiburada.stepDefinitions;

import com.hepsiburada.pages.FavoritePage;
import com.hepsiburada.pages.*;

import com.hepsiburada.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class favoriteListSteps {

    LoginPage loginPage=new LoginPage();
    SearchPage searchPage=new SearchPage();
    FavoritePage favoritePage=new FavoritePage();

    @Given("the user is on the main page")
    public void the_user_is_on_the_main_page() {
     loginPage.loginVerify();
    }

    @When("log in with valid credentials")
    public void log_in_with_valid_credentials() { loginPage.signIn(); }

    @When("the user enter {string} information")
    public void the_user_enter_information(String item) { searchPage.searchItem(item); }

    @Then("the user verifies that he sees {string} items in listing")
    public void the_user_verifies_that_he_sees_items_in_listing(String item) {
      searchPage.verifySamsungListing(item);
    }
    @When("select second page")
    public void select_second_page() { searchPage.selectPage(); }

    @Then("second page should be shown")
    public void second_page_should_be_shown() { Assert.assertTrue(Driver.get().getCurrentUrl().contains("sayfa=2")); }

    @When("add third item to favorites")
    public void add_third_item_to_favorites() { favoritePage.addItemToFavorite(); }

    @Then("the selected item should be display")
    public void the_selected_item_should_be_display() { favoritePage.verifyList(); }
    @When("remove item from favorite list")
    public void remove_item_from_favorite_list() { favoritePage.removeFromList(); }

    @Then("item should not be in favorite list")
    public void item_should_not_be_in_favorite_list() {favoritePage.verifyEmptyList(); }

}
