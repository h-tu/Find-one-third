package cmsc351f18;

import java.util.Random;
import java.util.Scanner;
/**
 * Sample Main for you to test your class(es)
 * You don't need to submit this file
 */
public class Main {

	public static void main(String[] args) {
	    System.out.println(" Total   [-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----]");
		System.out.print(" Current [");
		int dot = 0, total = 0, curr = 0, bar = 0;
	    int[] size = new int[]{1000,2000,5000,8000,10000,12000,15000,18000,20000,22000,25000,28000,30000,32000,35000,38000,40000,42000,45000,48000,50000,
                               52000,55000,58000,60000,62000,65000,68000,70000,72000,75000,78000,80000,82000,85000,88000,90000,92000,95000,98000,100000};
	    for(int i = 0; i < size.length; i ++){
            total += size[i];
        }
        dot = total / 100;
	    float[][] result = new float[size.length][];
        for(int i = 0; i < size.length; i ++){
            result[i] = run(size[i],5);
            curr += size[i];
            while(curr >= dot){
                System.out.print("-");
				curr -= dot;
                total -= dot;
				bar ++;
				if(bar == 5){
					if(total > 0){
                        System.out.print("|");
                    }
                    else {
                        System.out.print("]");
                    }
					bar = 0;
				}
            }
        }
        System.out.println("\n|  n  |  log(n)  |  C(n)  |  D(n)  | ");
        for(int i = 0; i < result.length; i++){
            plain(result[i]);
        }
        System.out.println(" -----\nTask completed.");
	}

	private static void plain(float[] result){
        System.out.print(((int)result[0]) + ", ");
        System.out.print( result[3] + ", ");
        System.out.print((result[2]) + ", ");
        System.out.print( result[5] + "\n");
    }

	private static void detail(float[] result){
        System.out.println(" --- k = " + ((int)result[0]) );
        System.out.println(" --- Want: (" + ((int)result[0]) + " + 2) / 3 " );
        System.out.println(" --- " + (((int)result[0]) + 2) + " / 3 = " + ((int)result[0])/3);
        System.out.println(" --- Found " + result[1]);
        System.out.println(" --- Average comparisons: " + result[2]);
        System.out.println(" --- logn for this n is: " + result[3]);
        System.out.println(" --- nlogn for this n is: " + result[4]);
        System.out.println(" --- coeff: " + result[5]);
    }

	private static float[] run(int size , int times){
        float[]result = new float[6];
        result[0] = (float) size;  // Size
        int total = 0;

        float nlogn = ((float)size)*lg(size);
        MartianOracle oracle = new MartianOracle(size);

        for(int tmp = 0; tmp < times; tmp ++){
            int i = 0;
            oracle = new MartianOracle(size);
            int[] input = genRand(size);
            while(i < size) {
                oracle.process(input[i]);
                i ++;
            }
            oracle.query();
            total += oracle.getTotal();
        }

        result[1] = oracle.query();
        result[2] = ((float)total)/((float)times);
        result[3] = lg(size);
        result[4] = nlogn;
        result[5] = result[2]/(nlogn);
        return result;
    }

    private static float lg(int num) {
        return (float) (Math.log(num) / Math.log(2));
    }

	private static int[] genRand(int n){
//        System.out.print("Generating random of size: " + n + "\n");
        int[] lst = new int[n];
        PermutationGenerator p = new PermutationGenerator(new Random((int)(Math.random()*1000)));
        return p.nextPermutation(n);
    }
}
