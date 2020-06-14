<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch" xmlns:form="http://www.w3.org/1999/html">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <form method="post" action="/receipt/create">
            <dl>
                <input type="hidden" name="idAlc" value="${receipt.id}"/>
                <dt>Client</dt>
                <dd>${receipt.client.getFullName()}</dd>
                <dt>Return Date</dt>
                <dd>${receipt.returnDate}</dd>
                <dt id="days">Days</dt>
                <dd>${receipt.days}</dd>
                <dt>Equipments To Return</dt>
                <dd>
                    <table class="table table-hover">
                        <tr>
                            <th>Choose</th>
                            <th>Family</th>
                            <th>Equipment</th>
                            <th>Amount Rented</th>
                            <th>Cost Per Day</th>
                            <th>Days Rented</th>
                            <th>Actual Cost</th>
                        </tr>
                        <#list receipt.equipmentRental as equip>
                            <#if equip.returned == false>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="chk" class="form-control" value="${equip.id}"/>
                                    </td>
                                    <td>${equip.equipment.category.name}</td>
                                    <td>${equip.equipment.name}</td>
                                    <td>${equip.numberRented}</td>
                                    <td>${equip.equipment.rate}</td>
                                    <td>${equip.days}</td>
                                    <td>${equip.cost}</td>
                                </tr>
                            </#if>
                        </#list>
                    </table>
                </dd>
            </dl>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<@macros.foot />