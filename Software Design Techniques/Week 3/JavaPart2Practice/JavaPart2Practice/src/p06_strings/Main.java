package p06_strings;
public class Main {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println("s1 == s2: " + (s1 == s2));       // same pool reference
        System.out.println("s1 == s3: " + (s1 == s3));       // different object
        System.out.println("s1.equals(s3): " + s1.equals(s3));

        String phase1 = "Vowel Tester";
        String phase2 = "Vwl Tstr";

        System.out.println("Vowels in: '" + phase1 + "'=" + countVowels(phase1));
        System.out.println("Vowels in: '" + phase2 + "'=" + countVowels(phase2));


        int field1 = 5;
        String field2 = "field2";
        double[] field3 = {30.2, 32.1, 63};
        System.out.println(stringBuilder(field1, field2, field3));
    }

    public static int countVowels(String input){
        return (int) input.toLowerCase().chars()
            .filter(c -> "aeiouy".indexOf(c) >= 0).count();
    }

    public static String stringBuilder(int field1, String field2, double[] field3){
        String output = "";
        output = output + Integer.toString(field1) + ",";
        output = output + field2 + ",[";
        for (int i = 0; i < field3.length; i++) {
            output = output + Double.toString(field3[i]);
            if (i != field3.length - 1){
                output = output + ",";
            }
        }
        output = output + "]";
        return output;
    }
}

