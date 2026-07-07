package day6;

public class HouseRobViaDP {
    public static int rob(int[] houses){
        if(houses.length==0) return 0;
        if(houses.length==1) return houses[0];
        int prev2=houses[0];
        int prev1 = Math.max(houses[0], houses[1]);
        int current=0;
        for(int index=2;index<houses.length;index++){
            current = Math.max(prev1, (houses[index]+prev2));
            prev2=prev1;prev1=current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,1,2}));
    }
}
