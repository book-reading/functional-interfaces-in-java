package chapter1;

/**
 * TestStringProcessor
 */
public class TestStringProcessor {
    public static void main(String[] args) {
        NamedStringProcessor nameSP = new NamedStringProcessor();

        StringProcessor anonSP = new StringProcessor(){
            @Override
            public String process(String x) {
                return x.toUpperCase();
            }
        };
        System.out.println(nameSP.process("hello"));
        System.out.println(anonSP.process("hello"));
    }
}