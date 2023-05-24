<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html" lang="ru">

<head>
    <title>Sellers and Buyers.</title>
</head>

<body>
<h1>Sellers and Buyers</h1>
<hr>
<h4>Подробная информация о товаре</h4>
<b>Название: </b> ${product.title}<br>
<b>Описание: </b> ${product.description}<br>
<b>Цена: </b> ${product.price}<br>
<b>Город: </b> ${product.city}<br>
<b>Автор: </b> ${product.author}<br>

<hr>

<h3>Удалить товар</h3>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить объявление"/>
</form>

</body>

</html>
