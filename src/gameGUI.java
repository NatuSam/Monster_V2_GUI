import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.image.*;

import static java.awt.Color.*;

public class gameGUI extends JFrame implements ActionListener {

    public String Pname;
    public int ph = 100;
    public int p1h = 100;
    public int p2h= 100;
    public int mh = 100;
    public String killed = "U Killed The Monster! \n press play to restart";
    public String dead = "The Monster Killed U! \n press play to restart";

    JPanel gameT, wel, PTOB, menu, PTOP;
    JLabel welM, player,phealth, monster, mhealth, gameEndPtoB, gameEndPtoP, player1, player2, p1health,p2health;
    JTextField name,name2;
    JButton play,atk, atk2,atk1,start;
    Border border = BorderFactory.createLineBorder(blue,4);
    ImageIcon pimage = new ImageIcon("mega.jpg");

    gameGUI(){


        this.setTitle("Monster Game");
        this.setVisible(true);
        this.setIconImage(pimage.getImage());
        this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750,750);
        this.setLayout(null);
        this.setResizable(false);


        menu = new JPanel();
        menu.setBackground(red);
        menu.setBounds(0,0, 750,100);
        menu.setBorder(border);
        menu.setLayout(null);

        play = new JButton();
        play.setBounds(225, 30,100,50);
        play.setText("Play");
        play.setFocusable(false);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b1) {
                gameT.setVisible(true);
                if(mh!=100 || ph!=100 || p1h!=100 || p2h!=100){
                    ph=100;
                    mh=100;
                    phealth.setText("100");
                    p1health.setText("100");
                    p2health.setText("100");
                    mhealth.setText("100");
                    player.setText("Player1");
                    player1.setText("Player1");
                    player2.setText("Player2");
                    start.setVisible(true);
                    gameEndPtoB.setVisible(false);
                    gameEndPtoP.setVisible(false);
                }
            }
        });

        JButton rec = new JButton();
        rec.setBounds(425, 30,100,50);
        rec.setText("record");
        rec.setFocusable(false);

        menu.add(play);
        menu.add(rec);

        gameT = new JPanel();
        gameT.setBackground(orange);
        gameT.setBounds(0,100, 750,100);
        gameT.setBorder(border);
        gameT.setLayout(null);
        gameT.setVisible(false);

        JButton ptop = new JButton();
        ptop.setBounds(270, 30,80,40);
        ptop.setText("P to P");
        ptop.setFocusable(false);
        ptop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wel.setVisible(true);
                start.setVisible(true);
                if(ph==100||p1h==100) {
                    PTOB.setVisible(false);
                    PTOP.setVisible(true);
                }
                name.setVisible(true);
                name2.setVisible(true);
                atk.setVisible(false);
                atk1.setVisible(true);
                atk2.setVisible(true);
            }
        });

        JButton ptob = new JButton();
        ptob.setBounds(400, 30,80,40);
        ptob.setText("P to Bot");
        ptob.setFocusable(false);
        ptob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b2) {
                wel.setVisible(true);

                if(ph==100||p2h==100) {
                    PTOB.setVisible(true);
                    PTOP.setVisible(false);
                }
                name.setVisible(true);
                name2.setVisible(false);
                atk.setVisible(true);
                atk2.setVisible(false);
                atk1.setVisible(false);
            }
        });

        gameT.add(ptop);
        gameT.add(ptob);

        wel = new JPanel();
        wel.setBackground(yellow);
        wel.setBounds(0,200, 750,200);
        wel.setLayout(null);
        wel.setBorder(border);
        wel.setVisible(false);

        welM = new JLabel();
        welM.setText("Welcome to Monster Game!");
        welM.setForeground(green);
        welM.setBounds(275, 40,200,40);

        name = new JTextField("Player1",25);
        name.setBounds(275, 90,200,20);
        name.setVisible(false);
        name2 = new JTextField("Player2",25);
        name2.setBounds(275, 120,200,20);
        name2.setVisible(false);

        start = new JButton();
        start.setBounds(300, 150,80,40);
        start.setText("Start");
        start.setFocusable(false);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setText(name.getText());
                player1.setText(name.getText());
                player2.setText(name2.getText());
                name.setVisible(false);
                name2.setVisible(false);
                start.setVisible(false);
                atk2.setVisible(false);
            }
        });


        wel.add(welM);
        wel.add(name);
        wel.add(name2);
        wel.add(start);


        PTOB = new JPanel();
        PTOB.setBounds(0,400, 750,300);
        PTOB.setBackground(white);
        PTOB.setBorder(border);
        PTOB.setLayout(null);
        PTOB.setVisible(false);

        player = new JLabel();
        player.setBounds(142, 100, 150,100);
        player.setFont(new Font("Serif", Font.BOLD, 20));
        player.setVisible(true);

        phealth = new JLabel();
        phealth.setText(String.valueOf(ph));
        phealth.setForeground(GREEN);
        phealth.setBounds(160, 175, 50,50);
        phealth.setVisible(true);

        monster = new JLabel("Monster");
        monster.setBounds(557, 100, 150,100);
        monster.setFont(new Font("Serif", Font.BOLD, 20));
        monster.setVisible(true);

        mhealth = new JLabel();
        mhealth.setText(String.valueOf(mh));
        mhealth.setForeground(RED);
        mhealth.setBounds(570, 175, 50,50);
        mhealth.setVisible(true);

        atk = new JButton("Atk");
        atk.setBounds(335, 125 , 80,50);
        atk.setVisible(true);
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
                    gameEndPtoB.setText(killed);
                    gameEndPtoB.setVisible(true);
                    atk.setVisible(false);
                    mhealth.setText("0");

                }
                else if (ph<=0){
                    gameEndPtoB.setText(dead);
                    gameEndPtoB.setVisible(true);
                    atk.setVisible(false);
                    phealth.setText("0");
                }

            }
        });

        gameEndPtoB = new JLabel(killed);
        gameEndPtoB.setBounds(175, 50 ,400,100);
        gameEndPtoB.setFont(new Font("Serif", Font.BOLD, 20));
        gameEndPtoB.setVisible(false);

        PTOB.add(monster);
        PTOB.add(mhealth);
        PTOB.add(atk);
        PTOB.add(player);
        PTOB.add(phealth);
        PTOB.add(gameEndPtoB);

        PTOP = new JPanel();
        PTOP.setBounds(0,400, 750,300);
        PTOP.setBackground(white);
        PTOP.setBorder(border);
        PTOP.setLayout(null);
        PTOP.setVisible(false);


        player1 = new JLabel();
        player1.setBounds(142, 100, 150,100);
        player1.setFont(new Font("Serif", Font.BOLD, 20));
        player1.setVisible(true);

        p1health = new JLabel();
        p1health.setText(String.valueOf(p1h));
        p1health.setForeground(GREEN);
        p1health.setBounds(160, 175, 50,50);
        p1health.setVisible(true);

        player2 = new JLabel();
        player2.setBounds(580, 100, 150,100);
        player2.setFont(new Font("Serif", Font.BOLD, 20));
        player2.setVisible(true);

        p2health = new JLabel();
        p2health.setText(String.valueOf(p2h));
        p2health.setForeground(GREEN);
        p2health.setBounds(590, 175, 50,50);
        p2health.setVisible(true);

        atk1 = new JButton("Atk");
        atk1.setBounds(225, 125 , 80,50);
        atk1.setFocusable(false);
        atk1.setVisible(true);
        atk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent at) {
                if(p2h>0 && p1h>0){
                    int p = rcheck();
                    p2h = p2h - p;
                    p2health.setText(String.valueOf(p2h));
                }
                atk1.setVisible(false);
                atk2.setVisible(true);
                if (p2h<=0) {
                    atk1.setVisible(false);
                    atk2.setVisible(false);
                    p2health.setText("0");
                    gameEndPtoP.setText(player1.getText() + " WON!");
                    gameEndPtoP.setVisible(true);
                }
                else {
                    atk1.setVisible(false);
                    atk2.setVisible(true);
                }


            }
        });

        atk2 = new JButton("Atk");
        atk2.setBounds(495, 125 , 80,50);
        atk2.setFocusable(false);
        atk2.setVisible(true);
        atk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent at) {
                if(p2h>0 && p1h>0){
                    int p = rcheck();
                    p1h = p1h - p;
                    p1health.setText(String.valueOf(p1h));
                }
                atk1.setVisible(true);
                atk2.setVisible(false);
                if (p1h<=0) {
                    atk1.setVisible(false);
                    atk2.setVisible(false);
                    p1health.setText("0");
                    gameEndPtoP.setText(player2.getText() + " WON!");
                    gameEndPtoP.setVisible(true);
                }
                else {
                    atk1.setVisible(true);
                    atk2.setVisible(false);
                }


            }
        });

        gameEndPtoP = new JLabel("Player1 "+ "won!");
        gameEndPtoP.setBounds(300, 50 ,400,100);
        gameEndPtoP.setForeground(RED);
        gameEndPtoP.setFont(new Font("Serif", Font.BOLD, 20));
        gameEndPtoP.setVisible(false);


        PTOP.add(player1);
        PTOP.add(p1health);
        PTOP.add(player2);
        PTOP.add(p2health);
        PTOP.add(atk1);
        PTOP.add(atk2);
        PTOP.add(gameEndPtoP);

        this.add(PTOP);
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
