
public class Array_problems {
	
	public static void main(String[] args) {
		int num[] = {0, 5, 6, 2, 4, 3};
		printArray(num);
		printArray(arrangeArray(num));
	}
	
	// input - array of integers
	// arrange the array in such a way that the odds are in the end of the array followed by evens
	public static int[] arrangeArray(int[] nums) {
		int evenEnd = 0;
		int oddEnd = nums.length-1;
		while (evenEnd != oddEnd) {
			if (nums[evenEnd] % 2 == 0) {
				evenEnd += 1;
			}
			else {
				int tmp = nums[evenEnd];
				nums[evenEnd] = nums[oddEnd];
				nums[oddEnd] = tmp;
				oddEnd--;
			}
		}
		return nums;
	}
	
	public static void printArray(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}
	
}
