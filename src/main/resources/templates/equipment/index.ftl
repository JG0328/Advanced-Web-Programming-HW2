
<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h2><@spring.message "equipment" /></h2>
        <br/>
        <a href="/equipment/create"><button type="button" class="btn btn-outline-primary"><@spring.message "add_new" /></button></a>
        <br />
        <table class="table">
            <br />
            <thead>
            <tr>
                <th scope="col"><@spring.message "image" /></th>
                <th scope="col"><@spring.message "name" /></th>
                <th scope="col"><@spring.message "subCategory" /></th>
                <th scope="col"><@spring.message "rate" /></th>
                <th scope="col"><@spring.message "stock" /></th>
                <th scope="col"><@spring.message "update" /></th>
                <th scope="col"><@spring.message "delete" /></th>
            </tr>
            </thead>
            <tbody>
            <#list equipments as equipment>
                <tr>
                    <td>
                        <#if equipment.image??>
                            ${equipment.image}
                        </#if>
                    </td>
                    <td>${equipment.name}</td>
                    <#if equipment.category??>
                        <td>${equipment.category.name}</td>
                    <#else>
                        <td><@spring.message "none" /></td>
                    </#if>
                    <td>${equipment.rate}</td>
                    <td>${equipment.stock}</td>
                    <td>
                        <a href="/equipment/update/${equipment.id}">
                            <button type="button" class="btn btn-warning"><@spring.message "update" /></button>
                        </a>
                    </td>
                    <td>
                        <form method="POST" action="/equipment/delete/${equipment.id}">
                            <button type="submit" class="btn btn-danger"><@spring.message "delete" /></button>
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</div>
<@macros.foot />
