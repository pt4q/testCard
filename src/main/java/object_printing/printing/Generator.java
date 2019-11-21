package object_printing.printing;

public interface Generator<O, I> {

    O generate(I input);
}
