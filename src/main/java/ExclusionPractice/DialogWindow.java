package ExclusionPractice;

import javax.swing.*; // импортируем весь свинг, дабы не заморачиваться(мы ведь только учимся))
import java.awt.*; // и весь авт аналогично
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.awt.Font;
import java.awt.event.*;
import java.awt.FlowLayout;

public class DialogWindow
{
    int sizeWidth;
    int sizeHeight;
    int centerLocation_x;
    int centerLocation_y;

    public JTextField textField_3;
    public JTextField textField_4;
    public JTextField textField_7_1;
    public JTextField textField_7_2;
    public JTextField textField_8_1;
    public JTextField textField_8_2;

    DialogWindow (int _sizeWidth, int _sizeHeight)
    {
        this.sizeWidth = _sizeWidth;
        this.sizeHeight = _sizeHeight;
    }

    public JPanel createContentPane ()
    {
        // Создаём панель
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(new Color(200, 203, 255)); // смена фона окна
        totalGUI.setLayout(null);

//        JFrame frame = new JFrame();
//        frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
//        frame.setVisible(true);

        // Добавляем текст в окно
        JLabel blueLabel = new JLabel("<html><font face=\"MyFont, Verdana, Arial\", size=\"5\"><br>" +
                "Домашнее задание включало в себя следующее:<br>" +
                "1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.<br><br>" +
                "2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.<br><br>" +
                "3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.</html>");
        blueLabel.setLocation(30, 0); // координаты текста
        blueLabel.setSize(sizeWidth - 70, sizeHeight - 100); // размер области с текстом
        blueLabel.setVerticalAlignment(1);
        blueLabel.setHorizontalAlignment(0);
        blueLabel.setForeground(Color.BLACK); // Цвет текста
        totalGUI.add(blueLabel);

        // Создание кнопки для задания №1
        JButton task_1_button = new JButton("Проверить задание");
        task_1_button.setToolTipText("<html>Нажмите для проверки задания №1</html>");
        task_1_button.setLocation(700, 80); // это координаты кнопки
        task_1_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_1_button);
        ActionListener actionListener1 = new TestActionListener(1); // Подключение обработчика событий к кнопке
        task_1_button.addActionListener(actionListener1);

        // Создание кнопки для задания №2
        JButton task_2_button = new JButton("Проверить задание");
        task_2_button.setToolTipText("<html>Нажмите для проверки задания №2</html>");
        task_2_button.setLocation(700, 150); // это координаты кнопки
        task_2_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_2_button);
        ActionListener actionListener2 = new TestActionListener(2); // Подключение обработчика событий к кнопке
        task_2_button.addActionListener(actionListener2);

        // Создание кнопки для задания №3
        JButton task_3_button = new JButton("Проверить задание");
        task_3_button.setToolTipText("<html>Нажмите для проверки задания №3</html>");
        task_3_button.setLocation(700, 220); // это координаты кнопки
        task_3_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_3_button);
        ActionListener actionListener3 = new TestActionListener(3); // Подключение обработчика событий к кнопке
        task_3_button.addActionListener(actionListener3);

        // Создание текстового поля для ввода слова для задания №3
        textField_3 = new JTextField(15);
        textField_3.setToolTipText("<html>Введите слово для поиска в задании №3<br>и нажмите соответствующую кнопку<br>\"Проверить задание\"</html>");
        textField_3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_3.setBounds(500, 220, 160, 30);
        totalGUI.add(textField_3);

        // Создание кнопки для выхода из программы
        JButton task_EXIT_button = new JButton("Выйти из программы");
        task_EXIT_button.setToolTipText("<html>Нажмите для выхода из программы</html>");
        task_EXIT_button.setLocation((int) (sizeWidth / 2 - 80), sizeHeight - 98); // это координаты кнопки
        task_EXIT_button.setSize(160,40 ); // это размер кнопки
        totalGUI.add(task_EXIT_button);
        ActionListener actionListener_EXIT = new TestActionListener(0); // Подключение обработчика событий к кнопке
        task_EXIT_button.addActionListener(actionListener_EXIT);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // Обработка событий при нажатии на левую кнопку мыши
    public class TestActionListener implements ActionListener
    {
        int taskNumber = 0;

        TestActionListener (int _taskNumber)
        {
            this.taskNumber = _taskNumber;
        }

        public void actionPerformed(ActionEvent e)
        {
            String message;
            File newDirectory;
            switch (taskNumber)
            {
                case 1:
                    SolveTask1 solveTask1 = new SolveTask1();
                    break;
                case 2:
                    SolveTask2 solveTask2 = new SolveTask2();
                    break;
                case 8:
                    SolveTask3 solveTask3 = new SolveTask3();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
