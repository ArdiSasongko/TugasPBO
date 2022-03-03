import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t;
        int nilai = 0,ket;
        do{
            System.out.println("Hitung Tabung dan Balok");
            System.out.print("1.Balok \n2.Tabung \nPilih : ");
            int pilih = input.nextInt();
            switch (pilih){
                case 1 :
                    System.out.print("Masukan panjang : ");
                    int p = input.nextInt();
                    System.out.print("Masukan Lebar : ");
                    int l = input.nextInt();
                    System.out.print("Masukan Tinggi : ");
                    t = input.nextInt();
                    PersegiPanjang persegiPanjang = new PersegiPanjang(p,l);
                    persegiPanjang.luas();
                    persegiPanjang.keliling();
                    Balok balok = new Balok(p,l,t);
                    balok.volume();
                    balok.luasper();
                    System.out.print("\nke menu ? \n1.ya 2.no \nPilih : ");
                    ket = input.nextInt();
                    if(ket == 1){
                        nilai = 1;
                    }
                    else {
                        return;
                    }
                    break;
                case 2 :
                    System.out.print("Masukan Jari-jari : ");
                    int r = input.nextInt();
                    System.out.print("Masukan Tinggi : ");
                    t = input.nextInt();
                    Lingkaran lingkaran = new Lingkaran(r);
                    lingkaran.luas();
                    lingkaran.keliling();
                    Tabung tabung = new Tabung(r,t);
                    tabung.volume();
                    tabung.luasper();
                    System.out.print("\nke menu ? \n1.ya 2.no \nPilih : ");
                    ket = input.nextInt();
                    if(ket == 1){
                        nilai = 1;
                    }
                    else {
                        return;
                    }
                    break;
                default :
                    System.out.println("Tidak ada pilihan");

            }

        }while(nilai == 1);

    }
}
