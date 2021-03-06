package cucumber.tests;

import com.smartframework.code.core.fruitsalad.testing.steps.AbstractStepDef;
import cucumber.tests.config.SpringConfig;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {SpringConfig.class}, inheritLocations = true)
public class AbstractContextStepDefs extends AbstractStepDef {

}
