<?php
	$db_name = "vry";
	$mysql_username = "vry";
	$mysql_password = "XnXssmDyympWzTnG";
	$server_name = "localhost";
	$conn = mysqli_connect($server_name,$mysql_username, $mysql_password, $db_name);
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($conn, "SELECT * FROM admin WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $username, $password);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["username"] = $username;
        $response["password"] = $password;
	
    }
    
    echo json_encode($response);
?>
