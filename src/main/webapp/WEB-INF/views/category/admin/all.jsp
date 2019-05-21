<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>


<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta title="" content="Виды продукции">
    <title>Виды продукции</title>
</head>
<body>
<div>
    <c:set var="categories_length" value="${fn:length(categories)}"/>
    <div>
        <b>
            <span>Категории</span>
            <c:if test="${categories_length eq 0}">
                <span>Список пуст!</span>
                <a href="<c:url value="/admin/category/add"/>" title="Добавить" title="Добавить">
                    <button type="submit">Добавить</button>
                </a>
            </c:if>
        </b>
    </div>
</div>
</body>
</html>
