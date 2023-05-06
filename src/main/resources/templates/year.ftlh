<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>За год</h2>
    <div class="col-2">
        <form action="/year" method="get">
            Поиск по году:
            <br>
            <input type="number" name="year" min="1900" max="2099" step="1"/><br>
            <input type="submit" value="Поиск"/>
        </form>
        <table cellspacing="2" border="1" cellpadding="5">
            <caption>Оплаты за текущий день</caption>
            <tr>
                <td>Месяц</td>
                <td>Основные</td>
                <td>Дополнительные</td>
                <td>Непредвиденные</td>
                <td>Итого</td>
                <td>Доход</td>

            </tr>
            <#list totalls as totall>

                <tr>
                    <td>${totall.month}</td>
                    <td> ${totall.main} </td>
                    <td> ${totall.other} </td>
                    <td> ${totall.notMain} </td>
                    <td>${totall.totall}</td>
                    <td>${totall.profit}</td>

                </tr>

            <#else>
                <h3>Товаров нет</h3>
            </#list>
        </table>

    </div>

    <div class="col-3">
    </div>
</@t.template>