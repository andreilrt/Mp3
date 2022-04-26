package Mp3;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Reproductor extends javax.swing.JDialog {

    Proceso Mp3ClassPlayer = new Proceso();
    public static int count;

    public Reproductor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Imagen = new javax.swing.JLabel();
        plus = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        stop = new javax.swing.JLabel();
        pause = new javax.swing.JLabel();
        Display = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/no gif.png"))); // NOI18N
        jPanel1.add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 250));

        plus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/mas.png"))); // NOI18N
        plus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                plusMouseReleased(evt);
            }
        });
        jPanel1.add(plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 50, 50));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/play.png"))); // NOI18N
        play.setText("jLabel2");
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playMouseReleased(evt);
            }
        });
        jPanel1.add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 50, 50));

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/stop.png"))); // NOI18N
        stop.setText("jLabel2");
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stopMouseReleased(evt);
            }
        });
        jPanel1.add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 50, 50));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/pause.png"))); // NOI18N
        pause.setText("jLabel2");
        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pauseMouseReleased(evt);
            }
        });
        jPanel1.add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 50, 50));

        Display.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 250, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseReleased
        try {
            Mp3ClassPlayer.Pause();
            Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/no gif.png")));
        } catch (IOException ex) {
            Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pauseMouseReleased

    private void stopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseReleased
        Mp3ClassPlayer.Stop();
        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/no gif.png")));
    }//GEN-LAST:event_stopMouseReleased

    private void playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseReleased
        Mp3ClassPlayer.Resume();
        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/gif.gif")));
    }//GEN-LAST:event_playMouseReleased

    private void plusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusMouseReleased
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
        JFileChooser chooser = new JFileChooser("C:\\Users\\lsras\\Music\\Music");
        chooser.addChoosableFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Mp3ClassPlayer.Stop();
            File myFile = chooser.getSelectedFile();
            String song = myFile + "";
            String name = chooser.getSelectedFile().getName();
            Display.setText("<html>" + name + "</html>");
            Mp3ClassPlayer.Play(song);
            Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mp3/gif.gif")));
        }
    }//GEN-LAST:event_plusMouseReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Reproductor dialog = new Reproductor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Display;
    private javax.swing.JLabel Imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pause;
    private javax.swing.JLabel play;
    private javax.swing.JLabel plus;
    private javax.swing.JLabel stop;
    // End of variables declaration//GEN-END:variables
}
