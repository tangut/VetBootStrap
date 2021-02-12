<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new pet
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name of pet" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="kind" placeholder="Kind">
                </div>
                <div class="form-group">
                     <input type="text" class="form-control" name="breed" placeholder="Breed">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>

<div class="card-columns">
    <#list pets as pet>
    <div class="card my-3">
     <h4> Pet № ${pet.id}</h4>
        <#if pet.filename??>
        <img src="/img/${pet.filename}" width="250" height="250">
        </#if>
        <div class="m-2">
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
