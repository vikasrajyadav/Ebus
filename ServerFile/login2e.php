<?php
    $con = mysqli_connect("localhost", "vry", "XnXssmDyympWzTnG", "vry");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

$sql="SELECT username,current_l,destination,quantity,ticketprice FROM Ticket Where username='vry' ";

if ($result=mysqli_query($con,$sql))
  {
  // Fetch one and one row
  while ($row=mysqli_fetch_row($result))
    {
    printf ("username='%s', current_location='%s', destination='%s', quantity='%s',ticketprice='%s'\n<br>",$row[0],$row[1],$row[2],$row[3],$row[4]);

    }
  // Free result set
  mysqli_free_result($result);
}

mysqli_close($con);
?>