<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/prof-pic.png">
    <title>StockIO</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            background: #272626;
        }

        #login {
            position: fixed;
            top: 50%;
            left: 50%;
            /* bring your own prefixes */
            transform: translate(-50%, -50%);
        }

        #login-form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        #login-form input {
            width: 28em;
            height: 3em;
            margin-bottom: 0.5em;
            background: #F2994A;
            border: none;
            border-radius: 10px;
            text-indent: 5px;
        }

        #login-form input::placeholder {
            color: black;
        }

        #login-form button {
            font-size: 1.2em;
            height: 1.8em;
            width: 19em;
        }

        #lgn-btn {
            margin-top: 1em;
            background: #F2994A;
            border: none;
            border-radius: 10px;
        }

        #lgn-btn:hover {
            cursor: pointer;
        }

        #prof-pic {
            width: 9em;
            margin-bottom: 2em;
        }

        #check-forgot {
            width: 100%;
            display: flex;
            margin-top: 1em;
        }

        #check-forgot input{
            height: 1em;
            width: 1em;
            margin-right: .5em;
            margin-left: .2em;
        }

        #check-forgot a{
            margin-left: auto;
        }

        #create-acc {
            margin-top: 1em;
        }

        .naked-text {
            color: whitesmoke;
            font-size: .8em;
        }

    </style>
</head>
<body>
<div id="login">
    <form id="login-form">
        <div id="profile-img">
            <img src="img/prof-pic.png" id="prof-pic">
        </div>
        <input type="text" placeholder="Username" id="lgn-username" required>
        <input type="text" placeholder="Password" id="lgn-password" required>
        <div class="naked-text" id="check-forgot">
            <input type="checkbox" id="lgn-rmbr" name="remember" value="remember">
            <label for="lgn-rmbr">Remember?</label>
            <a>Forgot Password?</a>
        </div>
        <button type="submit" id="lgn-btn">Login</button>
        <a class="naked-text" id="create-acc">Create an Account?</a>
    </form>
</div>

<a href="portal.jsp">Hello Servlet</a>
</body>
</html>