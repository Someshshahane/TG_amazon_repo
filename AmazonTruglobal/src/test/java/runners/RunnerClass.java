package runners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/RunnerClass/cucumber.json", 
        		"pretty", "html:target/RunnerClass/cucumber.html",
        		},
        features = "src/test/resources/FeaturesFiles/AddToCart.feature",
        glue = {"stepdefinitions"},
        tags = "@Add-To-Cart"
        )
public class RunnerClass extends AbstractTestNGCucumberTests{
	
	@BeforeClass
    public static void setup() {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String fileName = System.getProperty("user.dir")+"\\target\\Extent_Reports\\" + strDate+".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);
		
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "Version 120.0.6099.110");

	}
}
