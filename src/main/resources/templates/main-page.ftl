<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список студентів</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<header class="header">
    <div class="user-info">
        <span>Ласкаво просимо, ${adminIN}!</span>
        <button id="logout-button" onclick="window.location='/logout'">Вихід</button>
    </div>
</header>

<div class="students-container">
    <h2>Список студентів</h2>
    <table class="students-table">
        <thead>
        <tr>
            <th>ПІБ</th>
            <th>Група</th>
            <th>Рік набору</th>
            <th>Номер телефону</th>
            <th>Тип заявки</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <form method="post">
            <#list students as student>
                <tr>
                    <td>${student.pip}</td>
                    <td>${student.group_name!""}</td>
                    <td>${student.year_entry!""}</td>
                    <td>${student.phone_number!""}</td>
                    <td>${student.statement}</td>
                    <td>
                        <!-- Поле для ідентифікатора студента -->
                        <input type="hidden" name="isReady" value="Ready">
                        <button type="submit" name="Ready" value="Ready">Готово</button>
                    </td>
                </tr>
            </#list>
        </form>

        </tbody>
    </table>

</div>

</body>
</html>
