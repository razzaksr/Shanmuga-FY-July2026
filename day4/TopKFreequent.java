package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TopKFreequent {
    public static int[] extract(int[] arr, int k){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int each:arr){
            int temp = map.
                    getOrDefault(each, 0)+1;
            map.put(each,temp);
        }
        List<Map.Entry<Integer,Integer>> tempList = 
        new ArrayList<>(map.entrySet());
        tempList.sort(Map.Entry.comparingByValue());
        Collections.reverse(tempList);
        int[] result=new int[k];
        for(int index=0;index<k;index++)
            result[index]=tempList.get(index).getKey();
        return result;
    }
    public static void main(String[] args) {
        int[] got = extract(new int[]{1,2,1,2,1,2,3,1,3,2}, 2);
        System.out.println(Arrays.toString(got));
    }
}
