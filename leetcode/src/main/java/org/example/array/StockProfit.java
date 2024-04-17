package org.example.array;
//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//
//
//示例 1：
//
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
public class StockProfit {
    public int maxProfit(int[] prices) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                int price = prices[j] - prices[i];
//                max = Math.max(max,price);
//            }
//        }
//        int i = (max > 0) ? max : 0;
//        return i;
//        int minPrice = Integer.MAX_VALUE;
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if(prices[i]<minPrice) {
//                minPrice = prices[i];
//            }else if (prices[i] - minPrice > max) {
//                max = prices[i] - minPrice;
//            }
//        }
//        return max;



        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
