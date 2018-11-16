<?php
//include "connectdb.inc.php";

$resultArray = array();
//$resultArray["area"] = array();
$conn = mysqli_connect("localhost",$_POST['userdb'],$_POST['passworddb']);
$objDB = mysqli_select_db($conn,"bangna_queue");
mysqli_query($conn,"SET NAMES UTF8");
$sql = "Insert Into t_queue(staff_id, queue_date, row_1, queue_active, status_queue, date_begin)"
."Values('".$_POST['staff_id']."',now(),'".$_POST['row_1']."','1','1', now())";


mysqli_close($conn);
	//$pid = $_POST['order_id'];
	//$name = $_POST['foods_code'];
	//$price = $_POST['price'];
	//$description = $_POST['description'];
	//$conn->getArea();
header('Content-Type: application/json');
echo json_encode($resultArray);
?>