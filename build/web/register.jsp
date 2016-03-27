<%-- 
    Document   : index
    Created on : Mar 19, 2016, 9:56:51 AM
    Author     : Lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title></title>
    <script>
function check() {
    
    var u=document.getElementById("us");
    var p=document.getElementById("pa");
    var c=document.getElementById("cpa");
    
    
        if(u.value!="")
        {
         if(p.value!="")
            {
             if(c.value!="")
                {if (p.value == c.value)
                 {
              
                    return true;
                 }else {window.alert("Passwords do not match");return false;}
                }else{window.alert("Confirm password");return false;}
            }else{window.alert("Enter password");return false;}
        }else{window.alert("Enter username");return false;}
    

}
</script>
    <!--REQUIRED STYLE SHEETS-->
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLE CSS -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Ruluko' rel='stylesheet' type='text/css' />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">DIVIDED PASSWORD HASHING </a>
            </div>
            <!-- Collect the nav links for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="homepage.jsp">HOME</a>
                    </li>
                    <li><a href="login.html">LOGIN</a>
                    </li>
                    <li><a href="register.jsp">REGISTRATION</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!--End Navigation -->


    <!--Header section  -->
<div class="logincontainer">
    <form action="Division" method="post">
       <center><table> <tr><td><h3>Username</h3></td><td><h3><input type="text" name="username" id="us"></h3></td></tr>
       <tr><td> <h3>Password </h3></td><td><h3><input type="password" name="password" id="pa"></h3></td></tr>
       <tr><td> <h3>Confirm Password  </h3> </td><td><h3><input type="password" name="cpassword" id="cpa"></h3></td></tr>
        </table><input type="submit" value="Register" onClick="return check()">
           </center> </form></div>
	
    <!--End Header section  -->


    
    <!--End Contact Section -->
    <!--footer Section -->
    
    <!--End footer Section -->
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
    <script src="assets/plugins/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP CORE SCRIPT   -->
    <script src="assets/plugins/bootstrap.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>

</body>
</html>
