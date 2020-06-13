<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />

        <form method="POST" action="/family/create">
            <div class="form-group">
                <label for="parent_category">Select a Parent Category</label>
                <select id="parent_category" name="parent_category"  class="browser-default custom-select">
                    <option selected value="Null">None</option>
                    <#list parent_categories as category>
                        <option value="${category.id}">${category}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="stock">Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter name">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" class="form-control" name="description" id="description" placeholder="Enter a short description">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
</div>
<@macros.foot />
