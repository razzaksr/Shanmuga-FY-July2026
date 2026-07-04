package day4;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class DemoMaps {
    public static void main(String[] args) {
        Map<String,Double> repos = new Hashtable<>();
        repos.put("Maven", 65.8);
        repos.putIfAbsent("Gradle", 1.1);
        repos.put("Gradle", 34.3);
        repos.put("NPM", 78.9);
        repos.put("PIP", 34.5);
        repos.remove("Gradle");
        System.out.println(repos.getOrDefault("Gradle",0.0));
        Set<String> managers = repos.keySet();
        System.out.println(managers);
        Collection<Double> values = repos.values();
        System.out.println(values);
        repos.entrySet().forEach(each->{
            System.out.println(each.getKey()+" : "
            +each.getValue());
        });
    }
}
