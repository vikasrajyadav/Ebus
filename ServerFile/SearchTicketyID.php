<?php
	$db_name = "vry";
	$mysql_username = "vry";
	$mysql_password = "XnXssmDyympWzTnG";
	$server_name = "localhost";
	$conn = mysqli_connect($server_name,$mysql_username, $mysql_password, $db_name);
    
    $username = $_POST["username"];
    $ticketid = $_POST["ticketid"];
    
    $statement = mysqli_prepare($conn, "SELECT * FROM Ticket WHERE ticket_id = ?");
    mysqli_stmt_bind_param($statement, "i", $ticketid);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $ticket_id, $username, $current_l, $destination, $quantity, $ticketprice,$BooleancheckBox);
    

    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["username"] = $username;
        $response["current_l"] = $current_l;
        $response["destination"] = $destination;
        $response["quantity"] = $quantity;
        $response["ticketprice"] = $ticketprice;
	$response["boole"] = $BooleancheckBox;

    }
    
    echo json_encode($response);
?>
