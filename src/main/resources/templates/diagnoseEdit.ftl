<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">


<@c.page>
<#list pets as pet>
<#list diagnoses as dia>
<div class="card my-3" align = "center">
   <h4>Diagnose of pet № ${pet.id}</h4>
    <div class="m-2">
       <br>Name: <span>${dia.name}</span>
       <br>Simptom: <span>${dia.simptome}</span>
       <br>Medicine: <span>${dia.medicine}</span>
     </div>
</div>
 </#list>
 </#list>
 <div>
 <form method="post">
 <p>
  <textarea name="name" id="name" placeholder="Name of sickness" maxlength="400" cols="30" rows="1"></textarea>
 </p>
 <p>
 <textarea name="simptom" id="simptom" placeholder="Simptom" maxlength="400" cols="30" rows="9"></textarea>
 </p>
 <p>
 <textarea name="medicine" id="name" placeholder="Medicine" maxlength="400" cols="30" rows="9"></textarea>
 </p>
 <div><input type="hidden" name="_csrf" value="${_csrf.token}" />
 <button type="submit" class="btn btn-primary">Change diagnose</button></div>
 </form>
 </div>
 </@c.page>