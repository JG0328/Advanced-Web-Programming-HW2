<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <table class="table">
            <tr>
                <th><@spring.message "client" /></th>
                <th><@spring.message "date" /></th>
                <th><@spring.message "return" /> <@spring.message "date" /></th>
                <th><@spring.message "equipments" /></th>
                <th><@spring.message "total_cost" /></th>
            </tr>
            <#list receipts as receipt>
                <tr>
                    <td>${receipt.client.getFullName()}</td>
                    <td>${receipt.date}</td>
                    <td>${receipt.returnDate}</td>
                    <td>
                        <ul>
                            <#list receipt.equipmentRental as equip>
                                <li>${"${equip.equipment.name} - ${equip.numberRented} Stock"}</li>
                            </#list>
                        </ul>
                    </td>
                    <td>${receipt.cost}</td>
                </tr>
            </#list>
        </table>
    </div>
</div>
<@macros.foot />