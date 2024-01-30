package entity;

public class BarangEntity {
    String nama;
    String kode;
    double harga;
    String barangMasuk;

    public BarangEntity(String nama, String kode, double harga, String barangMasuk){
        this.nama = nama;
        this.kode = kode;
        this.harga = harga;
        this.barangMasuk = barangMasuk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

