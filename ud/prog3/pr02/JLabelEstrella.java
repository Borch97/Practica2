package ud.prog3.pr02;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelEstrella extends JLabel {

    private static final long serialVersionUID = 1L;  // Para serialización
    public static final int TAMANYO_ESTRELLA = 40;  // píxels (igual ancho que algo)
    public static final int RADIO_ESFERA_COCHE = 17;  // Radio en píxels del bounding circle del coche (para choques)
    public static final long FechaCreacion = System.currentTimeMillis();


    /** Construye y devuelve el JLabel de la estrella con su gráfico y tamaño
     */
    public JLabelEstrella() {
        // Esto se haría para acceder por sistema de ficheros
        // 		super( new ImageIcon( "bin/ud/prog3/pr00/estrella.png" ) );
        // Esto se hace para acceder tanto por recurso (jar) como por fichero
        try {
            setIcon( new ImageIcon( JLabelCoche.class.getResource( "img/estrella.png" ).toURI().toURL() ) );
        } catch (Exception e) {
            System.err.println( "Error en carga de recurso: estrella.png no encontrado" );
            e.printStackTrace();
        }
    }

    // Redefinición del paintComponent para que se escale el gráfico
    @Override
    protected void paintComponent(Graphics g) {
//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
        Image img = ((ImageIcon)getIcon()).getImage();
        Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
        // Escalado más fino con estos 3 parámetros:
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, TAMANYO_ESTRELLA, TAMANYO_ESTRELLA, null );
    }

}
