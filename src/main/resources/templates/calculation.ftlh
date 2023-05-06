<#import "blocks/template.ftlh" as t>
<@t.template>
    <h2>Редактирование расходов</h2>
    <table cellspacing="2" border="1" cellpadding="5">
        <caption>Оплаты</caption>
        <tr><td>Категория</td><td>Сумма</td><td>Важность</td><td>период</td></tr>
        <#list pays as pay>

            <tr><td>${pay.categoryPay} </td><td> ${pay.pay} </td><td> ${pay.vidCategoryPay} </td><td>${pay.timePay}</td></tr>

        <#else>
            <h3>Товаров нет</h3>
        </#list>
        <#--<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>-->
    </table>

    <br>
    <#--<table cellspacing="2" border="1" cellpadding="5">
        <caption>Лимиты</caption>
        <tr><td>Категория</td><td>Важность</td><td>Сумма</td><td>Остаток лимита</td></tr>
        <#list list1 as cat>

            <tr><td>${cat.category}</td><td>${cat.impotance}</td><td>${cat.pay}</td><td>${cat.ostatok}</td></tr>

        <#else>
            <h3>Товаров нет</h3>
        </#list>
        &lt;#&ndash;<tr><td>Одежда</td><td>${otherlimit.clothes}</td></tr>&ndash;&gt;
    </table>-->
    <#--${day.getRent()?replace('$ -','- $')}-->

    <#--<form action="/create" method="post">
        <input type="date" name="day" value="${day.day1}" readonly required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
               placeholder="дата" class="form-control"><br>
        <input type="number" name="food" value="${day.food}" class="form-control">Еда<br>
        <input type="number" name="himiya" value="${day.himiya}" class="form-control">Химия<br>
        <input type="number" name="auto" value="${day.auto}" placeholder="Авто" class="form-control">Авто<br>
        <input type="number" name="child" value="${day.child}" placeholder="Ребенок" class="form-control">Ребенок<br>
        <input type="text" name="apteka" value="${day.apteka}" placeholder="Аптека" class="form-control">Аптека<br>
        <input type="number" name="communal" value="${day.communal}" placeholder="Комуналка" class="form-control">Комуналка<br>
        <input type="number" name="nalogy" value="${day.nalogy}" placeholder="Налоги" class="form-control">Налоги<br>
        <input type="number" name="rent" value="${day.rent}" placeholder="Рента" class="form-control">Рента<br>
        <input type="number" name="clothes" value="${day.clothes}" placeholder="Одежда" class="form-control">Одежда<br>
        <input type="number" name="cosmetics" value="${day.cosmetics}" placeholder="Косметика" class="form-control">Косметика<br>
        <input type="number" name="present" value="${day.present}" placeholder="Подарки" class="form-control">Подарки<br>
        <input type="number" name="shopping" value="${day.shopping}" placeholder="Покупки" class="form-control">Покупки<br>
        <input type="number" name="hobie" value="${day.hobie}" placeholder="Хобби" class="form-control">Хобби<br>
        <input type="number" name="home" value="${day.home}" placeholder="Дом" class="form-control">Дом<br>
        <input type="number" name="rest" value="${day.rest}" placeholder="Отдых" class="form-control">Отдых<br>
        <input type="number" name="treatment" value="${day.treatment}" placeholder="Лечение" class="form-control">Лечение<br>
        <input type="number" name="travel" value="${day.travel}" placeholder="Путешествия" class="form-control">Путешествия<br>
        <input type="number" name="donations" value="${day.donations}" placeholder="donations" class="form-control">donations<br>

        <button type="submit"  class="btn btn-success">Добавить статью</button>

    </form>-->
<form action="/" method="get">
    <button type="submit"  class="btn btn-success">На главную</button>
</form>

</@t.template>