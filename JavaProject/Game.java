import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener{

    String question[][] =new String[10][5];
    String answer[][]= new String[10][2];
    String userans[][] =new String[10][1];
    JLabel qno,qsn;
    JRadioButton op1,op2,op3,op4;
    ButtonGroup grpops;
    JButton submit,next;

    public static int timer=15;
    public static int ans=0;
    public static int count=0;
    public static int score=0;

    String name;

    Game(String name){
        this.name=name;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("quiz.jpeg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1440,392);
        add(image);

        qno= new JLabel();
        qno.setBounds(100,450,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);

        qsn= new JLabel();
        qsn.setBounds(150,450,900,30);
        qsn.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qsn);

        question[0][0]= "Which of the following architecture does the Swing framework use?";
        question[0][1]="MVC";
        question[0][2]="MVP";
        question[0][3]="Layered architecture";
        question[0][4]="Master-Slave architecture";

        question[1][0]= "Which language is used in the swing framework?";
        question[1][1]="JavaScript";
        question[1][2]="Java";
        question[1][3]="React";
        question[1][4]="Python";

        question[2][0]= "When is the object created with new keyword?";
        question[2][1]="At run time";
        question[2][2]="At compile time";
        question[2][3]="Depend on the code";
        question[2][4]="None";

        question[3][0]= "An ____ is a change in the state of an item?";
        question[3][1]="Spinner";
        question[3][2]="Event";
        question[3][3]="Occurrence";
        question[3][4]="Activity";

        question[4][0]= "How many types of events are there?";
        question[4][1]="5";
        question[4][2]="4";
        question[4][3]="2";
        question[4][4]="3";

        question[5][0]= "In which of the following is toString() method defined?";
        question[5][1]="java.lang.Object";
        question[5][2]="java.lang.String";
        question[5][3]="java.lang.util";
        question[5][4]="None";

        question[6][0]= "An ____ is a short software that runs in a web browser.";
        question[6][1]="Application";
        question[6][2]="AWT";
        question[6][3]="Applet";
        question[6][4]="JFrame";

        question[7][0]= "Which of the following companies are using swing framework?";
        question[7][1]="IBM";
        question[7][2]="Oracle";
        question[7][3]="Microsoft";
        question[7][4]="All of the above";

        question[8][0]= "The ____ function is used to specify the layout of a container.";
        question[8][1]="UseLayout()";
        question[8][2]="setLayout()";
        question[8][3]="layout()";
        question[8][4]="DesignLayout()";

        question[9][0]= "In Swing, the ____ is used to render visuals and listen for events?";
        question[9][1]="Event adapters";
        question[9][2]="Events Handler";
        question[9][3]="Event listener";
        question[9][4]="Event-Driven Thread";

        answer[0][1]="MVC";
        answer[1][1]="Java";
        answer[2][1]="Component";
        answer[3][1]="Event";
        answer[4][1]="2";
        answer[5][1]="JFrame";
        answer[6][1]="Applet";
        answer[7][1]="All of the above";
        answer[8][1]="setLayout()";
        answer[9][1]="Event-Driven Thread";

        op1 = new JRadioButton();
        op1.setBounds(170,520,700,30);
        op1.setBackground(Color.WHITE);
        op1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op1);

        op2=new JRadioButton();
        op2.setBounds(170,560,700,30);
        op2.setBackground(Color.WHITE);
        op2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op2);

        op3=new JRadioButton();
        op3.setBounds(170,600,700,30);
        op3.setBackground(Color.WHITE);
        op3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op3);

        op4=new JRadioButton();
        op4.setBounds(170,640,700,30);
        op4.setBackground(Color.WHITE);
        op4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op4);

        grpops = new ButtonGroup();
        grpops.add(op1);
        grpops.add(op2);
        grpops.add(op3);
        grpops.add(op4);

        next =new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit =new JButton("Submit");
        submit.setBounds(1100,610,200,40);
        //submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            ans=1;
            if(grpops.getSelection()==null){
                userans[count][0]="";
            }
            else{
                userans[count][0]=grpops.getSelection().getActionCommand();
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        }else if(ae.getSource()==submit){
            ans=1;
            if(grpops.getSelection()==null){
                userans[count][0]="";
            }else{
                userans[count][0]= grpops.getSelection().getActionCommand();
            }
            for(int i=0;i<userans.length;i++){
                if(userans[i][0].equals(answer[i][1])){
                    score+=10;
                }
                else{
                    score+=0;
                }
            }
            setVisible(false);
            new Score(name,score);
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        String time="Time Left -"+timer+" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if(timer>0){
            g.drawString(time, 1100, 500);
        }
        else{
            g.drawString("Times Up!!",1100, 500);
        }
        timer--;

        try{
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(ans==1){
            ans=0;
            timer=15;
        }
        else if(timer<0){
            timer=15;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9){
                if(grpops.getSelection()==null){
                    userans[count][0]="";
                }
                else{
                    userans[count][0]=grpops.getSelection().getActionCommand();
                }
                for(int i=0;i<userans.length;i++){
                    if(userans[i][0].equals(answer[i][1])){
                        score+=10;
                    }
                    else{
                        score+=0;
                    }
                }
                setVisible(false);
                new Score(name,score);
            }
            else{
               if(grpops.getSelection()==null){
                userans[count][0]="";
               }
               else{
                userans[count][0]=grpops.getSelection().getActionCommand();
               }
               count++;
               start(count);
            }
        }
    }

    public void start(int count){
        qno.setText(""+ (count+1)+".");
        qsn.setText(question[count][0]);

        op1.setText(question[count][1]);
        op1.setActionCommand(question[count][1]);
        
        op2.setText(question[count][2]);
        op2.setActionCommand(question[count][2]);
        
        op3.setText(question[count][3]);
        op3.setActionCommand(question[count][3]);
        
        op4.setText(question[count][4]);
        op4.setActionCommand(question[count][4]);
        
        grpops.clearSelection();
    }
    public static void main(String[] arg){
        new Game("User");
    }
}
