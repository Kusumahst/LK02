import java.util.Scanner;

class Driver {
    public String nama;
    public String noSIM;
    public int usia;

    public Driver(String nama, String noSIM, int usia) {
        this.nama = nama;
        this.noSIM = noSIM;
        this.usia = usia;
    }
}

class Kendaraan {
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    public Driver driver;

    public Kendaraan(String platNomor, int maxPenumpang) {
        this.platNomor = platNomor;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = maxPenumpang;
    }

    public void cekPenumpang() {
        System.out.println("Jumlah Penumpang saat ini: " + jumlahPenumpang + " orang");
    }

    public void penumpangNaik(int naik) {
        System.out.println("Penumpang naik: " + naik + " orang");
        if (jumlahPenumpang + naik <= maxPenumpang) {
            jumlahPenumpang += naik;
        } else {
            System.out.println("Kapasitas Kendaraan tidak mencukupi");
        }
        cekPenumpang();
    }

    public void penumpangTurun(int turun) {
        System.out.println("Penumpang turun: " + turun + " orang");
        if (jumlahPenumpang - turun >= 0) {
            jumlahPenumpang -= turun;
        } else {
            System.out.println("Tidak ada penumpang yang turun");
        }
        cekPenumpang();
    }

    public void showDriver() {
        if (this.driver != null) {
            System.out.println("Nama: " + this.driver.nama + "\nUsia: " + this.driver.usia + " tahun");
        } else {
            System.out.println("Tidak ada supir yang terdaftar");
        }
    }

    public void showPlat() {
        System.out.println("NO SIM: " + this.driver.noSIM);
    }
}

class Bus extends Kendaraan {
    double hargaTiket;
    String jenisBus = "";

    public Bus(String platNomor, int maxPenumpang, double hargaTiket) {
        super(platNomor, maxPenumpang);
        this.hargaTiket = hargaTiket;
        jenisBus();
    }

    public void jenisBus() {
        if (0 < hargaTiket && hargaTiket <= 300000) {
            this.jenisBus = "Ekonomi";
        } else if (300000 < hargaTiket && hargaTiket <= 600000) {
            this.jenisBus = "Bisnis";
        } else {
            this.jenisBus = "Sleeper";
        }
    }

    public String JenisBus() {
        return jenisBus;
    }

    public void cekJenisBus() {
        System.out.println("Jenis Bus Saat Ini: " + jenisBus);
    }
}

class Truk extends Kendaraan {
    double muatanSekarang;
    double kapasitasMuatan;

    public Truk(String platNomor, int maxPenumpang, double kapasitasMuatan) {
        super(platNomor, maxPenumpang);
        this.kapasitasMuatan = kapasitasMuatan;
        this.muatanSekarang = 0;
    }

    public void cekMuatan() {
        System.out.println("Total Muatan saat ini: " + muatanSekarang);
    }

    public void tambahMuatan(int tambah) {
        System.out.println("Muatan Bertambah: " + tambah);
        if (muatanSekarang + tambah <= kapasitasMuatan) {
            muatanSekarang += tambah;
        } else {
            System.out.println("Kapasitas muatan tidak mencukupi");
        }
        cekMuatan();
    }

    public void kurangMuatan(int kurang) {
        System.out.println("Muatan Berkurang: " + kurang);
        if (muatanSekarang - kurang >= 0) {
            muatanSekarang -= kurang;
        } else {
            System.out.println("Tidak ada muatan yang berkurang");
        }
        cekMuatan();
    }
}

public class LK02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Bus b1 = new Bus("B 1742 CD", 25, 0);
        Truk t1 = new Truk("B 8142 YZ", 2, 100);

        Driver d1 = new Driver("Rayyan", "02789027", 25);
        Driver d2 = new Driver("Rudia", "73720948", 28);

        int pilihan = 0;
        do {
            System.out.print("\nSELAMAT DATANG DI APLIKASI KENDARAAN");
            System.out.print("\n------------------------------------");
            System.out.print("\nMENU PILIHAN: ");
            System.out.println("\n1. Bus");
            System.out.println("2. Truk");
            System.out.println("3. Keluar");
            System.out.print("------------------------------------");
            System.out.print("\nPilihan Anda: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    int pilihan1;
                    do {
                        System.out.println("\nMENU KENDARAAN BUS");
                        System.out.print("------------------------");
                        System.out.println("\nIDENTITAS PENGEMUDI");
                        b1.driver = d1;
                        b1.showDriver();
                        b1.showPlat();
                        System.out.print("------------------------");
                        System.out.println("\n1. Penumpang Naik");
                        System.out.println("2. Penumpang Turun");
                        System.out.println("3. Cek Penummpang");
                        System.out.println("4. Harga Tiket");
                        System.out.println("5. Cek Jenis Bus");
                        System.out.println("6. Keluar");
                        System.out.print("------------------------");
                        System.out.print("\nPilih Menu : ");
                        pilihan1 = input.nextInt();

                        switch (pilihan1) {
                            case 1:
                                System.out.println("Berapa jumlah penumpang naik?");
                                int naik = input.nextInt();
                                b1.penumpangNaik(naik);
                                break;
                            case 2:
                                System.out.println("Berapa jumlah penumpang turun?");
                                int turun = input.nextInt();
                                b1.penumpangTurun(turun);
                                break;
                            case 3:
                                b1.cekPenumpang();
                                break;
                            case 4:
                                System.out.println("Berapa Harga Tiket Bus?");
                                double hargaTiket = input.nextDouble();
                                b1.hargaTiket = hargaTiket;
                                b1.jenisBus();
                                break;
                            case 5:
                                b1.cekJenisBus();
                                break;
                            case 6:
                                System.out.println("Keluar dari menu Bus");
                                break;
                            default:
                                System.out.println("Menu Tidak Tersedia");
                                return;
                        }
                    } while (pilihan1 != 6);
                    break;
                case 2:
                    int pilihan2;
                    do {
                        System.out.println("\nMENU KENDARAAN TRUK");
                        System.out.print("------------------------");
                        System.out.println("\nIDENTITAS PENGEMUDI");
                        t1.driver = d2;
                        t1.showDriver();
                        t1.showPlat();
                        System.out.print("------------------------");
                        System.out.println("\n1. Penumpang Naik");
                        System.out.println("2. Penumpang Turun");
                        System.out.println("3. Cek Penummpang");
                        System.out.println("4. Tambah Muatan");
                        System.out.println("5. Kurang Muatan");
                        System.out.println("6. Cek Muatan");
                        System.out.println("7. Keluar");
                        System.out.print("------------------------");
                        System.out.print("\nPilih Menu : ");
                        pilihan2 = input.nextInt();

                        switch (pilihan2) {
                            case 1:
                                System.out.println("Berapa jumlah penumpang naik?");
                                int naik = input.nextInt();
                                t1.penumpangNaik(naik);
                                break;
                            case 2:
                                System.out.println("Berapa jumlah penumpang turun?");
                                int turun = input.nextInt();
                                t1.penumpangTurun(turun);
                                break;
                            case 3:
                                t1.cekPenumpang();
                                break;
                            case 4:
                                System.out.println("Berapa jumlah penambahan muatan?");
                                int tambah = input.nextInt();
                                t1.tambahMuatan(tambah);
                                break;
                            case 5:
                                System.out.println("Berapa jumlah pengurangan muatan?");
                                int kurang = input.nextInt();
                                t1.kurangMuatan(kurang);
                                break;
                            case 6:
                                t1.cekMuatan();
                                break;
                            case 7:
                                System.out.println("Keluar dari menu Bus");
                                break;
                            default:
                                System.out.println("Menu Tidak Tersedia");
                                return;
                        }
                    } while (pilihan2 != 7);
                    break;
                case 3:
                    System.out.println("\nTerima Kasih Telah Menggunakan Menu Ini");
                    break;
                default:
                    System.out.println("Pilihan anda tidak tersedia");
                    return;
            }
        } while (pilihan != 3);
        input.close();
    }
}
