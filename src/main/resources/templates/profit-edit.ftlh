<#import "blocks/template.ftlh" as t>
<@t.template>
    <div>
        <form action="/profit/edit" method="post">
            <input type="hidden" name="id" readonly value=${profit.id}> <br>
            <input type="number" name="profit" class="form-control">Доход<br>
            <input type="date" name="timeProfit" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
                   placeholder="дата" class="form-control" value=${profit.timeProfit}><br>
            <select name="categoryProfitId" id="selectID">
                <#list category as cat>
                    <#if (cat.categoryProfit==(profit.categoryProfit)) && (cat.vidCategoryProfit.vidCategoryProfit==(profit.vidCategoryProfit))>
                        <option selected
                                value=${cat.id}>${cat.categoryProfit} ${cat.vidCategoryProfit.vidCategoryProfit}</option>
                    <#else >
                        <option value=${cat.id}>${cat.categoryProfit} ${cat.vidCategoryProfit.vidCategoryProfit}</option>
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