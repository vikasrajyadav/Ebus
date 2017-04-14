<?php
	$db_name = "vry";
	$mysql_username = "vry";
	$mysql_password = "XnXssmDyympWzTnG";
	$server_name = "localhost";
	$conn = mysqli_connect($server_name,$mysql_username, $mysql_password, $db_name);
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($conn, "SELECT * FROM userDB WHERE username = ?");
    mysqli_stmt_bind_param($statement, "s", $username);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $name, $username, $age, $password, $balance);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["name"] = $name;
        $response["age"] = $age;
        $response["username"] = $username;
        $response["password"] = $password;
	$response["balance"] = $balance;
    }
    
    echo json_encode($response);
?>
