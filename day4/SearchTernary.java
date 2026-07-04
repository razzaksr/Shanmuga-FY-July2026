package day4;

public class SearchTernary {
    public static int find(String[] records,String org){
        int start=0, end=records.length-1, mid1=0, mid2=0;
        while(start<=end){
            mid1=start+(end-start)/3;
            mid2=end-(end-start)/3;
            if(records[mid1].compareTo(org)==0) return mid1;
            if(records[mid2].compareTo(org)==0) return mid2;
            // part1
            if(org.compareTo(records[mid1])<0) end=mid1-1;
            // part3
            else if(org.compareTo(records[mid2])>0) 
                start=mid2+1;
            else{start=mid1+1;end=mid2-1;}
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] placement={"Accenture","Capgemini",
        "Cognizant","GoldManSache","TietoEvry","Zoho"};
        System.out.println(find(placement, "Zoho"));
        System.out.println(find(placement, "Accenture"));
        System.out.println(find(placement, "GoldManSache"));
    }
}
