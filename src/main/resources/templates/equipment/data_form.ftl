<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h2>${name} <@spring.message "equipment" /></h2>
        <form method="POST" action="${action}">
            <div class="form-group">
                <label for="family"><@spring.message "select_family" /></label>
                <select id="category" name="category"  class="browser-default custom-select">
                    <option selected value="-1"><@spring.message "none" /></option>
                    <#list categories as category>
                        <option value="${category.id}">${category.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="name"><@spring.message "name" /></label>
                <input type="text" value="${equipment.name}" class="form-control" name="name" id="name" placeholder=<@spring.message "enter_name" />>
            </div>
            <div class="form-group">
                <label for="stock"><@spring.message "stock" /></label>
                <input type="number" value="${equipment.stock}" class="form-control" name="stock" id="stock" />
            </div>
            <div class="form-group">
                <label for="rate"><@spring.message "rate" /></label>
                <input type="number" step="0.1" value="${equipment.rate}" class="form-control" name="rate" id="rate" />
            </div>

            <div class="form-group">
                <label for="image"><@spring.message "image" /></label>
                <input type="file" class="form-control-file" id="image" placeholder="Image">
            </div>

            <button type="submit" class="btn btn-primary">${name}</button>
        </form>
    </div>
</div>
<@macros.foot />
