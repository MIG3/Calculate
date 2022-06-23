package ru.liga;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{

   Calculate calc = new Calculate();


    @Test
    public void InputEmptyReturnZero()
    {
        assertThat(calc.add("", ",")).isZero();
    }

    @Test
    public void InputOneNumReturnElem()
    {
        assertThat(calc.add("5", ",")).isEqualTo(5);
    }
    @Test
    public void InputTwoNumReturnSum()
    {
        assertThat(calc.add("5,-3,10", ",")).isEqualTo(15);
    }
    @Test
    public void InputNotTwoNumReturnErr()
    {
        assertThatThrownBy(() -> calc.add("5 X", " ")).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void InputMoreTwoNumReturnSum()
    {
        assertThat(calc.add("1,2,53,22,567", ",")).isEqualTo(645);
        assertThat(calc.add("1/2/53/0/567", "/")).isEqualTo(623);
        //assertThat(calc.add("1.2.53.-3.567", ".")).isEqualTo(620);
    }
    @Test
    public void InputTwoSlashStartNumReturnSum()
    {
        assertThat(calc.add("//* 1*2*53*22*567", ",")).isEqualTo(645);
    }

    @Test
    public void InputTwoSlashStartNumIgnoreMinusReturnSum()
    {
        assertThat(calc.add("//* 1*2*-53*22*567", ",")).isEqualTo(592);
    }
}
