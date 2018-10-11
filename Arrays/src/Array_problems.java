
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
	
	public static void rotateArray(int[][] matrix, int n) {
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
	
}
