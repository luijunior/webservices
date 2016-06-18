<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="executa?tarefa=BuscaParticipante" method="POST">
    <input type="submit" value="Buscar" />

</form>
<form action="executa?tarefa=CadastraParticipante" method="POST">
    Nome : <input type="text" name="nome" />
    Cpf : <input type="text" name="cpf" />
    <input type="submit" value="Cadastrar" />
</form>
</body>
</html>