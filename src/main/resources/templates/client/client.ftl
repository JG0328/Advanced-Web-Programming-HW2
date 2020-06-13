<#import "../macro.ftl" as macros>
<@macros.head/>

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <a href="/client/create">
            <button type="button" class="btn btn-outline-primary">Add a new Client</button>
        </a>
        <br/>
        <table class="table">
            <br/>
            <thead>
            <tr>
                <th scope="col">ID Number</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <#list clients as client>
                <tr>
                    <td>${client.idNumber}</td>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>
                        <a href="/client/delete?id=${client.id}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</div>
<@macros.foot />