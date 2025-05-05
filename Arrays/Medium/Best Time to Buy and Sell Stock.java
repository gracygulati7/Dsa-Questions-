// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int cp=prices[0]; int profit=0;
        for(int i=0;i<prices.length;i++){
            cp=Math.min(cp,prices[i]);
            profit=Math.max(profit,prices[i]-cp);
        }
        return profit;
    }
}
