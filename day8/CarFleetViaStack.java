package day8;

import java.util.Comparator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class CarFleetViaStack {
    public static int fleetFind(int[] p, int[] s, int tg){
        double time = 0.0;
        TreeMap<Integer,Integer> tab=new TreeMap<>(
            Comparator.reverseOrder()
        );
        for(int index=0;index<p.length;index++)
            tab.put(p[index], s[index]);
        Stack<Double> stk = new Stack<>();
        Set<Integer> dist = tab.keySet();
        for(int d:dist){
            time = (double) (tg-d)/tab.get(d);
            if(stk.isEmpty()||time>stk.peek()) 
                stk.push(time);
        }
        return stk.size();
    }
    public static void main(String[] args) {
        System.out.println(fleetFind(new int[]{10,8,0,5,3}, 
            new int[]{2,4,1,1,3}, 12));
    }
}
