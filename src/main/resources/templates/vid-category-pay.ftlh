<#import "blocks/template.ftlh" as t>
<@t.template>
    <#--<script type="text/javascript">
        function destroy()
        {
            if (confirm("Bы уверены, что хотите уничтожить эту страницу?"))
                return true;
            else return false;
        }
    </script>-->
    <h2>Вид категории оплаты платежа</h2>

    <div class="col-2">
        <form action="/pay/category/vid" method="post">
            <input type="text" name="vidCategoryPay" value="" class="form-control">Вид Категории<br>
            <#--<input type="text" name="impotance" value="" class="form-control">Важность<br>-->
            <button type="submit" class="btn btn-success">Добавить вид категории</button>
        </form>
        <br>
        <br>
        <br>
        <br>

        <#--<form action="/pay/category/vid/delete" method="post">
            <select name="idVidCategoryPay" id="selectID">
                <option value="">All</option>
                <#list list as cat>
                    <option value=${cat.id}>${cat.vidCategoryPay}</option>
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
            <#--<tr>
                <td>Категория</td>
                &lt;#&ndash;<td>Важность</td>&ndash;&gt;
            </tr>-->
            <#list list as cat>
                <tr>
                    <td>${cat.vidCategoryPay} </td>
                    <td>
                        <form action="/pay/category/vid/${cat.id}" method="post">
                            <#--<
                            <input type="number" name="id" value=${list.id}>-->
                            <#--<input type="text" name="category" id=list.id value="" class="form-control"/>-->

                            <input type="text" name="vidCategoryPay"
                                    <#--id=${list.id} -->
                                   value=""  class="form-control">
                            <#-- ${list.id}-->
                            <input type="submit" value="Изменить" onclick="return confirm('Вы уверены, что хотите изменить?')" >
                        </form>

                    </td>
                    <#--<td>${cat.impotance}</td>-->
                </tr>
            <#else>
                <h3>Товаров нет</h3>
            </#list>
        </table>
    </div>

</@t.template>
