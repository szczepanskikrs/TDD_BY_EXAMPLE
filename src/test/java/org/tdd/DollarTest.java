package org.tdd;

import junitparams.JUnitParamsRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(JUnitParamsRunner.class)

class DollarTest {

    Dollar testedDollar1;
    Dollar testedDollar2;

    @BeforeEach
    public void setupTestEnvironment() {
        testedDollar1 = new Dollar(5);
        testedDollar2 = new Dollar(10);
    }

    @Test
    void shouldPassWhenCorrectValuesArePassedToMultiplication() {
        assertThat(testedDollar1.times(2).amount).isEqualTo(10);
    }

    @Test
    void shouldPassWhenObjectsAreCreatedInCorrectMannerWithProvidedParameters() {
        Dollar testedDollar1 = new Dollar(5);
        Dollar testedDollar2 = testedDollar1.times(2);
        assertThat(testedDollar2.amount).isEqualTo(10);
        testedDollar2 = testedDollar1.times(5);
        assertThat(testedDollar2.amount).isEqualTo(25);
    }

    @Test
    void shouldPassWhenDollarsAreEqual() {
        assertThat(testedDollar1).isEqualTo(new Dollar(5));
    }
}
