<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#include "/WEB-INF/templates/header.ftl">
    <#include "/WEB-INF/css/circle_image.css">

</head>
<body>
    <h1><p>${about}</p><h1>


<article id="clock">
        <div id="hours-container">
            <div id="hours"></div>
        </div>
        <div id="minutes-container">
            <div id="minutes"></div>
        </div>
        <div id="circle-container">
            <div id="circle"></div>
        </div>
        <div id="circle-border_container">
             <div id="circle-border"></div>
        </div>
</article>


</body>
</html>