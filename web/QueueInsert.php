<?php
//include "connectdb.inc.php";

$resultArray = array();
//$resultArray["area"] = array();
$conn = mysqli_connect("localhost",$_POST['userdb'],$_POST['passworddb']);
$objDB = mysqli_select_db($conn,"bangna_queue");
mysqli_query($conn,"SET NAMES UTF8");
$sql = "Insert Into t_queue(staff_id, queue_date, row_1, queue_active, status_queue, date_begin)"
."Values('".$_POST['staff_id']."',now(),'".$_POST['row_1']."','1','1', now())";
mysqli_query($conn,$sql);
if($_POST['row_1']==="1"){
	$sql = "Update b_staff Set queue_current = '".$_POST['row_1']."', queue_date = now() "
		."Where staff_id = '".$_POST['staff_id']."'";
	mysqli_query($conn,$sql);	
}

$sql = "Select count(1) as cnt From t_queue Where staff_id = '".$_POST['staff_id']."' and status_queue = '1' ";
if ($result=mysqli_query($conn,$sql)){
	$intNumRows = mysqli_num_rows($result);
	if($intNumRows>0){
		while($row = mysqli_fetch_array($result)){
			$tmp = array();
			$tmp["onhand"] = $row["cnt"];
		}
	}else{
		$tmp = array();
			$tmp["onhand"] = "0";
	}
}else{
	$tmp = array();
	$tmp["onhand"] = "0";
}

//$tmp = array();
$tmp["remark"] = $_POST['row_1'];
$tmp["success"] = "ok";
array_push($resultArray,$tmp);
mysqli_close($conn);
	//$pid = $_POST['order_id'];
	//$name = $_POST['foods_code'];
	//$price = $_POST['price'];
	//$description = $_POST['description'];
	//$conn->getArea();
header('Content-Type: application/json');
echo json_encode($resultArray);
?>