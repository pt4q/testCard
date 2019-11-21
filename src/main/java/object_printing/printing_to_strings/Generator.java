package object_printing.printing_to_strings;

public interface Generator<O, I> {

    O generate(I input);
}
