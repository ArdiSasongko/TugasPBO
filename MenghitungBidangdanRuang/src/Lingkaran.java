public class Lingkaran extends BangunBidang implements MenghitungBidang{

    public Lingkaran(double r){
        super(r);
    }

    @Override
    public void luas(){
        double l = Math.PI*this.r*this.r;
        System.out.println("Luas Lingkaran : " + l);
    }

    @Override
    public void keliling(){
        double k = 2*Math.PI*r;
        System.out.println("Keliling Lingkaran : " + k);
    }
}
