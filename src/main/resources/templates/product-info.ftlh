<!DOCTYPE html>
<html lang="en">
<head>
    <title>BUY SELL</title>
</head>
<body>
<h1>BUY SELL</h1>
<h4>More information about product : </h4>
<b>Title of product : </b>${product.title}<br>
<b>Title of product : </b>${product.title}<br>
<hr>
<h3>
    Create new product
</h3>
<form action="/product/create" method="post">
    Навзвание обявления: <label>
        <input type="text" name="title"/>
    </label><br><br>
    Описание обявления: <label>
        <input type="text" name="description"/>
    </label><br><br>
    Цена товара : <label>
        <input type="number" name="price"/>
    </label><br><br>
    City : <label>
        <input type="text" name="city"/>
    </label><br><br>
    Author : <label>
        <input type="text" name="author"/>
    </label><br><br>
    <input type="submit" value=" add "/>
</form>
</body>
</html>