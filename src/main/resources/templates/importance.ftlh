<!--<!DOCTYPE HTML>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Важность</title>
</head>
<body>
<div>
    <h2>Важность</h2>
    <#--${day.getRent()?replace('$ -','- $')}-->
    <#list list as cat>
        <div>
            Важность${cat.impot}
        </div>
    <#else>
        <h3>Товаров нет</h3>
    </#list>
    <br><br>
    <form action="/importance/delete" method="post">
        <select name="id" id="selectID">
            <#list list as cat>

            <#--<div>
                Категория${cat.category}
            </div>-->
                <option value=${cat.id}>${cat.impot}</option>

            <#else>
            <#-- <option value=month>Месяц</option>-->
                <h3>Товаров нет</h3>
            </#list>


        </select>
        <button type="submit">Удалить</button>
    </form>
    <br><br>
    <form action="/importance" method="post"> Еда
        <input type="text" name="impot" value="" class="form-control">Категоря<br>

        <button type="submit"  class="btn btn-success">Добавить категорию</button>

    </form>
    <form action="/" method="get">
        <button  type="submit"  class="btn btn-success">На главную</button>
    </form>

</div>

</body>
</html>-->