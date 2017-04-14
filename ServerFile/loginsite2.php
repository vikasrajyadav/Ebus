<?php

$db_name = "vry";
$mysql_username = "vry";
$mysql_password = "XnXssmDyympWzTnG";
$server_name = "localhost";
$conn = mysqli_connect($server_name,$mysql_username, $mysql_password, $db_name);



$st = ("UPDATE userDB SET balance='$_POST[balance]' WHERE username='$_POST[username]'");
   
    
 

if(mysqli_query($conn,$st)){

echo "Successfully added to the user account :D<br>";
echo "\n It will automatically redirect to recharge page after 3 sec";
header("refresh:3; url=rechargepage.html");
}
else {
	echo "Not Updated";
}
?>