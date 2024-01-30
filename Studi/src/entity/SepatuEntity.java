package entity;

public class SepatuEntity extends BarangEntity {
    String jenisSepatu;
    String brand;
    int size;
    int stok;

    public SepatuEntity(String jenisSepatu, String brand, int size, int stok, String nama, String kode,
                        double harga, String barangMasuk){
        super(nama, kode, harga, barangMasuk);
        this.jenisSepatu = jenisSepatu;
        this.brand = brand;
        this.size = size;
        this.stok = stok;
    }

    public String getJenisSepatu() {
        return jenisSepatu;
    }

    public void setJenisSepatu(String jenisSepatu) {
        this.jenisSepatu = jenisSepatu;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void displaySepatu(){
        System.out.println(" ------------------------------------ ");
        System.out.println(" Tanggal Masuk : " + this.barangMasuk);
        System.out.println(" ------------------------------------ ");
        System.out.println(" Nama Sepatu : " + this.nama);
        System.out.println(" Brand : " + this.brand);
        System.out.println(" Jenis Sepatu : " + this.jenisSepatu);
        System.out.println(" Kode : " + this.kode);
        System.out.println(" Size : " + this.size);
        System.out.println(" Harga : " + this.harga);
        System.out.println(" Stok : " + this.stok);
    }

    public void displayStok(){
        System.out.println(" Stok : " + this.stok);
    }
}

