<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<style>
	.btn-sair{
		margin-top: 7px;
	}
</style>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
      </button>
      <a class="navbar-brand" href="#">Pizzaria</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="pizzas">Pizzas</a></li>
        <li><a href="ingredientes">Ingredientes</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li>
			<form action="${path}/sair" method="post">
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<button type="submit" class="btn btn-primary btn-sair">Sair</button>
			</form>
      	</li>
      </ul>
    </div>
  </div>
</nav>