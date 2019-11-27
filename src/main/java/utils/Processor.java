package utils;

public interface Processor <O,I> {

    O process(I input);
}
