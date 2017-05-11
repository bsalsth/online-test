var contextRoot = "/" + window.location.pathname.split('/')[1];
$(function() {

	$("#category").change(function() {
		var id = $("#category").val();

		$.ajax({

			type : 'GET',
			url : contextRoot + "/question/getSubCategoryList/" + id,
			data : {},
			datatype : "json",
			contentType : 'application/json',
			success : function(response) {
				alert(response)
				displaySubCategory(response);
			},
			error : function() {
				alert('Error while request...');
			}

		});
	});

	function displaySubCategory(categorylist) {
		$('#subcategory').empty();

		$.each(categorylist, function(k, v) {
			$('#subcategory').append(
					'<option value="' + v.subCatId + '">' + v.description
							+ '</option>');
		})
	}
})