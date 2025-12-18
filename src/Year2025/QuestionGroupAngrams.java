package Year2025;

import java.util.*;

public class QuestionGroupAngrams {

    public List<List<String>> solution(String arr[]){
        Map<String, List<String>> result= new HashMap<>();

        for(String s: arr){
            char[] sC = s.toCharArray();
            Arrays.sort(sC);
            String sortedS = new String(sC);
            result.putIfAbsent(sortedS, new ArrayList<>());
            result.get(sortedS).add(s);

        }
        return result.values().stream().toList();

    }
}
