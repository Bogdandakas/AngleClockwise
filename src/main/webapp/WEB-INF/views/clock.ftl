<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#include "/WEB-INF/templates/header.ftl">
    <#setting locale="en_US">
    <#include "/WEB-INF/css/circle_style.css">

</head>

<body>
<br>

    <table>
        <tr>
            <th><p>Input type</p></th>
            <td><a href="/clock/currentTime"><input type="submit" value="Current time"></a></td>
            <td><a href="/clock/${clock.hour+1}:${clock.minute}/next"><input type="submit" value="Next hour"></a></td>
            <td><a href="/clock/${clock.hour}:${clock.minute+1}/next"><input type="submit" value="Next minute"></a></td>
            <td><a href="/clock/random"><input type="submit" value="Random"></a></td>
        </tr>
    </table>

    <form name="clock" action="/clock/${time}" method="post">
        <table>
            <tr>
                <th><p>HOURS</p><input title="HOURS" type="text" name="hour" value=${clock.hour}></th>
                <th><p>MINUTES</p><input title="MINUTES" type="text" name="minute" value=${clock.minute}></th>
                <th><p>ACTION</p><input type="submit" value="Calc angle"></th>
            </tr>
        </table>
    </form>


<h1>${angle}</h1>

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