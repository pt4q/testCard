package object_printing;

public interface Generator<O, I> {

    O generate(I input);
}
