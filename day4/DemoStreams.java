package day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStreams {
    public static void main(String[] args) {
        List<Double> myDoubs = Stream.
        of(4.5,9.2,45.6,12.5).
        collect(Collectors.toList());
        myDoubs=Arrays.asList(9.5,2.3,5.6);
        myDoubs = List.of(9.8,2.3,5.8,12.5);

        List<Double> newOne = myDoubs.stream().filter
        (each->each>=5.0).collect(Collectors.toList());

        // newOne.stream().forEach(System.out::println);
        newOne.stream().forEach(each->System.out.println(each));
    }
}
