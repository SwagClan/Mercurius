/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lots.mercurius.stemming.sqlHandler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import lots.mercurius.stemming.IngelogdPersoon;
import lots.mercurius.stemming.Main;
import lots.mercurius.stemming.schermen.BeginScherm;

/**
 *
 * @author joris
 */
public class SQLhandler {

    private Main main;
    private static String url;
    private static String username;
    private static String passwoord;
    private Connection c;

    public SQLhandler(Main main) {
        this.main = main;
    }

    /**
     * set de urwaarde
     *
     * @param url als String
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUrl(){
        return url;
    }

    /**
     * ste de username waarde
     *
     * @param username als String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * set de passwoord waarde
     *
     * @param Pass als String
     */
    public void setPasswoord(String Pass) {
        this.passwoord = Pass;
    }

    public boolean isUserOk(BeginScherm b) {
        try {
            String sql
                    = "SELECT * FROM leden WHERE lid_naam= '" + b.getNaam() + "' AND lid_voornaam= '" + b.getVoornaam() + "';";
            maakConnectie();
            IngelogdPersoon p = main.getIngelogdPersoon();
            ResultSet rs = voerQryUit(sql);
            if (null == rs) {
                System.out.println("SELECT * WHERE lid_naam= '" + b.getNaam() + "' AND lid_voornaam= '" + b.getVoornaam() + "';");
                return false;
            }
            rs.beforeFirst();
            rs.next();
            String pass = rs.getString("lid_passwoord");
            p.setLid_id(rs.getInt("lid_id"));
            p.setNaam(rs.getString("lid_naam"));
            p.setVoornaam(rs.getString("lid_voornaam"));
            p.setFunc_id(rs.getInt("func_id"));
            rs.close();
            sluitConnectie();
            sql
                    = "SELECT * FROM functie WHERE func_id= '" + p.getFunc_id() + "';";
            maakConnectie();
            rs = voerQryUit(sql);
            if (rs == null) {
                System.out.println("SELECT * FROM functie WHERE func_id= '" + p.getFunc_id() + "';");
                return false;
            }
            rs.beforeFirst();
            rs.next();
            p.setRechten(rs.getInt("func_rechten"));
            sluitConnectie();
            if (pass.equals(encrypt(b.getPasswoord()))) {
                main.setIngelogPersoon(p);
                System.out.println("WW klopt");
                return true;
            } else {
                System.out.println("WW klopt niet");
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * gaat connectie leggen met de sql server VERGEET JE CONNECTIE NIET TE
     * SLUITEN
     *
     * @throws SQLException obj met error in
     */
    public void maakConnectie() {
        try {
            //MySql db
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://" + url, username, passwoord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(SQLhandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * gaat een qry uitvoeren
     *
     * @param sql de sql selectie als String
     * @return altijd de uit komst van da sql
     */
    public ResultSet voerQryUit(String sql) {
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return rs;
    }

    /**
     * gaat een update uit voeren in de DB
     *
     * @param sql de sql update selectie als String
     * @return returnt -1 als het niet gelukt is en returnt X aantal rijen als
     * int als het wel geluct is
     *
     * als je 5 rijen aanpast zou die 5 moetten returnen zo niet heeft die niet
     * alle rijen gedaan
     */
    public int voerUpdateUit(String sql) {
        int cont = -1;
        Statement stm;
        try {
            stm = c.createStatement();
            cont = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
        return cont;
    }

    /**
     * gaat de connectie sluiten met de sql server
     *
     * @throws SQLException obj met error in
     */
    public void sluitConnectie() {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLhandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * encripts pss to md5
     *
     * @param source String
     * @return md5 as String
     */
    public static String encrypt(String source) {
        String md5 = null;
        try {
            MessageDigest mdEnc = MessageDigest.getInstance("MD5"); //Encryption algorithm
            mdEnc.update(source.getBytes(), 0, source.length());
            md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
        } catch (Exception ex) {
            return null;
        }
        return md5;
    }
}
