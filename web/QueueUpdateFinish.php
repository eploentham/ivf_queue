<?php
//include "connectdb.inc.php";

$resultArray = array();
$tmp = array();
//$resultArray["area"] = array();
$conn = mysqli_connect("localhost",$_POST['userdb'],$_POST['passworddb']);
$objDB = mysqli_select_db($conn,"bangna_queue");
mysqli_query($conn,"SET NAMES UTF8");
$sql = "Update t_queue Set status_queue = '2', date_finish = now() Where queue_id = '".$_POST['queue_id']."'";
mysqli_query($conn,$sql);

$queueCurrent="";
$sql = "Select * From t_queue Where staff_id = '".$_POST['staff_id']."' and status_queue = '1' Order By queue_id asc limit 1";
if ($result=mysqli_query($conn,$sql)){
	$intNumRows = mysqli_num_rows($result);
	if($intNumRows>0){
		while($row = mysqli_fetch_array($result)){
			$queueCurrent = $row["row_1"];
			$tmp["row_1"] = $row["row_1"];
		}
	}else{
		$tmp["row_1"] = "0";
	}
}
//$queueCurrent = intval($queueCurrent)+1;
$sql = "Update b_staff Set queue_current ='".$queueCurrent."' Where staff_id = '".$_POST['staff_id']."'";
mysqli_query($conn,$sql);


$sql = "Select count(1) as cnt From t_queue Where staff_id = '".$_POST['staff_id']."' and status_queue = '1' ";
if ($result=mysqli_query($conn,$sql)){
	$intNumRows = mysqli_num_rows($result);
	if($intNumRows>0){
		while($row = mysqli_fetch_array($result)){
			$tmp["onhand"] = $row["cnt"];
		}
	}else{
			$tmp["onhand"] = "0";
	}
}else{
	$tmp["onhand"] = "0";
}

//$tmp["remark"] = $_POST['row_1'];
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