import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FlowerTest {
	private Flower[] outputArr;
	Flower firstFlower;
	
	@Before
    public void setup()
    {
		outputArr = FlowerParser.parse("irisTrainingSet.data");
		firstFlower = outputArr[0];
    }
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testComputeEuclidean() {
		assertEquals(0.678233, firstFlower.computeEuclidean(outputArr[1]), 0.01);
	}
	
	@Test
	public void testCopmuterEuclideanException() {
		exception.expect(IllegalArgumentException.class);
		firstFlower.computeEuclidean(null);
	}	
	
	@Test
	public void testFaultyFilename() {
		exception.expect(IllegalArgumentException.class);
		@SuppressWarnings("unused")
		Flower[] faultyFileArr = FlowerParser.parse("iamnotafilename.data");
	}
	
	@Test
	public void testCompareTo() {
		//assertEquals(-1, firstFlower.compareTo(outputArr[2]));
	}
}
