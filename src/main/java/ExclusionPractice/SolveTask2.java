package ExclusionPractice;

import javax.swing.*;

public class SolveTask2 // Класс для решения задачи №2
{

    SolveTask2(String[][] _textArray)
    {
        checkErrors(_textArray);
    }

    public void checkErrors(String[][] newStringArray)
    {
        int minNumber_x = 0;
        int maxNumber_x = 0;
        int minNumber_y = 0;
        int maxNumber_y = 0;
        int summa = 0;

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
            }
        }

        int i = 0;
        int j = 0;
        try
        {
            if ((maxNumber_x - minNumber_x + 1 == 4) && (maxNumber_y - minNumber_y + 1 == 4))
            {
                for (i = 0; i < maxNumber_x - minNumber_x + 1; i++)
                {
                    for (j = 0; j < maxNumber_y - minNumber_y + 1; j++)
                    {
                        try
                        {
                            summa += Integer.parseInt(newStringArray[i][j]);
                        }
                        catch(NumberFormatException e)
                        {
                            throw new MyArrayDataException();
                        }
                    }
                }
            }
            else
            {
                throw new MyArraySizeException();
            }
            System.out.println("Задан правильный массив целых чисел размерности 4x4.");
            System.out.println("Сумма всех членов массива = " + summa);
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Задан правильным массив целых чисел размерности 4x4.<br>Сумма всех членов массива = " + summa + ".</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (MyArraySizeException e)
        {
            System.out.println("Ошибка \"MyArraySizeException\" в размерности заданного массива! Массив должен быть размером 4x4.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Ошибка в размерности заданного массива!<br>Массив должен быть размером 4x4.<br>Пожалуйста, исправьте размер массива<br>и нажмите на кнопку \"Проверить задание\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        }
        catch (MyArrayDataException e)
        {
            System.out.printf("Ошибка \"MyArrayDataException\" в преобразовании элемента массива [" + (i + 1) + "; " + (j + 1) + "].");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Ошибка \"MyArrayDataException\" в преобразовании элемента массива [" + (i + 1) + "; " + (j + 1) + "].<br>Он должен быть целым числом.<br>Пожалуйста, исправьте его и нажмите на кнопку \"Проверить задание\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        }
    }

    class MyArraySizeException extends ArrayIndexOutOfBoundsException
    {
        MyArraySizeException()
        {
        }
    }

    class MyArrayDataException extends NumberFormatException
    {
        MyArrayDataException()
        {
        }
    }
}
