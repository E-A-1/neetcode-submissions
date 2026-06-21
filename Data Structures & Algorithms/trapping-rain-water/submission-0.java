class Solution {
    public int trap(int[] height) {
       // Brute force solution
       int res = 0;
       if (height.length==0) {
        return res;
       }
       int maxLeft[] = new int[height.length];
       int maxRight[] = new int[height.length];
       int maxL = height[0];
       int maxR = height[height.length-1];
       maxLeft[0] = 0;
       maxRight[height.length-1] = 0;
       for (int i = 1; i<height.length;i++) {
           maxLeft[i] = maxL;
           maxL = Math.max(maxL,height[i]);
           int getIndexForReverse = height.length-1-i;
           maxRight[getIndexForReverse] = maxR;
           maxR = Math.max(maxR,height[getIndexForReverse]);
       }
       for (int i = 0; i<height.length;i++) {
         int area = Math.min(maxLeft[i], maxRight[i]) - height[i];
         if (area > 0) {
            res = res + area;
         }

       }

       return res;
    }
}
