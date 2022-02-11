package steps;

import utilities.Driver;
import cucumber.api.java.After;

public class Hooks {

    @After
    public void tearDown(){
    Driver.quitDriver();
}
}
