**README BlackJax Ticket App**

## Deskripsi

Aplikasi BlackJax Ticket App merupakan aplikasi berbasis JavaFX untuk mengelola penjualan tiket konser. Aplikasi ini memungkinkan pengguna memilih jenis dan jumlah tiket, memasukkan informasi pribadi, memilih metode pembayaran, dan menyelesaikan pembelian tiket.

## Fitur

### 1. Pemilihan Tiket
- Pengguna dapat memilih dari tiga kategori tiket: Reguler, VIP, dan VVIP.
- Harga tiket ditampilkan untuk setiap kategori.
- Pengguna dapat memilih jumlah tiket setiap jenis menggunakan kontrol Spinner.

### 2. Data Pembeli
- Pembeli diminta untuk memasukkan nama, email, dan nomor telepon.
- Validasi dasar diimplementasikan untuk memastikan kelengkapan dan kevalidan input pembeli.

### 3. Checkout
- Pembeli dapat meninjau tiket yang dipilih dan total harga.
- Tombol "Checkout" beralih ke langkah berikutnya jika setidaknya satu tiket dipilih.

### 4. Metode Pembayaran
- Pembeli dapat memilih antara "Transfer Bank" atau "E-wallet" sebagai metode pembayaran.
- Opsi tambahan untuk bank atau e-wallet disediakan berdasarkan metode pembayaran yang dipilih.
- Tombol "Next" beralih ke langkah terakhir jika metode pembayaran dipilih.

### 5. Konfirmasi
- Pembeli dapat meninjau informasi yang dimasukkan, tiket yang dipilih, total harga, dan metode pembayaran yang dipilih.
- Aplikasi meminta pembeli untuk memasukkan nama pengirim untuk transfer bank.
- Pembeli diberi informasi bahwa e-ticket akan dikirim ke email setelah menyelesaikan pembayaran.

### 6. Selesai
- Pembeli memasukkan nama pengirim untuk transfer bank.
- Tombol "Selesai" menyelesaikan proses pembelian dan menyimpan informasi pembeli ke file teks ("pembeli_data.txt").


## File Handling

Aplikasi menambahkan informasi pembeli, rincian tiket, dan informasi pembayaran ke file "pembeli_data.txt". Setiap pembelian dicatat dalam set baris baru untuk memudahkan pembacaan.
