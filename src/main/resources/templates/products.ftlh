<!DOCTYPE html>
<html lang="en">
<head>
    <title>BUY SELL</title>
</head>
<body>
<h1>BUY SELL</h1>
<h4>Товары со всей России :</h4>
<form action="/" method="get">
    Search by title: <input type="text" name="title"> <br>
    <input type="submit" value="search"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} $ | <a href="/product/${product.id}"> More...</a> </p>
    </div>
    <#else>
    <h3>No products </h3>
</#list>
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