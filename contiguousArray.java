import java.util.Scanner;

public class contiguousArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the binary array: ");
        String binaryString = scanner.nextLine();

        int[] nums = new int[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            nums[i] = Character.getNumericValue(binaryString.charAt(i));
        }

        System.out.println("Maximum length of contiguous subarray: " + findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int sum = 0;
        // Map to store the sum and its first occurrence index
        java.util.Map<Integer, Integer> sumIndexMap = new java.util.HashMap<>();

        sumIndexMap.put(0, -1); // Initialize with sum 0 at index -1

        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (sumIndexMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        return maxLength;
    }
}
