<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Veterinary</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        <#if user??>
            <li class="nav-item">
            <a class="nav-link" href="/">Home</a>
             </li>
             <#else>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            </#if>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/main">Personal pets</a>
            </li>
            </#if>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            </#if>
            <#if isAdmin>
             <li class="nav-item">
               <a class="nav-link" href="/petList">Pet list</a>
             </li>
             </#if>
        </ul>
        <#if user??>
        <a class="nav-link" href = "/profile">${name}</a>
        <@l.logout />
        </#if>
    </div>
</nav>