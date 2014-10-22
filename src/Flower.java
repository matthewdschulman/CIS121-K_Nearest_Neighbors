import org.junit.Before;

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
		if (training == null || training[0] == null || k < 1) {
			throw new IllegalArgumentException();
		}
		Flower[] normalizedFlowers = getNormalizedFlowers(training);
		BinaryMaxHeap<Flower> heapOfCloseness = new BinaryMaxHeap<Flower>(Flower.class);
		for (int i = 0; i < normalizedFlowers.length; i++) { 
			heapOfCloseness.insert(normalizedFlowers[i]);			
		}
		Flower[] kClosest = new Flower[Math.min(k, heapOfCloseness.size())];
		for (int i = 0; i < k; i++) {
			kClosest[i] = heapOfCloseness.removeMax();
		}
		return kClosest;
	}
	
	private Flower[] getNormalizedFlowers(Flower[] training) {
		double feature0Min = Double.POSITIVE_INFINITY;
		double feature0Max = Double.NEGATIVE_INFINITY;
		double feature1Min = Double.POSITIVE_INFINITY;
		double feature1Max = Double.NEGATIVE_INFINITY;
		double feature2Min = Double.POSITIVE_INFINITY;
		double feature2Max = Double.NEGATIVE_INFINITY;
		double feature3Min = Double.POSITIVE_INFINITY;
		double feature3Max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < training.length; i++) {
			double[] features = training[i].getFeatures();
			if (features[0] < feature0Min) {
				feature0Min = features[0];
			}
			if (features[0] > feature0Max) {
				feature0Max = features[0];
			}
			if (features[1] < feature1Min) {
				feature1Min = features[1];
			}
			if (features[1] > feature1Max) {
				feature1Max = features[1];
			}
			if (features[2] < feature2Min) {
				feature2Min = features[2];
			}
			if (features[2] > feature2Max) {
				feature2Max = features[2];
			}
			if (features[3] < feature3Min) {
				feature3Min = features[3];
			}
			if (features[3] > feature3Max) {
				feature3Max = features[3];
			}
		}
		Flower[] normalizedFlowers = new Flower[training.length];
		for (int i = 0; i < training.length; i++) {
			double[] oldFeatures = training[i].getFeatures();
			double newf0 = ((oldFeatures[0] - feature0Min)/(feature0Max - feature0Min));
			double newf1 = ((oldFeatures[1] - feature1Min)/(feature1Max - feature1Min));
			double newf2 = ((oldFeatures[2] - feature2Min)/(feature2Max - feature2Min));
			double newf3 = ((oldFeatures[3] - feature3Min)/(feature3Max - feature3Min));
			normalizedFlowers[i] = new Flower(newf0, newf1, newf2, newf3, training[i].speciesName);
		}
		return normalizedFlowers;
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