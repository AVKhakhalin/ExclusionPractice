package ExclusionPractice;

import javax.swing.*;
import java.awt.*;

public class MainApp
{
    public static final int SIZE_WIDTH = 900;
    public static final int SIZE_HEIGHT = 700;
    public static final int NUMBER_ELEMENTS_X = 8;
    public static final int NUMBER_ELEMENTS_Y = 8;
    public static String[][] arrayForTask3;

    public static int numberRunMain = 0;

    public static void main(String[] args)
    {
        if (numberRunMain == 0)
        {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int centerLocationX = (int) ((screenSize.width - SIZE_WIDTH) / 2);
            int centerLocationY = (int) ((screenSize.height - SIZE_HEIGHT) / 2);

            JFrame.setDefaultLookAndFeelDecorated(false); // отображение стандартного вида окна
            JFrame frame = new JFrame("Домашнее задание №9 студента GeekBrains Хахалина Андрея Владимировича");

            //Create and set up the content pane.
            DialogWindow dialogWindow = new DialogWindow(SIZE_WIDTH, SIZE_HEIGHT); // создаём класс с диалоговым окном
            frame.setContentPane(dialogWindow.createContentPane()); // запускаем метод описывающий внешний вид
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(centerLocationX, centerLocationY);
            frame.setSize(SIZE_WIDTH, SIZE_HEIGHT);
            frame.setVisible(true);

            numberRunMain++;
        }
        else
        {
            SolveTask2 solveTask3 = new SolveTask2(arrayForTask3);
        }
    }
}
