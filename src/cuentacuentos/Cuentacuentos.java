package cuentacuentos;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.awt.resources.awt;

public class Cuentacuentos extends JFrame implements ActionListener {

    JFrame principal;
    JPanel panel, superior;
    JButton cuento1, cuento2, cuento3, cuento4, cuento5, cuento6, cuento7, cuento8;

    public Cuentacuentos() {

        JLabel texto;
        Font x = new Font("Arial", 0, 35);
        texto = new JLabel("Cuentacuentos");
        texto.setFont(x);

        cuento1 = new JButton();
        cuento2 = new JButton();
        cuento3 = new JButton();
        cuento4 = new JButton();
        cuento5 = new JButton();
        cuento6 = new JButton();
        cuento7 = new JButton();
        cuento8 = new JButton();

        cuento1.setIcon(new ImageIcon(getClass().getResource("/cuentos/caperucita roja.jpeg")));
        cuento2.setIcon(new ImageIcon(getClass().getResource("/cuentos/casca nueces.jpeg")));
        cuento3.setIcon(new ImageIcon(getClass().getResource("/cuentos/el gato con sombrero.jpeg")));
        cuento4.setIcon(new ImageIcon(getClass().getResource("/cuentos/el monstruo de colores.jpeg")));
        cuento5.setIcon(new ImageIcon(getClass().getResource("/cuentos/el soldadito de plomo.jpeg")));
        cuento6.setIcon(new ImageIcon(getClass().getResource("/cuentos/estirar la pata.jpeg")));
        cuento7.setIcon(new ImageIcon(getClass().getResource("/cuentos/la oveja negra.jpeg")));
        cuento8.setIcon(new ImageIcon(getClass().getResource("/cuentos/pulgarcito.jpeg")));

        cuento1.setBackground(new Color(210, 140, 54));
        cuento2.setBackground(new Color(76, 78, 93));
        cuento3.setBackground(new Color(30, 99, 168));
        cuento4.setBackground(new Color(255, 255, 255));
        cuento5.setBackground(new Color(235, 238, 245));
        cuento6.setBackground(new Color(213, 175, 162));
        cuento7.setBackground(new Color(110, 173, 69));
        cuento8.setBackground(new Color(110, 176, 66));

        cuento1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento1.wav");
            }
        });
        cuento2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento2.wav");
            }
        });
        cuento3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento3.wav");
            }
        });
        cuento4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento4.wav");
            }
        });
        cuento5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento5.wav");
            }
        });
        cuento6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento6.wav");
            }
        });
        cuento7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento7.wav");
            }
        });
        cuento8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReproducirSonido("D:\\TEC\\Topicos\\Tarea vacaciones\\Cuentacuentos\\src\\cuentos\\cuento8.wav");
            }
        });

        panel = new JPanel();
        superior = new JPanel();

        panel.setLayout(new GridLayout(2, 4, 5, 5));
        panel.add(cuento1);
        panel.add(cuento2);
        panel.add(cuento3);
        panel.add(cuento4);
        panel.add(cuento5);
        panel.add(cuento6);
        panel.add(cuento7);
        panel.add(cuento8);

        superior.add(texto);
        superior.setBackground(Color.CYAN);

        principal = new JFrame("Cuentacuentos");
        //principal.setSize(300, 300);
        principal.add(superior, BorderLayout.NORTH);

        principal.add(panel, BorderLayout.CENTER);
        principal.pack();
        principal.setVisible(true);
        principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Cuentacuentos();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public void ReproducirSonido(String nombreSonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
}
