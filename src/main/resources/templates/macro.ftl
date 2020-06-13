<#macro navbar>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <button type="button" id="sidebarCollapse" class="btn btn-primary">
                <i class="fa fa-bars"></i>
                <span class="sr-only">Toggle Menu</span>
            </button>
            <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fa fa-bars"></i>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home</a>
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
                        <a href="#">Dashboard</a>
                    </li>
                    <li>
                        <a href="#">Clients</a>
                    </li>
                    <li>
                        <a href="/equipment">Equipment</a>
                    </li>
                    <li>
                        <a href="/family">Families</a>
                    </li>
                    <li>
                        <a href="#">Rentals</a>
                    </li>
                    <li>
                        <a href="#">Returns</a>
                    </li>
                    <li>
                        <a href="#">History</a>
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
    <title>Inventario de Equipo</title>
</head>
<body>
</#macro>


<#macro foot>
            <script src="/js/jquery.min.js"></script>
            <script src="/js/popper.js"></script>
            <script src="/js/bootstrap.min.js"></script>
            <script src="/js/main.js"></script>
        </body>
    </html>
</#macro>