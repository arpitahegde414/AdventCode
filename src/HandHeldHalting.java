import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HandHeldHalting {
    public List<String> parseInput(){
        List<String> instructions = new ArrayList<>();
        try{
            instructions = Files.readAllLines(Paths.get("../InputFiles/HandHeldHalting.txt"));
            System.out.println("Parsed the file successfully.Length is: "+instructions.size());
        }
        catch(IOException e){
            System.out.println("Error parsing file "+e.getMessage());
        }
        return instructions;
    }

    public int getResult(List<String> instructions) {
        int acc = 0;
        Set<Integer> visited = new HashSet<>();
        int i = 0;
        while (i< instructions.size()) {
            if(visited.contains(i)) break;
            visited.add(i);
            String[] parts = instructions.get(i).split(" ");
            String op = parts[0];
            int arg = Integer.parseInt(parts[1]);
            switch(op){
                case "acc":
                    acc+= arg;
                    i++;
                    break;
                case "jmp":
                    i+=arg;
                    break;
                case "nop":
                    i++;
                    break;
            }
        }
        return acc;
    }

}
