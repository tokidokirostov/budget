<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>Добавление дохода</h2>
    <div class="col-2">

        <form action="/profit" method="post">
            <input type="number" name="profit" class="form-control">Платеж<br>
            <input type="date" name="timeProfit" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <select name="categoryProfitId" id="selectID">
                <#list category as cat>
                    <option value=${cat.id}>${cat.categoryProfit} ${cat.vidCategoryProfit.vidCategoryProfit}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <br>
            <button type="submit">Добавить</button>
        </form>
        <br><br>
        <form action="/profit" method="get">
            Поиск по дате:
            <br>
            <input type="date" name="day1" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <input type="date" name="day2" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <select name="categoryProfit" id="selectID">
                <option value="">Все категории</option>
                <#list listCategories as cat>
                    <option value=${cat}>${cat}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <br>
            <select name="vidCategoryProfit" id="selectID">
                <option value="">Все виды категорий</option>
                <#list vidCategoryProfit as cat>
                    <option value=${cat}>${cat}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <input type="submit" value="Поиск"/>
        </form>
    </div>

    <div class="col-3">
        <table cellspacing="2" border="1" cellpadding="5" align="center">
            <caption>Лимиты</caption>
            <tr>
                <td>Категория</td>
                <td>Сумма</td>
                <td>Важность</td>
                <td>период</td>
                <td></td>
            </tr>
            <#list profits as profit>
                <tr>
                    <td>${profit.categoryProfit} </td>
                    <td> ${profit.profit} </td>
                    <td> ${profit.vidCategoryProfit} </td>
                    <td>${profit.timeProfit}</td>
                    <td>
                        <form action="/profit/delete?profitId=${profit.id}" method="post">
                            <button type="submit" onclick="return confirm('Вы уверены, что хотите удалить?')">Удалить
                            </button>
                        </form>
                    </td>
                </tr>
            <#else>
                <h3>Товаров нет</h3>
            </#list>
            <tr>
                <td>Итого</td>
                <td>${total}</td>
            </tr>
        </table>
        <br><br>
    </div>

</@t.template>