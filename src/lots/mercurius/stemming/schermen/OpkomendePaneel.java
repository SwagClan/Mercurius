/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lots.mercurius.stemming.schermen;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import lots.mercurius.stemming.Main;

/**
 *
 * @author joris
 */
public class OpkomendePaneel extends javax.swing.JPanel {

    private Main main;
    private String naam;
    private boolean bool_praeses, bool_proSenior, bool_honorescousa, gestemd;
    private int lid_id;
    private StemPaneel stempaneel;

    /**
     * Creates new form OpkomendePaneel
     */
    public OpkomendePaneel(Main main, StemPaneel stempaneel) {
        initComponents();
        this.main = main;
        this.stempaneel = stempaneel;
    }
    
    public int getLid_id(){
        return lid_id;
    }

    public void setLid_id(int lid_id){
        this.lid_id = lid_id;
    }
    
    /**
     * set de naam van de opkomende
     *
     * @param naam
     */
    public void setOpkomendeNaam(String naam) {
        TitledBorder tb = BorderFactory.createTitledBorder(naam);
        this.setBorder(tb);
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public boolean getKomtopPraeses() {
        return bool_praeses;
    }

    public boolean getKomtopProSenior() {
        return bool_proSenior;
    }

    public boolean getKomtopProSeniorHonoresousa() {
        return bool_honorescousa;
    }

    private boolean isStemtvoorPreases() {
        return preasesVoor.isSelected();
    }

    private boolean isStemvoorPro_Senior() {
        return proSeniorVoor.isSelected();
    }

    private boolean isStemVoorHonorescousa() {
        return proSeniorHonorescousaVoor.isSelected();
    }
    
    public boolean isStemvoor(){
        if(isStemtvoorPreases() || isStemvoorPro_Senior() || isStemVoorHonorescousa()){
            return true;
        }else{
            return false;
        }
    }

    public void setKomtAl(boolean praeses, boolean pro_senior, boolean honorescousa) {
        if (praeses) {
            this.preases.setVisible(true);
            bool_praeses = true;
        } else {
            this.preases.setVisible(false);
            bool_praeses = false;
        }
        if (pro_senior) {
            this.proSenior.setVisible(true);
            bool_proSenior = true;
        } else {
            this.proSenior.setVisible(false);
            bool_praeses = false;
        }
        if (honorescousa) {
            this.honorescousa.setVisible(true);
            bool_honorescousa = true;
        } else {
            this.honorescousa.setVisible(false);
            bool_honorescousa = false;
        }
        begin();
    }
    
    public void setKunnenStemmen(boolean praeses, boolean pro_senior, boolean honorescousa){
        if(bool_praeses){
            if(praeses){
                preases.setVisible(true);
            }
        }
        if(bool_proSenior){
            if(pro_senior){
                this.proSenior.setVisible(true);
            }
        }
        if(bool_honorescousa){
            if(honorescousa){
                this.honorescousa.setVisible(true);
            }
        }
    }
    
    public void begin(){
        honorescousa.setVisible(false);
        preases.setVisible(false);
        preasesTegen.setSelected(false);
        preasesVoor.setSelected(false);
        proSenior.setVisible(false);
        proSeniorHonorescousaVoor.setSelected(false);
        proSeniorHonorescousaTegen.setSelected(false);
        proSeniorVoor.setSelected(false);
        proSeniorTegen.setSelected(false);
        gestemd = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preasesGroep = new javax.swing.ButtonGroup();
        proSeniorGroep = new javax.swing.ButtonGroup();
        proSeniorHonorescousa = new javax.swing.ButtonGroup();
        preases = new javax.swing.JPanel();
        preasesTegen = new javax.swing.JRadioButton();
        preasesVoor = new javax.swing.JRadioButton();
        proSenior = new javax.swing.JPanel();
        proSeniorVoor = new javax.swing.JRadioButton();
        proSeniorTegen = new javax.swing.JRadioButton();
        honorescousa = new javax.swing.JPanel();
        proSeniorHonorescousaVoor = new javax.swing.JRadioButton();
        proSeniorHonorescousaTegen = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("naam"));

        preases.setBorder(javax.swing.BorderFactory.createTitledBorder("Preases"));

        preasesGroep.add(preasesTegen);
        preasesTegen.setText("Stem Tegen");
        preasesTegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        preasesGroep.add(preasesVoor);
        preasesVoor.setText("Stem Voor");
        preasesVoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout preasesLayout = new javax.swing.GroupLayout(preases);
        preases.setLayout(preasesLayout);
        preasesLayout.setHorizontalGroup(
            preasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preasesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(preasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(preasesVoor)
                    .addComponent(preasesTegen))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        preasesLayout.setVerticalGroup(
            preasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preasesLayout.createSequentialGroup()
                .addComponent(preasesVoor)
                .addGap(18, 18, 18)
                .addComponent(preasesTegen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        proSenior.setBorder(javax.swing.BorderFactory.createTitledBorder("Pro-Senior"));

        proSeniorGroep.add(proSeniorVoor);
        proSeniorVoor.setText("Stem Voor");
        proSeniorVoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        proSeniorGroep.add(proSeniorTegen);
        proSeniorTegen.setText("Stem Tegen");
        proSeniorTegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout proSeniorLayout = new javax.swing.GroupLayout(proSenior);
        proSenior.setLayout(proSeniorLayout);
        proSeniorLayout.setHorizontalGroup(
            proSeniorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proSeniorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(proSeniorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proSeniorVoor)
                    .addComponent(proSeniorTegen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        proSeniorLayout.setVerticalGroup(
            proSeniorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proSeniorLayout.createSequentialGroup()
                .addComponent(proSeniorVoor)
                .addGap(18, 18, 18)
                .addComponent(proSeniorTegen))
        );

        honorescousa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pro-Senior Honorescousa"));

        proSeniorHonorescousa.add(proSeniorHonorescousaVoor);
        proSeniorHonorescousaVoor.setText("Stem Voor");
        proSeniorHonorescousaVoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        proSeniorHonorescousa.add(proSeniorHonorescousaTegen);
        proSeniorHonorescousaTegen.setText("Stem Tegen");
        proSeniorHonorescousaTegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout honorescousaLayout = new javax.swing.GroupLayout(honorescousa);
        honorescousa.setLayout(honorescousaLayout);
        honorescousaLayout.setHorizontalGroup(
            honorescousaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(honorescousaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(honorescousaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proSeniorHonorescousaVoor)
                    .addComponent(proSeniorHonorescousaTegen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        honorescousaLayout.setVerticalGroup(
            honorescousaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(honorescousaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proSeniorHonorescousaVoor)
                .addGap(18, 18, 18)
                .addComponent(proSeniorHonorescousaTegen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(preases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proSenior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(honorescousa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(preases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(proSenior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(honorescousa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPerformed
        // TODO add your handling code here:
        if(bool_praeses){
            if(preasesVoor.isSelected() || preasesTegen.isSelected()){
                stempaneel.dezePreases(this);
            }else{
                return;
            }
        }
        if(bool_proSenior){
            if(proSeniorVoor.isSelected() || proSeniorTegen.isSelected()){
                stempaneel.dezeProSenior(this);
            }else{
                return;
            }
        }
        if(bool_honorescousa){
            if(proSeniorHonorescousaVoor.isSelected() || proSeniorHonorescousaTegen.isSelected()){
                stempaneel.dezeProSeniorHonorescousa(this);
            }else{
                return;
            }
        }
        gestemd = true;
        stempaneel.setSubmitEnabled(true);
    }//GEN-LAST:event_ActionPerformed

    public boolean getGestemd(){
        return gestemd;
    }
    
    public void setStemvoorPreases(boolean flag){
        preasesVoor.setSelected(flag);
        preasesTegen.setSelected(!flag);
    }
    
    public void setStemvoorProSenior(boolean flag){
        proSeniorVoor.setSelected(flag);
        proSeniorTegen.setSelected(!flag);
    }
    
    public void setStemVoorProSeniorHonorascousa(boolean flag){
        proSeniorHonorescousaVoor.setSelected(flag);
        proSeniorHonorescousaTegen.setSelected(!flag);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel honorescousa;
    private javax.swing.JPanel preases;
    private javax.swing.ButtonGroup preasesGroep;
    private javax.swing.JRadioButton preasesTegen;
    private javax.swing.JRadioButton preasesVoor;
    private javax.swing.JPanel proSenior;
    private javax.swing.ButtonGroup proSeniorGroep;
    private javax.swing.ButtonGroup proSeniorHonorescousa;
    private javax.swing.JRadioButton proSeniorHonorescousaTegen;
    private javax.swing.JRadioButton proSeniorHonorescousaVoor;
    private javax.swing.JRadioButton proSeniorTegen;
    private javax.swing.JRadioButton proSeniorVoor;
    // End of variables declaration//GEN-END:variables
}
