<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="logoutstyle.css">
    <title>Login Page</title>	
</head>
<body>						
<div style="color: green; font-size: 50px; margin-left: -100px; margin-bottom: 500px; "><h1 style="color: green; font-size: 50px;">You Have Logout Successfully !!</h1></div>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required>
           
            <input type="password" name="password" placeholder="Password" required>
            <input style="width:200px; "  type="submit" value="Login"><br><br>
      <h1 style="color:purple; font-style: italic; font-size: 20px;">New Customer <a href="signup.jsp">SignUp</a></h1>
            
        </form>
        </div>
        </body>
        </html>