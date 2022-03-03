public class Tabung extends BangunRuang implements MenghitungRuang{

    public Tabung(double r, double tinggi){
        super(r,tinggi);
    }

    public void volume(){
        double v = Math.PI*r*r*tinggi;
        System.out.println("Volume Tabung adalah : " + v);
    }

    public void luasper(){
        double lp = 2*Math.PI*r*(r+tinggi);
        System.out.println("Luas Permukaan tabung adalah : " + lp);
    }
}
