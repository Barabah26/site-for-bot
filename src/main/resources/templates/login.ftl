<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Авторизація</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="login-container">
    <h2>Увійти до свого облікового запису</h2>
    <p class="error-message">${errorMessage}</p>
    <form method="post">
        <div class="input-group">
            <label for="username">Ім'я користувача:</label>
            <input type="text" id="login" name="login" required>
        </div>
        <div class="input-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Увійти</button>
    </form>
</div>
</body>
</html>
