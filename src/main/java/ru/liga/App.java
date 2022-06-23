package ru.liga;

import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculate calc = new Calculate();
        String regex = "[;:.]";
        System.out.println(calc.add("1.2.53.-3.567", regex));
    }
}
