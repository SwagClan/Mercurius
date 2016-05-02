/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lots.mercurius.stemming;

/**
 *
 * @author joris
 */
public class IngelogdPersoon {
    
    private String naam, voornaam;
    private int fuc_id, rechten, lid_id;
    private Main main;
    
    public IngelogdPersoon(Main main){
        this.main = main;
    }
    
    public int getLid_id(){
        return lid_id;
    }
    
    public void setLid_id(int lid_id){
        this.lid_id = lid_id;
    }
    
    public int getRechten(){
        return rechten;
    }
    
    public void setRechten(int rechten){
        this.rechten = rechten;
    }
    
    public int getFunc_id(){
        return fuc_id;
    }
    
    public void setFunc_id(int id){
        this.fuc_id = id;
    }
    
    public String getVoornaam(){
        return voornaam;
    }
    
    public void setVoornaam(String voornaam){
        this.voornaam = voornaam;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public void setNaam(String naam){
        this.naam = naam;
    }
    
}
