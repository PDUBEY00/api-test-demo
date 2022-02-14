package payments.utilities;

import payments.apiengine.EndPoints;
import payments.dataprovider.ConfigFileReader;

public class TestContext {

	private final EndPoints endPoints;
	private final ScenarioContext scenarioContext;

	public TestContext() {
		endPoints = new EndPoints(ConfigFileReader.getInstance().getBaseUrl());
		scenarioContext = new ScenarioContext();
	}

	public EndPoints getEndPoints() {
		return endPoints;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
