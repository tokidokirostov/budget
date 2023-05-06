<#import "blocks/template.ftlh" as t>
<@t.template>
    <div class="col-2">
        <h2>Добавление основного лимита</h2>

        <form action="/limit" method="post">
            <input type="number" name="limitPay" class="form-control">Сумма<br>
            <select name="categoryPayId" id="selectID">
                <#list category as cat>
                    <option value=${cat.id}>Категория лимита ${cat.categoryPay}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <br>

            <select name="periodPayId" id="selectID">
                <#list period as cat>
                    <option value=${cat.id}>Период лемита ${cat.periodPay}</option>
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
    </div>
    <div class="col-3">
        <table cellspacing="2" border="1" cellpadding="5" align="center">
            <caption>Лимиты</caption>
            <tr>
                <td>Категория</td>
                <td>Сумма</td>
                <td>Важность</td>
                <td>период</td>
            </tr>
            <#list list as cat>

                <tr>
                    <td>${cat.categoryPay.categoryPay} </td>
                    <td> ${cat.limitPay} </td>
                    <td> ${cat.categoryPay.vidCategoryPay.vidCategoryPay} </td>
                    <td>${cat.periodPay.periodPay}</td>
                </tr>

            <#else>
                <h3>Товаров нет</h3>
            </#list>
            <#--<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>-->
        </table>
    </div>

</@t.template>