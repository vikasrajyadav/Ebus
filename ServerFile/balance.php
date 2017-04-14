
<?php

$db_name = "vry";
$mysql_username = "vry";
$mysql_password = "XnXssmDyympWzTnG";
$server_name = "localhost";
$conn = mysqli_connect($server_name,$mysql_username, $mysql_password, $db_name);



$st = ("UPDATE userDB SET balance='$_POST[balance]' WHERE username='$_POST[username]'");
   
    
     $response = array();

if(mysqli_query($conn,$st)){
    $response["success"] = true;  
}
else {
        $response["success"] = false;  
}
    echo json_encode($response);
?>