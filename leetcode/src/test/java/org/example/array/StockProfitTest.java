package org.example.array;

public class StockProfitTest {

    public static void main(String[] args) {
        StockProfit solution = new StockProfit();

        // Test cases
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {1, 2, 3, 4, 5};

        System.out.println(solution.maxProfit(prices1)); // Expected output: 5
        System.out.println(solution.maxProfit(prices2)); // Expected output: 0
        System.out.println(solution.maxProfit(prices3)); // Expected output: 4
    }
}
