<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>По месяцам</h2>
    <div class="col-2">
        <form action="/months" method="get">
            Поиск по году:
            <br>
            <input type="number" name="year" min="1900" max="2099" step="1"/><br>
            <input type="submit" value="Поиск"/>
        </form>
        <br>
        <table cellspacing="2" border="1" cellpadding="5">
            <caption>Оплаты за текущий день</caption>
            <tr>
                <td>Категория</td>
                <td>Январь</td>
                <td>Февраль</td>
                <td>Март</td>
                <td>Апрель</td>
                <td>Май</td>
                <td>Июнь</td>
                <td>Июль</td>
                <td>Август</td>
                <td>Сентябрь</td>
                <td>Октябрь</td>
                <td>Ноябрь</td>
                <td>Декабрь</td>
                <td>Итого</td>
            </tr>
            <#list calcs as calc>

                <tr>
                    <td>${calc.categoryPay} </td>
                    <td> ${calc.yan} </td>
                    <td> ${calc.fev} </td>
                    <td>${calc.mart}</td>
                    <td>${calc.apr}</td>
                    <td>${calc.may}</td>
                    <td>${calc.yun}</td>
                    <td>${calc.yul}</td>
                    <td>${calc.avgu}</td>
                    <td>${calc.sept}</td>
                    <td>${calc.oct}</td>
                    <td>${calc.nov}</td>
                    <td>${calc.decb}</td>
                    <td>${calc.totall}</td>
                </tr>


            <#else>
                <h3>Товаров нет</h3>
            </#list>
            <#--<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>-->
            <tr>
                <td>Итого</td>
                <td>${yan}</td>
                <td>${fev}</td>
                <td>${mart}</td>
                <td>${apr}</td>
                <td>${may}</td>
                <td>${yun}</td>
                <td>${yul}</td>
                <td>${avgu}</td>
                <td>${sept}</td>
                <td>${oct}</td>
                <td>${nov}</td>
                <td>${decb}</td>
                <#--<td>${apr}</td>-->
            </tr>
        </table>

    </div>
    <div class="col-3">


    </div>
</@t.template>