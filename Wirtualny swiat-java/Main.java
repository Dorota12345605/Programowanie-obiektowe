import World.GameWorld;
import World.GameWorldGUI;

import javax.swing.*;
import java.awt.*;
public class Main
{
    public static void main(String[] args) {
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Enter width :"));
        JTextField widthField = new JTextField();
        inputPanel.add(widthField);

        inputPanel.add(new JLabel("Enter height :"));
        JTextField heightField = new JTextField();
        inputPanel.add(heightField);

        int result = JOptionPane.showConfirmDialog(
                null, inputPanel, "Board Size",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            try {
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                GameWorld world = new GameWorld(width, height); //stworzenie swiata
                new GameWorldGUI(world); //zaladowanie z okienka graficznego
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers");
            }
        }
        else
        {
            System.exit(0);
        }
    }
}
