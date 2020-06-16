<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch" xmlns:form="http://www.w3.org/1999/html">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <form method="post" action="/receipt/create">
            <dl>
                <input type="hidden" name="idAlc" value="${receipt.id}"/>
                <dt><@spring.message "client" /></dt>
                <dd>${receipt.client.getFullName()}</dd>
                <dt><@spring.message "return" /> <@spring.message "date" /></dt>
                <dd>${receipt.returnDate}</dd>
                <dt id="days"><@spring.message "days" /></dt>
                <dd>${receipt.days}</dd>
                <dt><@spring.message "equipments_to_return" /></dt>
                <dd>
                    <table class="table table-hover">
                        <tr>
                            <th><@spring.message "choose" /></th>
                            <th><@spring.message "category" /></th>
                            <th><@spring.message "equipment" /></th>
                            <th><@spring.message "amount_rented" /></th>
                            <th><@spring.message "rate" /></th>
                            <th><@spring.message "days_rented" /></th>
                            <th><@spring.message "total_cost" /></th>
                        </tr>
                        <#list receipt.equipmentRental as equip>
                            <#if equip.returned == false>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="chk" value="${equip.id}"/>
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