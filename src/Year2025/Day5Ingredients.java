package Year2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Day5Ingredients {
    public List<String> ingredientRange;
    public List<Long> ingredient;
    public void parseInput(){
        this.ingredientRange = new ArrayList<>();
        this.ingredient = new ArrayList<Long>();
        try(BufferedReader br = new BufferedReader((new FileReader("../InputFiles/Year2025/Day5Ingredients.txt")))){
            String line;
            while((line=br.readLine()) != null){
                if(line.trim().isEmpty()) break;
                ingredientRange.add(line);
            }
            while((line=br.readLine()) != null){
                if(line.trim().isEmpty()) break;
                ingredient.add(Long.parseLong(line));
            }
            //System.out.println("Length of ranges: "+ ingredientRange.size());
            //System.out.println("Length of foodID: "+ ingredient.size());
        }
        catch(IOException e){
            System.out.println("Error parsing file "+e.getMessage());
        }
    }

    public record Range(long start, long end) {}

    public int getResultPart1(){
        int result=0;
//        Set<Long> goodFood = new HashSet<>();
//        for(String range: this.ingredientRange){
//            String[] startEnd = range.split("-",2);
//            Long start = Long.parseLong(startEnd[0]);
//            Long end = Long.parseLong(startEnd[1]);
//            LongStream.rangeClosed(start, end).forEach(goodFood::add);
//        }
        List<Range> ranges = new ArrayList<>();

        //parse ranges
        for(String range: ingredientRange){
            String[] startEnd = range.split("-",2);
            long start = Long.parseLong(startEnd[0]);
            long end = Long.parseLong(startEnd[1]);
            ranges.add(new Range(start, end));
        }

        for(long foodId: this.ingredient){
            for(Range r: ranges){
                if(foodId>= r.start() && foodId<=r.end()){
                    result++;
                    break;
                }
            }
        }
//        System.out.print(result);
        return result;
    }

    public BigInteger getResultPart2(){
        BigInteger result = BigInteger.ZERO;
        List<Range> ranges = new ArrayList<>();

        //parse ranges
        for(String range: ingredientRange){
            String[] startEnd = range.split("-",2);
            long start = Long.parseLong(startEnd[0].trim());
            long end = Long.parseLong(startEnd[1].trim());
            ranges.add(new Range(start, end));
        }
        ranges.sort(Comparator.comparingLong(Range::start));
        long currentStart = ranges.get(0).start();
        long currentEnd = ranges.get(0).end();
        for(int i=1;i<ranges.size();i++){
            Range r = ranges.get(i);
            if(r.start()<=currentEnd+1){
                //merge the range
                currentEnd = Math.max(r.end(), currentEnd);
            }
            else{
                //isnt overlapping, so dont merge
                //just add the number of good food items in the result
                System.out.println("Addition to result: "+(currentEnd-currentStart+1));
                result= result.add(BigInteger.valueOf(currentEnd-currentStart+1));
                currentStart = r.start();
                currentEnd = r.end();
            }
        }
        result= result.add(BigInteger.valueOf(currentEnd-currentStart+1));

        return result;
    }

}
