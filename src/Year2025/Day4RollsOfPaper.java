package Year2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day4RollsOfPaper {

    public char[][] inputMatrix;

    public void parseInput(){
        try{
            List<String> rollsRows = Files.readAllLines(Paths.get("../InputFiles/Year2025/Day4RollsOfPaper.txt"));
            System.out.println("Parsed the file successfully.Length is: "+rollsRows.size());

            char[][] rollsMatrix = new char[rollsRows.size()][];
            for(int i=0;i<rollsRows.size();i++){
                rollsMatrix[i] = rollsRows.get(i).toCharArray();
            }
            this.inputMatrix= rollsMatrix;
        }
        catch(IOException e){
            System.out.println("Error parsing file "+e.getMessage());
        }
    }

    public int getResultPart1(){
        int[][] DIRS = {
                {-1, -1}, {-1,  0}, {-1,  1},
                { 0, -1},          { 0,  1},
                { 1, -1}, { 1,  0}, { 1,  1}
        };

        int result =0;
        int rows = inputMatrix.length;
        int columns = inputMatrix[0].length;
        List<Map.Entry<Integer, Integer>> updateIndices = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(inputMatrix[i][j]!='@') continue;

                int neighborCount = 0;
                for(int[] d: DIRS){
                    int nr = i+d[0];
                    int nc = j+d[1];

                    if(nr>=0 && nr<rows && nc>=0 && nc<columns){
                        if(inputMatrix[nr][nc]=='@')
                        {
                            neighborCount++;
                            if(neighborCount>=4)
                                break;
                        }
                    }
                }
                if(neighborCount<4){
                    //inputMatrix[i][j]='.';
                    updateIndices.add(new AbstractMap.SimpleEntry<Integer,Integer>(i,j));
                    result++;
                }
            }
        }
        System.out.println("Updating matrix, with result: "+ result);
        for(Map.Entry<Integer,Integer> pair: updateIndices){
            inputMatrix[pair.getKey()][pair.getValue()] = '.';
        }
        return result;
    }

    public int getResultPart2(){
        int result =0;
        int intermidiateResult = getResultPart1();
        result+=intermidiateResult;
        while(intermidiateResult>0){
            intermidiateResult = getResultPart1();
            result+=intermidiateResult;
        }
        return result;
    }
}
