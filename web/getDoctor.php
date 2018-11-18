<?php
//include "connectdb.inc.php";

//$conn = new ConnectDB();
$resultArray = array();
//$resultArray["area"] = array();
$conn = mysqli_connect("localhost",$_POST['userDB'],$_POST['passDB']);
$objDB = mysqli_select_db($conn,$_POST['nameDB']);
mysqli_query($conn,"SET NAMES UTF8");
$sql = "Select * From b_staff Where staff_active = '1' and position_id = '1' Order By sort1";
if ($result=mysqli_query($conn,$sql)){
	$intNumRows = mysqli_num_rows($result);
	while($row = mysqli_fetch_array($result)){
		//$arrCol = array();
		$tmp = array();
		$tmp["prefix"] = $row["prefix"];
		$tmp["staff_id"] = $row["staff_id"];
	    $tmp["staff_code"] = $row["staff_code"];
	    $tmp["staff_fname_t"] = $row["staff_fname_t"];
	    $tmp["staff_fname_e"] = $row["staff_fname_e"];
	    $tmp["staff_lname_t"] = $row["staff_lname_t"];
	    $tmp["staff_lname_e"] = $row["staff_lname_e"];
	    $tmp["active"] = $row["active"];
	    $tmp["remark"] = $row["remark"];
	    $tmp["username"] = $row["username"];
	    $tmp["password1"] = $row["password1"];
	    $tmp["priority"] = $row["priority"];
	    $tmp["tele"] = $row["tele"];
	    $tmp["mobile"] = $row["mobile"];
	    $tmp["fax"] = $row["fax"];
	    $tmp["email"] = $row["email"];
	    //$tmp["sort1"] = $row["sort1"];
	    $tmp["position_id"] = $row["sort1"];
	    $tmp["pid"] = $row["pid"];
	    //$tmp["tax_id"] = $row["tax_id"];
		//for($i=0;$i<$intNumField;$i++)
		//{
		//	$arrCol[mysql_field_name($objQuery,$i)] = $obResult[$i];
		//}
		array_push($resultArray,$tmp);
	}
}

mysqli_close($conn);
	//$pid = $_POST['order_id'];
	//$name = $_POST['foods_code'];
	//$price = $_POST['price'];
	//$description = $_POST['description'];
	//$conn->getArea();
header('Content-Type: application/json');
echo json_encode($resultArray);
?>