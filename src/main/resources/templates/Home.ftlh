<#import "blocks/template.ftlh" as t>
<@t.template>
    <#--<meta charset="utf-8">
    <title>Название документа</title>-->
    <#--<style>
        #zatemnenie {
            background: rgba(102, 102, 102, 0.5);
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            display: none;
        }
        #okno {
            width: 300px;
            height: 50px;
            text-align: center;
            padding: 15px;
            border: 3px solid #0000cc;
            border-radius: 10px;
            color: #0000cc;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            background: #fff;
        }
        #zatemnenie:target {display: block;}
        .close {
            display: inline-block;
            border: 1px solid #0000cc;
            color: #0000cc;
            padding: 0 12px;
            margin: 10px;
            text-decoration: none;
            background: #f2f2f2;
            font-size: 14pt;
            cursor:pointer;
        }
        .close:hover {background: #e6e6ff;}
    </style>
    <div id="zatemnenie">
        <div id="okno">
            &lt;#&ndash;Всплывающее окошко!<br>&ndash;&gt;
            <form action="/year" method="get">
                Поиск по году:
                <br>
                <input type="number" name="year" min="1900" max="2099" step="1"/><br>
                <input type="submit" value="Поиск"/>
            </form>

            &lt;#&ndash;<a href="#" class="close">Закрыть окно</a>&ndash;&gt;
        </div>
    </div>

    <a href="#zatemnenie">Вызвать всплывающее окно</a>


    ------------------------------------------------------
    <br>
    Hello!!! <br>-->
<h1><p align="center" > Добро пожаловать в семейный бюджет </p></h4>
    <#--<div class="col-2">
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
        &lt;#&ndash;${day.id}&ndash;&gt;
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
            &lt;#&ndash;<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>&ndash;&gt;
        </table>
<br><br>
        &lt;#&ndash;<table cellspacing="2" border="1" cellpadding="5">
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
        </table>&ndash;&gt;

    </div>-->
<#--<div class="col-3"></div>
</div>-->
</@t.template>
