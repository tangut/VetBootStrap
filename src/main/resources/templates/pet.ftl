<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">

<@c.page>
<h4>Profile of pet</h4>
<#list pets as pet>
<div>
    <div><h4> Pet № ${pet.id}</h4></div>
    <div>Name: <span>${pet.name}</span></div>
    <div>Kind: <span>${pet.kind}</span></div>
    <div>Breed: <span>${pet.breed}</span></div>
    <div>Master: <strong>${pet.masterName}</strong><div>
    <h4>Diagnose of pet</h4>
    <#list diagnoses as dia>
    <div>
       <div>Name: <span>${dia.name}</span></div>
       <div>Simptom: <span>${dia.simptome}</span></div>
       <div>Medicine: <span>${dia.medicine}</span></div>
       <#if isAdmin>
        <a class="btn btn-primary" href="/pet/${pet.id}/diagnose/${dia.id}" role="button">Change diagnose</a>
        </#if>
    </div>
    <#else>
    <div><h7>No diagnose</h7></div>
    <#if isAdmin>
    <div><a class="btn btn-primary" href="/pet/${pet.id}/diagnose" role="button">Change diagnose</a></div>
    </#if>
    </#list>
</div>
<#else>
No pets
</#list>
</@c.page>