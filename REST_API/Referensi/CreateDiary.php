<?php
include_once('koneksi.php');



$title = $_POST['title'];
$desc = $_POST['description'];
$pic = $_POST['url_pic'];

$insert = "INSERT INTO t_diary(title,description,img_url) VALUES ('$title','$desc','$pic')";



$exeinsert = mysqli_query($koneksi,$insert);



$response = array();



if($exeinsert)

{

  $response['code'] =1;

  $response['message'] = "Success! Data Inserted";

}else{

  $response['code'] =0;

  $response['message'] = "Failed! Data Not Inserted";

}



echo json_encode($response);

?>