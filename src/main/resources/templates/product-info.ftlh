<!DOCTYPE html>
<html lang="en">
<head>
    <title>BUY SELL</title>
</head>
<body>
<h1>BUY SELL</h1>
<h4>More information about product : </h4>

<img src="images/${product.images.get(0)!}" height="60px" alt=""/><br><br>
<img src="images/${product.images.get(1)!}" height="60px" alt=""/><br><br>
<img src="images/${product.images.get(2)!}" height="60px" alt=""/><br><br>

<b>Title of product : </b>${product.title}<br>
<b>Description of product : </b>${product.description}<br>
<b>Perice : </b>${product.price}<br>
<b>City : </b>${product.city}<br>
<b>Author : </b>${product.author}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value=" delete product "/>
</form>
</body>
</html>