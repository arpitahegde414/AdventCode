import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BinaryBoarding {

    public List<String> parseInput(){
        List<String> passes = new ArrayList<>();
        try{
            passes = Files.readAllLines(Paths.get("../InputFiles/BinaryBoarding.txt"));
            System.out.println("Parsed the file successfully");
        }
        catch(IOException e){
            System.out.println("Error parsing file "+e.getMessage());
        }
        return passes;
    }
    public int getResult(List<String> passes){
        int result =  -1;
        for(String pass: passes){
            int seatId = getSeatId(pass);
            if(seatId>result)
                result=seatId;
        }
        return result;
    }

    public static int getSeatId(String pass){
        String rowStr = pass.substring(0,7).replace('F','0').replace('B','1');
        String columnStr = pass.substring(7).replace('L','0').replace('R','1');
        int row = Integer.parseInt(rowStr, 2);
        int column = Integer.parseInt(columnStr, 2);
        return (row*8)+column;
    }
}
