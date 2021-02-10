<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">


<@c.page>
<#list pets as pet>
<#list diagnoses as dia>
   <h4>Diagnose of pet № ${pet.id}</h4>
    <div>
       <div>Name: <span>${dia.name}</span></div>
       <div>Simptom: <span>${dia.simptome}</span></div>
       <div>Medicine: <span>${dia.medicine}</span></div>
     </div>
 </#list>
 </#list>
 <div>
     <form method="post">
         <div><input type="text" name="name" placeholder="Name of sickness" /></div>
         <div><input type="text" name="simptom" placeholder="Simptom"></div>
         <div><input type="text" name="medicine" placeholder="Medicine"></div>
         <div><input type="hidden" name="_csrf" value="${_csrf.token}" />
         <button type="submit" class="btn btn-primary">Change diagnose</button></div>
     </form>
 </div>
 </@c.page>