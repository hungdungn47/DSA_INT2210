package Leetcode;
import java.util.*;
public class Area {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[][] land = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                land[i][j] = in.nextInt();
            }
        }

        System.out.println(findMaxRectangle(land, N, M));
    }

    public static int largestRectangleInHistogram(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightSmaller[i] = n - 1;
            } else {
                rightSmaller[i] = stack.peek() - 1;
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int width = rightSmaller[i] - leftSmaller[i] + 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int findMaxRectangle(int[][] land, int rows, int cols) {
        if (rows == 0 || cols == 0) return 0;

        int maxArea = 0;
        int[] height = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            int area = largestRectangleInHistogram(height);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}