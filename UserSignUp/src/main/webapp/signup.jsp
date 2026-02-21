<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="signupstyle.css">
    <title>Signup Page</title>
</head>
<body>
    <div class="container">
        <h2>Signup</h2>
        <form action="signup" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="tel" name="phone" placeholder="Phone No" required pattern="[0-9]{10}" title="Please enter a valid phone number">
            <input type="password" name="password" placeholder="Password (min 8 characters)"  minlength="8" required>
            <input type="submit" value="Sign Up">
        </form>
        </div>
</body>
</html>