/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balok;

/**
 *
 * @author Acer
 */
public class Hitung {
    public static double keliling(double panjang,double lebar){
        double keliling;
        keliling = (2*panjang)+(2*lebar);
        return keliling;
    }
    
    public static double volume(double panjang,double lebar,double tinggi){
        double volume;
        volume = panjang*lebar*tinggi;
        return volume;
    }
    
    public static double luas(double panjang,double lebar){
        double luas;
        luas = panjang * lebar;
        return luas;
    }
    
    public static double luasper(double panjang,double lebar,double tinggi){
        double luasper;
        luasper = (panjang*lebar)+(panjang*tinggi)*(tinggi+lebar);
        return luasper;
    }
}
