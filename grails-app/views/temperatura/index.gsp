<%@ page import="examen.vinco.Saldo" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'temperatura.label', default: 'Temperatura')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<h1>Conversión de temperatura</h1>
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>
<g:hasErrors bean="${cmd}">
    <ul>
        <g:eachError var="error" bean="${cmd}">
            <li>${error}</li>
        </g:eachError>
    </ul>
</g:hasErrors>

<g:form controller="temperatura" action="convertir">
    <label for='cantidad'>Cantidad:</label>
    <g:textField name="cantidad" id="cantidad"/>
    <br>
    <label for='cantidad'>Unidad origen:</label>
    <g:select from="${unidades}" name="unidadOrigen" id="unidadOrigen"/>
    <br>
    <label for='cantidad'>Unidad final:</label>
    <g:select from="${unidades}" name="unidadFinal" id="unidadFinal"/>

    <br>

    <g:submitButton name="Convertir"/>
</g:form>
</body>
</html>
