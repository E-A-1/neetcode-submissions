class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] response = new int[nums.length];
        // Optimal solution
        response[0] = 1;
        for (int i = 1; i<nums.length;i++) {
            response[i] = response[i-1]*nums[i-1];
        }
        int post = 1;
        for (int i=nums.length-1;i>=0;i--) {
            response[i] = response[i] * post;
            post *= nums[i]; 
        }

        return response;
    }
}  
