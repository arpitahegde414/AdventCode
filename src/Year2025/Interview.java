package Year2025;

import java.util.ArrayList;
import java.util.List;

public class Interview {

    public String smallest(int[] nums){
        List<String> input = new ArrayList<>();
        for(int n: nums){
            input.add(String.valueOf(n));
        }
        List<String> mergedString = mergeTwo(input);
        return mergedString.get(0);
    }

    public List<String> mergeTwo(List<String> nums){
        int len = nums.size();
        List<String> merged=new ArrayList<>();
        for(int i=0;i<len-1;i+=2){
            String s1 = nums.get(i)+ nums.get(i+1);
            String s2 = nums.get(i+1) + nums.get(i);
            if(Integer.parseInt(s1)> Integer.parseInt(s2))
                merged.add(s2);
            else
                merged.add(s1);
        }
        if(len%2!=0)
            merged.add(nums.get(len-1));
        System.out.println(merged);
        if(merged.size()>1)
            return mergeTwo(merged);
        return merged;
    }
}
