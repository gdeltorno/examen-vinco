<%@ page import="examen.vinco.Saldo" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'saldo.label', default: 'Saldo')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<g:uploadForm action="uploadFile" method="post">
    <g:if test='${flash.message}'>
        <div class='message'>${flash.message}</div>
    </g:if>
    <br>
    <br>
    <div>
        <label for='archivo'>Archivo:</label>
        <input type="file" id="file" name="file"/>
    </div>
    <button type="submit" tabindex="4">Cargar archivo</button>
</g:uploadForm>
</body>
</html>
