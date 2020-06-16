<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />

    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h2><@spring.message "rentals" /></h2>
        <br/>
        <a href="/rental/create" class="btn btn-outline-primary"><@spring.message "new_rental" /></a>
        <br/><br/>
        <table class="table">
            <thead>
            <tr>
                <th><@spring.message "client" /></th>
                <th><@spring.message "date" /></th>
                <th><@spring.message "return_date" /></th>
                <th><@spring.message "days" /></th>
                <th><@spring.message "equipments" /></th>
                <th><@spring.message "return" /> <@spring.message "equipment" /></th>
            </tr>
            </thead>
            <tbody>
            <#list rentals as rental>
                <tr>
                    <td>${rental.client.getFullName()}</td>
                    <td>${rental.date}</td>
                    <td>${rental.returnDate}</td>
                    <td>${rental.days}</td>
                    <td>
                        <dl>
                            <#list rental.equipmentRental as equip>
                                <#if equip.returned>
                                    <dd>
                                        <del>${"${equip.equipment.name}" + " - "+"${equip.numberRented}" + ' Stock'}</del>
                                    </dd>
                                <#else>
                                    <dd>
                                        ${"${equip.equipment.name}" + " - "+"${equip.numberRented}" + " Stock"}
                                    </dd>
                                </#if>
                            </#list>
                        </dl>
                    </td>
                    <td>
                        <a class="btn btn-outline-primary btn-sm" href="/receipt/create?id=${rental.id}"><@spring.message "receipt" /></a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
<@macros.foot />