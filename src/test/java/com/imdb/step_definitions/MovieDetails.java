package com.imdb.step_definitions;

import com.imdb.pages.AcademyAwardsPage;
import com.imdb.pages.DashboardPage;
import com.imdb.pages.MoviePage;
import com.imdb.pages.OscarsGuidePage;
import com.imdb.utilities.BrowserUtils;
import com.imdb.utilities.ConfigurationReader;
import com.imdb.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@Slf4j
public class MovieDetails {

    String director,writer,stars;
    DashboardPage dashboardPage=new DashboardPage();
    OscarsGuidePage oscarsGuidePage = new OscarsGuidePage();
    AcademyAwardsPage academyAwardsPage = new AcademyAwardsPage();
    MoviePage moviePage =new MoviePage();

    @Given("the user is on the main page")
    public void the_user_is_on_the_main_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("click on Menu")
    public void clickOnMenu() {

        BrowserUtils.waitForVisibility(dashboardPage.menuButtonLocator,20);
        dashboardPage.menuButtonLocator.click();

    }

    @And("click on {string} in Menu")
    public void clickOnInMenu(String itemForClick) {

        BrowserUtils.waitForVisibility(dashboardPage.getMenuItem(itemForClick),20);
        dashboardPage.getMenuItem(itemForClick).click();

    }

    @And("click on {string} in Events History")
    public void clickOnInEventsHistory(String year) {

        BrowserUtils.waitForVisibility(oscarsGuidePage.getEventHistory(year),20);
        oscarsGuidePage.getEventHistory(year).click();

    }

    @And("click on {string} in page")
    public void clickOnInPage(String text) {

        BrowserUtils.waitForVisibility(academyAwardsPage.getLocatorWithText(text),20);
        academyAwardsPage.getLocatorWithText(text).click();

    }

    @And("save {string} information")
    public void saveInformation(String movie) {

        BrowserUtils.waitFor(10);

        if(movie.equals("The Circus")) {

            this.director = moviePage.movieInformationLocators.get(0).getText();
            this.writer = moviePage.movieInformationLocators.get(1).getText();
            this.stars = moviePage.movieInformationLocators.get(2).getText() + ","
                    + moviePage.movieInformationLocators.get(3).getText() + ","
                    + moviePage.movieInformationLocators.get(4).getText();

        }else if(movie.equals("The Jazz Singer")) {
            this.director = moviePage.movieInformationLocators.get(0).getText();
            this.writer = moviePage.movieInformationLocators.get(1).getText() + ","
                    + moviePage.movieInformationLocators.get(2).getText() + ","
                    + moviePage.movieInformationLocators.get(3).getText();
            this.stars = moviePage.movieInformationLocators.get(4).getText() + ","
                    + moviePage.movieInformationLocators.get(5).getText() + ","
                    + moviePage.movieInformationLocators.get(6).getText();

        }

        log.info("director = " + director);
        log.info("writer = " + writer);
        log.info("stars = " + stars);
    }

    @When("click on Home Page")
    public void clickOnHomePage() {

        BrowserUtils.waitForVisibility(dashboardPage.homePageButtonLocator,20);
        dashboardPage.homePageButtonLocator.click();

    }

    @When("search {string} movie")
    public void search_movie(String movieName) {

        BrowserUtils.waitForVisibility(dashboardPage.searchTextBoxLocator,20);
        dashboardPage.searchTextBoxLocator.sendKeys(movieName, Keys.ENTER);

    }

    @And("click on {string} in search")
    public void clickOnInSearch(String movie) {

        if(movie.equals("The Circus")){
            dashboardPage.theCircusMovieLink.click();
        }else if(movie.equals("The Jazz Singer")){
            BrowserUtils.waitForVisibility(dashboardPage.theJazzSingerMovieLink,20);
            dashboardPage.theJazzSingerMovieLink.click();
        }
    }

    @Then("compare {string} director, writer and stars")
    public void compareDirectorWriterAndStars(String movie) {

        BrowserUtils.waitFor(3);
        if(movie.equals("The Circus")){
            Assert.assertEquals(this.director, moviePage.movieInformationLocators.get(0).getText());
            Assert.assertEquals(this.writer, moviePage.movieInformationLocators.get(1).getText());
            Assert.assertEquals(this.stars, moviePage.movieInformationLocators.get(2).getText() + ","
                    + moviePage.movieInformationLocators.get(3).getText() + ","
                    + moviePage.movieInformationLocators.get(4).getText());

        }else if(movie.equals("The Jazz Singer")){
            Assert.assertEquals(this.director,moviePage.movieInformationLocators.get(0).getText());
            Assert.assertEquals(this.writer,moviePage.movieInformationLocators.get(1).getText() + ","
                    + moviePage.movieInformationLocators.get(2).getText() + ","
                    + moviePage.movieInformationLocators.get(3).getText());
            Assert.assertEquals(this.stars,moviePage.movieInformationLocators.get(4).getText() + ","
                    + moviePage.movieInformationLocators.get(5).getText() + ","
                    + moviePage.movieInformationLocators.get(6).getText());
        }
    }

    @When("click on See all photos")
    public void clickOnSeeAllPhotos() {

        BrowserUtils.waitForVisibility(moviePage.moviePhotosLinkLocator,20);
        moviePage.moviePhotosLinkLocator.click();

    }

    @Then("check links are not broken {string}")
    public void checkLinksAreNotBroken(String movie) {

        BrowserUtils.waitFor(10);

        if(movie.equals("The Circus")) {
            for (WebElement eachImage : moviePage.theCircusImagesInPhotosPage) {

                Assert.assertTrue(Integer.parseInt(eachImage.getAttribute("naturalWidth")) > 0);
                log.info(eachImage.getAttribute("naturalWidth"));
            }
        }else if(movie.equals("The Jazz Singer")) {
            for (WebElement eachImage : moviePage.theJazzSingerImagesInPhotosPage) {

                Assert.assertTrue(Integer.parseInt(eachImage.getAttribute("naturalWidth")) > 0);
                log.info(eachImage.getAttribute("naturalWidth"));
            }
        }
    }
}
