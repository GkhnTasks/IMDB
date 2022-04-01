package com.imdb.pages;

import com.imdb.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashboardPage extends BasePage{

    @FindBy(css = "#imdbHeader-navDrawerOpen--desktop")
    public WebElement menuButtonLocator;

    @FindBy(css = "#home_img_holder")
    public WebElement homePageButtonLocator;

    @FindBy(css = "#suggestion-search")
    public WebElement searchTextBoxLocator;

    @FindBy(xpath = "(//tr//a)[2]")
    public WebElement theCircusMovieLink;

    @FindBy(xpath = "(//tr//a)[2]")
    public WebElement theJazzSingerMovieLink;


    public WebElement getMenuItem(String item){

        WebElement element= Driver.get().findElement(By.xpath("//span[text()='"+item+"']"));
        return element;

    }

}
