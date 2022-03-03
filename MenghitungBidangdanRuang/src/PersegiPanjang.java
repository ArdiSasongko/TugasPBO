public class PersegiPanjang extends BangunBidang implements MenghitungBidang {

    public PersegiPanjang(int panjang,int lebar){
        super(panjang,lebar);
    }

    @Override
    public void luas(){
        double l = panjang * lebar;
        System.out.println("Luas Persegi Panjang adalah : " + l);
    }

    @Override
    public void keliling(){
        double k = 2*(panjang + lebar);
        System.out.println("Keliling Persegi panjang adalah : " + k);
    }
}
