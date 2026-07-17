package day15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItenerary {
    Map<String,PriorityQueue<String>> graph = 
            new HashMap<>();
    LinkedList<String> itenerary = new LinkedList<>();
    public void dfs(String port){
        PriorityQueue<String> pq = graph.get(port);
        while (pq!=null&&!pq.isEmpty()) 
            dfs(pq.poll());
        itenerary.addFirst(port);
    }
    public List<String> find(List<List<String>> tickets){
        for(List<String> ticket:tickets)
            graph.computeIfAbsent(ticket.get(0), 
            k->new PriorityQueue<>())
            .offer(ticket.get(1));
        dfs("JFK");
        return itenerary;
    }
    public static void main(String[] args) {
        ReconstructItenerary re = new ReconstructItenerary();
        List<List<String>> tickets1 = Arrays.asList(
            List.of("MUC","LHR"),List.of("JFK","MUC"),
            List.of("SFO","SJC"),List.of("LHR","SFO")
        );
        System.out.println(re.find(tickets1));
        re = new ReconstructItenerary();
        List<List<String>> tickets2 = Arrays.asList(
            List.of("JFK","KUL"),List.of("JFK","NRT"),
            List.of("NRT","JFK")
        );
        System.out.println(re.find(tickets2));
    }
}
