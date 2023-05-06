<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>Категории оплаты платежа</h2>

        <div class="col-2">
            <form action="/pay/category" method="post">
                <input type="text" name="category" value="" class="form-control">Категоря<br>
                <#--<input type="text" name="impotance" value="" class="form-control">Важность<br>-->
                <select name="idVidCategoryPay" id="selectID">
                    <#list vidCategoryPayList as list>
                        <option value=${list.id}>${list.vidCategoryPay}</option>
                    <#else>
                        <h3>Товаров нет</h3>
                    </#list>
                </select>

                <button type="submit" class="btn btn-success">Добавить категорию</button>
            </form>
            <#--<br>
            <form action="/category/delete" method="post">
                <select name="category" id="selectID">
                    <#list categoryPayList as list>
                        <option value=${list.id}>${list.vidCategoryPay}</option>
                    <#else>
                        <h3>Товаров нет</h3>
                    </#list>
                </select>
                <button type="submit">Удалить</button>
            </form>-->
        </div>



        <div class="col-3">
            <table cellspacing="2" border="1" cellpadding="5" align="center">
                <caption>Лимиты</caption>
                <tr>
                    <td>Категория</td>
                    <td>Важность</td>
                </tr>
                <#list categoryPayList as list>
                    <tr>
                        <td>${list.categoryPay} </td>
                        <td>${list.vidCategoryPay.vidCategoryPay}</td>
                        <td>
                         <form action="/pay/category/${list.id}" method="post">
                             <#--<
                             <input type="number" name="id" value=${list.id}>-->
                             <#--<input type="text" name="category" id=list.id value="" class="form-control"/>-->

                             <input type="text" name="category"
                                    <#--id=${list.id} -->
                                    value=""  class="form-control">
                            <#-- ${list.id}-->
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
