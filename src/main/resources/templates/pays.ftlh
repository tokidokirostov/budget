<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>Добавление основного платежа</h2>
    <div class="col-2">

        <form action="/pay" method="post">
            <input type="number" name="pay" class="form-control">Платеж<br>
            <input type="date" name="timePay" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <select name="categoryId" id="selectID">
                <#list category as cat>
                    <option value=${cat.id}>Категория лимита ${cat.categoryPay}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <br>
            <button type="submit">Добавить</button>
        </form>
        <br><br>
        <form action="/pay" method="get">
            Поиск по дате:
            <br>
            <input type="date" name="day1" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <input type="date" name="day2" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control"><br>
            <select name="categoryPay" id="selectID">
                <option value="">Все категории</option>
                <#list listCategories as cat>
                    <option value=${cat}>${cat}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <br>
            <select name="vidCategoryPay" id="selectID">
                <option value="">Все виды категорий</option>
                <#list vidCategoryPay as cat>
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
            <#list pays as pay>

                <tr>
                    <td>${pay.categoryPay} </td>
                    <td> ${pay.pay} </td>
                    <td> ${pay.vidCategoryPay} </td>
                    <td>${pay.timePay}</td>
                    <td>
                        <form action="/pay/${pay.id}" method="get">
                            <button type="submit">редактировать</button>
                        </form>
                    </td>
                    <td>
                        <form action="/pay/delete?payId=${pay.id}" method="post">
                            <button type="submit" onclick="return confirm('Вы уверены, что хотите удалить?')">Удалить
                            </button>
                        </form>
                    </td>
                </tr>

            <#else>
                <h3>Покупок нет</h3>
            </#list>
            <tr>
                <td>Итого</td>
                <td>${totallPay}</td>
            </tr>
        </table>
        <br><br>
    </div>

</@t.template>