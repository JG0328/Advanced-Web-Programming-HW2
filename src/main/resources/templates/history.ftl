<#import "macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h1>History</h1>
        <hr>
        <div class="container">
            <h3>Client:</h3>
            <form class="form-inline" action="/history" method="post">
                <select class="form-control col-10" name="selectClient">
                    <option>None</option>
                    <#list clients as client>
                        <option value="${client.id}">${client.getFullName()}</option>
                    </#list>
                </select>
                <input type="submit" class="form-control col" value="Search"/>
            </form>
        </div>
        <#if client??>
            <h5>${client}</h5>
            <h6>Rentals</h6>
            <div class="container">
                <table class="table table-sm">
                    <tr>
                        <th>Date</th>
                        <th>Return Date</th>
                        <th>Days</th>
                        <th>Equipments</th>
                    </tr>
                    <#list rentals as rental>
                        <tr>
                            <td>${rental.date}</td>
                            <td>${rental.returnDate}</td>
                            <td>${rental.days}</td>
                            <td>
                                <dl>
                                    <#list rental.equipmentRental as equip>
                                        <dd>${"${equip.equipment.name} - ${equip.numberRented} Stock"}</dd>
                                    </#list>
                                </dl>
                            </td>
                        </tr>
                    </#list>
                </table>
            </div>
        </#if>
    </div>
</div>
<@macros.foot />