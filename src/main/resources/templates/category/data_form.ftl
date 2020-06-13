<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h2>${name} <@spring.message "category" /></h2>
        <form method="POST" action="${action}">
            <div class="form-group">
                <label for="parent_category"><@spring.message "parent_category" /></label>
                <select id="parent_category" name="parent_category"  class="browser-default custom-select">
                    <option selected value="-1"><@spring.message "none" /></option>
                    <#list parent_categories as parent_category>
                        <option value="${parent_category.id}">${parent_category.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="stock"><@spring.message "name" /></label>
                <input type="text" value="${category.name}" class="form-control" name="name" id="name" placeholder='<@spring.message "enter_name" />'>
            </div>
            <div class="form-group">
                <label for="description"><@spring.message "description" /></label>
                <input type="text" value="${category.description}" class="form-control" name="description" id="description" placeholder='<@spring.message "description_placeholder" />'>
            </div>
            <button type="submit" class="btn btn-primary">${name}</button>
        </form>
    </div>
</div>
<@macros.foot />
