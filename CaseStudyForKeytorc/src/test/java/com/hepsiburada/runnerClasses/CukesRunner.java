package com.hepsiburada.runnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/hepsiburada/stepDefinitions",
        dryRun = true,
        tags = "@hepsiburada",
        plugin = {"html:target/default-cucumber-reports",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt"
}
)
public class CukesRunner {
}
