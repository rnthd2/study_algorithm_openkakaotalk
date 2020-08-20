package leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		System.out.println(containerWithMostWater.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public int maxArea(int[] height) {
		double result = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				result = Math.max(Math.min(height[i],height[j])*(j-i),result);
			}
		}
		return (int)result;
	}
}
