class Solution {
    public int trap(int[] height) {
       // Optimal solution
       int res = 0;
       if (height.length==0) {
        return res;
       }
       int maxL = height[0];
       int maxR = height[height.length-1];
       int left = 1;
       int right = height.length-2;
       boolean lPass = maxL > maxR ? false : true;
       while (left <=right) {
        int response = 0;
         if (maxL <= maxR ) {
            maxL = Math.max(height[left], maxL);
            response = maxL - height[left];
            left++;
         }
         else {
            maxR = Math.max(height[right], maxR);
            response = maxR - height[right];
            right--;
         }

         if (response > 0) {
            res = res + response;
         }
       }

       return res;
    }
}
