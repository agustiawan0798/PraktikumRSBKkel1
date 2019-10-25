<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Cari Data Mahasiswa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
    <header>
      <h1 style="text-align:center">Cari Data Mahasiswa</h1>
    </header>
    <main style="display:flex;justify-content:center;flex-direction: column;">
            <form action="search" method="post" style="display:flex;justify-content:center;flex-direction: column;align-items: center;">
                <label for="nama" style="margin-bottom:5px">Cari Mahasiswa</label>
                <input id="nama" type="text" name="param" placeholder="Masukan Nama/NIM">
                <span style="color:black">${show}</span>
                <br>
                <input type="submit" name="submit" value="Cari" style="width:150px">
                <br>
            </form>
                <br>
            <form action="search" method="get" style="display:flex;justify-content:center;flex-direction: column;align-items: center;">
                <label for="nama" style="margin-bottom:5px">Tambah Mahasiswa</label>
                <input id="nama2" type="text" name="nama" placeholder="Masukkan Nama">
                <br>
                <input id="nim" type="text" name="nim" placeholder="Masukkan Nim">
                <br>
                <input type="submit" name="submit" value="Tambah" style="width:150px">
            </form>
    </main><br>
    <footer style="text-align:center">&copy; Kelompok 1</footer>
  </body>
</html>
