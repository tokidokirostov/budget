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
                    <td> ${calc.january} </td>
                    <td> ${calc.february} </td>
                    <td>${calc.march}</td>
                    <td>${calc.april}</td>
                    <td>${calc.may}</td>
                    <td>${calc.june}</td>
                    <td>${calc.july}</td>
                    <td>${calc.august}</td>
                    <td>${calc.september}</td>
                    <td>${calc.october}</td>
                    <td>${calc.november}</td>
                    <td>${calc.december}</td>
                    <td>${calc.totall}</td>
                </tr>
            <#else>
                <h3>Товаров нет</h3>
            </#list>
            <tr>
                <td>Итого</td>
                <td>${months["JANUARY"]}</td>
                <td>${months["FEBRUARY"]}</td>
                <td>${months["MARCH"]}</td>
                <td>${months["APRIL"]}</td>
                <td>${months["MAY"]}</td>
                <td>${months["JUNE"]}</td>
                <td>${months["JULY"]}</td>
                <td>${months["AUGUST"]}</td>
                <td>${months["SEPTEMBER"]}</td>
                <td>${months["OCTOBER"]}</td>
                <td>${months["NOVEMBER"]}</td>
                <td>${months["DECEMBER"]}</td>
            </tr>
        </table>
    </div>
    <div class="col-3">

    </div>
</@t.template>