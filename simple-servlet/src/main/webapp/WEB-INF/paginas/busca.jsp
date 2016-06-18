<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><body>
Resultado da busca:<br/>
<ul>
<c:forEach var="pessoa" items="${pessoas}">
    <c:out value="${pessoa.nome}"></c:out>
</c:forEach>
</ul>
</body></html>