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
		Flower flower = new Flower(1.23, 34.2, 234.5, 23.5, null);
	}	
	
	@Test
	public void testKNNkIsNegativeException() {
		exception.expect(IllegalArgumentException.class);
		Flower[] flowers = firstFlower.kNN(outputArr, -1);
	}	
	
	@Test
	public void testKNNTrainingIsNullException() {
		exception.expect(IllegalArgumentException.class);
		Flower[] flowers = firstFlower.kNN(null, 10);
	}	
	
	@Test
	public void testKNNTrainingIsEmptyException() {
		exception.expect(IllegalArgumentException.class);
		Flower[] emptyArr = new Flower[10];
		Flower[] flowers = firstFlower.kNN(emptyArr, 10);
	}	
	
	@Test
	public void testUpdateThisTestAndGetThisTest() {
		assertEquals(firstFlower, firstFlower.getThisTest(firstFlower));
		firstFlower.updateThisTest(outputArr[1]);
		assertEquals(outputArr[1], firstFlower.getThisTest(firstFlower));
	}	
	
	@Test
	public void getNormalizedDataTest() {
		Flower[] normalized = firstFlower.getNormalizedFlowers(outputArr);
		Flower firstNormal = normalized[0];
		assertEquals(0.30555, firstNormal.getFeatures()[0], 0.01);
	}	
	
	@Test
	public void testGetFeatures() {
		double[] features = firstFlower.getFeatures();
		System.out.println(features[0]);
		assertEquals(5.4, features[0], 0.01);
	}
	
	@Test
	public void testFlowerInstantiationException() {
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
		firstFlower.updateThisTest(outputArr[2]);
		assertEquals(-1, firstFlower.compareTo(outputArr[1]));
	}
	
	@Test
	public void testCompareToWithValidNeighborButNullG() {
		firstFlower.updateThisTest(outputArr[2]);
		exception.expect(IllegalArgumentException.class);
		assertEquals(1, firstFlower.compareTo(null));
	}	
	
	@Test
	public void testPredictNormalCaseWithOneLeader() {
		Flower[] newArr = new Flower[4];
		newArr[0] = outputArr[0];
		for (int i = 1; i < 4; i++) {
			newArr[i] = outputArr[i*30];
		}
		assertEquals("Iris-setosa", Flower.predict(newArr));
	}
	
	@Test
	public void testPredictNormalCaseWithATie() {
		Flower[] newArr = new Flower[6];
		for (int i = 0; i < 6; i++) {
			newArr[i] = outputArr[i*20 + 1];
		}
		assertEquals("Iris-virginica", Flower.predict(newArr));
	}
	
	@Test
	public void testPredictWithOneFlower() {
		Flower[] newArr = new Flower[1];
		newArr[0] = outputArr[41];
		assertEquals("Iris-versicolor", Flower.predict(newArr));
	}
	
	@Test
	public void testPredictWithNullInput() {
		exception.expect(IllegalArgumentException.class);
		Flower.predict(null);
	}
	
	@Test
	public void testPredictWithEmptyInput() {
		Flower[] newArr = new Flower[12];
		exception.expect(IllegalArgumentException.class);
		Flower.predict(newArr);
	}
	
	@Test
	public void testKNNReturnsCorrectSize() {
		Flower flowerOfInterest = outputArr[51];
		Flower[] neighbors = new Flower[50];
		for (int i = 0; i < 50; i++) {
			neighbors[i] = outputArr[i];
		}
		Flower[] kClosest = flowerOfInterest.kNN(neighbors, 10);
		for (int i = 0; i < 10; i++) {
			System.out.println(kClosest[i].getSpeciesName());
		}
	}
	
	@Test 
	public void testKNNR() {
		int toggleNumberOfNeighbors = 25;
		Flower flowerOfInterest = outputArr[0];
		Flower[] neighbors = new Flower[toggleNumberOfNeighbors];
		for (int i = 1; i < toggleNumberOfNeighbors + 1; i++) {
			neighbors[i-1] = outputArr[i];
			//neighbors[i-1].updateThisSpecies(Integer.toString(i-1));
		}
		for (int i = 0; i < toggleNumberOfNeighbors; i++) {
			System.out.println(flowerOfInterest.computeEuclidean(neighbors[i]) + " " + neighbors[i].getSpeciesName());
		}
		System.out.println("____");
		Flower[] kClosest = flowerOfInterest.kNN(neighbors, 2);
		for (int i = 0; i < 2; i++) {
			System.out.println(kClosest[i].getFeatures()[0] + " " + kClosest[i].getSpeciesName());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPredict() {
		int toggleNumberOfNeighbors = 40;
		Flower flowerOfInterest = outputArr[0];
		Flower[] neighbors = new Flower[toggleNumberOfNeighbors];
		for (int i = 1; i < toggleNumberOfNeighbors + 1; i++) {
			neighbors[i-1] = outputArr[i];
		}
		for (int i = 0; i < toggleNumberOfNeighbors; i++) {
			System.out.println(flowerOfInterest.computeEuclidean(neighbors[i]) + " " + neighbors[i].getSpeciesName());
		}
		System.out.println("____");
		Flower[] kClosest = flowerOfInterest.kNN(neighbors, 10);
		System.out.println("HERHEHRE");
		for (int i = 0; i < 5; i++) {
			System.out.println(kClosest[i].getFeatures()[0] + " " + kClosest[i].getSpeciesName());
		}
		Flower[] arrOfToPredict = FlowerParser.parse("irisTestSet.data");
		assertEquals("Iris-setosa", arrOfToPredict[0].predict(kClosest));
	}
	
}
