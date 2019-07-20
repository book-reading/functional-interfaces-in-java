package chapter1;

/**
 * StringProcessor2
 */
public interface StringProcessor2 {
    String process(String s);

    static boolean isLowerCase(String s) {
        boolean result = true;

        for (int i = 0; i < s.length() && result; ++i) {
            result &= Character.isLowerCase(s.charAt(i));
        }

        return result;
    }

    static boolean isUpperCase(String s) {
        boolean result = true;

        for (int i = 0; i < s.length() && result; ++i) {
            result &= Character.isUpperCase(s.charAt(i));
        }

        return result;
    }
}

class StringProcessor2Test {
    public static void main(String[] args) {
        StringProcessor2 toLowerCase = new StringProcessor2(){
            @Override
            public String process(String s) {
                return s.toLowerCase();
            }
        };

        StringProcessor2 toUpperCase = new StringProcessor2(){
            @Override
            public String process(String s) {
                return s.toUpperCase();
            }
        };

        String s = toLowerCase.process("FUNCTIONALINTERFACES");
        System.out.println(s);
        System.out.println("Lower case: " + StringProcessor2.isLowerCase(s));
        System.out.println("Upper case: " + StringProcessor2.isUpperCase(s));

        String t = toUpperCase.process(s);
        System.out.println("\n" + t);
        System.out.println("Lower case: " + StringProcessor2.isLowerCase(s));
        System.out.println("Upper case: " + StringProcessor2.isUpperCase(s));
    }
}
