package com.sxt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameJFrame extends JFrame implements ActionListener {

    // 创建按钮对象
    ImageIcon iconButton1 = new ImageIcon("imgs\\button1.png");
    ImageIcon iconButton2 = new ImageIcon("imgs\\button2.png");
    JButton jbt = new JButton();
    JButton jbt1 = new JButton();

    ImageIcon icon = new ImageIcon("imgs\\start.jpg");
    ImageIcon icon1=new ImageIcon("imgs\\title.png");
    JLabel jLabel = new JLabel(icon);
    JLabel jLabel1=new JLabel(icon1);
    public GameJFrame() {
        initJFrame();
        initImage();
        setLayout(null);
        this.setVisible(true);
    }

    private void initImage() {
        jLabel.setBounds(0, 0, 600, 913);

        this.getContentPane().add(jLabel);

    }

    private void initJFrame() {
        this.setSize(571, 913);
        this.setLocationRelativeTo((null));
        setTitle("飞机大战1.0");
        setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 设置按钮1
        jbt.setIcon(iconButton1);
        jbt.setBorderPainted(false);
        jbt.setContentAreaFilled(false);
        jbt.setBounds(571 / 2 - 60, 400, 120, 43);
        jbt.addActionListener(this);
        this.getContentPane().add(jbt);

        // 设置按钮2
//        jbt1.setIcon(iconButton2);
//        jbt1.setBorderPainted(false);
//        jbt1.setContentAreaFilled(false);
//        jbt1.setBounds(571 / 2 - 60, 500, 120, 43);
//        jbt1.addActionListener(this);
//        this.getContentPane().add(jbt1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == jbt) {
            System.out.println("你点击了开始游戏");
            new Game1();
        }
        if (source == jbt1) {
            System.out.println("你点击了模式选择");
        }
    }
}