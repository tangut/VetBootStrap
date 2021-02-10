<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<form method="get" action="/petList">
    <input type="text" name="filter" value="${filter!""}">
    <button type="submit" class="btn btn-primary">Find by number</button>
</form>
<#list pets as pet>
<div>
    <div><h4> Pet № ${pet.id}</h4></div>
    <div>Name: <span>${pet.name}</span></div>
    <div>Kind: <span>${pet.kind}</span></div>
    <div>Breed: <span>${pet.breed}</span></div>
    <div>Master: <strong>${pet.masterName}</strong><div>
    <div><td><a href="/pet/${pet.id}">View pet profile</a></td></div>
</div>
<#else>
No pets
</#list>
</@c.page>
