/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barutba;

/**
 *
 * @author Hanif
 */
public class Kata {
    private String katakata;
    private String tipe;
    private int token;
    
    public Kata(String katakata,String tipe, int token){
        this.katakata = katakata;
        this.tipe = tipe;
        this.token = token;
    }
    
    public String getKata(){
        return katakata;
    }
    
    public int getToken(){
        return token;
    }
    
    public String getTipe(){
        return tipe;
    }
}
