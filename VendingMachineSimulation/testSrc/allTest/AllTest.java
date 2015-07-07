package allTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTest extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(controlTest.Suite.suite());
		suite.addTest(modelTest.Suite.suite());
		suite.addTest(startupTest.Suite.suite());
		suite.addTest(viewTest.Suite.suite());
		return suite;
	}

}
