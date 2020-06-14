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
                    <option>...</option>
                    <#list clients as client>
                        <option value="${client.id}">${client.getFullName()}</option>
                    </#list>
                </select>
            </div>
            <table class="table">
                <#list equipments as equipment>
                    <tr>
                        <td><input class="form-control" type="checkbox" name="checkEquip" value="${equipment.id}"/></td>
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
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<@macros.foot />