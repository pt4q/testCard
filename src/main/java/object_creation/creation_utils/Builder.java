package object_creation.creation_utils;

public interface Builder <O,I>{
    O build (I input);
}
