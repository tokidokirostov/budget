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


            <#--<select name="impotId" id="selectID">
                <#list impot as cat>
                    <option value=${cat.id}>Важность лимита ${cat.impot}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>-->
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

        <#--<div>
            <h2>Добавление дополнительного платежа</h2>
            <form action="/pay" method="post"> Еда

                <input type="number" name="pay" placeholder="Лимит" class="form-control"><br>
                <input type="date" name="time_pay" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                       placeholder="дата" class="form-control"><br>
                <br>
                <button type="submit"  class="btn btn-success">Добавить статью</button>
            </form>
        </div>-->
        <#-- <#list list as cat>
             <div>
                 Платеж на ${cat.pay} = ${cat.timePay}
             </div>
         <#else>
             <h3>Товаров нет</h3>
         </#list>
        <br><br>-->
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
                        <form action="/pay/delete?payId=${pay.id}" method="post">
                            <button type="submit" onclick="return confirm('Вы уверены, что хотите удалить?')">Удалить</button>
                        </form>
                    </td>
                </tr>

            <#else>
                <h3>Товаров нет</h3>
            </#list>
            <#--<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>-->
            <tr>
                <td>Итого</td>
                <td>${totallPay}</td>
            </tr>
        </table>
        <br><br>

    </div>


</@t.template>