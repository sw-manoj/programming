package easyprob;

public class CountPrime {

	public static void main(String[] args) {

		CountPrime obj = new CountPrime();
		System.out.println(obj.countPrimes(10));
	}
	public int countPrimes(int n) {
		int count=0;
		boolean arr[]=new boolean[n];

		for (int num = 2; num < n; num++)  {
			if (arr[num]) continue;

			count++;
			for(long j = (long)num*num; j<n; j+=num) {
				arr[(int)j]=true;
			}
		}
		return count;
	}

}
