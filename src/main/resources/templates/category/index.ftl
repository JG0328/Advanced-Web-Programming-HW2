
<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h2><@spring.message "category" /></h2>
        <br/>
        <a href="/family/create"><button type="button" class="btn btn-outline-primary"><@spring.message "add_new" /></button></a>
        <br />

        <table class="table">
            <br />
            <thead>
            <tr>
                <th scope="col"><@spring.message "name" /></th>
                <th scope="col"><@spring.message "description" /></th>
                <th scope="col"><@spring.message "parent_category" /></th>
                <th />
                <th />
            </tr>
            </thead>
            <tbody>
            <#list categories as category>
                <tr>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <#if category.parentCategory??>
                        <td>${category.parentCategory.name}</td>
                    <#else>
                        <td><@spring.message "none" /></td>
                    </#if>

                    <td>
                        <a href="/family/update/${category.id}">
                            <button type="button" class="btn btn-warning"><@spring.message "update" /></button>
                        </a>
                    </td>
                    <td>
                        <form method="POST" action="/family/delete/${category.id}">
                            <button type="submit" class="btn btn-danger"><@spring.message "delete" /></button>
                        </form>
                    </td>
            </#list>
            </tbody>
        </table>

    </div>
</div>
<@macros.foot />
