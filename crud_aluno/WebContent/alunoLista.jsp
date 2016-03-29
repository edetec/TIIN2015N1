<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="alunoRN"
	class="br.senai.sc.ti20151n1.pwa.crudaluno.modelo.AlunoRN" />

<!DOCTYPE html>
<html>
<head>
<title>CRUD Aluno</title>
<%@include file="fragmentos/cabecalho.jsp"%>
</head>
<body>
	<%@include file="fragmentos/menu.jsp"%>

	<div class="col-md-6">
		<h1>Lista de aluno</h1>
		<c:if test="${ not empty msg }">
			<div class="alert alert-${ msg.tipo}">${msg.texto}</div>
		</c:if>
		<table class="table">
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Notícias</th>
				<th><span class="glyphicon glyphicon-wrench"></span></th>
			</tr>
			<tbody>
				<c:forEach var="aluno" items="${alunoRN.listar()}">
					<tr>
						<td>${aluno.nome}</td>
						<td>${aluno.email}</td>
						<td>${ aluno.noticias ? "Sim" : "Não" }</td>
						<td><a href="alunocontrole?cmd=deletar&id=${aluno.id}"
							onclick="return confirm('Tem certeza de que quer excluir o aluno ${aluno.nome}')"><span
								class="glyphicon glyphicon-trash"> </span></a> <a
							href="alunocontrole?cmd=editar&id=${aluno.id}"><span
								class="glyphicon glyphicon-edit"> </span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<%@include file="fragmentos/rodape.jsp"%>
</body>
</html>