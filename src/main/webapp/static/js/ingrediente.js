$(document).ready(function(){
	aplicarListerners();
});

var aplicarListerners = function() {
	$('.btn-excluir').on('click', function() {
		var id = $(this).parents('tr').data('id');
		
		$.ajax({
			url: 'ingredientes/' + id,
			type: 'DELETE',
			success: function(result){
				$('tr[data-id="' + id + '"]').remove();
			}
		});
	});
	
	$('#btn-salvar').on('click', function(){
		var url = '/pizzaria/ingredientes';
		var dadosIngredientes = $('#form-ingrediente').serialize();
		
		$.post(url, dadosIngredientes)
			.done(function(pagina) {
				$("#secao-ingredientes").html(pagina);
				aplicarListerners();
			})
			.fail(function() {
				alert("Erro ao salvar.");
			})
			.always(function() {
				$("#modal-ingrediente").modal('hide');
			});
	});
	
	
}