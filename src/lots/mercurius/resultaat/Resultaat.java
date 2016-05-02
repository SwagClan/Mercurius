/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lots.mercurius.resultaat;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lots.mercurius.stemming.Main;
import lots.mercurius.stemming.sqlHandler.SQLhandler;

/**
 *
 * @author joris
 */
public class Resultaat extends javax.swing.JFrame {

    private Main main;
    private Vector<ResultaatPersoon> resultaatPersoon = new Vector<ResultaatPersoon>();

    /**
     * Creates new form Resultaat
     */
    public Resultaat(Main main) {
        initComponents();
        this.main = main;
        jPanel1.setLayout(new BorderLayout());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mercurius.png")));
    }

    public void bereken() {
        try {
            String sql = "SELECT * FROM stemmingOpen";
            SQLhandler sqlHandler = main.getSQLhandler();
            sqlHandler.maakConnectie();
            ResultSet rs = sqlHandler.voerQryUit(sql);
            rs.next();
            boolean stemmingOpen = rs.getBoolean("bool");
            rs.close();
            sqlHandler.sluitConnectie();

            if (stemmingOpen) {
                JOptionPane.showMessageDialog(this, "Stemming is nog niet afgeleopen", "WARNING", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
                return;
            }
            sql = "SELECT * FROM komtop";
            sqlHandler.maakConnectie();
            rs = sqlHandler.voerQryUit(sql);
            rs.beforeFirst();
            while (rs.next()) {
                int lid_id = rs.getInt("lid_id");
                int func_id = rs.getInt("func_id");
                int stemmen_voor = rs.getInt("stemmen_voor");
                int stemmen_tegen = rs.getInt("stemmen_tegen");
                int totStemd = stemmen_voor + stemmen_tegen;//100%

                sql = "SELECT * FROM leden WHERE lid_id='" + lid_id + "';";
                ResultSet rs2 = sqlHandler.voerQryUit(sql);
                rs2.next();
                String naamVoornaam = rs2.getString("lid_naam") + " " + rs2.getString("lid_voornaam");
                rs2.close();

                sql = "SELECT * FROM functie WHERE func_id='" + func_id + "';";
                rs2 = sqlHandler.voerQryUit(sql);
                rs2.next();
                String func_naam = rs2.getString("func_naam");
                rs2.close();

                ResultaatPersoon r = new ResultaatPersoon(main);
                boolean gehaald = false;
                switch (func_naam) {
                    case "Praeses":
                        gehaald = r.setStemmenPreases(totStemd, stemmen_voor);
                        break;
                    case "Pro-Senior":
                        gehaald = r.setStemmenProSenior(totStemd, stemmen_voor);
                        break;
                    case "Pro-Senior Honorescousa":
                        gehaald = r.setStemmenProSeniorHonorescousa(totStemd, stemmen_voor);
                        break;
                }
                resultaatPersoon.add(r);
                if (gehaald) {
                    sql = "SELECT * FROM leden WHERE lid_id='" + lid_id + "';";
                    rs2 = sqlHandler.voerQryUit(sql);
                    rs2.next();
                    rs2.updateInt("func_id", func_id);
                    rs2.updateRow();
                    rs2.close();
                    
                    sql = "SELECT * FROM komtop WHERE lid_id='" + lid_id + "';";
                    rs2 = sqlHandler.voerQryUit(sql);
                    rs2.next();
                    rs2.deleteRow();
                    rs2.close();
                }
            }
            rs.close();
            sqlHandler.sluitConnectie();
            setPennel();
        } catch (SQLException ex) {
            Logger.getLogger(Resultaat.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultaat stemming"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void setPennel() {
        int i = 0;
        for (ResultaatPersoon r : resultaatPersoon) {
            switch (i) {
                case 4:
                    jPanel1.add(r, BorderLayout.WEST);
                    break;
                case 3:
                    jPanel1.add(r, BorderLayout.NORTH);
                    break;
                case 2:
                    jPanel1.add(r, BorderLayout.WEST);
                    break;
                case 1:
                    jPanel1.add(r, BorderLayout.EAST);
                    break;
                case 0:
                    jPanel1.add(r, BorderLayout.CENTER);
                    break;
            }
            i += 1;
        }
        jPanel1.updateUI();
        main.pack();
    }

    public void begin() {
        jPanel1.removeAll();
    }

}