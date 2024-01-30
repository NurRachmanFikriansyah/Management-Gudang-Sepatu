package models;

import entity.BarangEntity;
import entity.SepatuEntity;

import java.util.ArrayList;

public class Sepatu {
    public ArrayList<SepatuEntity> listSepatu;

    public Sepatu() {
        listSepatu = new ArrayList<>();
    }

    public ArrayList<SepatuEntity> getListSepatu() {
        return listSepatu;
    }

    public void addSepatu(BarangEntity barang) {
        listSepatu.add((SepatuEntity) barang);
    }

    public void deleteSepatu(SepatuEntity sepatu) {
        listSepatu.remove(sepatu);
    }

    public SepatuEntity searchNamaSepatu(String nama) {
        for (SepatuEntity shoes : listSepatu) {
            if (shoes.getNama().equals(nama)) {
                return shoes;
            }
        }
        return null;
    }

    public SepatuEntity searcBrandSepatu(String nama) {
        for (SepatuEntity merk : listSepatu) {
            if (merk.getBrand().equals(nama)) {
                return merk;
            }
        }
        return null;
    }

    public SepatuEntity searchKodeSepatu(String kode) {
        for (SepatuEntity code : listSepatu) {
            if (code.getKode().equals(kode)) {
                return code;
            }
        }
        return null;
    }

    public SepatuEntity searchStokSepatu(int stoks) {
        for (SepatuEntity stoq : listSepatu) {
            if (stoq.getStok() == stoks) {
                return stoq;
            }
        }
        return null;
    }

    public void ViewofStok(String kode) {
        for (SepatuEntity sepatu : Modell.sepatu.listSepatu) {
            if (sepatu.getKode().equals(kode)) {
                sepatu.displayStok();
                return;
            }
        }
    }
}

