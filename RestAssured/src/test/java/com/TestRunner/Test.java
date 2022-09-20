package com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
features = "src/main/java/com/FeatureFiles",
glue = "StepDefenition")

public class Test extends AbstractTestNGCucumberTests {
	 
	}