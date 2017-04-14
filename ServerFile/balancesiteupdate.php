
<?php
$con=mysqli_connect("localhost","vry","XnXssmDyympWzTnG","vry");
// Check connection
$userna = $_POST[username];
$balance = $_POST[balance];

if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

$sql="SELECT name,balance FROM userDB WHERE username='$userna' ";

if ($result=mysqli_query($con,$sql))
  {
  // Fetch one and one row
  while ($row=mysqli_fetch_row($result))
    {
    
$hello=$row[1];
    }
  // Free result set

  mysqli_free_result($result);
}

$bu = $balance + $hello;

$st = ("UPDATE userDB SET balance='$bu' WHERE username='$userna'");
   
    
 

if(mysqli_query($con,$st)){

echo "Successfully added to the user account :D<br>";
echo "\n It will automatically redirect to recharge page after 3 sec";
header("refresh:3; url=rechargepage.html");
}
else {
	echo "Not Updated";
}

mysqli_close($con);
?>