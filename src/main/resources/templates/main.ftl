<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <form method="post">
        <input type="text" name="name" placeholder="Name of pet" />
        <input type="text" name="kind" placeholder="Kind">
        <input type="text" name="breed" placeholder="Breed">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</div>
<#list pets as pet>
<div>
    <div><h4> Pet № ${pet.id}</h4></div>
    <div>Name: <span>${pet.name}</span></div>
    <div>Kind: <span>${pet.kind}</span></div>
    <div>Breed: <span>${pet.breed}</span></div>
    <div><td><a href="/pet/${pet.id}">View pet profile</a></td></div>
</div>
<#else>
No pets
</#list>
</@c.page>
