package day7;

public class BestTimeSellStockCollDownViaDP {
    public static int maxProfit(int[] stocks){
        if(stocks==null||stocks.length==0)return 0;
        int size = stocks.length;
        int hold = -stocks[0], sold=0, rest=0;
        int pHold=0,pSold=0,pRest=0;
        for(int index=1;index<size;index++){
            pHold=hold;pSold=sold;pRest=rest;
            // when hold
            hold=Math.max(pHold, pRest-stocks[index]);
            // when sold
            sold = pHold+stocks[index];
            // when rest
            rest = Math.max(pRest,pSold);
        }
        return Math.max(sold,rest);
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(maxProfit(new int[]{1}));
        System.out.println(maxProfit(new int[]{1,2,4}));
    }
}
