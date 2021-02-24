package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "features/homeTest.feature" }, 
					glue = { "steps" }, 
					//tags = {"" }, 
					monochrome = true, 
					dryRun = false, 
					plugin = { "pretty", "html:cucmberReports/webReport",
				"json:cucmberReports/jsonreport.json",
				"de.monochromata.cucumber.report.PrettyReports:target/cucumber", })

public class Runner {
	@AfterClass
	public static void JVMreports() {
		File reportOutputDirectory = new File("report/maven-JVM-Report");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("cucmberReports/jsonreport.json");//json path

		String buildNumber = "1";
		String projectName = "GudSho";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setBuildNumber(buildNumber);
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "chrome");
		configuration.setSortingMethod(SortingMethod.NATURAL);
		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
		//configuration.setTrendsStatsFile(new File(""));
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		

	}
	

	
}
