<#import "parts/common.ftl" as c>

<@c.page>
 <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
    >
<h5>Profile of user ${name}</h5>
<h5>Changing password:</h5>
${message?ifExists}
<form method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
     <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Save</button>
 </form>
</@c.page>
