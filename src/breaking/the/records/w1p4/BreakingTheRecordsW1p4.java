/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package breaking.the.records.w1p4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author ahmed
 */
public class BreakingTheRecordsW1p4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

      
        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
    class  Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
       List<Integer> indexs=new ArrayList<>();
       int countMax,countMin;
       countMax=0;
       countMin=0;
       int max=scores.get(0);
       int min=scores.get(0);
       for(int i =0;i<scores.size();i++)
       {
           if(max<scores.get(i))
           {
               max=scores.get(i);
               countMax+=1;           }
     
        if(min>scores.get(i))
               {
                 min=scores.get(i);
                 countMin+=1;
               }
       }
       indexs.add(countMax);
       indexs.add(countMin);    
       return indexs;

    }

}

