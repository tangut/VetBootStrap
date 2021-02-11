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
<div class="card-columns">
<#list pets as pet>
<div class="card my-3">
     <div class="m-2">
    <h4> Pet № ${pet.id}</h4>
    <br><span>Name: ${pet.name}</span>
    <br><span>Kind: ${pet.kind}</span>
    <br><span>Breed: ${pet.breed}</span>
    <br><td><a href="/pet/${pet.id}">View pet profile</a></td>
    </div>
</div>
<#else>
No pets
</#list>
</div>
</@c.page>
