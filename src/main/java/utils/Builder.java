package utils;

import object_creation.param.status_and_exceptions.RecognizeParamTypeException;

public interface Builder <O,I>{
    O build (I input) throws RecognizeParamTypeException;
}
