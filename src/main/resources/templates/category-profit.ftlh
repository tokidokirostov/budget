<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>Категории дохода</h2>

    <div class="col-2">
        <form action="/profit/category" method="post">
            <input type="text" name="categoryProfit" value="" class="form-control">Категоря<br>
            <select name="vidCategoryProfitId" id="selectID">
                <#list vidCategoryProfit as list>
                    <option value=${list.id}>${list.vidCategoryProfit}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>

            <button type="submit" class="btn btn-success">Добавить категорию</button>
        </form>
        <br>
    </div>

    <div class="col-3">
        <table cellspacing="2" border="1" cellpadding="5" align="center">
            <tr>
                <td>Категория</td>
                <td>Изменить категорию дохода</td>
                <td>Вид категории</td>
            </tr>
            <#list categoryProfit as list>
                <tr>
                    <td>${list.categoryProfit} </td>
                    <td>
                        <form action="/profit/category/edit" method="post">
                            <input type="number" name="id" value="${list.id}" hidden>
                            <input type="text" name="categoryProfit" value="" class="form-control">
                            <input type="submit" value="Изменить"
                                   onclick="return confirm('Вы уверены, что хотите изменить?')">
                        </form>
                    </td>
                    <td>${list.vidCategoryProfit.vidCategoryProfit}</td>
                </tr>
            <#else>
                <h3>Категорий нет</h3>
            </#list>
        </table>
    </div>

</@t.template>
