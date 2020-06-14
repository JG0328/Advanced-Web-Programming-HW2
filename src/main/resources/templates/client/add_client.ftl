<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <form action="/client/create" method="post">
            <div class="form-group">
                <label for="idNumber"><@spring.message "id_number" /></label>
                <input type="text" class="form-control" id="idNumber" name="idNumber"/>
            </div>

            <div class="form-group">
                <label for="firstName"><@spring.message "first_name" /></label>
                <input type="text" class="form-control" id="firstName" name="firstName"/>
            </div>

            <div class="form-group">
                <label for="lastName"><@spring.message "last_name" /></label>
                <input type="text" class="form-control" id="lastName" name="lastName"/>
            </div>

            <div class="form-group">
                <label for="phoneNumber"><@spring.message "phone_number" /></label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"/>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email"/>
            </div>

            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </div>
</div>
<@macros.foot />