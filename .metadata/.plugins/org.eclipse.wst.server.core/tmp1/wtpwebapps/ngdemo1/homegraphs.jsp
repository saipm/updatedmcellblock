<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
* {
padding: 0;
margin: 0;
}
body {
font-size: 73%;
font-family: verdana, arial, helvetica, sans-serif;
padding: 10px;
}
#navigation {
overflow: auto;
}
#navigation li {
float: left;
list-style: none;
background-color: #666; /* to cater for users without images */
}
#navigation a {
display: block;
background-image: url(css-tabs/tabright.gif);
background-position: top right;
background-repeat: no-repeat;
color: #FFF;
text-decoration: none;
font-weight: bold;*/
}
#navigation span {
display: block;
background-image: url(css-tabs/tableft.gif);
background-repeat: no-repeat;
padding: 5px 15px;
}
#navigation a:hover {
background-position: right -198px;
}
#navigation a:hover span {
background-position: 0 -198px;
}
#navigation li ul {
position: absolute;
width: 10em;
left: -999em;
margin-left: 2px;
font-size: 90%;
}
#navigation li ul a, #navigation li ul a:link {
background-image: none;
padding: 5px;
width: 10em;
background-color: #666;
}
#navigation li ul a:hover {
background-color: #333;
}
#navigation li:hover ul, #navigation li.sfhover ul {
left: auto;
}
</style>
</head>
<body>
<ul id="navigation">
<li><a href="#"><span>Home</span></a></li>
<li><a href="#"><span>About</span></a>
<ul>
<li><a href="#">My Qualifications</a></li>
<li><a href="#">My Personal Details</a></li>
</ul>
</li>
<li><a href="#"><span>Services</span></a>
<ul>
<li><a href="#">HTML</a></li>
<li><a href="#">CSS</a></li>
<li><a href="#">Accessibility</a></li>
</ul>
</li>
<li><a href="#"><span>Portfolio</span></a></li>
<li><a href="#"><span>Contact</span></a></li>
<li><a href="#"><span>Links</span></a></li>
</ul>
</body>
</html>