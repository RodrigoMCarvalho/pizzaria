<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${titulo}</title>

	<c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
		<style type="text/css">
			@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
			@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
		</style>
</head>
<body>
	<c:if test="${not empty mensagemErro}">
		<div class="container" style="margin-top: 10px">
			<div class="alert alert-danger">${mensagemErro}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    			<span aria-hidden="true">&times;</span>
	  			</button>
  			</div>
		</div>
	</c:if>
	<c:if test="${not empty mensagemSucesso}">
		<div class="container" style="margin-top: 10px">
			<div class="alert alert-success">${mensagemSucesso}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    			<span aria-hidden="true">&times;</span>
	  			</button>
  			</div>
		</div>
	</c:if>
	
	<section class="container" id="secao-ingredientes" style="margin-top: 10px">
		<jsp:include page="tabela-ingredientes.jsp"/>
	</section>
	
	<jsp:include page="modal-ingredientes.jsp"/>
	
	<script type="text/javascript" src="${path}/static/js/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/static/js/ingrediente.js"></script>
	
</body>
</html>