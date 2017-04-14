<?php
   	$db_name = "vry";
	$mysql_username = "vry";
	$mysql_password = "XnXssmDyympWzTnG";
	$server_name = "localhost";
	$conn = mysqli_connect($server_name,$mysql_username, $mysql_password, $db_name);
    
    $username = $_POST["username"];
    $current_l = $_POST["current_l"];
    $destination = $_POST["destination"];
    $quantity = $_POST["quantity"];
    $ticketprice = $_POST["ticketprice"];
    $bool = $_POST["bool"];


    $statement = mysqli_prepare($conn, "INSERT INTO Ticket (username, current_l, destination, quantity, ticketprice,BooleancheckBox) VALUES (?, ?, ?, ?, ?,?)");
    mysqli_stmt_bind_param($statement, "sssiis", $username, $current_l, $destination, $quantity, $ticketprice,$bool);
    mysqli_stmt_execute($statement);
    
	$last_id = $conn->insert_id;
   
	
    $response = array();
    $response["success"] = true;  
    $response["ticketid"] = $last_id;
    
    echo json_encode($response);
?>
