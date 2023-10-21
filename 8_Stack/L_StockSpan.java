//https://youtu.be/p9T-fE1g1pU?si=WmmYK-8RrOQ-S3ec
//The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days. The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day. For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
//Solution: Basically the problem boils down to finding the nearest greater to left and finding the difference in index which will give us the no. of days on which the stock is less than or equal to the current price.
//Brute force - two loops.
//Performant - NGL and find difference in indexes which will give the result.

import java.util.Stack;

public class L_StockSpan {
    public static void main(String[] args) {
        //int[] prices = new int[]{100,80,60,70,60,75,85};
        int[] prices = new int[]{68,735,101,770,525,279,559,563,465,106,146,82,28,362,492,596,743,28,637,392,205,703,154,293,383,622,317,519,696,648,127,372,339,270,713,68,700,236,295,704,612,123};
        System.out.println(prices.length);
        int[] result = findSpanOfStockPrice(prices);
        System.out.println(result.length);
        for(int element : result){
            System.out.print(element + " ");
        }
    }

    private static class Pair{
        int element;
        int index;

        Pair(int element, int index){
            this.element = element;
            this.index = index;
        }

        public int getElement(){
            return element;
        }

        public int getIndex(){
            return index;
        }
        
    }

    private static int[] findSpanOfStockPrice(int[] prices){
        int[] result = new int[prices.length];
        Stack<Pair> stack = new Stack<>();

        for(int i=0; i<prices.length; i++){
            if(stack.isEmpty()){
                result[i] = i+1;
                stack.push(new Pair(prices[i],i));
            } else {
                if(stack.peek().getElement() <= prices[i]){
                    while(!stack.isEmpty() && stack.peek().getElement() <= prices[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        result[i] = i+1;
                        stack.push(new Pair(prices[i],i));
                    } else {
                        result[i] = i - stack.peek().getIndex();
                        stack.push(new Pair(prices[i],i));
                    }
                } else {
                    result[i] = i - stack.peek().getIndex();
                    stack.push(new Pair(prices[i],i));
                }
            }
        }
        
        return result;
    }

}
