/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reloj;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.SwingUtilities;

/**
 *
 * @author aleja
 */
public class Frame {
    
    public JFrame f = new JFrame();
    public JPanel p = new JPanel();
    
    public JTextField tf_h = new JTextField();
    public JTextField tf_m = new JTextField();
    public JTextField tf_s = new JTextField();
    
    public JTextField tf_d = new JTextField();
    public JTextField tf_mth = new JTextField();
    public JTextField tf_y = new JTextField();   
    
    public JLabel h = new JLabel("Hr");
    public JLabel m = new JLabel("Mts");
    public JLabel s = new JLabel("Sg");
    
    public JLabel p1 = new JLabel(":");
    public JLabel p2 = new JLabel(":");
    
    public JButton ok = new JButton("Ok");
    
    public Font fn = new Font("Arial", Font.BOLD, 30);
    public Font fl = new Font("Arial", Font.BOLD, 18);
    public Font fp = new Font("Arial", Font.BOLD, 25);
    
    public Font tm = new Font("Arial", Font.BOLD, 50);
    public Font th = new Font("Arial", Font.BOLD, 20);
    
    public  String[] options1 = {"Enero", "Ferbrero", "Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public  String[] options2 = {"1", "2", "3","4", "5", "6","7", "8", "9","10", "11", "12","13", "14", "15","16", "17", "18","19", "20", "21","22", "23", "24","26","27","28","29","30","31"};
    public  String[] options3 = {"1999", "2000", "2001","2002", "2003", "2004","2005", "2006", "2007","2008", "2009", "2010","2011", "2012", "2013","2014", "2015", "2016","2017", "2018", "2019","2020", "2021", "2022","2023"};
    
    public  JComboBox comboBox1 = new JComboBox<>(options1);
    public  JComboBox comboBox2 = new JComboBox<>(options2);
    public  JComboBox comboBox3 = new JComboBox<>(options3);
    
    public Frame(){
        
       f.setSize(500,300);
       f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
       f.setLocationRelativeTo(null);  
       f.setResizable(false);
       f.add(p);
       p.setLayout(null);
       
       //Hora
       
       p.add(h);
       p.add(p1);
       h.setFont(fl);
       h.setBounds(145, 100, 50, 50);
       p1.setFont(fp);
       p1.setBounds(195, 50, 50, 50);
       p.add(tf_h);
       tf_h.setBounds(130, 50, 50, 50);
       tf_h.setFont(fn);
       
       //Minutos
       
       p.add(p2);
       p2.setFont(fp);
       p2.setBounds(279, 50, 50, 50);
       p.add(m);
       m.setFont(fl);
       m.setBounds(223,100, 100, 50);
       p.add(tf_m);
       tf_m.setBounds(215, 50, 50, 50);
       tf_m.setFont(fn);
       
       //Segundos
       
       p.add(s);
       s.setFont(fl);
       s.setBounds(310, 100, 100, 50);
       p.add(tf_s);
       tf_s.setBounds(300, 50, 50, 50);
       tf_s.setFont(fn);
       
       
       
       p.add(comboBox1);
       comboBox1.setBounds(80, 150, 100, 30);
       
       p.add(comboBox2);
       comboBox2.setBounds(215, 150, 50, 30);
       
       p.add(comboBox3);
       comboBox3.setBounds(300, 150, 100, 30); 

       
       p.add(ok);
       ok.setBounds(210, 200, 60, 35);
       ok.setFont(fl);

       ok.addActionListener(new ActionListener() {
    
           @Override
    public void actionPerformed(ActionEvent e) {
       
        f.dispose();

        JFrame newFrame = new JFrame("Reloj");
        JPanel pn = new JPanel();
        JLabel hora = new JLabel();

        JLabel mes = new JLabel();
        JLabel dia = new JLabel();
        JLabel año = new JLabel();
        
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(400, 200);
        newFrame.setLocationRelativeTo(null);
        newFrame.setResizable(false);

        newFrame.add(pn);
        pn.setLayout(null);
        pn.setBackground(Color.black);
        pn.add(hora);
        pn.add(mes);
        pn.add(dia);
        pn.add(año);
        
        hora.setFont(tm);
        hora.setBounds(100, 50, 300, 100);
        hora.setForeground(Color.red);
        
        mes.setFont(th);
        mes.setBounds(200, 0, 150, 30);
        mes.setForeground(Color.gray);
        
        dia.setFont(th);
        dia.setBounds(270, 0, 150, 30);
        dia.setForeground(Color.gray);
        
        año.setFont(th);
        año.setBounds(300, 0, 150, 30);
        año.setForeground(Color.gray);
        
        newFrame.setVisible(true);

        final int nh = Integer.parseInt(tf_h.getText());
        final int nm = Integer.parseInt(tf_m.getText());
        final int ns = Integer.parseInt(tf_s.getText());
         
        String box1 = (String) comboBox1.getSelectedItem();
        String box2 = (String) comboBox2.getSelectedItem();
        String box3 = (String) comboBox3.getSelectedItem();
              
        Thread thread = new Thread(() -> {
           
            int hour = nh;
            int minute = nm;
            int second = ns;

            while (true) {
                second++;
                if (second == 60) {
                    second = 0;
                    minute++;
                }
                if (minute == 60) {
                    minute = 0;
                    hour++;
                }
                if (hour == 24) {
                    hour = 0;
                }

                String horah = String.format("%02d", hour);
                String horam = String.format("%02d", minute);
                String horas = String.format("%02d", second);
                String tiempoCompleto = horah + ":" + horam + ":" + horas;

                SwingUtilities.invokeLater(() -> {
                   
                    hora.setText(tiempoCompleto);
                  
                    mes.setText(box1);
                    dia.setText(box2);
                    año.setText(box3);
               
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ee) {
                    ee.printStackTrace();
                }
            }
        });

        thread.start();
    }
});

        p.add(ok);
       
       
       f.setVisible(true);
        
     
    }
    
}
