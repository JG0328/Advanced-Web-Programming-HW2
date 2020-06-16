<#macro navbar>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <button type="button" id="sidebarCollapse" class="btn btn-primary">
                <i class="fa fa-bars"></i>
                <span class="sr-only">Toggle Menu</span>
            </button>
            <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <i class="fa fa-bars"></i>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/"><@spring.message "home" /></a>
                    </li>
                    <li>
                        <select id="language" class="selectpicker" data-width="fit" style="margin-top:7px">
                            <option value="en">English</option>
                            <option value="es">Español</option>
                        </select>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</#macro>

<#macro sidebar>
    <nav id="sidebar">
        <div class="p-4 pt-5">
            <ul class="list-unstyled components mb-5">
                <li>
                    <a href="/"><@spring.message "dashboard" /></a>
                </li>
                <li>
                    <a href="/client"><@spring.message "clients" /></a>
                </li>
                <li>
                    <a href="/equipment"><@spring.message "equipments" /></a>
                </li>
                <li>
                    <a href="/family"><@spring.message "categories" /></a>
                </li>
                <li>
                    <a href="/rental"><@spring.message "rentals" /></a>
                </li>
                <li>
                    <a href="/receipt"><@spring.message "returns" /></a>
                </li>
                <li>
                    <a href="/history"><@spring.message "history" /></a>
                </li>
            </ul>

        </div>
    </nav>
</#macro>

<#macro head>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/jquery-ui.css">
    <title><@spring.message "equipment_inventory" /></title>
</head>
<body>
</#macro>


<#macro foot>
<script src="/js/jquery.js"></script>
<script src="/js/popper.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/jquery-ui.js"></script>
<script type="text/javascript">
    var selectedLanguage = sessionStorage.getItem("language");
    if (selectedLanguage) {
        document.getElementById("language").value = selectedLanguage;
    }

    document.getElementById("language").onchange = function (e) {
        var language = e.target.value;
        sessionStorage.setItem("language", language);
        window.location.href = window.location.href.split('?')[0] + "?lang=" + language;
    }

    // Datepicker
    $(function () {
        $("#returnDate").datepicker({
            dateFormat: "dd/mm/yy",
            minDate: "+1D"
        }).datepicker("setDate", "+1D");
    });
</script>
</body>
</html>
</#macro>

