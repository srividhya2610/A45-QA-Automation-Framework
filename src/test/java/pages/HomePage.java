package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) { super(givenDriver); }

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;

    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;

//    @FindBy(xpath = "//a[text()="+"playlistName"+"']")
//    private WebElement newPlaylist;

    //By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");

    //By playlistNameField = By.cssSelector("[name='name']");

    public void doubleClickPlaylist() { doubleClick(firstPlaylist); }
    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
        //By newPlaylist = By.xpath("//a[text()="+playlistName+"']");
       // newPlaylist.sendKeys(playlistName);
        //return newPlaylist.isDisplayed();
        By newPlaylist = By.xpath("//a[text()="+playlistName+"']");
        return findElement(newPlaylist).isDisplayed();
    }
}
