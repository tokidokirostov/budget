<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>Редактирование расходов</h2>
    <table cellspacing="2" border="1" cellpadding="5">
        <caption>Оплаты</caption>
        <tr>
            <td>Категория</td>
            <td>Сумма</td>
            <td>Важность</td>
            <td>период</td>
        </tr>
        <#list pays as pay>
            <tr>
                <td>${pay.categoryPay} </td>
                <td> ${pay.pay} </td>
                <td> ${pay.vidCategoryPay} </td>
                <td>${pay.timePay}</td>
            </tr>
        <#else>
            <h3>Товаров нет</h3>
        </#list>
    </table>
    <br>

    <form action="/" method="get">
        <button type="submit" class="btn btn-success">На главную</button>
    </form>

</@t.template>