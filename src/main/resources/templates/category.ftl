
<#import "macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <a href="/family/create"><button type="button" class="btn btn-outline-primary">Add a new Category</button></a>
        <br />
        <table class="table">
            <br />
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Parent Family</th>
            </tr>
            </thead>
            <tbody>
            <#list categories as category>
                <tr>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td>${category.parentCategory}</td>
            </#list>
            </tbody>
        </table>

    </div>
</div>
<@macros.foot />
