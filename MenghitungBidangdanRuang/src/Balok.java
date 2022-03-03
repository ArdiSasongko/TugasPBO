public class Balok extends BangunRuang implements MenghitungRuang{

    public Balok(double panjang,double lebar,double tinggi){
        super(panjang, lebar, tinggi);
    }

    @Override
    public void volume(){
        double v = this.panjang*this.lebar*this.tinggi;
        System.out.println("Volume Balok adalah : " + v);
    }

    @Override
    public void luasper(){
        double lp = 2*((this.panjang*this.lebar)+(this.panjang*this.tinggi)+(this.lebar*this.tinggi));
        System.out.println("Luas Permukaan Balok adalah : " + lp);
    }
}
