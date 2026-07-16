package day14;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node(){val=0;neighbors=new ArrayList<Node>();}
    public Node(int v){val = v;neighbors=new ArrayList<Node>();}
    public Node(int v,ArrayList<Node> neigh){
        val=v;neighbors=neigh;
    }
}
