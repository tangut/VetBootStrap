<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<form method="get" action="/petList">
    <input type="text" name="filter" value="${filter!""}">
    <button type="submit" class="btn btn-primary">Find by number</button>
</form>
<div class="card-columns">
<#list pets as pet>
<div class="card my-3">
     <div class="m-2">
    <h4> Pet № ${pet.id}</h4>
    <br><span>Name: ${pet.name}</span>
    <br><span>Kind: ${pet.kind}</span>
    <br><span>Breed: ${pet.breed}</span>
    <br><strong> Master: ${pet.masterName}</strong>
    <br><td><a href="/pet/${pet.id}">View pet profile</a></td>
    </div>
</div>
<#else>
No pets
</#list>
</div>
</@c.page>
