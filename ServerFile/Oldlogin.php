<?php

$db_name = "vry";
$mysql_username = "vry";
$mysql_password = "XnXssmDyympWzTnG";
$server_name = "localhost";
$conn = mysqli_connect($server_name,$mysql_username, $mysql_password, $db_name);


$user_name = $_POST["username"];
$user_pass = $_POST["password"];
$mysql_qry = "select * from admin where username like '$user_name' and password like '$user_pass';";
$result = mysqli_query($conn , $mysql_qry);
if(mysqli_num_rows ($result) > 0){
	header('Location: http://vry.vipiny.com/rechargepage.html');
}
else {
	echo "Login not Success";
}
?>