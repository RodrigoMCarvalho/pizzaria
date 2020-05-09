<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<fmt:setLocale value="pt_BR"/>
<table class="table table-hover table-condensed table-striped table-bordered" id="tbl-pizzas" style="width: 800px" >
	<thead>
		<tr>
			<td style="width: 20px; text-align: center"># </td>
			<td style="width: 80px; text-align: center">Nome </td>
			<td style="width: 80px; text-align: center">Preço </td>
			<td style="width: 80px; text-align: center">Categoria </td>
			<td style="width: 80px; text-align: center">Ingredientes </td>
			<td style="width: 10px; text-align: center">Ações </td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pizzas}" var="pizza">
		<tr data-id="${pizza.id}">
			<td>${pizza.id}</td>
			<td>${pizza.nome}</td>
			<td>
				<fmt:formatNumber value="${pizza.preco}" type="currency"/>
			</td>
			<td>${pizza.categoria}</td>
			<td>
				<c:forEach items="${pizza.ingredientes}" var="ingrediente">
					${ingrediente.nome}
				</c:forEach>
			</td>
			<td style="text-align: center">
				<button type="button" class="btn btn-warning btn-editar">Editar</button>
				<button style="margin-left: 10px" type="button" class="btn btn-danger btn-excluir">Excluir</button>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3">Quantidade de Pizzas cadastrados: <span id="quantidade-pizzas">${pizzas.size()}</span></td>
		</tr>
		<tr>
			<td colspan="3">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-pizza">
						Cadastrar pizza
				</button>
			</td>
		</tr>
	</tfoot>
</table>