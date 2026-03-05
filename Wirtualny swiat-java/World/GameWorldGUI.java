package World;

import Animals.Human;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class GameWorldGUI {
    private GameWorld world;
    private JFrame frame;
    private JTextArea board;
    private JTextArea logArea;
    private JButton saveButton;
    private JButton loadButton;
    private JButton exitButton;
    private JButton startTurnButton;
    private boolean isTurnInProgress = false;

    private GameWorldGUI gui;


    public GameWorldGUI(GameWorld world) {
        this.world = world;
        this.world.setGUI(this);

        frame = new JFrame("Game World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zakoncz dzialanie aplikacji
        frame.setSize(1000, 600);

        board = new JTextArea();
        board.setFont(new Font("Monospaced", Font.PLAIN, 16));
        board.setEditable(false);
        board.setFocusable(true);

        logArea = new JTextArea(6, 20);
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        logArea.setBackground(new Color(240, 240, 215));

        JScrollPane boardScrollPane = new JScrollPane(board);
        JScrollPane logScroll = new JScrollPane(logArea);

        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        exitButton = new JButton("Exit");
        startTurnButton = new JButton("Start Turn");

        JPanel panelForButtons = new JPanel(new FlowLayout());
        panelForButtons.add(startTurnButton);
        panelForButtons.add(saveButton);
        panelForButtons.add(loadButton);
        panelForButtons.add(exitButton);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(boardScrollPane, BorderLayout.CENTER);
        centerPanel.add(logScroll, BorderLayout.SOUTH);

        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        frame.getContentPane().add(panelForButtons, BorderLayout.SOUTH);

        addListeners();
        updateBoardDisplay();

        frame.setVisible(true);
        board.requestFocusInWindow(); //reagowanie klawisze
    }

    private void addListeners() {

        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                world.saveToFile(file.getAbsolutePath());
                showMessage("Game saved to: " + file.getName());
            }
        });

        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                world.loadFromFile(file.getAbsolutePath());
                updateBoardDisplay();
                showMessage("Game loaded from: " + file.getName());
            }
        });

        startTurnButton.addActionListener(e -> {
            isTurnInProgress = true;
            updateTurnLog("Turn started Use arrows to move the Human");
            board.requestFocusInWindow();
        });

        board.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!isTurnInProgress)
                    return;
                int dx = 0, dy = 0;
                boolean move = false;

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        dy = -1;
                        move = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        dy = 1;
                        move = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        dx = -1;
                        move = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        dx = 1;
                        move = true;
                        break;
                    case KeyEvent.VK_V:
                        Human human = world.getHuman();
                        if (human != null && human.isSkillReady()) {
                            human.setActivateShield(true);
                            updateBoardDisplay();
                            updateTurnLog("Alazur's Shield activated!");
                        } else {
                            updateTurnLog("Shield not ready");
                        }
                        break;
                }

                if (move) {
                    Human human = world.getHuman();
                    if (human != null) {
                        human.setMoveDirection(dx, dy);
                        world.clearTurnMessages();
                        world.takeTurn();
                        world.removeAllDeadOrganism();
                        world.setNumberOfTurn(world.getNumberOfTurn() + 1);

                        human.updateSkill();
                        human.setActivateShield(false);

                        updateBoardDisplay();
                        updateTurnLog(world.getTurnMessages() + "\n" + human.getShieldStatus());
                        isTurnInProgress = false;
                    }
                }
            }
        });

        board.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                FontMetrics fm = board.getFontMetrics(board.getFont());
                int charWidth = fm.charWidth('-');
                int lineHeight = fm.getHeight();

                int col = e.getX() / charWidth;
                int row = (e.getY() / lineHeight) - 4; // linie naglowka uwzglednienie

                if (!world.isOkay(col, row) || world.getOrganism(col, row) != null) return;

                String input = JOptionPane.showInputDialog(frame, "Enter organism name (for example: Wolf, Grass):");
                if (input != null && !input.trim().isEmpty()) {
                    char symbol;
                    switch (input.trim().toLowerCase()) {
                        case "sheep":
                            symbol = 'S';
                            break;
                        case "wolf":
                            symbol = 'W';
                            break;
                        case "antilope":
                            symbol = 'A';
                            break;
                        case "fox":
                            symbol = 'F';
                            break;
                        case "turtle":
                            symbol = 'T';
                            break;
                        case "grass":
                            symbol = '/';
                            break;
                        case "milkweed":
                            symbol = '*';
                            break;
                        case "guarana":
                            symbol = ',';
                            break;
                        case "nightshadeberries":
                            symbol = '!';
                            break;
                        case "barszczsosnowskiego":
                            symbol = 'U';
                            break;
                        default:
                            symbol = '?';
                            break;
                    }

                    if (symbol != '?') {
                        world.createNewOrganismFromSymbol(symbol, new Point(col, row));
                        updateBoardDisplay();
                        updateTurnLog("Added: " + input + " at (" + col + ", " + row + ")");
                    } else {
                        showMessage("Unknown organism type: " + input);
                    }
                }
            }
        });
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void updateBoardDisplay() {
        StringBuilder sbBoard = new StringBuilder();
        sbBoard.append("===== Dorota Kasilowska =====\n");
        sbBoard.append("Index: s203533\n");
        sbBoard.append("Turn: ").append(world.getNumberOfTurn()).append("\n\n");

        for (int j = 0; j < world.getN(); j++) {
            for (int i = 0; i < world.getM(); i++) {
                Organism org = world.getOrganism(i, j);
                if (org == null) {
                    sbBoard.append('-');
                } else {
                    sbBoard.append(org.getSymbol());
                }
            }
            sbBoard.append("\n");
        }

        board.setText(sbBoard.toString());
        board.requestFocusInWindow();
    }

    public void updateTurnLog(String logText)
    {
        logArea.setText(logText);
    }

    public void showMessage(String msg)
    {
        JOptionPane.showMessageDialog(frame, msg, "Game Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void endGame(String reason)
    {
        JOptionPane.showMessageDialog(frame, "Game Over: " + reason, "Game Over", JOptionPane.WARNING_MESSAGE);
        frame.dispose(); // zamknij okno
        System.exit(0);   // przerwij aplikacje
    }
}