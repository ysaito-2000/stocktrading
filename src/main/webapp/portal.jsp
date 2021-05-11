<%@ page import="com.example.csproject.stock.User" %>
<%@ page import="com.example.csproject.stock.Database" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.csproject.stock.DataPoint" %>
<%@ page import="java.lang.reflect.Array" %><%--
  Created by IntelliJ IDEA.
  User: Yuki
  Date: 5/8/2021
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/prof-pic.png">
    <title>StockIO - Portal</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            list-style: none;
        }

        body {
            overflow: hidden;
        }

        #sidebar {
            height: 100%;
            width: 11%;
            position: absolute;
            left: 0;
            background: rgb(255, 255, 255);
            border-right: 1px solid #F8F8F8;
            z-index: 5;
        }

        #profile {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        #profile h1 {
            font-size: 1.3em;
        }

        #stock-nav {
            font-size: .7em;
            font-weight: lighter;
            margin-top: 1em;
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 100%;
        }

        #stock-nav-dropdown {
            display: flex;
            flex-direction: row;
            align-items: center;
            font-size: 1.5em;
            font-weight: bolder;
            width: 75%;
            padding-top: .1em;
            padding-bottom: .1em;
            border-top: 1px solid #61A6FF;
            border-bottom: 1px solid #61A6FF;
        }

        #stock-nav-dropdown img{
            margin-left: auto;
            margin-right: .1em;
        }

        #stock-nav-dropdown p{
            color: #61A6FF;
        }

        #stock-nav-title {
            margin-top: .5em;
            margin-bottom: .5em;
            padding-top: .3em;
            padding-bottom: .3em;
            border-top: 1px solid #61A6FF;
            border-bottom: 1px solid #61A6FF;
            width: 75%;
            text-align: center;
            color: #61A6FF;
            font-weight: 0;
            font-size: 1.9em;
            letter-spacing: .1em;
        }

        #stock-nav ul {
            font-size: 1.7em;
            list-style: none;
        }

        #stock-nav li {
            margin-bottom: .2em;
        }

        #showcase {
            height: 100%;
            width: 89%;
            position: absolute;
            right: 0;
        }

        #topbar {
            background: rgb(250, 251, 252);
            position: relative;
            width: 100%;
            height: 12%;
            border-bottom: 1px solid #E7E7E7;
            z-index: 4;
        }

        #topbar img {
            position: absolute;
            width: 4em;
            right: 0;
        }

        #date-select ul li{
            display: block;
            text-align: center;
            float: left;
            text-decoration: none;
            margin-left: 3em;
            font-size: 1.2em;
        }

        #date-select ul{
            position: absolute;
            bottom: 1em;
        }

        #content {
            background: rgb(246, 249, 252);
            width: 100%;
            height: 88%;
            display: flex;
        }

        #graph {
            margin-left: 3em;
            padding-top: 3em;
            width: 50vw;
            height: 65vh;
        }

        #bottom-bar {
            display: flex;
            flex-direction: row;
            margin-left: 3em;
        }

        #bottom-bar div {
            margin-top: 1.8em;
            margin-left: 1.5em;
            font-size: 1.4em;
        }

        #bottom-bar button {
            color: #61A6FF;
            font-size: 1.1em;
            width: 80px;
            height: 25px;
            position: relative;
            text-align: center;
            cursor: pointer;
            border: none;
            background: none;
        }

        #bottom-bar input {
            height: 2.5em;
            width: 4em;
        }

        #btm-bar-buy {
            padding-left: 14em;
        }

        #btm-bar-shares, #btm-bar-profit {
            display: inherit;
            flex-direction: row;
        }

        #user-shares, #user-profit {
            margin-left: 1em;
        }

        #right-bar {
            margin-left: auto;
            margin-right: auto;
            margin-top: 6em;
            display:flex;
            flex-direction: column;
            align-items: center;
        }

        #right-bar form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        #remind-radio {
            margin-top: 1em;
        }

        #price-input {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 2em;
        }

    </style>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        let stockData = JSON.parse(`${stockJSON}`);

        let formattedStockData = [];

        for (let i in stockData) {
            let dataPoint = stockData[i];
            formattedStockData.push([dataPoint.date, dataPoint.close]);
        }

        google.charts.load('current', {'packages':['corechart', 'scatter']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            let data = new google.visualization.DataTable();

            data.addColumn("string", "Date");
            data.addColumn("number", "Close");

            data.addRows(formattedStockData)

            let options = {
                title: 'Apple',
                width: 1000,
                height: 600,
                series: {
                    1: {axis: "close"}
                },
                axes: {
                    y: {
                        "price": { label: "Price/Stock"}
                    }
                },
                legend: {position: 'bottom'}
            };

            let materialChart = new google.charts.Scatter(document.getElementById('chart'));
            materialChart.draw(data, google.charts.Scatter.convertOptions(options));
        }
    </script>
</head>
<body>
    <div id="body">
        <div id="sidebar">
            <div id="profile">
                <img src="img/prof-pic2.png">
                <h1>DeepStockValue</h1>
            </div>
            <div id="stock-nav">
                <p id="stock-nav-title">Stocks</p>
                <ul>
                    <li>Tesla</li>
                    <li>Apple</li>
                    <li>AMD</li>
                </ul>
                <div id="stock-nav-dropdown">
                    <p>More</p>
                    <img src="img/expand-arrow.png">
                </div>
            </div>
        </div>
        <div id="showcase">
            <div id="topbar">
                <div id="date-select">
                    <ul>
                        <li>H</li>
                        <li>D</li>
                        <li>W</li>
                        <li>M</li>
                        <li>All</li>
                    </ul>
                </div>
                <img src="img/logout.png">
            </div>
            <div id="content">
                <div id="center-content">
                    <div id="graph">
                        <div id="chart" style="width: 900px; height: 500px"></div>
                    </div>
                    <div id="bottom-bar">
                        <div id="btm-bar-shares">
                            <p>Shares:</p>
                            <p id="user-shares">0</p>
                        </div>
                        <div id="btm-bar-profit">
                            <p>Profit:</p>
                            <p id="user-profit">0</p>
                        </div>
                        <div id="btm-bar-buy">
                            <form method="post" action="/buysellservlet">
                                <label for="buy"><button type="submit">Buy</button></label>
                                <input type="number" min="0" name="buy" id="buy" value="0.0">
                                <label for="sell"><button type="submit">Sell</button></label>
                                <input type="number" min="0" name="sell" id="sell" value="0.0">
                            </form>
                        </div>
                    </div>
                </div>
                <div id="right-bar">
                    <p>Set Reminders</p>
                    <form method="post" action="/reminderservlet">
                        <div id="remind-radio">
                            <input type="radio" id="remind-buy" name="remind" value="remind-buy" checked>
                            <label for="remind-buy">Buy</label>
                            <input type="radio" id="remind-sell" name="remind" value="remind-sell">
                            <label for="remind-sell">Sell</label>
                        </div>
                        <label for="stock-amount">Stock Amount</label>
                        <input type="number" name="stock-amount" id="stock-amount" min="0" value="0.0"><br>
                        <label for="stock-price">Stock Price</label>
                        <input type="number" name="stock-price" id="stock-price" min="0" value="0">
                        <button type="submit">Submit</button>
                    </form>

                    <div>
                        <p>Notifications</p>
                        <p id="notifs"></p>
                    </div>

                    <div id="price-input">
                        <p>Input Price</p>
                        <form method="post" action="/updatestockservlet">
                            <label for="new-stock-price">Stock Price</label>
                            <input type="number" name="new-stock-price" min="0" value="0.0" id="new-stock-price"><br>
                            <label for="new-stock-date">Date (DD-Month-YY)</label>
                            <input type="text" name="new-stock-date" id="new-stock-date">
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script>
    let shouldBuy = `${shouldBuy}`;
    let shouldSell = `${shouldSell}`;

    if (shouldBuy == "true") {
        document.getElementById('notifs').innerHTML += "<p>You Should Have Bought!</p>"
    }

    if (shouldSell == "true") {
        document.getElementById('notifs').innerHTML += "<p>You Should Have Sold!</p>"
    }
</script>
</body>
</html>
