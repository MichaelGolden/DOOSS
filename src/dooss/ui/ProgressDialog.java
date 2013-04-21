/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProgressDialog.java
 *
 * Created on 27 Jan 2012, 11:17:03 AM
 */
package structurevis.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import structurevis.structures.StructureParser;

/**
 *
 * @author Michael Golden
 */
public class ProgressDialog extends javax.swing.JDialog {

    MainApp mainapp;
    File collectionFolder;
    int binSize = 5;
    int radius = 1000;
    int maxSubstructureSize = 200;

    /**
     * Creates new form ProgressDialog
     */
    public ProgressDialog(MainApp mainapp) {
        super(mainapp, false);
        this.mainapp = mainapp;
        this.collectionFolder = mainapp.collectionFolder;

        initComponents();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        this.setTitle("Initializing dataset for the first use...");
        jProgressBar1.setIndeterminate(true);
        new ProgressThread().start();
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - getWidth()) / 2;
        final int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
        setModal(true);
    }

    class ProgressThread extends Thread {

        public void run() {
            try {
                if (!DistanceMatrix.getCacheFile(collectionFolder/*
                         * , binSize, radius
                         */).exists() || !FullGenomeDrawPanel.getCacheFile(collectionFolder, maxSubstructureSize).exists()) {
                    new Thread(new Runnable() {

                        public void run() {
                            // needs to be in a seperate thread, otherwise blocks
                            ProgressDialog.this.setVisible(true);
                        }
                    }).start();
                }
                mainapp.distanceMatrix = DistanceMatrix.load(collectionFolder/*
                         * , binSize, radius
                         */);
                if (mainapp.distanceMatrix == null) {
                    int bestBinSize = DistanceMatrix.getBestBinSize(mainapp.structureCollection.dotBracketStructure.length(), 1000);
                    mainapp.distanceMatrix = new DistanceMatrix(bestBinSize, radius, StructureParser.getPairedNucleotidePositions(mainapp.structureCollection.dotBracketStructure));
                    mainapp.distanceMatrix.computeFloydWarshall();
                    mainapp.distanceMatrix.cache(collectionFolder);
                }
                mainapp.genomePanel1.initialise(mainapp, maxSubstructureSize);
            } catch (Exception ex) {
                System.err.println("An error occured: " + ex.getMessage());
            } finally {
                ProgressDialog.this.setModal(false);
                ProgressDialog.this.setVisible(false);
                ProgressDialog.this.dispose();
            }
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Initializing...");
        setResizable(false);

        jScrollPane1.setBorder(null);

        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextPane1.setText("StructureVis is generating graphical coordinates and interaction distances for structures in this dataset. This may take a few minutes, but only needs to be done the first time a dataset is opened.");
        jTextPane1.setOpaque(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
