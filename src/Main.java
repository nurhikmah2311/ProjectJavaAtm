import java.util.Scanner;

class ATM {
    private String nomorAkun;
    private String pin;
    private double saldo;

    public ATM(String nomorAkun, String pin, double saldo) {
        this.nomorAkun = nomorAkun;
        this.pin = pin;
        this.saldo = saldo;
    }

    public String getNomorAkun(){
        return nomorAkun;
    }
    public String getPin(){
        return pin;
    }
    public void cekSaldo() {
        System.out.println("Saldo Anda: $" + saldo);
    }

    public  void deposit(double jumlah) {
        saldo += jumlah;
        System.out.println("Deposit sejumlah $" + jumlah + " berhasil. Saldo Anda Sekarang: $" + saldo);
    }

    public void tarikTunai(double jumlah) {
        if (jumlah > saldo) {
            System.out.println("Saldo tidak mencukupi.");
        } else  {
            saldo -= jumlah;
            System.out.println("Penarikan sejumlah $" + jumlah + " berhasil. Saldo Anda sekarang: $" + saldo);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //objek atm dengan nomor akun, PIN, dan saldo awal
        ATM atm = new ATM("123456789", "1234", 0);

        //memasukkan nomor akun dan PIN
        System.out.println("Selamat datang di ATM.");
        System.out.print("Masukkan nomor akun : ");
        String inputNomorAkun = scanner.nextLine();

        System.out.print("Masukkan PIN        : ");
        String inputPin = scanner.nextLine();

        //Periksa nomor akun dan pin sudah sesuai atau belum
        if(inputNomorAkun.equals(atm.getNomorAkun()) && inputPin.equals(atm.getPin())) {
            System.out.println("Autentikasi berhasil");
            int pilihan;

            do {
                System.out.println("\nMenu : ");
                System.out.println("1. Cek Saldo");
                System.out.println("2. Deposit");
                System.out.println("3. Tarik Tunai");
                System.out.println("4. Keluar");
                System.out.print("Pilihan Anda: ");

                pilihan = scanner.nextInt();

                switch (pilihan) {
                    case 1: atm.cekSaldo();
                    break;
                    case 2:
                        System.out.print("Masukkan jumlah deposit: ");
                        double depositJumlah = scanner.nextDouble();
                        atm.deposit(depositJumlah);
                        break;
                    case 3:
                        System.out.print("Masukkan jumlah tarik tunai: ");
                        double tarikTunaiJumlah = scanner.nextDouble();
                        atm.tarikTunai(tarikTunaiJumlah);
                        break;
                    case 4:
                        System.out.println("Terima kasih telah menggunakan ATM. Sampai jumpa!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silahkan pilih lagi.");
                }
            } while (pilihan != 4);
        } else {
            System.out.println("Nomor akun atau PIN salah. Program berhenti.");
        }
    }
}
