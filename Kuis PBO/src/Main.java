
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nama,sekolah,nm;
        boolean ulang = true;
        int a,b,c,d;
        float hasil = 0;
        Peserta peserta = new Peserta();
        do{
            System.out.println("\nLomba Apresiasi Pahlawan Wanita");
            System.out.println("Terdapat 2 kategori : ");
            System.out.println("1. Animasi (Tim) \n2. Menulis Surat (individu)");
            System.out.print("Masukan pilihan : ");
            int pilih = input.nextInt();

            switch (pilih){
                case 1 :
                    nm = input.nextLine();
                    System.out.print("\nMasukan nama : ");
                    nama = input.nextLine();
                    System.out.print("\nMasukan nama sekolah : ");
                    sekolah = input.nextLine();

                    System.out.println("\nForm penilaian");
                    System.out.print("\nNilai Alur Cerita : ");
                    a = input.nextInt();
                    System.out.print("\nNilai Kreativitas : ");
                    b = input.nextInt();
                    System.out.print("\nNilai konten : ");
                    c = input.nextInt();
                    System.out.print("\nSinematografi : ");
                    d = input.nextInt();

                    System.out.println("Piihan :");
                    System.out.println("1.Hasil \n2.Exit \nPilih :");
                    int pilih2 = input.nextInt();
                    switch (pilih2){
                        case 1 :
                            hasil = (peserta.alurCerita(a)+ peserta.konten(c) + peserta.kreativitas(b) + peserta.sinematografi(d));

                            if(hasil >= 85){
                                System.out.println(nama + " Dari " + sekolah + " Dinyatakan lolos dengan total nilai : " + hasil);
                            }else{
                                System.out.println(nama + " Dari " + sekolah + " Dinyatakan tidak lolos dengan total nilai : " + hasil);
                            }
                            break;
                        case 2 :
                            ulang = false;
                            break;
                        default :
                            System.out.println("Tidak ada pilihan");

                    }
                    break;
                case 2 :
                    nm = input.nextLine();
                    System.out.print("\nMasukan nama : ");
                    nama = input.nextLine();
                    System.out.print("\nMasukan nama sekolah : ");
                    sekolah = input.nextLine();

                    System.out.println("\nForm penilaian");
                    System.out.print("\nNilai Struktur : ");
                    a = input.nextInt();
                    System.out.print("\nNilai Isi Surat : ");
                    b = input.nextInt();
                    System.out.print("\nKaidah bahasa : ");
                    c = input.nextInt();
                    System.out.print("\nKreativitas surat : ");
                    d = input.nextInt();

                    System.out.println("Piihan :");
                    System.out.println("1.Hasil \n2.Exit \nPilih :");
                    int pilih3 = input.nextInt();
                    switch (pilih3){
                        case 1 :
                            hasil = (peserta.struktur(a)+ peserta.isi(c) + peserta.KaidahBahasa(b) + peserta.kreativitasSurat(d));

                            if(hasil >= 85){
                                System.out.println(nama + " Dari " + sekolah + " Dinyatakan lolos dengan total nilai : " + hasil);
                            }else{
                                System.out.println(nama + " Dari " + sekolah + " Dinyatakan tidak lolos dengan total nilai : " + hasil);
                            }
                        case 2 :
                            ulang = false;
                            break;
                        default :
                            System.out.println("Tidak ada pilihan");
                    }
                    break;
                default :
                    System.out.println("Tidak ada pilihan");
            }
        }while(ulang);

    }

}
