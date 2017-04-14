
<?php
$con=mysqli_connect("localhost","vry","XnXssmDyympWzTnG","vry");
// Check connection
$ticketid = $_POST[ticketid];
$boolean = $_POST[boolean];


$st = ("UPDATE Ticket SET BooleancheckBox ='$boolean' WHERE ticket_id='$ticketid'");
   
    
 
      $response = array();

if(mysqli_query($con,$st)){

	        $response["success"] = true;  

  

}
else {
        $response["success"] = false;  

 $response["bool"] = false;
	
}

    echo json_encode($response);

mysqli_close($con);
?>