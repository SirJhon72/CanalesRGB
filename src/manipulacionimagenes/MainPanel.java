
package manipulacionimagenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author jgonz
 */
public class MainPanel extends javax.swing.JFrame {

    public MainPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Lienzo = new javax.swing.JLabel();
        BuscarImagen = new javax.swing.JButton();
        Convert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Imagen");

        Lienzo.setText("Imagen");

        BuscarImagen.setText("Cargar Imagen");
        BuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarImagenActionPerformed(evt);
            }
        });

        Convert.setText("Convertir Imagen");
        Convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BuscarImagen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Convert))
                            .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(Lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarImagen)
                    .addComponent(Convert))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarImagenActionPerformed
        try {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String path = file.getAbsolutePath();
        Image in = Toolkit.getDefaultToolkit().createImage(path);
        in = in.getScaledInstance(Lienzo.getWidth(), Lienzo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon li = new ImageIcon(in);
        Lienzo.setIcon(li);
            
        BufferedImage img = ImageIO.read(file);
            
            
            for(int y = 0; y < img.getHeight(); y++){
                for(int x = 0; x < img.getWidth(); x++){
                    
                    //Tomamos los valores RGB de cada pixel
                    int pixel = img.getRGB(x,y);
                    
                    //Obtenemos los 3 canales en general
                    Color color = new Color(pixel, true);
                    
                    //Separamos los colores segun su canal
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    
                    //Cambiamos los valores RGB
                    //red = 0;
                    green = 150;
                    blue = 150;
                    
                    //Asginamos el nuevo color
                    color = new Color(red, green, blue);
                    
                    //Finalmente, aplicamos el nuevo color a la imagen
                    img.setRGB(x, y, color.getRGB());
                }
            }
            //Guardamos la imagen
            file = new File("output.jpg");
            ImageIO.write(img, "jpg", file);
            System.out.println("Terminado");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//https://www.tutorialspoint.com/how-to-set-modify-the-pixels-rgb-values-of-an-image-using-java-opencv-library
//https://www.geeksforgeeks.org/image-processing-java-set-1-read-write/?ref=lbp
    }//GEN-LAST:event_BuscarImagenActionPerformed

    private void ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertActionPerformed
        
        //Cargamos la nueva imagen generada en el proceso anterior
        try {
            File file = new File("output.jpg");
            String path = file.getAbsolutePath();
            Image in = Toolkit.getDefaultToolkit().createImage(path);
            in = in.getScaledInstance(Lienzo.getWidth(), Lienzo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon li = new ImageIcon(in);
            Lienzo.setIcon(li);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al cargar la imagen generada");
        }

      
    }//GEN-LAST:event_ConvertActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarImagen;
    private javax.swing.JButton Convert;
    private javax.swing.JLabel Lienzo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
