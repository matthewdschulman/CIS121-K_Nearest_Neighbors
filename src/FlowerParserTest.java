import static org.junit.Assert.*;

import org.junit.Test;


public class FlowerParserTest {

	@Test
	public void test() {
		Flower[] outputArr = FlowerParser.parse("irisTrainingSet.data");
		assertEquals(120, outputArr.length);
	}

}
