
package batallanaval;

/**
 *
 * @author josep
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimacionASCII extends JPanel {

    private int frame = 0;
    private int barcoOffset = 0;
    private boolean mostrarShip = false;
    private boolean mostrarGame = false;
    private Timer timer;

    private final String[] colores = {"#00eeff", "#00ccdd", "#00aacc", "#0088bb", "#00aacc", "#00ccdd"};
    private int colorIdx = 0;

    private final String BATTLE =
        "██████   ████  ████████ ████████ ██      ████████\n" +
        "██   ██ ██  ██    ██       ██    ██      ██      \n" +
        "██████  ██████    ██       ██    ██      █████   \n" +
        "██   ██ ██  ██    ██       ██    ██      ██      \n" +
        "██████  ██  ██    ██    ████████ ███████ ████████";

    private final String SHIP =
        " ██████ ██   ██ ██ ██████ \n" +
        "██      ██   ██ ██ ██   ██\n" +
        "███████ ███████ ██ ██████ \n" +
        "     ██ ██   ██ ██ ██     \n" +
        " █████  ██   ██ ██ ██     ";

    private final String GAME =
        " ██████   ████  ██   ██ ████████\n" +
        "██       ██  ██ ███ ███ ██      \n" +
        "██   ███ ██████ ██ █ ██ █████   \n" +
        "██    ██ ██  ██ ██   ██ ██      \n" +
        " ██████  ██  ██ ██   ██ ████████";

    public AnimacionASCII() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(700, 320));

        timer = new Timer(200, e -> {
            frame++;
            colorIdx = (colorIdx + 1) % colores.length;
            barcoOffset = (barcoOffset + 1) % 40;
            if (frame == 4) mostrarShip = true;
            if (frame == 8) mostrarGame = true;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Font fuenteGrande = new Font("Courier New", Font.BOLD, 11);
        Font fuenteChica = new Font("Courier New", Font.PLAIN, 13);
        g2.setFont(fuenteGrande);

        // Color animado para BATTLE
        g2.setColor(Color.decode(colores[colorIdx]));
        dibujarMultilinea(g2, BATTLE, 20, 30);

        // SHIP
        if (mostrarShip) {
            g2.setColor(new Color(0, 180, 200));
            dibujarMultilinea(g2, SHIP, 20, 110);
        }

        // GAME
        if (mostrarGame) {
            g2.setColor(new Color(0, 150, 180));
            dibujarMultilinea(g2, GAME, 20, 190);
        }

        // Barco moviéndose
        g2.setFont(fuenteChica);
        g2.setColor(new Color(170, 220, 255));
        String barco = " ".repeat(barcoOffset) + "       |    |        \n" +
                       " ".repeat(barcoOffset) + "    .--+---.--+--.   \n" +
                       " ".repeat(barcoOffset) + "  __|___|__|___|__   \n" +
                       " ".repeat(barcoOffset) + "  \\_______________/  ";
        dibujarMultilinea(g2, barco, 10, 250);

        // Olas
        g2.setColor(new Color(0, 80, 120));
        String olas = (frame % 2 == 0)
            ? "~  ~~~  ~  ~~~  ~  ~~~  ~  ~~~  ~  ~~~  ~"
            : "~~~  ~  ~~~  ~  ~~~  ~  ~~~  ~  ~~~  ~  ";
        g2.drawString(olas, 10, 305);
    }

    private void dibujarMultilinea(Graphics2D g, String texto, int x, int y) {
        String[] lineas = texto.split("\n");
        int lineaAltura = g.getFontMetrics().getHeight();
        for (int i = 0; i < lineas.length; i++) {
            g.drawString(lineas[i], x, y + i * lineaAltura);
        }
    }
}
