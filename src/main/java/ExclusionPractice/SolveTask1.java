package ExclusionPractice;

import javax.swing.*;

public class SolveTask1 // Класс для решения задачи №1
{
    String[][] textArray;

    SolveTask1(String[][] _textArray)
    {
        textArray = new String[_textArray.length][_textArray[0].length];
        for (int j = 0; j < _textArray[0].length; j++)
        {
            for (int i = 0; i < _textArray.length; i++)
            {
                textArray[i][j] = _textArray[i][j];
            }
        }

        String[][] resultArray = checkErrors(textArray);
    }

    public String[][] checkErrors(String[][] newStringArray)
    {
        int minNumber_x = 0;
        int maxNumber_x = 0;
        int minNumber_y = 0;
        int maxNumber_y = 0;
        String[][] resArray = new String[4][4];
        String[][] resFalseArray = new String[4][4];

        // Определение границ заполненных ячеек
        for (int j = 0; j < newStringArray[0].length; j++)
        {
            for (int i = 0; i < newStringArray.length; i++)
            {
                if ((newStringArray[i][j] != null) && (newStringArray[i][j].length() != 0) && (i < minNumber_x))
                {
                    minNumber_x = i;
                }
                if ((newStringArray[i][j] != null) && (newStringArray[i][j].length() != 0) && (i > maxNumber_x))
                {
                    maxNumber_x = i;
                }
                if ((newStringArray[i][j] != null) && (newStringArray[i][j].length() != 0) && (j < minNumber_y))
                {
                    minNumber_y = j;
                }
                if ((newStringArray[i][j] != null) && (newStringArray[i][j].length() != 0) && (j > maxNumber_y))
                {
                    maxNumber_y = j;
                }
                if ((j < 4) && (i < 4))
                {
                    resFalseArray[i][j] = "";
                }

            }
        }

        try
        {
            if ((maxNumber_x - minNumber_x + 1 == 4) && (maxNumber_y - minNumber_y + 1 == 4))
            {
                for (int i = 0; i < maxNumber_x - minNumber_x + 1; i++)
                {
                    for (int j = 0; j < maxNumber_y - minNumber_y + 1; j++)
                    {
                        resArray[i][j] = newStringArray[i][j];
                    }
                }
            }
            else
            {
                throw new MyArraySizeException();
            }
            System.out.println("Задан правильным двумерный строковый массив, размерности 4x4.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Задан правильным двумерный строковый массив, размерности 4x4.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (MyArraySizeException e)
        {
            System.out.println("Ошибка в размерности заданного массива! Массив должен быть размером 4x4.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Ошибка в размерности заданного массива!<br>Массив должен быть размером 4x4.<br>Пожалуйста, исправьте размер массива<br>и нажмите на кнопку \"Проверить задание\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
            return resFalseArray;
        }
        return resArray;
    }

    class MyArraySizeException extends ArrayIndexOutOfBoundsException
    {
        MyArraySizeException()
        {
        }
    }
}
