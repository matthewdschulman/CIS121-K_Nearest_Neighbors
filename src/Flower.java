/**
 * A class to represent a Flower, and various methods on it.
 * @author Max Scheiber (scheiber), 14fa
 */
public class Flower implements Comparable<Flower> {
	private double[] thisFeatures;
	private String speciesName;
	private Flower neighbor;
	/**
	 * @param label The flower's species.
	 * @throws IllegalArgumentException is label is null.
	 */
	public Flower(double f0, double f1, double f2, double f3, String label) {
		if (label == null) {
			throw new IllegalArgumentException();
		}
		thisFeatures = new double[4];
		thisFeatures[0] = f0;
		thisFeatures[1] = f1;
		thisFeatures[2] = f2;
		thisFeatures[3] = f3;
		speciesName = label;
	}

	/**
	 * @param features f0, f1, f2, and f3.
	 * @param label The flower's species.
	 * @throws IllegalArgumentException if features is not length 4, or label is null.
	 */
	public Flower(double[] features, String label) {
		thisFeatures = features;
		speciesName = label;
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
	
	public void updateNeighbor(Flower newNeighbor) {
		this.neighbor = newNeighbor;
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
		return thisFeatures;
	}

	@Override
	/**
	 * Should compare the distance between this and the test point to g and the test point.
	 */
	//returns 1 is (f -> neighbor distance) > (g -> neighbor distance) and -1 if "" < ""
	//throws IllegalArgumentException if g is null
	//throws IllegalStateException if this.neighbor is null
	public int compareTo(Flower g) {
		if (g == null) {
			throw new IllegalArgumentException();
		}
		if (this.neighbor == null) {
			throw new IllegalStateException("this.neighbor is null");
		}
		if ((this.computeEuclidean(this.neighbor) - g.computeEuclidean(this.neighbor) > 0)) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * @return the Euclidean distance between this and g (NOT the test point and g).
	 * @throws IllegalArgumentException is g is null.
	 */
	double computeEuclidean(Flower g) {
		if (g == null) {
			throw new IllegalArgumentException();
		}
		double[] fFeatures = this.getFeatures();
		double[] gFeatures = g.getFeatures();
		
		return (Math.sqrt(Math.pow(fFeatures[0] - gFeatures[0], 2) + 
				Math.pow(fFeatures[1] - gFeatures[1], 2) + 
				Math.pow(fFeatures[2] - gFeatures[2], 2) + 
				Math.pow(fFeatures[3] - gFeatures[3], 2)));
	}
}