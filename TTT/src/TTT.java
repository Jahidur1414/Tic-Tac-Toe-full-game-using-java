import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

class TTT extends Canvas {

    JFrame f = new JFrame("TIC--TAC--TO");
    JButton b[];
    TextField tf;
    String s;
    int a[];

    TTT() {
        JWindow window = new JWindow();
        JLabel pp = new JLabel("");

        window.getContentPane().add(
                new JLabel("", new ImageIcon("E:\\JAVA\\TTT\\src\\minion.png"), SwingConstants.CENTER));
        window.setBounds(250, 80, 800, 600);

        window.setVisible(true);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        window.setVisible(false);
        JFrame frame = new JFrame();
        frame.add(new JLabel("Welcome"));
        frame.setVisible(false);
        frame.setSize(300, 200);
        window.dispose();

        a = new int[9];

        for (int i = 0; i < 9; i++)
        {
            a[i] = i;
        }
        b = new JButton[9];
        tf = new TextField();
        Listener o = new Listener(this);

        tf.setBounds(50, 240, 150, 50);
        f.add(tf);
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton(s);

        }
        b[0].setBounds(50, 50, 50, 50);

        b[1].setBounds(50, 100, 50, 50);

        b[2].setBounds(50, 150, 50, 50);

        b[3].setBounds(100, 50, 50, 50);
        pp.setBounds(110, 60, 30, 20);
        f.add(pp);

        b[4].setBounds(100, 100, 50, 50);

        b[5].setBounds(100, 150, 50, 50);

        b[6].setBounds(150, 50, 50, 50);

        b[7].setBounds(150, 100, 50, 50);

        b[8].setBounds(150, 150, 50, 50);
        b[0].addActionListener(o);
        b[1].addActionListener(o);
        b[2].addActionListener(o);
        b[3].addActionListener(o);

        b[4].addActionListener(o);

        b[5].addActionListener(o);

        b[6].addActionListener(o);

        b[7].addActionListener(o);

        b[8].addActionListener(o);

        f.add(b[0]);
        f.add(b[1]);
        f.add(b[2]);
        f.add(b[3]);
        f.add(b[4]);
        f.add(b[5]);
        f.add(b[6]);
        f.add(b[7]);
        f.add(b[8]);

        f.setLayout(null);
        Font font = new Font("Monotype Corsiva", Font.BOLD, 20);
        tf.setFont(font);
        f.setVisible(true);
        f.setResizable(false);
        f.setBounds(500, 150, 250, 400);
        f.setSize(250, 350);
        f.getContentPane().setBackground(Color.CYAN);
    }

    public static void main(String[] s) {
        TTT ttt = new TTT();

        //System.exit(0);
    }
}

class Listener extends Canvas implements ActionListener {

    TTT d;

    static int c = 1;

    Listener(TTT d) {
        this.d = d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == d.b[i]) 
            {
                if (c % 2 == 0)
                {
                    if(d.a[i]!=30){
                    d.b[i].setIcon(new ImageIcon("E:\\JAVA\\TTT\\src\\cross.png"));
                    c++;
                    d.a[i] = 20;}

                } 
                else 
                {
                    if(d.a[i]!=20)
                    {
                    d.b[i].setIcon(new ImageIcon("E:\\JAVA\\TTT\\src\\dot.png"));
                    c++;
                    d.a[i] = 30;
                    }
                }
            }
        }

        int m = 0;
        if ((d.a[0] == d.a[4]) && (d.a[4] == d.a[8]) || (d.a[2] == d.a[4]) && (d.a[4] == d.a[6]) || (d.a[3] == d.a[4]) && (d.a[4] == d.a[5]) || (d.a[1] == d.a[4]) && (d.a[4] == d.a[7]) || (d.a[0] == d.a[3]) && (d.a[3] == d.a[6]) || (d.a[2] == d.a[5]) && (d.a[5] == d.a[8]) || (d.a[0] == d.a[1]) && (d.a[1] == d.a[2]) || (d.a[6] == d.a[7]) && (d.a[7] == d.a[8])) {
            if (c % 2 == 0) {
                m = 1;
                d.tf.setText("Cross  WINS");
                //System.exit(0);

            } else if (c % 2 != 0) {
                m = 1;
                d.tf.setText("Circule  WINS");
                //System.exit(0);
            } else {
                d.tf.setText("Match Draw!");
                System.exit(0);
            }
        } else if ((d.a[0] != d.a[4]) && (d.a[4] != d.a[8]) || (d.a[2] != d.a[4]) && (d.a[4] != d.a[6]) || (d.a[3] != d.a[4]) && (d.a[4] != d.a[5]) || (d.a[1] != d.a[4]) && (d.a[4] != d.a[7]) || (d.a[0] != d.a[3]) && (d.a[3] != d.a[6]) || (d.a[2] != d.a[5]) && (d.a[5] != d.a[8]) || (d.a[0] != d.a[1]) && (d.a[1] != d.a[2]) || (d.a[6] != d.a[7]) && (d.a[7] != d.a[8])) {
            if (m != 1) {
                d.tf.setText("Enjoy the game!");
            }
            //System.exit(0);
        }

    }
}
