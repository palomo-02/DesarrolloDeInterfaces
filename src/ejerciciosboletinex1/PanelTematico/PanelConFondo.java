
package ejerciciosboletinex1.PanelTematico;

import javax.swing.*;
import java.awt.*;

public class PanelConFondo extends JPanel {
    private Image imagenFondo;

    public PanelConFondo(String rutaImagen) {
    imagenFondo = new ImageIcon(rutaImagen).getImage();
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
