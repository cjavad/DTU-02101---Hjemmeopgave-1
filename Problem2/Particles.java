import java.util.*;

public class Particles {
	public static void runSimulation(int n, int s, int t) {
		Random rand = new Random();
		System.out.println("n=" + n + " s=" + s + " t=" + t);

		// Placerer partiklerne på tilfældige felter
		int[][] p = new int[3][2];
		for (int[] is : p) {
			is[0] = rand.nextInt(n);
			is[1] = rand.nextInt(n);
		}

		// Selve simuleringen
		for (int i = 0; i < t; i++) {
			//Partiklerne rykker
			for (int[] is : p) {
				is[0] = clamp(is[0] += rand.nextInt(2*s+1)-s, 0, n - 1);
				is[1] = clamp(is[1] += rand.nextInt(2*s+1)-s, 0, n - 1);
			}

			// Printer move nummer og positioner
			System.out.print("move " + (i + 1) + ", positions");
			for (int j = 0; j < 3; j++) {
				System.out.print(" P" + (j + 1) + "=[" + p[j][0] + ';' + p[j][1] + ']');
			}
			System.out.println("");
		}
	}

	//En klassisk clamp metode, der sørger for at en værdi er inden for specificerede grænser
	static int clamp(int tal, int lav, int høj) {
		if (tal > høj)
			return høj;
		else if (tal < lav)
			return lav;
		else
			return tal;
	}
}