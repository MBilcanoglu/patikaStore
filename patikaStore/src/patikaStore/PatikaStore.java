package patikaStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PatikaStore {
	private static List<Brand> markalar;
	private static List<Product> urunler;

	public static void main(String[] args) {
		markalar = new ArrayList<>();
		urunler = new ArrayList<>();

		markaOlustur();
		urunOlustur();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("PatikaStore �r�n Y�netim Sistemi");
			System.out.println("1. �r�nleri Listele");
			System.out.println("2. �r�n Ekle");
			System.out.println("3. �r�n Sil");
			System.out.println("4. �r�nleri Filtrele");
			System.out.println("0. ��k��");
			System.out.print("Se�iminizi yap�n: ");

			int secim = scanner.nextInt();

			switch (secim) {
			case 1:
				urunleriListele();
				break;
			case 2:
				urunEkle(scanner);
				break;
			case 3:
				urunSil(scanner);
				break;
			case 4:
				urunleriFiltrele(scanner);
				break;
			case 0:
				System.out.println("��k�� yap�l�yor...");
				System.exit(0);
				break;
			default:
				System.out.println("Ge�ersiz bir se�im yapt�n�z. Tekrar deneyin.");
			}
		}
	}

	private static void markaOlustur() {
		markalar.add(new Brand(1, "Samsung"));
		markalar.add(new Brand(2, "Lenovo"));
		markalar.add(new Brand(3, "Apple"));
		markalar.add(new Brand(4, "Huawei"));
		markalar.add(new Brand(5, "Casper"));
		markalar.add(new Brand(6, "Asus"));
		markalar.add(new Brand(7, "HP"));
		markalar.add(new Brand(8, "Xiaomi"));
		markalar.add(new Brand(9, "Monster"));

		Collections.sort(markalar, Comparator.comparing(Brand::getName));
	}

	private static void urunOlustur() {
		urunler.add(new MobilePhone(1, 2000, 0.1, 10, "Cep Telefonu 1", markalar.get(0), "128 GB", "6.1 Inc", 4000,
				"6 MB", "Siyah"));
		urunler.add(new MobilePhone(2, 2500, 0.2, 5, "Cep Telefonu 2", markalar.get(1), "64 GB", "6.1 Inc", 4000,
				"6 MB", "Mavi"));
		urunler.add(new Notebook(3, 5000, 0.15, 8, "Notebook 1", markalar.get(2), "8 GB", "512 SSD", "14 in�"));
		urunler.add(new Notebook(4, 6000, 0.25, 3, "Notebook 2", markalar.get(3), "8 GB", "256 SSD", "15 in�"));
	}

	private static void urunleriListele() {
		System.out.println("----- �r�nler -----");
		System.out.println("ID\t�r�n Ad�\tMarka\t\tBirim Fiyat�\tStok Miktar�");
		System.out.println("-----------------------------------------------------");

		for (Product urun : urunler) {
			System.out.format("%d\t%s\t%s\t%.2f TL\t%d adet%n", urun.getId(), urun.getUrunAdi(),
					urun.getMarka().getName(), urun.getBirimFiyat(), urun.getStokMiktari());
		}

		System.out.println();
	}

	private static void urunEkle(Scanner scanner) {
		System.out.println("�r�n Ekleme");
		System.out.println("1. Cep Telefonu");
		System.out.println("2. Notebook");
		System.out.print("�r�n t�r�n� se�in (1-2): ");
		int tur = scanner.nextInt();

		System.out.print("�r�n ID'sini girin: ");
		int id = scanner.nextInt();

		System.out.print("Birim fiyat�n� girin: ");
		double birimFiyat = scanner.nextDouble();

		System.out.print("�ndirim oran�n� girin: ");
		double indirimOrani = scanner.nextDouble();

		System.out.print("Stok miktar�n� girin: ");
		int stokMiktari = scanner.nextInt();

		scanner.nextLine(); // Bo� sat�r� oku

		System.out.print("�r�n ad�n� girin: ");
		String urunAdi = scanner.nextLine();

		System.out.print("Marka ID'sini girin: ");
		int markaId = scanner.nextInt();
		Brand marka = markalar.stream().filter(m -> m.getId() == markaId).findFirst().orElse(null);

		if (marka == null) {
			System.out.println("Ge�ersiz marka ID'si. �r�n eklenemedi.");
			return;
		}

		switch (tur) {
		case 1:
			scanner.nextLine(); // Bo� sat�r� oku

			System.out.print("Haf�za bilgisini girin: ");
			String hafizaBilgisi = scanner.nextLine();

			System.out.print("Ekran boyutunu girin: ");
			String ekranBoyutu = scanner.nextLine();

			System.out.print("Pil g�c�n� girin: ");
			int pilGucu = scanner.nextInt();

			scanner.nextLine(); // Bo� sat�r� oku

			System.out.print("RAM miktar�n� girin: ");
			String ram = scanner.nextLine();

			System.out.print("Renk se�in (Siyah, K�rm�z�, Mavi): ");
			String renk = scanner.nextLine();

			urunler.add(new MobilePhone(id, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, hafizaBilgisi,
					ekranBoyutu, pilGucu, ram, renk));
			System.out.println("Cep telefonu ba�ar�yla eklendi.");
			break;

		case 2:
			scanner.nextLine(); // Bo� sat�r� oku

			System.out.print("RAM miktar�n� girin: ");
			ram = scanner.nextLine();

			System.out.print("Depolama kapasitesini girin: ");
			String depolama = scanner.nextLine();

			System.out.print("Ekran boyutunu girin: ");
			ekranBoyutu = scanner.nextLine();

			urunler.add(new Notebook(id, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, ram, depolama,
					ekranBoyutu));
			System.out.println("Notebook ba�ar�yla eklendi.");
			break;

		default:
			System.out.println("Ge�ersiz bir se�im yapt�n�z. �r�n eklenemedi.");
		}

		System.out.println();
	}

	private static void urunSil(Scanner scanner) {
		System.out.println("�r�n Silme");
		System.out.print("Silmek istedi�iniz �r�n�n ID'sini girin: ");
		int id = scanner.nextInt();

		Product urun = urunler.stream().filter(u -> u.getId() == id).findFirst().orElse(null);

		if (urun == null) {
			System.out.println("Belirtilen ID'ye sahip bir �r�n bulunamad�.");
			return;
		}

		urunler.remove(urun);
		System.out.println("�r�n ba�ar�yla silindi.");
		System.out.println();
	}

	private static void urunleriFiltrele(Scanner scanner) {
		System.out.println("�r�nleri Filtreleme");
		System.out.println("1. ID'ye g�re filtrele");
		System.out.println("2. Markaya g�re filtrele");
		System.out.print("Filtreleme t�r�n� se�in (1-2): ");
		int tur = scanner.nextInt();

		switch (tur) {
		case 1:
			System.out.print("Filtrelenecek ID'yi girin: ");
			int id = scanner.nextInt();

			List<Product> filtrelenenlerId = urunler.stream().filter(u -> u.getId() == id).collect(Collectors.toList());

			if (filtrelenenlerId.isEmpty()) {
				System.out.println("Belirtilen ID'ye sahip bir �r�n bulunamad�.");
			} else {
				System.out.println("----- Filtrelenen �r�nler -----");
				urunleriListele(filtrelenenlerId);
			}

			break;

		case 2:
			System.out.print("Filtrelenecek marka ID'sini girin: ");
			int markaId = scanner.nextInt();

			List<Product> filtrelenenlerMarka = urunler.stream().filter(u -> u.getMarka().getId() == markaId)
					.collect(Collectors.toList());

			if (filtrelenenlerMarka.isEmpty()) {
				System.out.println("Belirtilen marka ID'ye sahip bir �r�n bulunamad�.");
			} else {
				System.out.println("----- Filtrelenen �r�nler -----");
				urunleriListele(filtrelenenlerMarka);
			}

			break;

		default:
			System.out.println("Ge�ersiz bir se�im yapt�n�z.");
		}

		System.out.println();
	}

	private static void urunleriListele(List<Product> urunler) {
		System.out.println("ID\t�r�n Ad�\tMarka\t\tBirim Fiyat�\tStok Miktar�");
		System.out.println("-----------------------------------------------------");

		for (Product urun : urunler) {
			System.out.format("%d\t%s\t%s\t%.2f TL\t%d adet%n", urun.getId(), urun.getUrunAdi(),
					urun.getMarka().getName(), urun.getBirimFiyat(), urun.getStokMiktari());
		}

		System.out.println();
	}

}
