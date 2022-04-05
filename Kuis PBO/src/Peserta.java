import Perlombaan.Animasi;
import Perlombaan.Surat;

import java.util.*;

public class Peserta implements Animasi,Surat {

    @Override
    public float alurCerita(float nilai) {
        float hasil;
        hasil = nilai * 0.15f ;
        return hasil;
    }

    @Override
    public float konten(float nilai) {
        float hasil;
        hasil = nilai * 0.35f;
        return hasil;
    }

    @Override
    public float sinematografi(float nilai) {
        float hasil;
        hasil = nilai * 0.15f;
        return hasil;
    }

    @Override
    public float kreativitas(float nilai) {
        float hasil;
        hasil = nilai * 0.35f;
        return hasil;
    }


    @Override
    public float struktur(float nilai) {
        float hasil;
        hasil = nilai * 0.10f ;
        return hasil;
    }

    @Override
    public float isi(float nilai) {
        float hasil;
        hasil = nilai * 0.40f ;
        return hasil;
    }

    @Override
    public float KaidahBahasa(float nilai) {
        float hasil;
        hasil = nilai * 0.20f ;
        return hasil;
    }

    @Override
    public float kreativitasSurat(float nilai) {
        float hasil;
        hasil = nilai * 0.30f ;
        return hasil;
    }
}



