package chapter1;

/**
 * TwoArgsProcessor
 */
@FunctionalInterface
public interface TwoArgsProcessor<T> {
    T process(T arg1, T arg2);
}
