package easyprob;

//https://leetcode.com/problems/can-place-flowers/
public class CanPlaceFlowers {
	public static void main(String[] args) {
		CanPlaceFlowers obj = new CanPlaceFlowers();
		System.out.println(obj.canPlaceFlowers(new int[] {0,0,1,0,0}, 1));
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
		for(int i = 0 ; i < len && n > 0; i++)
		{
			if(flowerbed[i] == 1)
			{
				continue;
			}
			if((i == 0 || flowerbed[i-1] != 1) && (i == len-1 || flowerbed[i+1] != 1))
			{
				flowerbed[i] = 1;
				n--;
			}
		}
		return n == 0;
    }
}
