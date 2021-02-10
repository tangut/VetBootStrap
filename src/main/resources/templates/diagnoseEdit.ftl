<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">


<@c.page>
<#list pets as pet>
<#list diagnoses as dia>
   <h4>Diagnose of pet № ${pet.id}</h4>
    <div>
       <div>Name: <span>${dia.name}</span></div>
       <div>Simptome: <span>${dia.simptome}</span></div>
       <div>Medicine: <span>${dia.medicine}</span></div>
     </div>
 </#list>
 </#list>
 </@c.page>