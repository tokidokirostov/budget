<#import "blocks/template.ftlh" as t>
<@t.template>
    Hello!!!
    <div class="col-2">
        <form action="/date/" method="get">
            Поиск по дате:
            <br>
            <input type="date" name="day" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <input type="submit" value="Поиск"/>
        </form>
        <br>
        <form action="/date/" method="get">
            Поиск по дате:
            <br>
            <input type="number" min="2000" max="9999" name="day" required pattern="[0-9]{4}"
                   placeholder="дата" class="form-control"><br>
            <input type="submit" value="Поиск"/>
        </form>
        <br>
        <#--${day.id}-->
        <form action="/calculation" method="get">
            Поиск по дате:
            <br>
            <input type="date" name="day1" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <input type="date" name="day2" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <input type="submit" value="Поиск"/>
        </form>
    </div>
    <div class="col-3">
        <table cellspacing="2" border="1" cellpadding="5">
            <caption>Оплаты за текущий день</caption>
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
            <#--<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>-->
        </table>
<br><br>
        <#--<table cellspacing="2" border="1" cellpadding="5">
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
                    <td>${calc.yan + calc.fev + calc.mart}</td>
                </tr>

            <#else>
                <h3>Товаров нет</h3>
            </#list>
            &lt;#&ndash;<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>&ndash;&gt;
        </table>-->

    </div>
<#--<div class="col-3"></div>
</div>-->
</@t.template>
