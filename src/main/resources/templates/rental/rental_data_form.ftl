<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch" xmlns:form="http://www.w3.org/1999/html">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <form method="post" action="/rental/create">
            <div class="form-group">
                <label>Date</label>
                <input type="text" class="form-control" value="${rental.date}" disabled name="date"/>
            </div>
            <div class="form-group">
                <label>Return Date</label>
                <input type="text" class="form-control" name="returnDate" id="returnDate"
                       required/>
            </div>
            <div class="form-group">
                <label>Client</label>
                <select class="form-control" name="client" id="client" required>
                    <#list clients as client>
                        <option value="${client.id}">${client.getFullName()}</option>
                    </#list>
                </select>
            </div>
            <br/>
            <h4>Select Equipments</h4>
            <table class="table" border="3">
                <tr>
                    <th>Select</th>
                    <th>Category</th>
                    <th>Name</th>
                    <th>Daily Rate</th>
                    <th>Stock</th>
                    <th>Number of items</th>
                </tr>
                <#list equipments as equipment>
                    <tr>
                        <td><input type="checkbox" name="checkEquip" value="${equipment.id}"/></td>
                        <td>${equipment.category.name}</td>
                        <td>${equipment.name}</td>
                        <td>${equipment.rate}</td>
                        <td>${equipment.stock}</td>
                        <td><input name="stockEquip" value="0" type="number" class="form-control"
                                   max="${equipment.stock}" min="0"/></td>
                        <input type="hidden" name="index" value="${equipment?index}"/>
                    </tr>
                </#list>
            </table>
            <#if equipments?size != 0 && clients?size != 0>
                <button type="submit" class="btn btn-primary">Submit</button>
            <#else>
                <div class="alert alert-warning" role="alert">
                    There are no equipments available or registered clients to create a rental
                </div>
            </#if>

        </form>
    </div>
</div>
<@macros.foot />