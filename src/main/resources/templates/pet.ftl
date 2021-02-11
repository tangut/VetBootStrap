<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">

<@c.page>
<h4>Profile of pet</h4>
<#list pets as pet>
<div class="card my-3" align = "center">
         <div class="m-2">
    <br><h4> Pet № ${pet.id}</h4>
    <br>Name: <span>${pet.name}</span>
    <br>Kind: <span>${pet.kind}</span>
    <br>Breed: <span>${pet.breed}</span>
    <br>Master: <strong>${pet.masterName}</strong>
    <br><h4>Diagnose of pet</h4>
    <#list diagnoses as dia>
    <div>
       <div>Name: <span>${dia.name}</span></div>
       <div>Simptom: <span>${dia.simptome}</span></div>
       <div>Medicine: <span>${dia.medicine}</span></div>
       <#if isAdmin>
        <div><br><a class="btn btn-primary" href="/pet/${pet.id}/diagnose/${dia.id}" role="button">Change diagnose</a></div>
        </#if>
    </div>
    <#else>
    <div><h7>No diagnose</h7></div>
    <#if isAdmin>
    <div><a class="btn btn-primary" href="/pet/${pet.id}/diagnose" role="button">Change diagnose</a></div>
    </#if>
    </div>
    </#list>
</div>
<#else>
No pets
</#list>
</@c.page>