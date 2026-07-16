package day14;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    static Map<Node,Node> visisted = new HashMap<>();
    public static Node clone(Node node){
        if(node==null) return null;
        if(visisted.containsKey(node)) 
            return visisted.get(node);
        Node mirror = new Node(node.val);
        visisted.put(node, mirror);
        for(Node nei:node.neighbors)
            mirror.neighbors.add(clone(nei));
        return mirror;
    }
    public static void bfs(Node root){
        Queue<Node> que = new LinkedList<>();
        boolean[] isVisited = new boolean[visisted.size()];
        que.offer(root);
        while (!que.isEmpty()) {
            Node node = que.poll();
            if(isVisited[node.val]) continue;
            for(Node nei:node.neighbors){
                if(!isVisited[nei.val]) 
                {isVisited[nei.val]=true;que.offer(nei);}
            }
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.addAll(List.of(node2,node4));
        node2.neighbors.addAll(List.of(node1,node3));
        node3.neighbors.addAll(List.of(node2,node4));
        node4.neighbors.addAll(List.of(node1,node3));
        Node cloned = clone(node1);
        bfs(cloned);
    }
}
