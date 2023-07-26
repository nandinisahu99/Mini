import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{

    JButton start;
    JTextField tx;
    Quiz(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setVisible(true);
        setSize(1200,500);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("quiz.jpeg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel h1=new JLabel("Simple Mind");
        h1.setBounds(750, 60, 300, 45);
        h1.setFont(new Font("SansSerif",Font.ITALIC,40));
        h1.setForeground(new Color(30,144,254));
        add(h1);

        JLabel name=new JLabel("Enter your name");
        name.setBounds(800, 150, 300, 20);
        name.setFont(new Font("SansSerif",Font.BOLD,18));
        name.setForeground(new Color(30,144,254));
        add(name);

        tx=new JTextField();
        tx.setBounds(735,195, 300, 30);
        tx.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tx);

        start = new JButton("Start");
        start.setBounds(830,250,120,25);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Quiz_Time");
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            String nam=tx.getText();
            setVisible(false);
            new Start(nam);
        }
    }
    public static void main(String[] arg){
        new Quiz();
    }
}
