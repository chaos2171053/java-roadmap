package org.example.array;

//初始化糖果数组：首先，为每个孩子分配一个糖果，这样每个孩子至少都有一个糖果。
//
//从左到右遍历评分：从左到右遍历孩子的评分，如果当前孩子的评分比前一个孩子高，那么他应该比前一个孩子多一个糖果。这里，你需要更新当前孩子的糖果数。
//
//从右到左遍历评分：接下来，从右到左再次遍历孩子的评分，如果当前孩子的评分比后一个孩子高，并且他当前的糖果数不大于后一个孩子的糖果数，那么他应该比后一个孩子多一个糖果。同样，你需要更新当前孩子的糖果数。
//
//计算总糖果数：最后，累加所有孩子的糖果数，得到总的糖果数。
public class Candy {
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int total = 0;
        int[] candyArray = new int[length];
        for (int i = 0; i < length; i++) {
            candyArray[i] = 1;
        }
        // 从左到右遍历，如果评分比前一个孩子高，分配糖果数增加
        for (int i = 1; i < length; i++) {
            if(ratings[i]>ratings[i-1]){
                //candyArray[i]+=1;
                candyArray[i] = candyArray[i-1] + 1;
            }
        }
        // 从右到左遍历，如果评分比后一个孩子高，并且当前孩子的糖果数不大于后一个孩子，分配糖果数增加
        for (int i = length-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1]&& candyArray[i]<=candyArray[i+1]){
                candyArray[i] = candyArray[i+1] + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            total+=candyArray[i];
        }
        return total;
    }
}
