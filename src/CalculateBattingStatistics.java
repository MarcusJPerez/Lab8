import java.util.Scanner;

public class CalculateBattingStatistics {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char idLoop = 'y';
		while((idLoop ==  'y')){
		int numBatters = Validator.getInt(scan, "Enter number of batters: ", 1, Integer.MAX_VALUE);
		int[][] statChart = new int[numBatters][];

		getAtBats(scan, statChart);

		for (int i = 0; i < statChart.length; i++) {
			System.out.printf("Batter %d   batting average: %.3f   slugging percentage: %.3f\n", i + 1,
					batAvg(statChart[i]), slugPercentage(statChart[i]));
					}
		
		System.out.println("Would you like find more stats?(Y/N)");
		while (!scan.hasNext("[yYnN]")) {
			System.out.println("Enter y to find more stats or n to quit");
			scan.next();
		}
			idLoop = scan.next().charAt(0);
		
	}
		System.out.println("Goodbye!");
	}

	private static void getAtBats(Scanner scan, int[][] statChart) {
		for (int i = 0; i < statChart.length; i++) {

			int atBats = Validator.getInt(scan, "Enter number of at bats for batter " + (i) + ": ", 1,
					Integer.MAX_VALUE);
			statChart[i] = new int[atBats];
			System.out.println();

			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
			for (int j = 0; j < statChart[i].length; j++) {
				statChart[i][j] = Validator.getInt(scan, "Result for at-bat " + j + ": ", 0, 4);
			}
			
		}
	}

	public static double batAvg(int[] atBats) {
		int count = 0;

		for (int bat : atBats) {
			if (bat > 0) {
				count++;
			}
		}
		return (double) count / atBats.length;
	}

	public static double slugPercentage(int[] atBats) {
		int sum = 0;

		for (int bat : atBats) {
			sum += bat;
		}
		return (double) sum / atBats.length;
	}
}