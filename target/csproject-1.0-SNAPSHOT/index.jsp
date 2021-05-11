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
            font-family: Verdana, Helvetica;
        }

        input:focus, textarea:focus, select:focus{
            outline: none;
        }

        a:visited, a:link, a:visited, a:active {
            text-decoration: none;
            color: whitesmoke;
        }

        body {
            background: #272626;
        }

        #background {
            width: 100vw;
            height: 100vh;
            background-image: url("img/stock.png");
            background-size: cover;
            position: absolute;
            top: 0px;
            right: 0px;
            bottom: 0px;
            left: 0px;
            opacity: 0.4;
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

        #lgn-username, #lgn-password {
            background: #F2994A;
            box-shadow: inset 9px 9px 18px #c27a3b,
            inset -9px -9px 18px #ffb859;
        }

        #login-form button {
            font-size: 1em;
            letter-spacing: .2em;
            color: rgba(0, 0, 0, 0.8);
            height: 2em;
            width: 23em;
            background: linear-gradient(145deg, #ffa44f, #da8a43);
        }

        #login-form button:focus {
            background: #F2994A;
            box-shadow: inset 9px 9px 18px #c27a3b,
            inset -9px -9px 18px #ffb859;
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
            margin-bottom: .5em;
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
<%--<div id="background"></div>--%>
<div id="login">
    <form id="login-form" method="post" action="/login">
        <div id="profile-img">
            <img src="img/prof-pic.png" id="prof-pic">
        </div>
        <input type="text" placeholder="Username" name="username" id="lgn-username" autocomplete="off" required>
        <input type="password" placeholder="Password" name="password" id="lgn-password" autocomplete="off" required>
        <div class="naked-text" id="check-forgot">
            <input type="checkbox" id="lgn-rmbr" name="remember" value="remember">
            <label for="lgn-rmbr">Remember?</label>
            <a href="#">Forgot Password?</a>
        </div>
        <button type="submit" id="lgn-btn">Login</button>
        <a href="#" class="naked-text" id="create-acc">Create an Account?</a>
    </form>
</div>
</body>
</html>