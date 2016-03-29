<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>CRUD Aluno</title>
<%@include file="fragmentos/cabecalho.jsp"%>
</head>
<body>
	<%@include file="fragmentos/menu.jsp"%>

	<div class="col-md-6">
		<h1>Cadastro de aluno</h1>

		<c:if test="${ not empty msg }">
			<div class="alert alert-${ msg.tipo}">${msg.texto}</div>
		</c:if>

		<form action="alunocontrole" method="post">
			<input type="hidden" name="id" value="${aluno.id}">
			<c:if test="${not empty aluno.id}">
				<div class="form-group">
					<label for="inputId">Código</label> <input type="text"
						name="idleitura" class="form-control" value="${aluno.id}"
						id="inputId" readonly="readonly">
				</div>
			</c:if>
			<div class="form-group">
				<label for="inputEmail">Email address</label> <input type="text"
					name="email" class="form-control" value="${aluno.email}"
					id="inputEmail" placeholder="Email">
			</div>
			<div class="form-group">
				<label for="inputNome">Nome</label> <input type="text" name="nome"
					class="form-control" id="inputNome" value="${aluno.nome}"
					placeholder="Nome">
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="noticias"
					${aluno.noticias ? "checked":""}> Desejo receber notícias
				</label>
			</div>
			<button type="submit" class="btn btn-success">Salvar</button>
			<button type="reset" class="btn btn-default">Restaurar</button>
		</form>
	</div>

	<%@include file="fragmentos/rodape.jsp"%>
</body>
</html>