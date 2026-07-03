package day3;

public class GasStation {
    public static int circle(int[] gas, int[] cost){
        int totTank = 0, carTank = 0, iSta=0;
        for(int index=0;index<gas.length;index++){
            totTank += gas[index]-cost[index];
            carTank += gas[index]-cost[index];
            if(carTank<0) {
                carTank=0;
                iSta=index+1;
            }
        }
        return totTank>=0?iSta:-1;
    }
    public static void main(String[] args) {
        System.out.println(circle(new int[]{1,2,3,4,5}, 
            new int[]{3,4,5,1,2}));
    }
}
