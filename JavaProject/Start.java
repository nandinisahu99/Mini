import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener{

    String name;
    JButton start,back;
    Start(String name){
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setSize(1200,500);

        JLabel h1=new JLabel("Welcome "+ name+" to Quiz Game");
        h1.setBounds(350, 20, 700, 30);
        h1.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        h1.setForeground(new Color(30,144,254));
        add(h1);

        JLabel h2=new JLabel("!!Rules for Quiz!!");
        h2.setBounds(300, 100, 700, 30);
        h2.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        h2.setForeground(new Color(30,144,254));
        add(h2);

        JLabel rules = new JLabel();
        rules.setBounds(300, 50, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. All the questions are compulsory." + "<br><br>" +
                "2. No negative marks for wrong Answer." + "<br><br>" +
                "3. Each question has time limit." + "<br><br>" +
                "4. Do not try toswitch the tab." + "<br><br>" +
            "<html>"
        );
        add(rules);

        start = new JButton("Start Quiz");
        start.setBounds(300, 400, 100, 30);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setBounds(500, 400, 100, 30);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Quiz_Time");
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            setVisible(false);
            new Game(name);
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Quiz();
        }
    }
    public static void main(String[] arg){
        new Start("User");
    }
}
