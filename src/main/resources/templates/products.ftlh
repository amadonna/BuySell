<!DOCTYPE html>
<html lang="">
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Товары со всей России</h4>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название объявления: <input type="text" name="title" required/><br><br>
    Описание объявления: <input type="text" name="description" required/><br><br>
    Цена: <input type="number" name="price" required/><br><br>
    Город: <input type="text" name="city" required/><br><br>
    Имя: <input type="text" name="author" required/><br><br>
    Первая фотография: <input type="file" name="file1" accept="image/*" required/><br><br>
    Вторая фотография: <input type="file" name="file2" accept="image/*" required/><br><br>
    Третья фотография: <input type="file" name="file3" accept="image/*" required/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>
