package Banco;

import java.awt.*;
import JFrame;
import static WindowConstants.EXIT_ON_CLOSE;

public class Banco extends JFrame {

    private Button dispAcouBal, makeDep, makeWithDraw;
    //dispAcouBal= Display Account Balance
    //makeDep= Make a deposit
    //makeWithDraw= Make a with drawal
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    private Button buttonenter, buttonclear;
    private TextField tf1, tf2;
    private TextArea ta;

    public Banco(String title) {
        super(title);
        dispAcouBal = new Button("Display Account Balance");
        makeDep = new Button("Make a deposit");
        makeWithDraw = new Button("Make a with drawal");
        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        button0 = new Button("0");
        buttonenter = new Button("Enter");
        buttonclear = new Button("Delete");

        Panel southPanel = new Panel(new GridLayout(3, 1));
        southPanel.add(dispAcouBal);
        southPanel.add(makeDep);
        southPanel.add(makeWithDraw);

        Panel northPanel = new Panel(new GridLayout(4, 3));
        northPanel.add(button1);
        northPanel.add(button2);
        northPanel.add(button3);
        northPanel.add(button4);
        northPanel.add(button5);
        northPanel.add(button6);
        northPanel.add(button7);
        northPanel.add(button8);
        northPanel.add(button9);
        northPanel.add(button0);
        northPanel.add(buttonenter);
        northPanel.add(buttonclear);

        TextField tf1 = new TextField(20);
        TextField tf2 = new TextField(20);
        Panel centerPanel = new Panel(new BorderLayout());
        centerPanel.add(tf1, BorderLayout.NORTH);
        centerPanel.add(northPanel, BorderLayout.CENTER);

        Panel estePanel = new Panel(new GridLayout(2, 1));
        estePanel.add(southPanel);
        estePanel.add(centerPanel);

        Panel panel = new Panel(new BorderLayout());

        TextArea ta = new TextArea();
        panel.add(ta, BorderLayout.CENTER);
        panel.add(tf2, BorderLayout.SOUTH);

        this.add(estePanel, BorderLayout.WEST);

        this.add(panel, BorderLayout.CENTER);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Container f = new Banco("BANK A T M");
        f.setSize(800, 600);//preguntar sobre la opc que adapta el tamaño a la cantidad de botones.
        f.setVisible(true);
    }
}