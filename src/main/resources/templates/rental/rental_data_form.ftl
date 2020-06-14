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
                <input type="date" class="form-control" name="returnDate" id="returnDate"
                       required/>
            </div>
            <div class="form-group">
                <label>Client</label>
                <select class="form-control" name="selectClient" id="selectClient" required>
                    <option>...</option>
                    <#list clients as client>
                        <option value="${client.id}">${client.getFullName()}</option>
                    </#list>
                </select>
            </div>
            <table class="table">
                <tr>

                </tr>
            </table>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<@macros.foot />
<script>
    $(function () {
        $("#returnDate").datepicker({
            dateFormat: "dd/mm/yy",
            defaultDate: +1,
            minDate: +1
        });
    });
</script>
