import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.BasePage;
import org.testng.Assert;

public class PlaylistTests extends BaseTest{

    @Test
    public void renamePlaylist(){
        String playlistName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}
