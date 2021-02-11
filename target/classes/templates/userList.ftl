<#import "parts/common.ftl" as c>

<@c.page>

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <th scope = "row">${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>

