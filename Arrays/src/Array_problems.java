import java.util.Arrays;

public class Array_problems {
	
	public static void main(String[] args) {
		int num[] = {1, 4, 0, 0, 3, 10, 5};
		System.out.print(Arrays.toString(findSum(num, 7)));
		/**
		printArray(num);
		printArray(arrangeArray(num));
		int[] num2 = {1, 2, 3};
		printArray(num2);
		rotate(num2, 1);
		printArray(num2);
		**/
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

	public static void rotate(int[] nums, int k) {
		if (k > nums.length) k = nums.length - 1;
        int p = nums.length-k;
        int j = 1;
        while (p != nums.length) {
            int store = nums[p];
            for (int i = p; i >= j; i--) {
                nums[i] = nums[i-1];
            }
            nums[j-1] = store;
            j++;
            p++;
        }      
    }
	
	// Find subarray with given sum
	public static int[] findSum(int[] arr, int sum) {
		int total_sum = arr[0];
		int start = 0;
		for (int i = 1; i < arr.length; i++) {
			while (total_sum > sum) {
				total_sum -= arr[start]; 
				start++;
			}
			if (total_sum == sum) {
				return Arrays.copyOfRange(arr, start, i);
			}
			total_sum += arr[i];
		}
		return null;
	}
	
	
}
