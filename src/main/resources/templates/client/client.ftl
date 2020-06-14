<#import "../macro.ftl" as macros>
<@macros.head/>

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h2><@spring.message "client" /></h2>
        <br />
        <a href="/client/create">
            <button type="button" class="btn btn-outline-primary"><@spring.message "add_new" /></button>
        </a>
        <br/>
        <table class="table">
            <br/>
            <thead>
            <tr>
                <th scope="col"><@spring.message "id_number" /></th>
                <th scope="col"><@spring.message "first_name" /></th>
                <th scope="col"><@spring.message "last_name" /></th>
                <th scope="col"><@spring.message "delete" /></th>
            </tr>
            </thead>
            <tbody>
            <#list clients as client>
                <tr>
                    <td>${client.idNumber}</td>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>
                        <a href="/client/delete?id=${client.id}" class="btn btn-danger btn-sm"><@spring.message "delete" /></a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</div>
<@macros.foot />