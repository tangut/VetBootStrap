<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <form method="post">
        <input type="text" name="name" placeholder="Кличка животного" />
        <input type="text" name="kind" placeholder="Вид">
        <input type="text" name="breed" placeholder="Порода">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Добавить</button>
    </form>
</div>
<div>Список животных</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter!""}">
    <button type="submit" class="btn btn-primary">Найти</button>
</form>
<#list pets as pet>
<div>
    <span>${pet.name}</span>
    <span>${pet.kind}</span>
    <span>${pet.breed}</span>
    <strong>${pet.masterName}</strong>
</div>
<#else>
No pets
</#list>
</@c.page>
