/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Commands.Command;
import Commands.Insert;
import Entities.Database;
import SQLiteDependencies.SQLiteBaseListener;
import SQLiteDependencies.SQLiteLexer;
import SQLiteDependencies.SQLiteParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author tasso
 */
public class Tela extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        setLocationRelativeTo(null);
        listener = new SQLiteBaseListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTaQuery = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCbDataBase = new javax.swing.JComboBox<>();
        cxCriar = new javax.swing.JRadioButton();
        cxSelecionar = new javax.swing.JRadioButton();
        jTfNomeDatabase = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBRodar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTaOuput = new javax.swing.JTextArea();
        jBLer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTaQuery.setColumns(20);
        jTaQuery.setRows(5);
        jTaQuery.setPreferredSize(new java.awt.Dimension(400, 50));
        jScrollPane1.setViewportView(jTaQuery);

        jLabel1.setText("Query Editor ");

        jLabel2.setText("Data Output");

        jCbDataBase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cxCriar.setText("Criar DataBase");
        cxCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxCriarActionPerformed(evt);
            }
        });

        cxSelecionar.setText("Selecionar DataBase");
        cxSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxSelecionarActionPerformed(evt);
            }
        });

        jTfNomeDatabase.setToolTipText("");
        jTfNomeDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfNomeDatabaseActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome da Database");

        jBRodar.setText("Rodar");
        jBRodar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRodarActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jTaOuput.setColumns(20);
        jTaOuput.setRows(5);
        jScrollPane3.setViewportView(jTaOuput);

        jBLer.setText("Ler");
        jBLer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jBRodar)
                                .addGap(138, 138, 138)
                                .addComponent(jBLimpar)
                                .addGap(62, 62, 62)
                                .addComponent(jBLer))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(800, 800, 800))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCbDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cxSelecionar))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cxCriar)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTfNomeDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(155, 155, 155)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxCriar)
                    .addComponent(cxSelecionar))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfNomeDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBRodar)
                    .addComponent(jBLimpar)
                    .addComponent(jBLer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTfNomeDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfNomeDatabaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfNomeDatabaseActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTaQuery.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_jBLimparActionPerformed

    private void cxSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxSelecionarActionPerformed
        cxCriar.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_cxSelecionarActionPerformed

    private void cxCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxCriarActionPerformed
        cxSelecionar.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_cxCriarActionPerformed

    private void jBRodarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRodarActionPerformed

        CodePointCharStream inputStream = CharStreams.fromString(jTaQuery.getText());
        SQLiteLexer lexer = new SQLiteLexer(inputStream);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        SQLiteParser parser = new SQLiteParser(cts);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.parse();

        ParseTreeWalker p = new ParseTreeWalker();
        p.walk(listener, tree);
        
        
        Database db = new Database("C:/Users/Lucas Dolsan/Desktop/", "bancasso");
        System.out.println(db.toString());
        System.out.println("Rodando comando: " + listener.getCurrentCommand().toString());
       


    }//GEN-LAST:event_jBRodarActionPerformed

    private void jBLerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLerActionPerformed
        try {
            listener.readData();
            
        } catch (IOException ex) {
            System.out.println("Não Leu" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBLerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }

        });
    }
    public SQLiteBaseListener listener;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cxCriar;
    private javax.swing.JRadioButton cxSelecionar;
    private javax.swing.JButton jBLer;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBRodar;
    private javax.swing.JComboBox<String> jCbDataBase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTaOuput;
    private javax.swing.JTextArea jTaQuery;
    private javax.swing.JTextField jTfNomeDatabase;
    // End of variables declaration//GEN-END:variables
}
