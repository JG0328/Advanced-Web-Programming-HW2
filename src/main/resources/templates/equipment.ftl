
<#import "macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <a href="/equipment/add"><button type="button" class="btn btn-outline-primary">Add a new Equipment</button></a>
        <br />
        <table class="table">
            <br />
            <thead>
            <tr>
                <th scope="col">Image</th>
                <th scope="col">Name</th>
                <th scope="col">Family</th>
                <th scope="col">Sub-Family</th>
                <th scope="col">Rate</th>
                <th scope="col">Stock</th>
            </tr>
            </thead>
            <tbody>
            <#list equipments as equipment>
                <tr>
                    <td>${equipment.image}</td>
                    <td>${equipment.name}</td>
                    <td>${equipment.category}</td>
                    <td>${equipment.subCategory}</td>
                    <td>${equipment.rate}</td>
                    <td>${equipment.stock}</td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</div>
<@macros.foot />
