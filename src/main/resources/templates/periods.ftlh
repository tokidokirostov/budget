<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2 align="center">Период лимита</h2>

    <div class="col-2">
        <form action="/pay/period" method="post">
            <input type="text" name="periodPay" value="" class="form-control">Период
            <br>
            <button type="submit" class="btn btn-success">Добавить период</button>
        </form>
        <br><br>
    </div>

    <div class="col-3">
        <form action="/pay/period/delete" method="post">
            <select name="period1" id="selectID">
                <#list list as cat>
                    <option value=${cat.id}>${cat.periodPay}</option>
                <#else>
                    <h3>Товаров нет</h3>
                </#list>
            </select>
            <button type="submit">Удалить</button>
        </form>

        <table cellspacing="2" border="1" cellpadding="5" align="center">
            <caption>Периоды</caption>
            <#list list as cat>
                <tr>
                    <#--<td>Период</td>-->
                    <td>${cat.periodPay}</td>
                    <td><a href="/pay/period/delete/${cat.id}" methods="put">/period/delete/${cat.id}</a> </td>
                    <td>
                        <form action="/pay/period/delete?period1=${cat.id}" method="post">
                            <button type="submit">Удалить</button>
                        </form>
                    </td>
                </tr>
            <#else>
                <h3>Товаров нет</h3>
            </#list>
        </table>
    </div>
</@t.template>