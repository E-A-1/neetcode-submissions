class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSellingDay = prices[0];
        // DP
        for (int i = 1; i<prices.length; i++) {
            maxProfit = Math.max(prices[i] - minSellingDay, maxProfit);
            minSellingDay = Math.min(prices[i], minSellingDay);
        }


        return maxProfit;
    }
}
