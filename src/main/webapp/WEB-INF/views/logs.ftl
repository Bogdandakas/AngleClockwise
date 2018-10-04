<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Events</title>
    <#include "/WEB-INF/templates/header.ftl">

</head>
<body>
<h1>Events list</h1>

<table style="border-style: outset; border-color: slategray;">
<tbody style="background: white;">

    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Level</th>
        <th>Text</th>
    </tr>
    <#list logs as log>
    <tr>
        <td>${log.id}</td>
        <td>${log.date}</td>
        <td>${log.level}</td>
        <td>${log.text}</td>
    </tr>
    </#list>
</table>
</tbody>

</body>
</html>