package ui;

public interface Processor <O,I> {

    O process(I input);
}
