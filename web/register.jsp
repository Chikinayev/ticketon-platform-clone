<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.12.2022
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="registration-styles.css">
</head>
<body>
<div class="container main">
    <form action="/register" method="post">
        <h2 class='title'>Регистрация</h2>

        <input type="text" name="email" placeholder="Email или телефон" class='mt-4'>

        <input type="password" name="password" placeholder="Пароль" class='mt-4'>

        <input type="password" name="password-confirmation" placeholder="Подтверждение пароля" class='mt-4'>

        <input type="text" name="phone" placeholder="Номер телефона(+7)" class='mt-4'>

        <div class='sign-up-link mt-2 ms-1'><a href="" color='#fe7400'>Уже зарегистрированы?</a></div>

        <button type='submit' class='submit mt-3'>
            Зарегистрироваться
        </button>
    </form>
</div>
</body>
</html>
