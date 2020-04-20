<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<table class="table table-hover table-condensed table-striped table-bordered" id="tbl-ingredientes" style="width: 800px" >
			<thead>
				<tr>
					<td style="width: 20px; text-align: center"># </td>
					<td style="width: 80px; text-align: center">Nome </td>
					<td style="width: 80px; text-align: center">Categoria </td>
					<td style="width: 10px; text-align: center">Ações </td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingredientes}" var="ingrediente">
				<tr data-id="${ingrediente.id}">
					<td>${ingrediente.id}</td>
					<td>${ingrediente.nome}</td>
					<td>${ingrediente.categoria}</td>
					<td style="text-align: center"><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button style="margin-left: 10px" type="button" class="btn btn-danger btn-excluir">Excluir</button></td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">Quantidade de ingredientes cadastrados: <span id="quantidade-ingrediente">${ingredientes.size()}</span></td>
				</tr>
				<tr>
					<td colspan="3">
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-ingrediente">
  						Cadastrar ingrediente
						</button>
						<a class="btn btn-primary"  href="pizzas">Pizzas</a>
					</td>
				</tr>
			</tfoot>
		</table>