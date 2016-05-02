/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lots.mercurius.resultaat;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import lots.mercurius.stemming.Main;

/**
 *
 * @author joris
 */
public class ResultaatPersoon extends javax.swing.JPanel {

    private Main main;
    /**
     * Creates new form ResultaatPersoon
     */
    public ResultaatPersoon(Main main) {
        initComponents();
        this.main = main;
        begin();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        proSeniorHonorescousaPannel = new javax.swing.JPanel();
        proSeniorHonorescousa = new javax.swing.JLabel();
        proSeniorPannel = new javax.swing.JPanel();
        proSenior = new javax.swing.JLabel();
        praesesPannel = new javax.swing.JPanel();
        preases = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("naam"));

        jLabel3.setText("Resultaat nodig 66,6%");

        proSeniorHonorescousaPannel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pro-Senior Honorescousa"));

        proSeniorHonorescousa.setForeground(new java.awt.Color(244, 3, 3));
        proSeniorHonorescousa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proSeniorHonorescousa.setText("0%");

        javax.swing.GroupLayout proSeniorHonorescousaPannelLayout = new javax.swing.GroupLayout(proSeniorHonorescousaPannel);
        proSeniorHonorescousaPannel.setLayout(proSeniorHonorescousaPannelLayout);
        proSeniorHonorescousaPannelLayout.setHorizontalGroup(
            proSeniorHonorescousaPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proSeniorHonorescousaPannelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proSeniorHonorescousa, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        proSeniorHonorescousaPannelLayout.setVerticalGroup(
            proSeniorHonorescousaPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proSeniorHonorescousaPannelLayout.createSequentialGroup()
                .addComponent(proSeniorHonorescousa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        proSeniorPannel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pro-Senior"));

        proSenior.setForeground(new java.awt.Color(244, 3, 3));
        proSenior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proSenior.setText("0%");

        javax.swing.GroupLayout proSeniorPannelLayout = new javax.swing.GroupLayout(proSeniorPannel);
        proSeniorPannel.setLayout(proSeniorPannelLayout);
        proSeniorPannelLayout.setHorizontalGroup(
            proSeniorPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proSeniorPannelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proSenior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        proSeniorPannelLayout.setVerticalGroup(
            proSeniorPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proSeniorPannelLayout.createSequentialGroup()
                .addComponent(proSenior)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        praesesPannel.setBorder(javax.swing.BorderFactory.createTitledBorder("Praeses"));

        preases.setForeground(new java.awt.Color(244, 3, 9));
        preases.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preases.setText("0%");

        javax.swing.GroupLayout praesesPannelLayout = new javax.swing.GroupLayout(praesesPannel);
        praesesPannel.setLayout(praesesPannelLayout);
        praesesPannelLayout.setHorizontalGroup(
            praesesPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(praesesPannelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(preases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        praesesPannelLayout.setVerticalGroup(
            praesesPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(praesesPannelLayout.createSequentialGroup()
                .addComponent(preases)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel2.setText("Behaald resultaat:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(proSeniorHonorescousaPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proSeniorPannel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(praesesPannel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(praesesPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(proSeniorPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proSeniorHonorescousaPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel peases2;
    private javax.swing.JLabel peases3;
    private javax.swing.JPanel praesesPannel;
    private javax.swing.JLabel preases;
    private javax.swing.JLabel proSenior;
    private javax.swing.JLabel proSeniorHonorescousa;
    private javax.swing.JPanel proSeniorHonorescousaPannel;
    private javax.swing.JPanel proSeniorPannel;
    // End of variables declaration//GEN-END:variables

    public void setNaam(String naam){
        TitledBorder tb = BorderFactory.createTitledBorder(naam);
        this.setBorder(tb);
    }

    public boolean setStemmenPreases(int totStemd, int stemmen_voor) {
        double percent = berekenPercentStemming(totStemd, stemmen_voor);
        boolean gehaald = false;
        preases.setText(percent + "");
        if(percent >= 66.6){
            preases.setForeground(Color.black);
            gehaald = true;
        }else{
            preases.setForeground(Color.red);
        }
        preases.setVisible(true);
        praesesPannel.setVisible(true);
        return gehaald;
    }

    public boolean setStemmenProSenior(int totStemd, int stemmen_voor) {
        double percent = berekenPercentStemming(totStemd, stemmen_voor);
        boolean gehaald = false;
        proSenior.setText(percent + "");
        if(percent >= 66.6){
            proSenior.setForeground(Color.black);
            gehaald = true;
        }else{
            proSenior.setForeground(Color.red);
        }
        proSenior.setVisible(true);
        proSeniorPannel.setVisible(true);
        return gehaald;
    }

    public boolean setStemmenProSeniorHonorescousa(int totStemd, int stemmen_voor) {
        double percent = berekenPercentStemming(totStemd, stemmen_voor);
        boolean gehaald = false;
        proSeniorHonorescousa.setText(percent + "");
        if(percent >= 66.6){
            proSeniorHonorescousa.setForeground(Color.black);
            gehaald = true;
        }else{
            proSeniorHonorescousa.setForeground(Color.red);
        }
        proSeniorHonorescousa.setVisible(true);
        proSeniorHonorescousaPannel.setVisible(true);
        return gehaald;
    }

    private double berekenPercentStemming(int totStemd, int stemmen_voor) {
        double percent = 0;
        percent = (100/totStemd)*stemmen_voor;
        percent = (int) (percent*10.0)/10.0;
        return percent;
    }

    public void begin(){
        preases.setVisible(false);
        proSenior.setVisible(false);
        proSeniorHonorescousa.setVisible(false);
        praesesPannel.setVisible(false);
        proSeniorPannel.setVisible(false);
        proSeniorHonorescousaPannel.setVisible(false);
    }
}
