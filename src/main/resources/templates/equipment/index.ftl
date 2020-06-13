
<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <a href="/equipment/create"><button type="button" class="btn btn-outline-primary">Add a new Equipment</button></a>
        <br />
        <table class="table">
            <br />
            <thead>
            <tr>
                <th scope="col">Image</th>
                <th scope="col">Name</th>
                <th scope="col">Sub-Family</th>
                <th scope="col">Rate</th>
                <th scope="col">Stock</th>
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
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
                    <td>${equipment.category.name}</td>
                    <td>${equipment.rate}</td>
                    <td>${equipment.stock}</td>
                    <td>
                        <a href="/equipment/update/${equipment.id}">
                            <button type="button" class="btn btn-warning">Update</button>
                        </a>
                    </td>
                    <td>
                        <form method="POST" action="/family/delete/${equipment.id}">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</div>
<@macros.foot />
