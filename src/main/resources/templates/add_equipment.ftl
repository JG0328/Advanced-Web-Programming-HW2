<#import "macro.ftl" as macros>

<@macros.head />

<div class="wrapper d-flex align-items-stretch">
    <@macros.sidebar />
    <div id="content" class="p-4 p-md-5">
        <@macros.navbar />

        <form>
            <div class="form-group">
                <label for="family">Select a family</label>
                <select id="family" name="family"  class="browser-default custom-select">
                    <option selected value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
            <div class="form-group">
                <label for="sub-family">Select a sub-family</label>
                <select id="sub-family" name="sub-family" class="browser-default custom-select">
                    <option selected value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
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



            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<@macros.foot />
