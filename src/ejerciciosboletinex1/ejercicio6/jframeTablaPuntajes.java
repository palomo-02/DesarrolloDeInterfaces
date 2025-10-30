/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejerciciosboletinex1.ejercicio6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class jframeTablaPuntajes extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(jframeTablaPuntajes.class.getName());
    private TableRowSorter<TableModel> sorter;
    private DefaultTableModel model; // ✅ AÑADE ESTA LÍNEA

    /**
     * Creates new form jframeTablaPuntajes
     */
    public jframeTablaPuntajes() {
        initComponents();

        // ✅ SOLO UN MODELO - ELIMINA 'cambioNombre'
        model = new DefaultTableModel();
        String titulo[] = {"jugador", "puntaje", "nivel", "prioridad"};
        model.setColumnIdentifiers(titulo);
        jTable1.setModel(model);

        sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        sorter.setSortKeys(java.util.Arrays.asList(
                new javax.swing.RowSorter.SortKey(1, javax.swing.SortOrder.DESCENDING)
        ));

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                int col = jTable1.columnAtPoint(evt.getPoint());
                if (col == 2 && row >= 0) {
                    String jugador = (String) jTable1.getValueAt(row, 0);
                    Integer nivel = (Integer) jTable1.getValueAt(row, 2);
                    Integer puntaje = (Integer) jTable1.getValueAt(row, 1);

                    javax.swing.JOptionPane.showMessageDialog(jframeTablaPuntajes.this,
                            "Jugador: " + jugador + "\nPuntaje: " + puntaje + "\nNivel: " + nivel,
                            "Información del Jugador", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void addTableClickListener() {
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int column = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());
                if (column == 2 && model.getRowCount() > 0) {
                    mostrarJugadorConMayorPuntaje();
                }
            }
        });
    }

    private void mostrarJugadorConMayorPuntaje() {
        if (model.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay jugadores en la tabla", "Tabla vacía", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int maxPuntaje = -1;
        String nombreMejorJugador = "";
        int nivelMejorJugador = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            int puntaje = Integer.parseInt(model.getValueAt(i, 1).toString());
            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
                nombreMejorJugador = model.getValueAt(i, 0).toString();
                nivelMejorJugador = Integer.parseInt(model.getValueAt(i, 2).toString());
            }
        }

        String mensaje = String.format("🏆 JUGADOR CON MAYOR PUNTAJE 🏆\n\nNombre: %s\nNivel: %d\nPuntaje: %d", nombreMejorJugador, nivelMejorJugador, maxPuntaje);
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Mejor Jugador", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarJugadoresPrioridadAlta() {
        // 1. Crear un texto para mostrar los resultados
        String resultado = "JUGADORES PRIORIDAD ALTA:\n\n";

        // 2. Contador para saber cuántos hay
        int contador = 0;

        // 3. Recorrer todas las filas de la tabla
        for (int i = 0; i < model.getRowCount(); i++) {
            // 4. Obtener la prioridad de la fila actual (columna 3)
            String prioridad = model.getValueAt(i, 3).toString();

            // 5. Si la prioridad es "Alta", mostrar sus datos
            if (prioridad.equalsIgnoreCase("Alta")) {
                // 6. Obtener los otros datos de esa fila
                String nombre = model.getValueAt(i, 0).toString();
                int puntaje = (int) model.getValueAt(i, 1);
                int nivel = (int) model.getValueAt(i, 2);

                // 7. Añadir al resultado
                resultado += "• " + nombre + " - Puntos: " + puntaje + " - Nivel: " + nivel + "\n";
                contador++;
            }
        }

        // 8. Si no hay ninguno, mostrar mensaje
        if (contador == 0) {
            resultado = "No hay jugadores con prioridad alta";
        }

        // 9. Mostrar el resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(this, resultado, "Prioridad Alta", JOptionPane.INFORMATION_MESSAGE);
    }

    public void alta(Jugador jugador) {
        // ✅ USA 'model' en lugar de obtenerlo de jTable1
        Object[] fila = {jugador.getNombre(), jugador.getPuntaje(), jugador.getNivel(), jugador.getPrioridad()};
        model.addRow(fila);
        if (sorter != null) {
            sorter.sort();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BotonValoresAleatorios = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.jTable1.columnModel.title2")); // NOI18N
            jTable1.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.jTable1.columnModel.title3")); // NOI18N
        }

        BotonValoresAleatorios.setText(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.BotonValoresAleatorios.text")); // NOI18N
        BotonValoresAleatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonValoresAleatoriosActionPerformed(evt);
            }
        });

        jButton2.setText(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.jLabel1.text")); // NOI18N

        jButton1.setText(org.openide.util.NbBundle.getMessage(jframeTablaPuntajes.class, "jframeTablaPuntajes.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonValoresAleatorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonValoresAleatorios)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        añadirJugador dialogoAlta = new añadirJugador(this, true);

        dialogoAlta.setVisible(true);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void BotonValoresAleatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonValoresAleatoriosActionPerformed

        String[] nombres = {"Ana", "Carlos", "Maria", "Luis", "Elena", "Pedro", "Sofia", "Javier", "Laura", "Diego"};

        // Seleccionar un nombre aleatorio
        int indiceNombre = (int) (Math.random() * nombres.length);
        String nombre = nombres[indiceNombre];

        // Generar puntuación y nivel aleatorios
        int puntuacion = (int) (Math.random() * 1000) + 100;
        int nivel = (int) (Math.random() * 10) + 1;

        String[] prioridades = {"baja", "media", "alta"};
        String prioridad = prioridades[(int) (Math.random() * prioridades.length)]; // ✅ CORREGIDO

        // Crear y añadir el jugador
        Jugador jugador = new Jugador(nombre, puntuacion, nivel, prioridad);
        LogicaJugadores.añadirJugador(jugador);
        alta(jugador);


    }//GEN-LAST:event_BotonValoresAleatoriosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        mostrarJugadoresPrioridadAlta();


    }//GEN-LAST:event_jButton1ActionPerformed
    private void refrescarTabla() {
        model.setRowCount(0); // limpia las filas

        for (Jugador jugador : LogicaJugadores.getListaJugadores()) {
            model.addRow(new Object[]{
                jugador.getNombre(),
                jugador.getPuntaje(),
                jugador.getNivel(),
                jugador.getPrioridad()

            });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new jframeTablaPuntajes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonValoresAleatorios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
