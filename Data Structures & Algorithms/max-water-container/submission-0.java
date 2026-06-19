class Solution {
    public int maxArea(int[] heights) {
        int area = 0;

        int i = 0;
        int j = heights.length - 1;
        
        while (i < j) {
            int newArea = Math.min(heights[i], heights[j]) * (j-i);
            area = Math.max(area, newArea);

            if(heights[i] < heights[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return area;
    }
}
