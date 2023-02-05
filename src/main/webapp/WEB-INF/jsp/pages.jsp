<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
	<div class="col-lg-6 mx-auto">
	<div class="panel panel-primary" id="pagePanel">
		<div class="panel-heading" id="panelTitle"></div>
		<div class="panel-body">
			<form id="pageForm" name="pageForm">
				
						<div class="row" id="idfield">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="id">ID</label> <input type="text"
										readonly="readonly" class="form-control" id="pageId" name="pageId">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Page Name</label> <input type="text"
										class="form-control" id="pageName" name="pageName"
										placeholder="Enter Page Name">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Code</label> <input type="text"
										class="form-control" id="pageCode" name="pageCode"
										placeholder="Enter Code">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Page Description</label> <input type="text"
										class="form-control" id="pageDesc" name="pageDesc"
										placeholder="Enter Description">
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="col-lg-10">
								<button type="button" id="savePage" class="btn btn-primary">Create</button>
								<button type="button" id="updatePage" onclick="updatePagebtn();" class="btn btn-primary">Update</button>
							</div>
						</div>
					
			</form>
		</div>
	</div>
	</div>
	</div>
	
	<button type="button" id="addNewPage" onclick="newPagebtn();" class="btn btn-success">Add New</button>
	
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
						<thead>
							<tr>
							
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Code</th>
								<th scope="col">Description</th>
								<th scope="col"></th>
								<th scope="col"></th>
							
							</tr>
						</thead>
						<tbody id="tbl_pageList">
					</tbody>
				</table>
			</div>
		</div>
</div>

	<%@ include file="common/footer.jspf"%>

	<script>
		var data = "";
		$(document).ready(function() {

			getAllrecord();
			
			$('#addNewPage').show();
			$('#pagePanel').hide();


			$('#savePage').click(function() {
				$.ajax({
					type : "POST",
					url : "insertPage",
					data : {
						
						pageId : $("#pageId").val(),
						pageName : $("#pageName").val(),
						pageCode : $("#pageCode").val(),
						pageDesc : $("#pageDesc").val()
					},
					success : function(result) {
						getAllrecord();
						
						$('#pagePanel').hide();
						$('#addNewPage').show();
						$('#pageForm')[0].reset()
						
					},
					error : function(err) {
						alert("error is" + err)
					}
				});
			});

		});

		function getAllrecord() {
			$.ajax({
				type : "GET",
				url : "getPageList",
				success : function(response) {
					data = response

					$('.tr').remove();
					
					for (i = 0; i < data.length; i++) {
						$("#tbl_pageList").append(
								'<tr class="tr"> <td>' + data[i].pageId
										+ '</td> <td>' + data[i].pageName
										+ '</td> <td>' + data[i].pageCode
										+ '</td> <td>' + data[i].pageDesc
										+ '</td> <td><input type="button" class="btn btn-warning" onclick="editPage('
										+ data[i].pageId
										+ ');"  value="Edit"></input>'
										+ '</td> <td> <input type="button" class="btn btn-danger" onclick="deletePage(' 
										+ data[i].pageId + ');" value="Delete"></input></td> </tr>');
					}
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function editPage(id) {
			
			$.ajax({
				type : "GET",
				url : "page/edit/" + id,
				dataType : 'json',
				success : function(response) {
						
					 $("#pageId").val(response.pageId),
					 $("#pageName").val(response.pageName), 
					 $("#pageCode").val(response.pageCode), 
					 $("#pageDesc").val(response.pageDesc)
					 
					const div = document.getElementById("panelTitle");
					div.innerHTML = "Edit Page Form";
					
					$('#pagePanel').show();
					$('#savePage').hide();
					$('#updatePage').show();
					$('#addNewPage').show();
					$('#idfield').show();
					
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function newPagebtn()
		{
			const div = document.getElementById("panelTitle");
			div.innerHTML = "Create Page Form";
			$('#pagePanel').show();
			$('#savePage').show();
			$('#updatePage').hide();
			$('#addNewPage').hide();
			$('#idfield').hide();
			$('#pageForm')[0].reset()
		}
		
		function updatePagebtn() {

			$.ajax({
				type : "PATCH",
				url : "updatePage",
				data : {
					pageId : $("#pageId").val(),
					pageName : $("#pageName").val(),
					pageCode : $("#pageCode").val(),
					pageDesc : $("#pageDesc").val()
				},
				success : function(result) {
					
					getAllrecord();
					$('#pagePanel').hide();
					$('#savePage').hide();
					$('#updatePage').hide();
					$('#addNewPage').show();
					$('#idfield').hide();
					$('#pageForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function deletePage(id) {
			$.ajax({
				type : "DELETE",
				url : "page/" + id,
				success : function(response) {
					getAllrecord();
					$('#pagePanel').hide();
					$('#savePage').hide();
					$('#updatePage').hide();
					$('#addNewPage').show();
					$('#idfield').hide();
					$('#pageForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		
	</script>