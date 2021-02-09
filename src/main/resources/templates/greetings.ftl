<#import "parts/common.ftl" as c>
<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>
<@c.page>
<#if known>
<#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
    >
<h5>Hello, ${name}!</h5>
<h5>Thank you for using our web application! Have a nice day!</h5>
<#else>
<h5>Hello, guest!</h5>
<h5>This is a veterinary web application.</h5>
</#if>
</@c.page>
