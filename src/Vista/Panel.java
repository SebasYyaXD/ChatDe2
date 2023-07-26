package chatDe2.Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JTextField;
import chatDe2.Controlador.EnviarTexto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Panel extends JPanel {

    private final JTextField txtCampo;
    private final JButton btnEnviar;
    private final JButton btnEmojis;
    private final JPopupMenu emojiMenu;
    private final JLabel JLabelCesar;

    public Panel() {

        JLabelCesar = new JLabel("Cesar");
        txtCampo = new JTextField(20);
        txtCampo.setFont(new Font("Apple Color Emoji", Font.PLAIN, 12));

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new EnviarTexto(txtCampo, JLabelCesar));

        btnEmojis = new JButton("😊");
        btnEmojis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmojiMenu(btnEmojis);
            }
        });

        txtCampo.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }
        });
        updateButtonState();

        emojiMenu = new JPopupMenu();

        JMenu subMenuEmojis = new JMenu("Emojis");
        subMenuEmojis.add(createEmojiMenuItem("😊"));
        subMenuEmojis.add(createEmojiMenuItem("😄"));
        subMenuEmojis.add(createEmojiMenuItem("😍"));
        subMenuEmojis.add(createEmojiMenuItem("😘"));
        subMenuEmojis.add(createEmojiMenuItem("😎"));
        subMenuEmojis.add(createEmojiMenuItem("😇"));
        subMenuEmojis.add(createEmojiMenuItem("🤗"));
        subMenuEmojis.add(createEmojiMenuItem("😂"));
        subMenuEmojis.add(createEmojiMenuItem("😋"));
        subMenuEmojis.add(createEmojiMenuItem("🤔"));
        subMenuEmojis.add(createEmojiMenuItem("😡"));
        subMenuEmojis.add(createEmojiMenuItem("😭"));

        JMenu subMenuAnimales = new JMenu("Animales");
        subMenuAnimales.add(createEmojiMenuItem("🐶"));
        subMenuAnimales.add(createEmojiMenuItem("🐱"));
        subMenuAnimales.add(createEmojiMenuItem("🐭"));
        subMenuAnimales.add(createEmojiMenuItem("🐰"));
        subMenuAnimales.add(createEmojiMenuItem("🦊"));
        subMenuAnimales.add(createEmojiMenuItem("🦁"));
        subMenuAnimales.add(createEmojiMenuItem("🐻"));
        subMenuAnimales.add(createEmojiMenuItem("🐯"));
        subMenuAnimales.add(createEmojiMenuItem("🐸"));
        subMenuAnimales.add(createEmojiMenuItem("🐌"));
        subMenuAnimales.add(createEmojiMenuItem("🐘"));
        subMenuAnimales.add(createEmojiMenuItem("🦑"));

        JMenu subMenuComida = new JMenu("Comida");
        subMenuComida.add(createEmojiMenuItem("🍕"));
        subMenuComida.add(createEmojiMenuItem("🍣"));
        subMenuComida.add(createEmojiMenuItem("🍔"));
        subMenuComida.add(createEmojiMenuItem("🌮"));
        subMenuComida.add(createEmojiMenuItem("🍿"));
        subMenuComida.add(createEmojiMenuItem("🍝"));
        subMenuComida.add(createEmojiMenuItem("🍱"));
        subMenuComida.add(createEmojiMenuItem("🍛"));
        subMenuComida.add(createEmojiMenuItem("🍲"));
        subMenuComida.add(createEmojiMenuItem("🍦"));
        subMenuComida.add(createEmojiMenuItem("🍩"));
        subMenuComida.add(createEmojiMenuItem("🍺"));
        subMenuComida.add(createEmojiMenuItem("🍹"));

        JMenu subMenuViajes = new JMenu("Viajes");
        subMenuViajes.add(createEmojiMenuItem("✈️"));
        subMenuViajes.add(createEmojiMenuItem("🚗"));
        subMenuViajes.add(createEmojiMenuItem("🚆"));
        subMenuViajes.add(createEmojiMenuItem("🚢"));
        subMenuViajes.add(createEmojiMenuItem("🚲"));
        subMenuViajes.add(createEmojiMenuItem("🏔️"));
        subMenuViajes.add(createEmojiMenuItem("🗽"));
        subMenuViajes.add(createEmojiMenuItem("🏰"));
        subMenuViajes.add(createEmojiMenuItem("🗺️"));
        subMenuViajes.add(createEmojiMenuItem("🏝️"));
        subMenuViajes.add(createEmojiMenuItem("🏟️"));
        subMenuViajes.add(createEmojiMenuItem("🏞️"));

        JMenu subMenuNaturaleza = new JMenu("Naturaleza");
        subMenuNaturaleza.add(createEmojiMenuItem("🌞"));
        subMenuNaturaleza.add(createEmojiMenuItem("🌧️"));
        subMenuNaturaleza.add(createEmojiMenuItem("🌈"));
        subMenuNaturaleza.add(createEmojiMenuItem("🌪️"));
        subMenuNaturaleza.add(createEmojiMenuItem("❄️"));
        subMenuNaturaleza.add(createEmojiMenuItem("🌊"));
        subMenuNaturaleza.add(createEmojiMenuItem("🍃"));
        subMenuNaturaleza.add(createEmojiMenuItem("🌸"));
        subMenuNaturaleza.add(createEmojiMenuItem("🌳"));
        subMenuNaturaleza.add(createEmojiMenuItem("🍂"));
        subMenuNaturaleza.add(createEmojiMenuItem("☔"));
        subMenuNaturaleza.add(createEmojiMenuItem("🌋"));

        // Agrega los submenús al menú principal
        emojiMenu.add(subMenuEmojis);
        emojiMenu.add(subMenuAnimales);
        emojiMenu.add(subMenuNaturaleza);
        emojiMenu.add(subMenuComida);
        emojiMenu.add(subMenuViajes);

        add(btnEmojis);
        add(JLabelCesar);
        add(txtCampo);
        add(btnEnviar);
    }

    private void showEmojiMenu(JButton btnEmojis) {
        emojiMenu.show(btnEmojis, 0, btnEmojis.getHeight());
    }

    private JMenuItem createEmojiMenuItem(String emoji) {
        JMenuItem item = new JMenuItem(emoji);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCampo.setText(txtCampo.getText() + emoji);
            }
        });
        return item;
    }

    private void updateButtonState() {
        String text = txtCampo.getText().trim();
        boolean isEmpty = text.isEmpty();
        btnEnviar.setEnabled(!isEmpty);
    }

}
