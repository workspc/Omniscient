package sandbox.junit;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class _001_ExternalRulesExample {

	// private String testCase;
	private int first;
	private int second;
	private int expected;

	public _001_ExternalRulesExample(String testCase, int first, int second, int expected) {
		// this.testCase = testCase;
		this.first = first;
		this.second = second;
		this.expected = expected;
	}

	@Parameters(name = "{0}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {

				{ "Case-1", 0, 0, 0 },

				{ "Case-2", 1, 1, 2 },

				{ "Case-3", 2, 1, 3 },

				{ "Case-4", 3, 2, 5 },

				{ "Case-5", 4, 3, 7 },

				{ "Case-6", 5, 5, 10 },

				{ "Case-7", 6, 8, 14 }

		});
	}

	// @Rule
	// public final ExternalResource resource = new ExternalResource() {
	// @Override
	// protected void before() throws Throwable {
	// myServer.connect();
	// };
	//
	// @Override
	// protected void after() {
	// myServer.disconnect();
	// };
	// };

	@Test
	public void testParams() throws Exception {
		Assert.assertEquals("Not Equal", expected, first + second);
	}
}
