import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{

    Score(String name,int score){
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("quiz.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel h1 = new JLabel("Thank You " + name + " for playing Quiz");
        h1.setBounds(45, 30, 700, 30);
        h1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(h1);
        
        JLabel uscore = new JLabel("Your score is " + score);
        uscore.setBounds(350, 200, 300, 30);
        uscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(uscore);

        JButton submit = new JButton("Exit");
        submit.setBounds(380, 270, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }   

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] arg){
        new Score("User",0);
    }
}
