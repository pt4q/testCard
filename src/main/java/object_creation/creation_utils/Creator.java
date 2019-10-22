package object_creation.creation_utils;

import java.util.List;

public interface Creator <O, I> {
   O create (I input);
}
