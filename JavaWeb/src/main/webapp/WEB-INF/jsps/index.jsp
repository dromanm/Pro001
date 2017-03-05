<%--
  Created by IntelliJ IDEA.
  User: nucleos
  Date: 04.03.17
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <script>
        function checkAuthFields() {
            var login = document.getElementById("login");
            var pass = document.getElementById("password");

            var error = document.getElementById("error");

            if (login.value == '') {
                error.innerHTML = "Ошибка! Не заполнено поле логин!";
                return false;
            }

            if (pass.value == '') {
                error.innerHTML = "Ошибка! Не заполнено поле пароль!";
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <div>
        <fieldset>
            <legend>Авторизация</legend>
            <span id="error" style="color: #ff0000"></span>
            <form action="/auth" method="post" onsubmit="return checkAuthFields()">
                <p>Логин  :</p><input type="text" id="login"/><br>
                <p>Пароль :</p><input type="password" id="password"/><br>
                <input type="submit" onclick="checkAuthFields()">
            </form>
        </fieldset>
    </div>
</body>
</html>
