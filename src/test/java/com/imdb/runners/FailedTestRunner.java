package com.imdb.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report"},
        features = "@target/rerun.txt",
        glue = "com/imdb/step_definitions"

)
public class FailedTestRunner {

}
