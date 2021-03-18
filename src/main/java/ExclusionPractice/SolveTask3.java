package ExclusionPractice;

import javax.swing.*;

public class SolveTask3 // Класс для решения задачи №3
{
    String[][] textArray;
    int minNumber_x = 0;
    int maxNumber_x = 0;
    int minNumber_y = 0;
    int maxNumber_y = 0;

    int summa = 0;

    SolveTask3(String[][] _textArray)
    {
        // Определение границ заполненных ячеек
        for (int j = 0; j < _textArray[0].length; j++)
        {
            for (int i = 0; i < _textArray.length; i++)
            {
                if ((_textArray[i][j] != null) && (_textArray[i][j].length() != 0) && (i < minNumber_x))
                {
                    minNumber_x = i;
                }
                if ((_textArray[i][j] != null) && (_textArray[i][j].length() != 0) && (i > maxNumber_x))
                {
                    maxNumber_x = i;
                }
                if ((_textArray[i][j] != null) && (_textArray[i][j].length() != 0) && (j < minNumber_y))
                {
                    minNumber_y = j;
                }
                if ((_textArray[i][j] != null) && (_textArray[i][j].length() != 0) && (j > maxNumber_y))
                {
                    maxNumber_y = j;
                }
            }
        }

        textArray = new String[4][4];
        int i = 0;
        int j = 0;
        try
        {
            for (i = 0; i < maxNumber_x - minNumber_x + 1; i++)
            {
                if (i < 4)
                {
                    for (j = 0; j < maxNumber_y - minNumber_y + 1; j++)
                    {
                        if (j < 4)
                        {
                            textArray[i][j] = _textArray[i][j];
                            try
                            {
                                summa += Integer.parseInt(_textArray[i][j]);
                            }
                            catch(NumberFormatException e)
                            {
                                throw new MyArrayDataException();
                            }
                        }
                        else
                        {
                            throw new MyArraySizeException();
                        }
                    }
                }
                else
                {
                    throw new MyArraySizeException();
                }
            }
            System.out.println("Задан правильным массив целых чисел размерности 4x4.");
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

