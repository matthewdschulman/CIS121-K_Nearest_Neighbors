import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FlowerParserTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testParser() {
		Flower[] outputArr = FlowerParser.parse("irisTrainingSet.data");
		assertEquals(120, outputArr.length);
		Flower firstFlower = outputArr[0];
		assertEquals(5.4, firstFlower.getFeatures()[0], 0.01);
		Flower lastFlower = outputArr[outputArr.length - 1];
		assertEquals(2.1, lastFlower.getFeatures()[3], 0.01);
	}
	
	@Test
	public void testFaultyFilename() {
		exception.expect(IllegalArgumentException.class);
		Flower[] faultyFileArr = FlowerParser.parse("iamnotafilename.data");
	}

}
