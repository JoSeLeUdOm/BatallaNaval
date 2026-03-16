
package batallanaval;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author josep
 */
public class MenuVentana extends javax.swing.JFrame {
    private JButton jButton1;
    private JButton jButton2;

    public MenuVentana() {
        
        // configuración ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // pantalla completa
        setBackground(Color.BLACK);
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setLayout(new BorderLayout());

        // animación arriba ocupa todo
        AnimacionASCII animacion = new AnimacionASCII();
        getContentPane().add(animacion, BorderLayout.CENTER);

        // panel botones abajo
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.BLACK);
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

        jButton1 = new JButton("JUGAR");
        jButton1.setFont(new Font("Algerian", Font.BOLD, 18));
        jButton1.setForeground(new Color(0, 220, 255));
        jButton1.setBackground(Color.BLACK);
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 200), 2));
        jButton1.setFocusPainted(false);

        jButton2 = new JButton("SALIR");
        jButton2.setFont(new Font("Algerian", Font.BOLD, 18));
        jButton2.setForeground(new Color(0, 220, 255));
        jButton2.setBackground(Color.BLACK);
        jButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 200), 2));
        jButton2.setFocusPainted(false);

        panelBotones.add(jButton1);
        panelBotones.add(jButton2);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        // acciones botones
        jButton1.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
            if (nombre != null && !nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "¡Bienvenido, " + nombre + "!");
            }
        });

        jButton2.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "¡Hasta luego!");
            System.exit(0);
        });

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MenuVentana().setVisible(true));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
