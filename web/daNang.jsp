<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>TRAVELER - For Customer</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Topbar Start -->
        <div class="container-fluid bg-light pt-3 d-none d-lg-block">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                        <div class="d-inline-flex align-items-center">
                            <p><i class="fa fa-envelope mr-2"></i>hungdnbde160562@fpt.edu.vn</p>
                            <p class="text-body px-3">|</p>
                            <p><i class="fa fa-phone-alt mr-2"></i>+84 763 245 677</p>
                        </div>
                    </div>
                    <div class="col-lg-6 text-center text-lg-right">
                        <div class="d-inline-flex align-items-center">
                            <p>Welcome ${user.userName}</p>
                            <a class="text-primary px-3" href="">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                            <a class="text-primary px-3" href="">
                                <i class="fab fa-instagram"></i>
                            </a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Your Account</a>
                                <div class="dropdown-menu border-0 rounded-0 m-0">
                                    <form action="UpdateAccountUserController" method="POST" class="dropdown-item">
                                        <tr>
                                            <td>
                                                <input type="submit" value="Update Account">
                                                <input type="text" hidden value="${user}" name="name">
                                            </td>
                                        </tr>
                                    </form>
                                    <form action="index.html" method="POST" class="dropdown-item">
                                        <tr>
                                            <td>
                                                <input type="submit" value="Log Out">
                                            </td>
                                        </tr>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid position-relative nav-bar p-0">
            <div class="container-lg position-relative p-0 px-lg-3" style="z-index: 9;">
                <nav class="navbar navbar-expand-lg bg-light navbar-light shadow-lg py-3 py-lg-0 pl-3 pl-lg-5">
                    <a href="customerPage.jsp" class="navbar-brand">
                        <h1 class="m-0 text-primary"><span class="text-dark">OPEN TO</span>UR</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                        <div class="navbar-nav ml-auto py-0">
                            <a href="index.html" class="nav-item nav-link active">Home</a>
                            <a href="about.html" class="nav-item nav-link">About</a>
                            <a href="service.html" class="nav-item nav-link">Services</a>
                            
                            <!-- Kiểm tra cái giỏ hàng -->
                            <c:set var="size" value="${sessionScope.size}"/>
                            <a href="customerCart.jsp" class="nav-item nav-link">My Cart (${size})</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu border-0 rounded-0 m-0">
                                    <a href="blog.html" class="dropdown-item">Blog Grid</a>
                                    <a href="single.html" class="dropdown-item">Blog Detail</a>
                                    <a href="destination.html" class="dropdown-item">Destination</a>
                                    <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Navbar End -->


        <!-- Carousel Start -->
        <div class="container-fluid p-0">
            <div id="header-carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="w-100" src="img/Kinh-nghiem-du-lich-Ba-Na-Hill.jpg" alt="Image">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 900px;">
                                <h4 class="text-white text-uppercase mb-md-3">Ba Na Hill</h4>
                                <h1 class="display-3 text-white mb-md-4">Romantic Fantasy Paradise.</h1>
                                <a href="banahillblog.jsp" class="btn btn-primary py-md-3 px-md-5 mt-2">Book Now</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="w-100" src="img/hostel.jpg" alt="Image">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 900px;">
                                <h4 class="text-white text-uppercase mb-md-3">Beauty Hotel</h4>
                                <h1 class="display-3 text-white mb-md-4">Discover Amazing Places With Friend or Lover</h1>
                                <a href="" class="btn btn-primary py-md-3 px-md-5 mt-2">Book Now</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="w-100" src="img/sun-wheel.jpg" alt="Image">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 900px;">
                                <h4 class="text-white text-uppercase mb-md-3">Sun Wheel</h4>
                                <h1 class="display-3 text-white mb-md-4">The Most Beauty And Biggest Wheel In Viet Nam</h1>
                                <a href="" class="btn btn-primary py-md-3 px-md-5 mt-2">Book Now</a>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
                    <div class="btn btn-dark" style="width: 45px; height: 45px;">
                        <span class="carousel-control-prev-icon mb-n2"></span>
                    </div>
                </a>
                <a class="carousel-control-next" href="#header-carousel" data-slide="next">
                    <div class="btn btn-dark" style="width: 45px; height: 45px;">
                        <span class="carousel-control-next-icon mb-n2"></span>
                    </div>
                </a>
            </div>
        </div>

        <!-- Packages Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Packages</h6>
                    <h1>Pefect Tour Packages</h1>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="package-item bg-white mb-2">
                            <img class="img-fluid" src="img/BA-NA-HILLS.jpg" alt="">
                            <div class="p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-map-marker-alt text-primary mr-2"></i>Da Nang</small>
                                    <small class="m-0"><i class="fa fa-calendar-alt text-primary mr-2"></i>No Limited</small>
                                    <small class="m-0"><i class="fa fa-user text-primary mr-2"></i>No Limited</small>
                                </div>
                                <a class="h5 text-decoration-none" href="banahillblog.jsp">Ba Na Hill <br> It is a very romantic fantasy paradise.</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                        <h5 class="m-0">$350</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="package-item bg-white mb-2">
                            <img class="img-fluid" src="img/congviennuocnuithantai.jpg" alt="">
                            <div class="p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-map-marker-alt text-primary mr-2"></i>Da Nang</small>
                                    <small class="m-0"><i class="fa fa-calendar-alt text-primary mr-2"></i>No Limited</small>
                                    <small class="m-0"><i class="fa fa-user text-primary mr-2"></i>No Limited</small>
                                </div>
                                <a class="h5 text-decoration-none" href="suoiThanTaiBlog.jsp">Suoi Than Tai <br><br> Have Fun With Water.</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                        <h5 class="m-0">$350</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="package-item bg-white mb-2">
                            <img class="img-fluid" src="img/package-3.jpg" alt="">
                            <div class="p-4">
                                <div class="d-flex justify-content-between mb-3">
                                    <small class="m-0"><i class="fa fa-map-marker-alt text-primary mr-2"></i>Da Nang</small>
                                    <small class="m-0"><i class="fa fa-calendar-alt text-primary mr-2"></i>No Limited</small>
                                    <small class="m-0"><i class="fa fa-user text-primary mr-2"></i>No Limited</small>
                                </div>
                                <a class="h5 text-decoration-none" href="myKheBeachBlog.jsp">My Khe Paradise <br> One of the most beautiful beaches in Vietnam</a>
                                <div class="border-top mt-4 pt-4">
                                    <div class="d-flex justify-content-between">
                                        <h6 class="m-0"><i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small></h6>
                                        <h5 class="m-0">$350</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Demo List Of Service -->
<!--                    <form name="f" action="" method="post">
                        Enter Number of items to by: 
                        <input type="number" name="num" value="1" />
                        <hr/>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Service ID</th>
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>Phone</th>
                                    <th>Quantity Available</th>
                                    <th>Price</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <jsp:useBean id="db" class="DAO.ServiceDAO"/>
                                <c:forEach items="${db.all}" var="p">
                                    <tr>
                                        <td>${p.serviceID}</td>
                                        <td>${p.serviceName}</td>
                                        <td>${p.serviceAddress}</td>
                                        <td>${p.servicePhone}</td>
                                        <td>${p.serviceQuantity}</td>
                                        <td>${p.servicePrice}</td>
                                        <td>
                                            <input type="submit" onclick="buy('${p.serviceID}')" value="Buy Item"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>-->
                    <!-- End Demo -->
                </div>
            </div>
        </div>
        <!-- Packages End -->

        <!-- Service Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Services</h6>
                    <h1>Tours & Travel Services</h1>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="service-item bg-white text-center mb-2 py-5 px-4">
                            <i class="fa fa-2x fa-route mx-auto mb-4"></i>
                            <h5 class="mb-2">Custom Your Tour</h5>
                            <p class="m-0">You can easy to custom wherever you want to travel</p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="service-item bg-white text-center mb-2 py-5 px-4">
                            <i class="fa fa-2x fa-ticket-alt mx-auto mb-4"></i>
                            <h5 class="mb-2">Contact With Seller</h5>
                            <p class="m-0">Through Open Tour you can make a connect with seller they can help you to reduce experience when travel</p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="service-item bg-white text-center mb-2 py-5 px-4">
                            <i class="fa fa-2x fa-money-check-alt mx-auto mb-4"></i>
                            <h5 class="mb-2">Cheap</h5>
                            <p class="m-0">Compared to tour trips, the price at OpenTour is very cheap, you can experience more places than having to follow an available tour.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Blog Start -->
        <div class="container-fluid py-5">
            <div class="container pt-5 pb-3">
                <div class="text-center mb-3 pb-3">
                    <h6 class="text-primary text-uppercase" style="letter-spacing: 5px;">Our Blog</h6>
                    <h1>Latest From Our Blog</h1>
                </div>
                <div class="row pb-3">
                    <div class="col-lg-4 col-md-6 mb-4 pb-2">
                        <div class="blog-item">
                            <div class="position-relative">
                                <img class="img-fluid w-100" src="img/blog-1.jpg" alt="">
                                <div class="blog-date">
                                    <h6 class="font-weight-bold mb-n1">01</h6>
                                    <small class="text-white text-uppercase">Jan</small>
                                </div>
                            </div>
                            <div class="bg-white p-4">
                                <div class="d-flex mb-2">
                                    <a class="text-primary text-uppercase text-decoration-none" href="">Admin</a>
                                    <span class="text-primary px-2">|</span>
                                    <a class="text-primary text-uppercase text-decoration-none" href="">Tours & Travel</a>
                                </div>
                                <a class="h5 m-0 text-decoration-none" href="">Dolor justo sea kasd lorem clita justo diam amet</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4 pb-2">
                        <div class="blog-item">
                            <div class="position-relative">
                                <img class="img-fluid w-100" src="img/blog-2.jpg" alt="">
                                <div class="blog-date">
                                    <h6 class="font-weight-bold mb-n1">01</h6>
                                    <small class="text-white text-uppercase">Jan</small>
                                </div>
                            </div>
                            <div class="bg-white p-4">
                                <div class="d-flex mb-2">
                                    <a class="text-primary text-uppercase text-decoration-none" href="">Admin</a>
                                    <span class="text-primary px-2">|</span>
                                    <a class="text-primary text-uppercase text-decoration-none" href="">Tours & Travel</a>
                                </div>
                                <a class="h5 m-0 text-decoration-none" href="">Dolor justo sea kasd lorem clita justo diam amet</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4 pb-2">
                        <div class="blog-item">
                            <div class="position-relative">
                                <img class="img-fluid w-100" src="img/blog-3.jpg" alt="">
                                <div class="blog-date">
                                    <h6 class="font-weight-bold mb-n1">01</h6>
                                    <small class="text-white text-uppercase">Jan</small>
                                </div>
                            </div>
                            <div class="bg-white p-4">
                                <div class="d-flex mb-2">
                                    <a class="text-primary text-uppercase text-decoration-none" href="">Admin</a>
                                    <span class="text-primary px-2">|</span>
                                    <a class="text-primary text-uppercase text-decoration-none" href="">Tours & Travel</a>
                                </div>
                                <a class="h5 m-0 text-decoration-none" href="">Dolor justo sea kasd lorem clita justo diam amet</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Blog End -->


        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-white-50 py-5 px-sm-3 px-lg-5" style="margin-top: 90px;">
            <div class="row pt-5">
                <div class="col-lg-3 col-md-6 mb-5">
                    <a href="" class="navbar-brand">
                        <h1 class="text-primary"><span class="text-white">TRAVEL</span>ER</h1>
                    </a>
                    <p>Sed ipsum clita tempor ipsum ipsum amet sit ipsum lorem amet labore rebum lorem ipsum dolor. No sed vero lorem dolor dolor</p>
                    <h6 class="text-white text-uppercase mt-4 mb-3" style="letter-spacing: 5px;">Follow Us</h6>
                    <div class="d-flex justify-content-start">
                        <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                        <a class="btn btn-outline-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-5">
                    <h5 class="text-white text-uppercase mb-4" style="letter-spacing: 5px;">Our Services</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>About</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Destination</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Services</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Packages</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Guides</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Testimonial</a>
                        <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>Blog</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-5">
                    <h5 class="text-white text-uppercase mb-4" style="letter-spacing: 5px;">Usefull Links</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>About</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Destination</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Services</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Packages</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Guides</a>
                        <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Testimonial</a>
                        <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>Blog</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-5">
                    <h5 class="text-white text-uppercase mb-4" style="letter-spacing: 5px;">Contact Us</h5>
                    <p><i class="fa fa-map-marker-alt mr-2"></i>FPT University</p>
                    <p><i class="fa fa-phone-alt mr-2"></i>+84 981231xxx</p>
                    <p><i class="fa fa-envelope mr-2"></i>hungdnbde160562@fpt.edu.com</p>
                    <h6 class="text-white text-uppercase mt-4 mb-3" style="letter-spacing: 5px;">Newsletter</h6>
                    <div class="w-100">
                        <div class="input-group">
                            <a href="login.jsp"><button class="btn btn-primary px-3">Sign Up</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
        <script type="text/javascript">
                                                function buy(id) {
                                                    document.f.action = "buy?id=" + id;
                                                    document.f.submit();
                                                }
        </script>
    </body>

</html>