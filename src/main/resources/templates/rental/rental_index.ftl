<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <br/>
        <a href="/rental/create" class="btn btn-outline-primary">New Rental</a>
        <br/>
        <table class="table">
            <thead>
            <tr>
                <th>Client</th>
                <th>Date</th>
                <th>Return Date</th>
                <th>Days</th>
                <th>Equipments</th>
                <th>Return</th>
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
                                        <del>${"${equip.equipment.name}" + " - "+"${equip.numberRented}" + " Stock"}</del>
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
                        <a class="btn btn-outline-primary btn-sm" href="/receipt/create?id=${rental.id}">Receipt</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
<@macros.foot />