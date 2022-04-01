package com.imdb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MoviePage extends BasePage{

    @FindBy(xpath = "//a[@data-testid='photos-title']")
    public WebElement moviePhotosLinkLocator;

    @FindBy(xpath = "//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link']")
    public List<WebElement> movieInformationLocators;

    @FindBy(css = "a[href^='/title/tt0018773/mediaviewer/']>img")
    public List<WebElement> theCircusImagesInPhotosPage;

    @FindBy(css = "a[href^='/title/tt0018037/mediaviewer/']>img")
    public List<WebElement> theJazzSingerImagesInPhotosPage;

}
