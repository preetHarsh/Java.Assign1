package gui_swing_events;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author
 */
public class SwingEventWindow extends JFrame implements ActionListener, ItemListener {

    private final int WIDTH = 500;

    //JButton calculateBtn;
    private JRadioButton sumBtn;
    private JRadioButton averageBtn;
    private JRadioButton maximumBtn;
    private JRadioButton minimumBtn;
    private Integer rdoChecked;
    private JTextField input;
    private JTextField output;

    public SwingEventWindow(boolean show) {
        this.setSize(WIDTH, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center the frame on the screen

        // main 
        JPanel mainPanel = new JPanel(new GridLayout(6, 1));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // top section
        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        JLabel title = new JLabel("Excel Funtions");
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Monospaced", 0, 20));
        title.setBounds(10, 0, WIDTH, 30);

        JLabel instruction = new JLabel("Enter your numbers seperated by spaces");
        instruction.setFont(new java.awt.Font("Monospaced", 0, 15));
        input = new JTextField();

        mainPanel.add(title);
        topPanel.add(instruction);
        topPanel.add(input);

        mainPanel.add(topPanel);

        // options section
        sumBtn = new JRadioButton("Auto Sum");
        sumBtn.setSelected(true);
        sumBtn.addItemListener(this);
        sumBtn.setFont(new java.awt.Font("Monospaced", 0, 15));

        averageBtn = new JRadioButton("Average");
        averageBtn.addItemListener(this);
        averageBtn.setFont(new java.awt.Font("Monospaced", 0, 15));

        maximumBtn = new JRadioButton("Maximum");
        maximumBtn.addItemListener(this);
        maximumBtn.setFont(new java.awt.Font("Monospaced", 0, 15));

        minimumBtn = new JRadioButton("Minimum");
        minimumBtn.addItemListener(this);
        minimumBtn.setFont(new java.awt.Font("Monospaced", 0, 15));

        JPanel radioPanel = new JPanel();
        GridLayout layoutForRadios = new GridLayout(1, 4);
        radioPanel.setLayout(layoutForRadios);
        radioPanel.add(sumBtn);
        radioPanel.add(averageBtn);
        radioPanel.add(maximumBtn);
        radioPanel.add(minimumBtn);
        mainPanel.add(radioPanel);

        // calculate section
        JButton calculateBtn = new JButton("Calculate");
        calculateBtn.setSize(100, 50);
        calculateBtn.addActionListener(this);

        JPanel panelForCalBtn = new JPanel();
        panelForCalBtn.add(calculateBtn);
        mainPanel.add(panelForCalBtn);

        // result section
        JLabel result = new JLabel("Result");
        output = new JTextField("");

//        JPanel panelForResultSection = new JPanel();
//        panelForResultSection.add(result);
//        panelForResultSection.add(output);
//        mainPanel.add(panelForResultSection);
        
        mainPanel.add(result);
        mainPanel.add(output);

        this.add(mainPanel);
        this.setVisible(show);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello");
        System.out.println("input " + input.getText());
        System.out.println("radio checked " + rdoChecked);
        Excel excel = new Excel(input.getText());
        switch (rdoChecked) {
            case 1:
                System.out.println("result " + excel.findTotal());
                output.setText(excel.findTotal() + "");
                break;
            case 2:
                output.setText(excel.findAverage() + "");
                break;
            case 3:
                output.setText(excel.findMax() + "");
                break;
            case 4:
                output.setText(excel.findMin() + "");
            default:
                System.err.println("No option is selected");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton selectedRadio = (JRadioButton) e.getItem();
        
        String text = selectedRadio.getText();
        if (text.equalsIgnoreCase("auto sum")) {
            rdoChecked = 1;
        } else if (text.equalsIgnoreCase("average")) {
            rdoChecked = 2;
        } else if (text.equalsIgnoreCase("maximum")) {
            rdoChecked = 3;
        } else if (text.equalsIgnoreCase("minimum")) {
            rdoChecked = 4;

        }

        switch (rdoChecked) {
            case 1:
                // sumBtn.setSelected(false);
                averageBtn.setSelected(false);
                maximumBtn.setSelected(false);
                minimumBtn.setSelected(false);
                break;

            case 2:
                sumBtn.setSelected(false);
                //averageBtn.setSelected(false);
                maximumBtn.setSelected(false);
                minimumBtn.setSelected(false);
                break;
            case 3:
                sumBtn.setSelected(false);
                averageBtn.setSelected(false);
                //maximumBtn.setSelected(false);
                minimumBtn.setSelected(false);
                break;
            case 4:
                sumBtn.setSelected(false);
                averageBtn.setSelected(false);
                maximumBtn.setSelected(false);
                //minimumBtn.setSelected(false);  
                break;
            default:
                throw new AssertionError();
        }

    }

}
