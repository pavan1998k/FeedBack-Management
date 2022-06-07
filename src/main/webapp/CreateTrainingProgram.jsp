<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
input[type=date], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=date]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<form action="saveTraining">
  <div class="container">
    <h1>Training Program Details</h1>
    <p>Please fill in this form to create an TrainingPrograms.</p>
    <hr>

    <label><b>Name</b></label>
    <input type="text" placeholder="Enter training program name" name="name" required><br>

    <label><b>Starting Date</b></label><br>
    <input type="text" placeholder="Enter Starting Date(yyyy-mm-dd)" name="startingDate" required><br>

    <label><b>Ending Date</b></label><br>
    <input type="text" placeholder="Enter Ending Date(yyyy-mm-dd)" name="endingDate" required><br>
    
    <label><b>Faculty Name</b></label>
    <input type="text" placeholder="Enter Faculty Name" name="facultyName" required>
    <br>
    <button type="submit" value="Submit">Submit</button>
  </div>
  
</form>

</body>
</html>