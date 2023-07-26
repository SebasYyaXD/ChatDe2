/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andre Sebastián
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI extends JFrame {

    private final JTextArea areatexto;
    private final Panel chatPanel;

    public GUI() throws HeadlessException {
        setTitle("Chat Angel"); // Cambio de "Chat André" a "Chat Angel"
        // Cargar la imagen desde la carpeta de recursos
        ImageIcon icono = new ImageIcon(getClass().getResource("chat.png"));
        setIconImage(icono.getImage());

        setBounds(600, 300, 400, 250);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        areatexto = new JTextArea();
        areatexto.setFont(new Font("Apple Color Emoji", Font.PLAIN, 12));
        areatexto.setEditable(false);
        mainPanel.add(areatexto, BorderLayout.CENTER);

        chatPanel = new Panel();
        chatPanel.setFont(new Font("Apple Color Emoji", Font.PLAIN, 30));
        mainPanel.add(chatPanel, BorderLayout.SOUTH);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void iniciarServidor() {
        Servidor servidor = new Servidor(areatexto);
        servidor.start();
    }
}
