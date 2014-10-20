/**
 * A class to represent a Flower, and various methods on it.
 * @author Max Scheiber (scheiber), 14fa
 */
public class Flower implements Comparable<Flower> {
	/**
	 * @param label The flower's species.
	 * @throws IllegalArgumentException is label is null.
	 */
	public Flower(double f0, double f1, double f2, double f3, String label) {
		// TODO: unimplemented
	}

	/**
	 * @param features f0, f1, f2, and f3.
	 * @param label The flower's species.
	 * @throws IllegalArgumentException if features is not length 4, or label is null.
	 */
	public Flower(double[] features, String label) {
		// TODO: unimplemented
	}

	/**
	 * @param training The training data points
	 * @param k parameter for kNN
	 * @return the normalized k nearest Flowers
	 * @throws IllegalArgumentException if training is null/empty or if
	 * 		k is not positive.
	 */
	public Flower[] kNN(Flower[] training, int k) {
		// TODO: unimplemented
		return null;
	}

	/**
	 * @return the majority label of the inputted labels. If there is a tie,
	 *		return any one of the correct labels.
	 * @throws IllegalArgumentException if neighbors is null/empty.
	 */
	public static String predict(Flower[] neighbors) {
		// TODO: unimplemented
		return null;
	}

	/**
	 * @return a length-four array of features f0, f1, f2, and f3.
	 */
	public double[] getFeatures() {
		// TODO: unimplemented
		return null;
	}

	@Override
	/**
	 * Should compare the distance between this and the test point to g and the test point.
	 */
	public int compareTo(Flower g) {
		// TODO: unimplemented
		return -1;
	}

	/**
	 * @return the Euclidean distance between this and g (NOT the test point and g).
	 * @throws IllegalArgumentException is g is null.
	 */
	double computeEuclidean(Flower g) {
		// TODO: unimplemented
		return -1;
	}
}