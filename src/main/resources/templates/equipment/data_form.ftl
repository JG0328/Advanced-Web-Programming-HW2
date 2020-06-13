<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />

        <form method="POST" action="${action}">
            <div class="form-group">
                <label for="family">Select a family</label>
                <select id="category" name="category"  class="browser-default custom-select">
                    <option selected value="-1">None</option>
                    <#list categories as category>
                        <option value="${category.id}">${category.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter name">
            </div>
            <div class="form-group">
                <label for="stock">Stock</label>
                <input type="number" class="form-control" name="stock" id="stock" placeholder="Enter items in stock">
            </div>
            <div class="form-group">
                <label for="rate">Daily Rate</label>
                <input type="number" step="0.1" class="form-control" name="rate" id="rate" placeholder="Enter daily rate price">
            </div>

            <div class="form-group">
                <label for="image">Image</label>
                <input type="file" class="form-control-file" id="image" placeholder="Image">
            </div>

            <button type="submit" class="btn btn-primary">${name}</button>
        </form>
    </div>
</div>
<@macros.foot />
