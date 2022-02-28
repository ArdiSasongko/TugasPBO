
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int pilih,ket;
        int nilai = 0;
        Scanner input = new Scanner(System.in);

        Konversi konversi = new Konversi();
        do{System.out.println("Masukan Pilihan ");
            System.out.print("1.Input Celcius \n2.Konversi \nPilih : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1 :
                    konversi.celcius();
                    System.out.println("ke menu ? \n1.ya \n2.no \nPilih : ");
                    ket = input.nextInt();
                    if(ket == 1){
                        nilai = 1;
                    }
                    break;
                case 2 :
                    konversi.hasilKonversi();
                    System.out.print("ke menu ? \n1.ya \n2.no Pilih : ");
                    ket = input.nextInt();
                    if(ket == 1){
                        nilai = 1;
                    }
                    break;
                default :
                    System.out.println("Tidak ada pilihan");
            }
        }while(nilai == 1);


    }
}
