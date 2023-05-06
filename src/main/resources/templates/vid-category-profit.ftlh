<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>Вид категории дохода</h2>

    <div class="col-2">
        <form action="/profit/category/vid" method="post">
            <input type="text" name="vidCategoryProfit" value="" class="form-control">Вид Категории<br>
            <#--<input type="text" name="impotance" value="" class="form-control">Важность<br>-->
            <button type="submit" class="btn btn-success">Добавить вид категории</button>
        </form>
        <br>
        <br>
        <br>
        <br>
        <#--<form action="/profit/category/vid/delete" method="post">
            <select name="idVidCategoryPay" id="selectID">
                <#list vidCategoriesProfit as cat>
                    <option value=${cat.id}>${cat.vidCategoryProfit}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <button type="submit">Удалить</button>
        </form>-->
    </div>



    <div class="col-3">
        <table cellspacing="2" border="1" cellpadding="5" align="center">
            <caption>Вид категории</caption>
            <#list vidCategoriesProfit as cat>
                <tr>
                    <td>${cat.vidCategoryProfit} </td>
                    <td>
                        <form action="/profit/category/vid/${cat.id}" method="post">
                            <input type="text" name="vidCategoryProfit" value=""  class="form-control">
                            <input type="submit" value="Изменить" onclick="return confirm('Вы уверены, что хотите изменить?')">
                        </form>

                    </td>
                </tr>
            <#else>
                <h3>Товаров нет</h3>
            </#list>
        </table>
    </div>

</@t.template>
