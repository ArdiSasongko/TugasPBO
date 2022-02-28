import java.util.Scanner;


public class Konversi {
    int k,c,f,r;
    Scanner input = new Scanner(System.in);

    public Konversi(){

    }

    public Konversi(int k,int c,int f,int r){
        this.k = k;
        this.c = c;
        this.f = f;
        this.r = r;
    }

    public double celcius(){
        System.out.print("Masukan nilai Celcius : ");
        c = input.nextInt();
        return c;
    }

    public double kelvin(){
        k = c + 273;
        System.out.println("Hasil Konversi ke kelvin : " + k);
        return k;
    }

    public double farheint(){
        f = 9/c * 5 + 32;
        System.out.println("Hasil Konversi ke farheint : " + f);
        return f;
    }

    public double reamur(){
        r = 4*c / 5;
        System.out.println("Hasil Konversi ke reamur : " + r);
        return r;
    }

    void hasilKonversi(){
        kelvin();
        farheint();
        reamur();
    }
}
