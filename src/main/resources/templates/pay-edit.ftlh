<#import "blocks/template.ftlh" as t>
<@t.template>
    <div>
        <form action="/pay/edit" method="post">
            <input type="hidden" name="id" readonly value=${pay.id}> <br>
            <input type="number" name="pay" class="form-control">Платеж<br>
            <input type="date" name="timePay" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control" value=${pay.timePay}><br>
            <select name="categoryId" id="selectID">
                <#list category as cat>
                    <#if cat.categoryPay==(pay.categoryPay)>
                        <option selected value=${cat.id}>Категория ${cat.categoryPay}</option>
                    <#else >
                        <option value=${cat.id}>Категория ${cat.categoryPay}</option>
                    </#if>
                <#else>
                    <h3>Категорий нет</h3>
                </#list>
            </select>
            <br>
            <button type="submit">Добавить</button>
        </form>
    </div>
</@t.template>