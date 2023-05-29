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
			System.out.println("PatikaStore Ürün Yönetim Sistemi");
			System.out.println("1. Ürünleri Listele");
			System.out.println("2. Ürün Ekle");
			System.out.println("3. Ürün Sil");
			System.out.println("4. Ürünleri Filtrele");
			System.out.println("0. Çýkýþ");
			System.out.print("Seçiminizi yapýn: ");

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
				System.out.println("Çýkýþ yapýlýyor...");
				System.exit(0);
				break;
			default:
				System.out.println("Geçersiz bir seçim yaptýnýz. Tekrar deneyin.");
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
		urunler.add(new Notebook(3, 5000, 0.15, 8, "Notebook 1", markalar.get(2), "8 GB", "512 SSD", "14 inç"));
		urunler.add(new Notebook(4, 6000, 0.25, 3, "Notebook 2", markalar.get(3), "8 GB", "256 SSD", "15 inç"));
	}

	private static void urunleriListele() {
		System.out.println("----- Ürünler -----");
		System.out.println("ID\tÜrün Adý\tMarka\t\tBirim Fiyatý\tStok Miktarý");
		System.out.println("-----------------------------------------------------");

		for (Product urun : urunler) {
			System.out.format("%d\t%s\t%s\t%.2f TL\t%d adet%n", urun.getId(), urun.getUrunAdi(),
					urun.getMarka().getName(), urun.getBirimFiyat(), urun.getStokMiktari());
		}

		System.out.println();
	}

	private static void urunEkle(Scanner scanner) {
		System.out.println("Ürün Ekleme");
		System.out.println("1. Cep Telefonu");
		System.out.println("2. Notebook");
		System.out.print("Ürün türünü seçin (1-2): ");
		int tur = scanner.nextInt();

		System.out.print("Ürün ID'sini girin: ");
		int id = scanner.nextInt();

		System.out.print("Birim fiyatýný girin: ");
		double birimFiyat = scanner.nextDouble();

		System.out.print("Ýndirim oranýný girin: ");
		double indirimOrani = scanner.nextDouble();

		System.out.print("Stok miktarýný girin: ");
		int stokMiktari = scanner.nextInt();

		scanner.nextLine(); // Boþ satýrý oku

		System.out.print("Ürün adýný girin: ");
		String urunAdi = scanner.nextLine();

		System.out.print("Marka ID'sini girin: ");
		int markaId = scanner.nextInt();
		Brand marka = markalar.stream().filter(m -> m.getId() == markaId).findFirst().orElse(null);

		if (marka == null) {
			System.out.println("Geçersiz marka ID'si. Ürün eklenemedi.");
			return;
		}

		switch (tur) {
		case 1:
			scanner.nextLine(); // Boþ satýrý oku

			System.out.print("Hafýza bilgisini girin: ");
			String hafizaBilgisi = scanner.nextLine();

			System.out.print("Ekran boyutunu girin: ");
			String ekranBoyutu = scanner.nextLine();

			System.out.print("Pil gücünü girin: ");
			int pilGucu = scanner.nextInt();

			scanner.nextLine(); // Boþ satýrý oku

			System.out.print("RAM miktarýný girin: ");
			String ram = scanner.nextLine();

			System.out.print("Renk seçin (Siyah, Kýrmýzý, Mavi): ");
			String renk = scanner.nextLine();

			urunler.add(new MobilePhone(id, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, hafizaBilgisi,
					ekranBoyutu, pilGucu, ram, renk));
			System.out.println("Cep telefonu baþarýyla eklendi.");
			break;

		case 2:
			scanner.nextLine(); // Boþ satýrý oku

			System.out.print("RAM miktarýný girin: ");
			ram = scanner.nextLine();

			System.out.print("Depolama kapasitesini girin: ");
			String depolama = scanner.nextLine();

			System.out.print("Ekran boyutunu girin: ");
			ekranBoyutu = scanner.nextLine();

			urunler.add(new Notebook(id, birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, ram, depolama,
					ekranBoyutu));
			System.out.println("Notebook baþarýyla eklendi.");
			break;

		default:
			System.out.println("Geçersiz bir seçim yaptýnýz. Ürün eklenemedi.");
		}

		System.out.println();
	}

	private static void urunSil(Scanner scanner) {
		System.out.println("Ürün Silme");
		System.out.print("Silmek istediðiniz ürünün ID'sini girin: ");
		int id = scanner.nextInt();

		Product urun = urunler.stream().filter(u -> u.getId() == id).findFirst().orElse(null);

		if (urun == null) {
			System.out.println("Belirtilen ID'ye sahip bir ürün bulunamadý.");
			return;
		}

		urunler.remove(urun);
		System.out.println("Ürün baþarýyla silindi.");
		System.out.println();
	}

	private static void urunleriFiltrele(Scanner scanner) {
		System.out.println("Ürünleri Filtreleme");
		System.out.println("1. ID'ye göre filtrele");
		System.out.println("2. Markaya göre filtrele");
		System.out.print("Filtreleme türünü seçin (1-2): ");
		int tur = scanner.nextInt();

		switch (tur) {
		case 1:
			System.out.print("Filtrelenecek ID'yi girin: ");
			int id = scanner.nextInt();

			List<Product> filtrelenenlerId = urunler.stream().filter(u -> u.getId() == id).collect(Collectors.toList());

			if (filtrelenenlerId.isEmpty()) {
				System.out.println("Belirtilen ID'ye sahip bir ürün bulunamadý.");
			} else {
				System.out.println("----- Filtrelenen Ürünler -----");
				urunleriListele(filtrelenenlerId);
			}

			break;

		case 2:
			System.out.print("Filtrelenecek marka ID'sini girin: ");
			int markaId = scanner.nextInt();

			List<Product> filtrelenenlerMarka = urunler.stream().filter(u -> u.getMarka().getId() == markaId)
					.collect(Collectors.toList());

			if (filtrelenenlerMarka.isEmpty()) {
				System.out.println("Belirtilen marka ID'ye sahip bir ürün bulunamadý.");
			} else {
				System.out.println("----- Filtrelenen Ürünler -----");
				urunleriListele(filtrelenenlerMarka);
			}

			break;

		default:
			System.out.println("Geçersiz bir seçim yaptýnýz.");
		}

		System.out.println();
	}

	private static void urunleriListele(List<Product> urunler) {
		System.out.println("ID\tÜrün Adý\tMarka\t\tBirim Fiyatý\tStok Miktarý");
		System.out.println("-----------------------------------------------------");

		for (Product urun : urunler) {
			System.out.format("%d\t%s\t%s\t%.2f TL\t%d adet%n", urun.getId(), urun.getUrunAdi(),
					urun.getMarka().getName(), urun.getBirimFiyat(), urun.getStokMiktari());
		}

		System.out.println();
	}

}
