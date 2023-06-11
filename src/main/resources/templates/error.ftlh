<#import "blocks/template.ftlh" as t>
<@t.template>

    <div class="col-2">
        <h2>${error}</h2>
        <br>
        <input type="button" onclick="history.back();" value="Назад"/>

    </div>
    <div class="col-3">

    </div>
</@t.template>