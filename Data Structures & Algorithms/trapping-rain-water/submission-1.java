class Solution {
    public int trap(int[] height) {
       // Brute force solution
       int res = 0;
       if (height.length==0) {
        return res;
       }
       int maxL = height[0];
       int maxR = height[height.length-1];
       int left = 1;
       int right = height.length-2;
       boolean lPass = maxL > maxR ? false : true;
       while (left < right) {
        int response = 0;
         if (lPass) {
            maxL = Math.max(height[left-1], maxL);
            response = maxL - height[left];

         }
         else {
            maxR = Math.max(height[right+1], maxR);
            response = maxR - height[right];
         }
         if (maxL > maxR) {
            right--;
            lPass = false;
         }
         else {
            left++;
            lPass = true;
         }
         if (response > 0) {
            res = res + response;
         }
       }

       return res;
    }
}
