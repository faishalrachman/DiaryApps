<?php 
include_once('koneksi.php');

$id = $_POST['id'];

$query = "SELECT * FROM t_diary WHERE id = $id";
$result = mysqli_query($koneksi,$query);
$array_data = array();
while($baris = mysqli_fetch_assoc($result))
{
  $array_data[]=$baris;
}

echo json_encode($array_data);
?>
