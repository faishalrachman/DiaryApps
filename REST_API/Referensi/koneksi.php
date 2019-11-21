<?php
	$koneksi = mysqli_connect("localhost","root","","db_diaryapps") or die("Koneksi Gagal");
	if (mysqli_connect_errno()) {
		echo "Gagal terhubung MySQL: " . mysqli_connect_error();
	}

?>
