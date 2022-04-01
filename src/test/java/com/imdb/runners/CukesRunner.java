package com.imdb.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-html-reports",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/features",
        glue = "com/imdb/step_definitions" ,
        dryRun = false,
        tags = "@runAll"
)
public class CukesRunner {
}
