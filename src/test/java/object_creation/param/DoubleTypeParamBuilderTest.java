package object_creation.param;

import jdk.tools.jlink.internal.packager.AppRuntimeImageBuilder;
import org.junit.Before;
import org.junit.Test;

public class DoubleTypeParamBuilderTest {

    private DoubleTypeParamBuilder doubleTypeParamBuilder;

    @Before
    public void setUp() throws Exception {
        doubleTypeParamBuilder = new DoubleTypeParamBuilder();

    }

    @Test
    public void build() {
    }

    @Test
    public void tryToAddSubtypeAndValue() {

        doubleTypeParamBuilder.calcAverageInComplexString()
    }
}