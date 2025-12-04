package Year2025;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3EscalaterBatteries {
    public List<String> parseInput(){
        List<String> instructions = new ArrayList<>();
        try{
            instructions = Files.readAllLines(Paths.get("../InputFiles/Year2025/Day3EscalaterBatteries.txt"));
            System.out.println("Parsed the file successfully.Length is: "+instructions.size());
        }
        catch(IOException e){
            System.out.println("Error parsing file "+e.getMessage());
        }
        return instructions;
    }
    public int getResultPartOne(List<String> inputBatteries){
        int result =0;
        int maxVal;
        int lengthOfBatteries = inputBatteries.get(0).length();
        for(String battery: inputBatteries){
            maxVal=0;
            for(int i=0;i<lengthOfBatteries-1;i++){
                for(int j=i+1;j<lengthOfBatteries;j++){
                    String currDigit = ""+battery.charAt(i)+battery.charAt(j);
                    int currNum = Integer.parseInt(currDigit);
                    if(currNum>maxVal){
                        maxVal = currNum;
                    }
                }
            }
            result+=maxVal;
        }
        return result;
    }

    public long  getResultPart2(List<String> inputBatteries){
        long result=0;
        int k=12;

        for(String battery: inputBatteries){
            int toRemove= battery.length()-k;
            System.out.println("Battery: "+ battery);
            StringBuilder stack= new StringBuilder();

            for(char c: battery.toCharArray()){
                while(toRemove>0 && stack.length()>0 && stack.charAt(stack.length()-1)< c)
                {
                    stack.deleteCharAt(stack.length()-1);
                    toRemove--;
                }
                stack.append(c);
            }
            System.out.println("Stack string: "+ stack);
            result+=Long.parseLong(stack.substring(0,k));
        }
        return result;
    }
}
