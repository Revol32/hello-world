import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        
        String collect = IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining("-"));
        System.out.println(collect);
        int code = 1;
        String fds = "А";
        int symbolCode = (int) fds.charAt(0);
        char re = (char) ((int) fds.charAt(0)+1);
        boolean isUpperCase = Character.isUpperCase(re);
        re=Character.toLowerCase(re);
        System.out.println(symbolCode);
        System.out.println(re);
        System.out.println((char) (1071 + (symbolCode +code-1071) % 32));
        List<LocalTime> am;
        List<LocalTime> pm;

            am = new ArrayList<>();
            am.add(LocalTime.of(8, 0));
            am.add(LocalTime.of(8, 30));
            am.add(LocalTime.of(9, 0));
            am.add(LocalTime.of(9, 30));
            am.add(LocalTime.of(10, 0));
            am.add(LocalTime.of(10, 30));
            am.add(LocalTime.of(11, 0));
            am.add(LocalTime.of(11, 30));
            am.add(LocalTime.of(12, 0));
            am.add(LocalTime.of(12, 30));

            pm = new ArrayList<>();
            pm.add(LocalTime.of(13,0));
            pm.add(LocalTime.of(13,30));
            pm.add(LocalTime.of(14,0));
            pm.add(LocalTime.of(14,30));
            pm.add(LocalTime.of(14,0));
            pm.add(LocalTime.of(14,30));
            pm.add(LocalTime.of(14,0));
            pm.add(LocalTime.of(14,30));
            pm.add(LocalTime.of(14,0));
            pm.add(LocalTime.of(14,30));
            pm.add(LocalTime.of(14,0));
            pm.add(LocalTime.of(14,30));
        String hello = "Hello";
        String world = "world";
        long in = 15L;
        LocalDate date = LocalDate.now();
        System.out.println(pm.toString());
        System.out.println(hello+" "+world+"!");
        System.out.println(getOperatorsToString());
        String test = "1+()-/2*3-.)4";
        String mat = "["+getOperatorsToString()+"]"+"["+getOperatorsToString()+"]";
        System.out.println("["+getOperatorsToString()+"]{2}");
        Matcher matcher = Pattern.compile("["+getOperatorsToString()+"]"+"["+getOperatorsToString()+")]|[(][)]").matcher(test);
        matcher = Pattern.compile("[\\d+\\.?\\d*]").matcher(test);
        while (matcher.find()) {
            test = test.replace(matcher.group(), "");
        }
        System.out.println(test);
        Pattern patternOperatorDuplication = Pattern.compile("[" + getOperatorsToString() + "]" +
                "[" + getOperatorsToString() + ")]");
        System.out.println(patternOperatorDuplication);

    }
    static final Map<String,Integer> operators;

    static {
        operators=new HashMap<String, Integer>();
        operators.put("(", 0);
        operators.put(")", 0);
        operators.put("+", 1);
        operators.put("-", 1);
        operators.put("*", 2);
        operators.put("/", 2);
    }

    public static String getOperatorsToString() {
        StringBuilder operatorsString = new StringBuilder();
        for (String operator: operators.keySet()) {
            if (!operator.equals("(") && !operator.equals(")")) {
                operatorsString.append(operator);
            }
        }
        return operatorsString.toString();
    }
}
