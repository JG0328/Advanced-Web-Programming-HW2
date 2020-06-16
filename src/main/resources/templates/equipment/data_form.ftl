<#import "../macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />
        <h2>${name} <@spring.message "equipments" /></h2>
        <form method="POST" action="${action}" enctype=multipart/form-data>
            <div class="form-group">
                <label for="family"><@spring.message "select_family" /></label>
                <select id="category" name="category"  class="browser-default custom-select">
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
                <#if rate??>
                    <input type="number" step="0.1" lang="en" value="${rate}" min="0.1" class="form-control" name="rate" id="rate" />
                <#else>
                    <input type="number" step="0.1" lang="en" value="0.1" min="0.1" class="form-control" name="rate" id="rate" />
                </#if>
            </div>


            <#if equipment.photo??>
                <img src="data:${equipment.photo.mimeType};base64, ${equipment.photo.base64Image}" class="card-img-top" style="max-width: 100px; height: auto;" alt="Image" />
            <#else>
                <div class="form-group">
                    <label for="image"><@spring.message "image" /> (<@spring.message "not_editable" />)</label>
                    <input type="file" class="form-control-file" name="image_file"  id="image_file" placeholder="Image">
                </div>
            </#if>


            <br/><br/>

            <#if categories?size != 0>
                <button type="submit" class="btn btn-primary">${name}</button>
            <#else>
                <div class="alert alert-warning" role="alert">
                    <@spring.message "no_categories_warning" />
                </div>
            </#if>
        </form>
    </div>
</div>
<@macros.foot />
