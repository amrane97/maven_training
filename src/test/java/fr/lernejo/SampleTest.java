package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.server.Operation;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    private Sample sample;

    @BeforeEach
    public void initSample() {
        sample = new Sample();
    }


    @Test
    public void test_Fact_Positive_Number() {
        //GIVEN
        int n = 4;
        //WHEN
        int actualResult = sample.fact(n);
        //THEN
        Assertions.assertThat(actualResult).isEqualTo(24);
    }

    @Test
    public void test_Fact_Negative_Number() {

        //GIVEN
        int n = -4;

        //WHEN
        ThrowableAssert.ThrowingCallable factFn = () -> sample.fact(n);

        //THEN
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(factFn)
            .withMessage("N should be positive");
    }

    @Test
    public void testOpAdd() {

        //GIVEN
        int number1 = 3;
        int number2 = 4;
        //WHEN
        int actualResult = sample.op(Sample.Operation.ADD, number1,number2);
        //THEN
        Assertions.assertThat(actualResult).isEqualTo(7);
    }

    @Test
    public void testOpMul() {

        //GIVEN
        int number1 = 3;
        int number2 = 4;
        //WHEN
        int actualResult = sample.op(Sample.Operation.MULT, number1,number2);
        //THEN
        Assertions.assertThat(actualResult).isEqualTo(12);
    }
}
