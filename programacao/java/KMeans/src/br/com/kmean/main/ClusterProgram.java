package br.com.kmean.main;

public class ClusterProgram {

	public static void main(String[] args) {

		System.out.println("\nBegin k-means clustering demo\n");
		double[][] rawData = new double[10][];
		rawData[0] = new double[] { 73, 72.6 };
		rawData[1] = new double[] { 61, 54.4 };
		rawData[2] = new double[] { 67, 99.9 };
		rawData[3] = new double[] { 68, 97.3 };
		rawData[4] = new double[] { 62, 59.0 };
		rawData[5] = new double[] { 75, 81.6 };
		rawData[6] = new double[] { 74, 77.1 };
		rawData[7] = new double[] { 66, 97.3 };
		rawData[8] = new double[] { 68, 93.3 };
		rawData[9] = new double[] { 61, 59.0 };

		System.out.println("Raw unclustered data:\n");
		System.out.println("ID heigh(in. Weight (kg.)");
		System.out.println("--------------------------");
		showData(rawData, 1, true, true);
		int numClusters = 3;
		System.out.println("\nSetting numClusters to " + numClusters);
		System.out.println("\nStarting clustering using k-means algorithm");
		Clusterer c = new Clusterer(numClusters);
		int[] clustering = c.cluster(rawData);
		System.out.println("Clustering complete\n");
		System.out.println("Final clustering in internal form:\n");
		showVector(clustering, true);
		System.out.println("Rw data by cluster:\n");
		showClustered(rawData, clustering, numClusters, 1);
		System.out.println("\nEnd k-means clustering demo\n");

	}

	private static void showData(double[][] data, int decimals, boolean indices, boolean newLine) {
		for (int i = 0; i < data.length; ++i) {
			if (indices == true)
				System.out.print(i + "\t");
			for (int j = 0; j < data[i].length; ++j) {
				double v = data[i][j];
				System.out.printf("%." + decimals + "f  ", v);
			}
			System.out.println(" ");
		}
		if (newLine == true)
			System.out.println("\n");

	}

	private static void showClustered(double[][] data, int[] clustering, int numClusters, int decimals) {
		for (int k = 0; k < numClusters; k++) {
			System.out.print("=================");
			for (int i = 0; i < data.length; ++i) {
				int clusterId = clustering[i];
				if (clusterId != k)
					continue;
				System.out.println(i + "\t");
				for (int j = 0; j < data[i].length; ++j) {
					double v = data[i][j];
					System.out.printf("%." + decimals + "f", v);

				}
				System.out.print(" ");

			}
			System.out.print("=================");
		}

	}

	private static void showVector(int[] clustering, boolean newLine) {
		for (int i = 0; i < clustering.length; ++i) {
			System.out.print(clustering[i] + " ");
			if (newLine == true) {
				System.out.println("\n");
			}
		}

	}

}
