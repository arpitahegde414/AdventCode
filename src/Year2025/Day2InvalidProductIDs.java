package Year2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2InvalidProductIDs {
    public List<String> parseInput(){
        List<String> ranges = new ArrayList<>();
        try{
            String rangesString = Files.readString(Paths.get("../InputFiles/Year2025/Day2InvalidProductIDs.txt"));
            ranges = Arrays.asList(rangesString.split(","));
            System.out.println("Parsed the file successfully.Length is: "+ranges.size());
        }
        catch(IOException e){
            System.out.println("Error parsing file "+e.getMessage());
        }
        return ranges;

    }

    public long getResult(List<String> inputRanges){
        long result=0;
        for(String range: inputRanges){
            String[] parts = range.split("-",2);
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            for(long i=start;i<end;i++){
                String number = Long.toString(i);
                if(i==0 || number.length()%2!=0 || number.startsWith("0")){
                    continue;
                }
                //divide the string to two parts
                String firstPart = number.substring(0, number.length()/2);
                String secondPart = number.substring(number.length()/2);
                if(firstPart.equals(secondPart))
                       result+=i;
            }
        }
        return result;
    }

    public long getResultPartTwo(List<String> inputRanges){
        long result=0;
        for(String range: inputRanges){
            String[] parts = range.split("-",2);
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            for(long i=start;i<end;i++){
                String number = Long.toString(i);
                if(i==0||number.startsWith("0")){
                    continue;
                }
                String doubleNumber = number+number;
                int index = doubleNumber.indexOf(number, 1);
                if(index!=-1 && index<number.length()){
                    result+=i;
                }
            }
        }
        return result;
    }
}
