package views;

import entity.BarangEntity;
import entity.SepatuEntity;
import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SepatuView extends Login {
    Scanner input = new Scanner(System.in);

    Admin adminModel = new Admin();
    Sepatu sepatuModel = new Sepatu();

    @Override
    boolean login() {
        System.out.print(" Username :");
        String username = input.nextLine();
        System.out.print(" Password :");
        String password = input.nextLine();
        return adminModel.statusLogin(username,password);
    }

    public void initialData(){
        SepatuEntity sepatu = new SepatuEntity("Casual","Adidas",40,5,
                "Adidas Spezials","adss3pzl5",1200000,"11 Mei 2023");
        SepatuEntity shoes = new SepatuEntity("Running","Ortuseight",39,3,
                "Furtunity","orts39",450000,"12 Juni 2023");

        Modell.sepatu.addSepatu(sepatu);
        Modell.sepatu.addSepatu(shoes);
    }

    private void menuAdmin(){
        System.out.println(" --------- MENU UNTUK ADMIN --------- ");
        System.out.println(" 1. Login Admin ");
        System.out.println(" 2. Exit ");
        System.out.println(" ------------------------------------ ");
    }

    private void menuFitur(){
        System.out.println(" --------- FITUR UNTUK ADMIN --------- ");
        System.out.println(" 1. Tambah Sepatu ");
        System.out.println(" 2. View All Sepatu ");
        System.out.println(" 3. Delete Sepatu ");
        System.out.println(" 4. Update Informasi Sepatu ");
        System.out.println(" 5. Search Sepatu By Nama ");
        System.out.println(" 6. Search Sepatu by Brand ");
        System.out.println(" 7. View Stok Sepatu ");
        System.out.println(" ------------------------------------ ");
    }

    public void run(){
        initialData();





        int pilih;
        awal:

//        x : while (true){
        do{
            menuAdmin();

            System.out.print(" Pilih Menu : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println(" ------------------------------------ ");

            switch (pilih){
                case 1:
                    System.out.println(" ------------------------------------ ");
                    System.out.println("            Login Admin ");
                    System.out.println(" ------------------------------------ ");
                    boolean status = login();
                    System.out.println(status);

                    if (status){
                        System.out.println(" Login Berhasil ");

                        boolean login = true;
                        while (login) {
                            menuFitur();

                            int pilihDong;

                            System.out.print(" Pilih Fitur : ");
                            pilihDong = input.nextInt();
                            input.nextLine();

                            switch (pilihDong) {
                                case 1:
                                    tambahSepatu();
                                    break;

                                case 2:
                                    viewAllSepatu();
                                    break;

                                case 3:
                                    deleteSepatu();
                                    break;

                                case 4:
                                    updateInformasiShoes();
                                    break;

                                case 5:
                                    searchByNama();
                                    break;

                                case 6:
                                    searchByBrand();
                                    break;

                                case 7:
                                    viewStok();
                                    break;

                                default:
                                    System.out.println(" Terima Kasih ");
                                    continue awal;
                            }
                        }


                    } else {
                        System.out.println(" Username / Password Salah ");
                    }

                case 2:
                    System.out.println(" Terima Kasih Semoga Bertemu Kembali ");
            }

        }while (pilih!=2);

    }
    private void tambahSepatu(){
        String jenisSepatu, brand, namaSepatu, kode, barangMasuk;
        int size, stok;
        double harga;

        System.out.println(" --------- Tambah Sepatu --------- ");
        System.out.print(" Nama Sepatu : ");
        namaSepatu = input.nextLine();

        if (Modell.sepatu.searchNamaSepatu(namaSepatu) == null ){
            System.out.println(" --------- Informasi Sepatu --------- ");
            System.out.print(" Tanggal Masuk : ");
            barangMasuk = input.nextLine();
            System.out.print(" Brand : ");
            brand = input.nextLine();
            System.out.print(" Kode : ");
            kode = input.nextLine();
            System.out.print(" Jenis : ");
            jenisSepatu = input.nextLine();
            System.out.print(" Size : ");
            size = input.nextInt();
            input.nextLine();
            System.out.print(" Harga : ");
            harga = input.nextDouble();
            System.out.print(" Stok : ");
            stok = input.nextInt();
            input.nextLine();

            SepatuEntity sepatu = new SepatuEntity(jenisSepatu,brand,size,stok,namaSepatu,kode,harga,barangMasuk);
            Modell.sepatu.addSepatu(sepatu);

        }
    }

    private void viewAllSepatu(){
        System.out.println(" --------- Lihat Sepatu --------- ");
        if(Modell.sepatu.listSepatu.size() > 0){
            for ( SepatuEntity sepatu : Modell.sepatu.listSepatu ){
                sepatu.displaySepatu();
            }
        } else {
            System.out.println(" Sepatu Tidak Ada!!!");
        }
    }

    private void deleteSepatu(){
        System.out.println(" --------- Hapus Sepatu --------- ");

        System.out.print(" Kode : ");
        String code = input.nextLine();

        SepatuEntity sepatuu = Modell.sepatu.searchKodeSepatu(code);

        if (sepatuu !=null){
                Modell.sepatu.deleteSepatu(sepatuu);
                System.out.println(" Sepatu Berhasil dihapus ");
            }else {
                System.out.println(" Sepatu Tidak Ditemukan ");
            }

        }

        public void updateInformasiShoes(){
        String namaShoes;

        System.out.println(" --------- Update Informasi Sepatu --------- ");
        System.out.print(" Nama : ");
        namaShoes = input.nextLine();

        SepatuEntity shoes = Modell.sepatu.searchNamaSepatu(namaShoes);

        if (shoes != null){
            System.out.println(" Pilih Yang Akan Di Update ");
            System.out.println(" 1. Harga ");
            System.out.println(" 2. Stok ");
            System.out.println(" --------------------------- ");
            System.out.print(" Pilih : ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println(" Harga \t : " + shoes.getHarga());
                    System.out.print(" Harga Baru : ");
                    int harga = input.nextInt();

                    shoes.setHarga(harga);

                    System.out.println(" Harga Sepatu Berhasil diUpdate ");
                }

                case 2 -> {
                    System.out.println(" Stok  \t\t : " + shoes.getStok());
                    System.out.print(" Update Stok : ");
                    int stok = input.nextInt();
                    input.nextLine();

                    shoes.setStok(stok);

                    System.out.println(" Stok Berhasil diUpdate ");
                }

                default -> System.out.println(" Pilihan Tidak Ada !!!!! ");
            }

        } else {
            System.out.println(" Barang Tidak Ditemukan !!!!! ");
        }
    }

    private void searchByNama(){
        System.out.print(" Nama : ");
        String nama = input.nextLine();
        SepatuEntity cek = Modell.sepatu.searchNamaSepatu(nama);
        if (cek != null){
            Modell.sepatu.searchNamaSepatu(nama).displaySepatu();
        } else {
            System.out.println(" Nama Sepatu Tidak Ada ");
        }
    }

    private void searchByBrand(){
        System.out.print(" Brand : ");
        String brand = input.nextLine();

        SepatuEntity cek = Modell.sepatu.searcBrandSepatu(brand);
        if (cek != null){
            Modell.sepatu.searcBrandSepatu(brand).displaySepatu();
        }
    }
    private void viewStok(){
        System.out.print(" Kode : ");
        String kd = input.nextLine();
        Modell.sepatu.ViewofStok(kd);
        if (kd == null){
            System.out.println(" Kode Sepatu Tidak Ditemukan ");
        }
    }
}
