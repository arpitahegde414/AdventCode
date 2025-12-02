package Year2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1DailPassword {
    public List<String> parseInput(){
        List<String> instructions = new ArrayList<>();
        try{
            instructions = Files.readAllLines(Paths.get("../InputFiles/Year2025/Day1DailPassword.txt"));
            System.out.println("Parsed the file successfully.Length is: "+instructions.size());
        }
        catch(IOException e){
            System.out.println("Error parsing file "+e.getMessage());
        }
        return instructions;
    }

    public int getResult(List<String> input){
        int result = 0;
        int currentDail = 50;
        for(String i: input){
            if(i.startsWith("R")){
                //INCREMENT CURRENT DAIL with mod
                currentDail = (currentDail + Integer.parseInt(i.substring(1)))%100;
            }
            else{
                //decrement current dail with mod
                currentDail = (currentDail - Integer.parseInt(i.substring(1)))%100;
            }
            if(currentDail==0){
                result+=1;
            }
        }
        return result;
    }

}
