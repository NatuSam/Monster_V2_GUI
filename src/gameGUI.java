import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.Color.*;

public class gameGUI extends JFrame implements ActionListener {

    public String Pname;
    public int ph = 100;
    public int mh = 100;
    public String killed = "U Killed The Monster! \n press play to restart";
    public String dead = "The Monster Killed U! \n press play to restart";
    JPanel gameT, wel, PTOB;
    JLabel player,phealth, monster, mhealth, gameend;
    JTextField name;
    JButton atk;
    Border border = BorderFactory.createLineBorder(blue,4);
    ImageIcon pimage = new ImageIcon("mega.png");

    gameGUI(){


        this.setTitle("Monster Game");
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750,750);
        this.setLayout(null);
        this.setResizable(false);


        JPanel menu = new JPanel();
        menu.setBackground(red);
        menu.setBounds(0,0, 750,100);
        menu.setBorder(border);
        menu.setLayout(null);

        JButton game = new JButton();
        game.setBounds(225, 30,100,50);
        game.setText("Play");
        game.setFocusable(false);
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b1) {
                gameT.setVisible(true);
                wel.setVisible(true);
                name.setVisible(true);
                if(mh<=0 || ph<=0){
                    ph= 100;
                    mh= 100;
                    phealth.setText(String.valueOf(ph));
                    mhealth.setText(String.valueOf(mh));
                }
            }
        });

        JButton rec = new JButton();
        rec.setBounds(425, 30,100,50);
        rec.setText("record");
        rec.setFocusable(false);

        menu.add(game);
        menu.add(rec);

        wel = new JPanel();
        wel.setBackground(yellow);
        wel.setBounds(0,100, 750,200);
        wel.setLayout(null);
        wel.setBorder(border);
        wel.setVisible(false);

        JLabel welc = new JLabel();
        welc.setText("Welcome to Monster Game!");
        welc.setForeground(green);
        welc.setBounds(275, 40,200,40);
        wel.add(welc);

        name = new JTextField("Player1",25);
        name.setBounds(275, 90,200,20);
        wel.add(name);

        gameT = new JPanel();
        gameT.setBackground(orange);
        gameT.setBounds(0,300, 750,100);
        gameT.setBorder(border);
        gameT.setLayout(null);
        gameT.setVisible(false);

        JButton ptop = new JButton();
        ptop.setBounds(270, 30,80,40);
        ptop.setText("P to P");
        ptop.setFocusable(false);

        JButton ptob = new JButton();
        ptob.setBounds(400, 30,80,40);
        ptob.setText("P to Bot");
        ptob.setFocusable(false);
        ptob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b2) {
                player.setText(name.getText());
                PTOB.setVisible(true);
                name.setVisible(false);
                gameend.setVisible(false);
                atk.setVisible(true);


            }
        });

        gameT.add(ptop);
        gameT.add(ptob);



        PTOB = new JPanel();
        PTOB.setBounds(0,400, 750,300);
        PTOB.setBackground(white);
        PTOB.setBorder(border);
        PTOB.setLayout(null);
        PTOB.setVisible(false);

        player = new JLabel();
        player.setBounds(142, 100, 150,100);
        player.setFont(new Font("Serif", Font.BOLD, 20));

        phealth = new JLabel();
        phealth.setText(String.valueOf(ph));
        phealth.setForeground(GREEN);
        phealth.setBounds(160, 175, 50,50);

        atk = new JButton("Atk");
        atk.setBounds(335, 125 , 80,50);
        atk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent at) {
                if(mh>0 && ph>0){
                    int p = rcheck();
                    ph = ph - p;
                    int m = rcheck();
                    mh = mh - m;
                    phealth.setText(String.valueOf(ph));
                    mhealth.setText(String.valueOf(mh));
                }
                if (mh<=0) {
                    gameend.setText(killed);
                    gameend.setVisible(true);
                    atk.setVisible(false);
                    mh = 0;

                }
                else if (ph<=0){
                    gameend.setText(dead);
                    gameend.setVisible(true);
                    atk.setVisible(false);
                    ph=0;
                }

            }
        });

        monster = new JLabel("Monster");
        monster.setBounds(557, 100, 150,100);
        monster.setFont(new Font("Serif", Font.BOLD, 20));

        mhealth = new JLabel();
        mhealth.setText(String.valueOf(mh));
        mhealth.setForeground(RED);
        mhealth.setBounds(570, 175, 50,50);

        PTOB.add(monster);
        PTOB.add(mhealth);
        PTOB.add(atk);
        PTOB.add(player);
        PTOB.add(phealth);

        gameend = new JLabel(killed);
        gameend.setBounds(225, 50 ,300,100);
        gameend.setFont(new Font("Serif", Font.BOLD, 20));
        gameend.setVisible(false);

        PTOB.add(gameend);

        this.add(PTOB);
        this.add(menu);
        this.add(gameT);
        this.add(wel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public int rcheck(){
        //This method returns a random number fron 0-6
        //The if statements are used to make the randomness by percent
        Random rand = new Random();
        int r = rand.nextInt(100);
        if(r <=18){ r=6;}
        else if(18<r && r <=32){  r=5;}
        else if(32<r && r <=45){ r=4;}
        else if(45<r && r <=58){ r=3;}
        else if(58<r && r <=71){r=2;}
        else if(71<r && r <=85){ r=1;}
        else if(85<r && r <=100){r=0;}
        return r;
    }
}
