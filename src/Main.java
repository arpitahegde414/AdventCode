import Year2025.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
//        BinaryBoarding b = new BinaryBoarding();
//        System.out.println(b.getResult(b.parseInput()));
//        HandHeldHalting h = new HandHeldHalting();
//        System.out.println(h.getResult(h.parseInput()));
//        Day1DailPassword d = new Day1DailPassword();
//        System.out.println(d.getResult(d.parseInput()));
//        Day2InvalidProductIDs d = new Day2InvalidProductIDs();
//        System.out.println(d.getResult(d.parseInput()));
//        System.out.println(d.getResultPartTwo(d.parseInput()));

//        Day3EscalaterBatteries eB = new Day3EscalaterBatteries();
//        System.out.println(eB.getResultPart2(eB.parseInput()));
//        Day4RollsOfPaper rP = new Day4RollsOfPaper();
//        rP.parseInput();
//        //System.out.println(rP.getResultPart1());
//        System.out.println(rP.getResultPart2());
//        Day5Ingredients i = new Day5Ingredients();
//        i.parseInput();
//        //System.out.println(i.getResultPart1());
//        System.out.println(i.getResultPart2());
//        int[] input = new int[]{3, 30, 34, 5, 9};
//        int[] input2 = new int[]{1, 12, 3 ,14};
//        Interview i = new Interview();

//        System.out.println(i.smallest(input2));
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};

        QuestionGroupAngrams q = new QuestionGroupAngrams();
         System.out.println(q.solution(strs));
    }
}