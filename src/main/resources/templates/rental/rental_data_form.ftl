<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch" xmlns:form="http://www.w3.org/1999/html">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <form method="post" action="/rental/create">
            <div class="form-group">
                <label><@spring.message "date" /></label>
                <input type="text" class="form-control" value="${rental.date}" disabled name="date"/>
            </div>
            <div class="form-group">
                <label><@spring.message "return" /> <@spring.message "date" /></label>
                <input type="text" class="form-control" name="returnDate" id="returnDate"
                       required/>
            </div>
            <div class="form-group">
                <label><@spring.message "client" /></label>
                <select class="form-control" name="client" id="client" required>
                    <#list clients as client>
                        <option value="${client.id}">${client.getFullName()}</option>
                    </#list>
                </select>
            </div>
            <br/>
            <h4><@spring.message "select" /> <@spring.message "equipments" /></h4>
            <table class="table" border="3">
                <tr>
                    <th><@spring.message "select" /></th>
                    <th><@spring.message "category" /></th>
                    <th><@spring.message "name" /></th>
                    <th><@spring.message "rate" /></th>
                    <th><@spring.message "stock" /></th>
                    <th><@spring.message "number_of_equipments" /></th>
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
                    <@spring.message "rentals_error" />
                </div>
            </#if>

        </form>
    </div>
</div>
<@macros.foot />