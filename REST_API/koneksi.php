<?php 
    $host = "localhost";
    $username = "root";
    $pass = "";
    $db = "db_diary";
    $koneksi = mysqli_connect($host,$username,$pass,$db) 
        or die("Koneksi Gagal");
	if (mysqli_connect_error()) {
		echo "Gagal terhubung MySQL: " . mysqli_connect_error();
	}
?>