package hooks;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static final String URL =
            "http://uitestingplayground.com/";

    @Before
    public void setUp() {
        AqualityServices.getBrowser().maximize();
        AqualityServices.getBrowser().goTo(URL);
    }

    @After
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
