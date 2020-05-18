<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<style>
	.btn-cadastrar{
		margin-right: 7px;
	}
	.top{
		margin-top: 7px;
	 }
</style>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
      </button>
      <a class="navbar-brand" href="#"><spring:message code="views.menu.pizzaria"/></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="pizzarias">Pizzarias</a></li>
        
        <li><a href="?lang=pt_BR">
        		<img alt="Portugues" src="${path}/static/img/br.png" style="height: 25px">
        	</a>
        </li>
        <li><a href="?lang=en_US">
        		<img alt="Ingles" src="${path}/static/img/us.png" style="height: 25px">
        	</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li>
      		<button type="submit" class="btn btn-primary btn-cadastrar top">Me cadastrar</button>
      	</li>
      	<li>
      		<button type="submit" class="btn btn-primary top">Entrar</button>
      	</li>
      </ul>
    </div>
  </div>
</nav>