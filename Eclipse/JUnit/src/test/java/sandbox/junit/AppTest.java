package sandbox.junit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import sandbox.junit.utils.Case;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Rule
	public _001_CustomRule myRule = new _001_CustomRule();

	@Test
	@Case()
	public void testMyCustomRule() {
		Assert.assertTrue(true);
	}
}