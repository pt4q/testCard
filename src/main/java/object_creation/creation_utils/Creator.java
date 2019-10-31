package object_creation.creation_utils;

import object_creation.param.status_and_exceptions.RecognizeParamTypeException;

public interface Creator <O, I> {
   O create (I input) throws RecognizeParamTypeException;
}
