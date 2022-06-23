package ru.liga;

public class Calculate implements Add
{

    @Override
    public Integer add(String numbers, String regex)
    {
        String ignor = "\\";
        try
        {
            int result = 0;
            if (numbers == "")
                return 0;
            else if (numbers.startsWith("//"))
            {
                regex = String.valueOf(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            String operands[] = numbers.split("\\"+ regex);
            int count = operands.length;

            if (count == 1)
                return Integer.parseInt(operands[0]);
            else
            {
                for (int i = 0; i < operands.length; i++)
                {
                    if (Integer.parseInt(operands[i])>0)
                        result += Integer.parseInt(operands[i]);
                }
                return result;
            }
        }
        catch (NumberFormatException e)
        {
            throw new RuntimeException("Не число");
        }
    }
}
