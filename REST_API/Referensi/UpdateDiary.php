<?php

require_once('koneksi.php');

$id = $_POST['id'];
$title = $_POST['title'];
$desc = $_POST['description'];
$pic = $_POST['url_pic'];

$getdata = mysqli_query($koneksi,"SELECT * FROM t_diary WHERE id='$id'");
$rows = mysqli_num_rows($getdata);

$update = "UPDATE diary SET title='$title',description='$desc',img_url='$pic' WHERE id='$id'";
$exequery = mysqli_query($koneksi,$update);

$respose = array();

if($rows > 0)
{
  if($exequery)
  {
    $respose['code'] = 1;
    $respose['message'] = "Updated Success";
  }else{
    $respose['code'] = 0;
    $respose['message'] = "Updated Failed";
  }
}else{
  $respose['code'] = 0;
  $respose['message'] = "Updated Failed, Not data selected";
}
echo json_encode($respose);
?>