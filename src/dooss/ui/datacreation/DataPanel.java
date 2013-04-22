/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataPanel.java
 *
 * Created on 03 Dec 2011, 7:37:50 PM
 */
package structurevis.ui.datacreation;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import structurevis.ui.datacreation.wizard.WizardListener;

/**
 *
 * @author Michael Golden
 */
public class DataPanel extends javax.swing.JPanel implements ListSelectionListener,  WizardListener  {

    DataModel dataModel;

    /** Creates new form DataPanel */
    public DataPanel(DataModel dataModel) {
        this.dataModel = dataModel;
        initComponents();

        dataTable1.table.getSelectionModel().addListSelectionListener(this);

        try {

            PropertyResourceBundle resources = (PropertyResourceBundle) ResourceBundle.getBundle("structurevis.ui.datacreation.text");
            jTextPane1.setText(resources.getString("DATA_PANEL_DESCRIPTION"));
            jTextPane1.setCaretPosition(0);

        } catch (MissingResourceException mre) {
            // resource missing
        }
        
        WizardMain.wizard.addWizardListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable1 = new structurevis.ui.datacreation.DataTable();
        addButton1D = new javax.swing.JButton();
        addButton2D = new javax.swing.JButton();
        addSequenceData = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data overlays"));

        dataTable1.setPreferredSize(new java.awt.Dimension(200, 200));
        jScrollPane1.setViewportView(dataTable1);

        addButton1D.setText("Add 1D data");
        addButton1D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1DActionPerformed(evt);
            }
        });

        addButton2D.setText("Add 2D data");
        addButton2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton2DActionPerformed(evt);
            }
        });

        addSequenceData.setText("Add sequence data");
        addSequenceData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSequenceDataActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Description");

        jTextPane1.setContentType("text/html");
        jTextPane1.setEditable(false);
        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(addButton1D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton2D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addSequenceData)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton1D)
                    .addComponent(addButton2D)
                    .addComponent(addSequenceData)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButton1DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1DActionPerformed
        SequenceDialog1D dialog = new SequenceDialog1D(new javax.swing.JFrame(), true, dataModel, -1);
        centerAndShow(dialog);
        dataTable1.dataModel.setRows(dataModel.overlays);
    }//GEN-LAST:event_addButton1DActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String type = dataModel.overlays.get(dataTable1.table.getSelectedRow()).type;
        if (type.equals("SequenceData1D")) {
            SequenceDialog1D dialog = new SequenceDialog1D(new javax.swing.JFrame(), true, dataModel, dataTable1.table.getSelectedRow());
            dataTable1.dataModel.setRows(dataModel.overlays);
            centerAndShow(dialog);
        } else if (type.equals("SequenceData2D")) {
            SequenceDialog2D dialog = new SequenceDialog2D(new javax.swing.JFrame(), true, dataModel, dataTable1.table.getSelectedRow());
            dataTable1.dataModel.setRows(dataModel.overlays);
            centerAndShow(dialog);
        } else if (type.equals("NucleotideComposition")) {
            NucleotideDialog dialog = new NucleotideDialog(new javax.swing.JFrame(), true, dataModel, dataTable1.table.getSelectedRow());
            dataTable1.dataModel.setRows(dataModel.overlays);
            centerAndShow(dialog);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        dataModel.overlays.remove(dataTable1.table.getSelectedRow());
        dataTable1.dataModel.setRows(dataModel.overlays);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButton2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton2DActionPerformed
        SequenceDialog2D dialog = new SequenceDialog2D(new javax.swing.JFrame(), true, dataModel, -1);
        centerAndShow(dialog);
        dataTable1.dataModel.setRows(dataModel.overlays);
    }//GEN-LAST:event_addButton2DActionPerformed

    private void addSequenceDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSequenceDataActionPerformed
        NucleotideDialog dialog = new NucleotideDialog(new javax.swing.JFrame(), true, dataModel, -1);
        centerAndShow(dialog);
        dataTable1.dataModel.setRows(dataModel.overlays);
    }//GEN-LAST:event_addSequenceDataActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1D;
    private javax.swing.JButton addButton2D;
    private javax.swing.JButton addSequenceData;
    private structurevis.ui.datacreation.DataTable dataTable1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    public void valueChanged(ListSelectionEvent e) {
        if (dataTable1.table.getSelectedRow() != -1) {
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
        } else {
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }

    public void centerAndShow(JDialog dialog) {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - dialog.getWidth()) / 2;
        final int y = (screenSize.height - dialog.getHeight()) / 2;
        dialog.setLocation(x, y);
        dialog.setVisible(true);
    }

    
    boolean referencedAdded = false;
    DataOverlay dataOverlay = null;
    @Override
    public void panelChangedEvent(Object fromPanelIdentifier, Object toPanelIdentifier) {
        if(toPanelIdentifier.equals(DataDescriptor.IDENTIFIER))
        {
              // add reference alignment to data overlays
            if (dataModel.getReferenceAlignment() != null && dataModel.getReferenceAlignment().exists()) {                        
                
                if(!referencedAdded)
                {
                    dataOverlay = new DataOverlay();
                }
                dataOverlay.nucleotideAlignmentFile = dataModel.getReferenceAlignment();                
                dataOverlay.type = "NucleotideComposition";
                if(!referencedAdded)
                {                                        
                    dataOverlay.fieldName = "reference_alignment";
                    if(dataModel.isFieldNameUsed("reference_alignment", dataOverlay))
                    {
                        dataOverlay.fieldName = dataModel.getNextName("reference_alignment");
                    }
                    dataModel.overlays.add(dataOverlay);                    
                    dataTable1.dataModel.setRows(dataModel.overlays);
                    referencedAdded = true;
                }
            }
        }
    }
}