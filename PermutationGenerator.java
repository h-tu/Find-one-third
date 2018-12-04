package PACKAGENAME;

import java.util.Random;

public class PermutationGenerator {
	final private Random m_random;
	PermutationGenerator(Random random) {
		m_random = random;
	}
	
	public int[] nextPermutation(int n) {
//		System.out.println("|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
//		System.out.print("|");
//		int next = n/100;
//		int bar = 0;
		int tmp = this.m_random.nextInt(n-1);
		int[] result = new int[n];
		for(int i = 1; i <= n; i ++){
//			if(i == next){
//				System.out.print("-");
//				next += n/100;
//				bar ++;
//				if(bar == 5){
//					System.out.print("|");
//					bar = 0;
//				}
//			}
//			System.out.print(i + " -> ");
			while(result[tmp] != 0){
				tmp = this.m_random.nextInt(n);
			}
//			System.out.println(tmp);
			result[tmp] = i;
		}
		return result;
	}
}
