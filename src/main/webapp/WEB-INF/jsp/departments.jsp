<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
	<div class="col-lg-6 mx-auto">
	<div class="panel panel-primary" id="departmentPanel">
		<div class="panel-heading" id="panelTitle"></div>
		<div class="panel-body">
			<form id="departmentForm" name="departmentForm">
				
					
						<div class="row" id="idfield">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="id">ID</label> <input type="text"
										readonly="readonly" class="form-control" id="depId" name="depId">
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Department Name</label> <input type="text"
										class="form-control" id="depName" name="depName"
										placeholder="Enter Department Name">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Code</label> <input type="text"
										class="form-control" id="depCode" name="depCode"
										placeholder="Enter  Code">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Description</label> <input type="text"
										class="form-control" id="depDesc" name="depDesc"
										placeholder="Enter  Description">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<button type="button" id="saveDepartment" class="btn btn-primary">Create</button>
								<button type="button" id="updateDepartment" onclick="updateDepartmentbtn();" class="btn btn-primary">Update</button>
							</div>
						</div>
					
			</form>
		</div>
	</div>
	</div>
	</div>
	
	<button type="button" id="addNewDepartment" onclick="newDepartmentbtn();" class="btn btn-success">Add New</button>
	
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
						<tbody id="tbl_DeptList">
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
			
			$('#addNewDepartment').show();
			$('#departmentPanel').hide();
			$('#saveDepartment').click(function() {
				$.ajax({
					type : "POST",
					url : "insertDepartment",
					data : {

						depId : $("#depId").val(),
						depName : $("#depName").val(),
						depCode : $("#depCode").val(),
						depDesc : $("#depDesc").val()
					},
					success : function(result) {
						getAllrecord();
						
						$('#departmentPanel').hide();
						$('#addNewDepartment').show();
						$('#departmentForm')[0].reset()
						
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
				url : "getDeptlList",
				success : function(response) {
					data = response

					$('.tr').remove();
					
					for (i = 0; i < data.length; i++) {
						$("#tbl_DeptList").append(
								'<tr class="tr"> <td>' + data[i].depId
										+ '</td> <td>' + data[i].depName
										+ '</td> <td>' + data[i].depCode
										+ '</td> <td>' + data[i].depDesc
										+ '</td> <td><input type="button" class="btn btn-warning" onclick="editDepartment('
										+ data[i].depId
										+ ');"  value="Edit"></input>'
										+ '</td> <td> <input type="button" class="btn btn-danger" onclick="deleteDepartment(' 
										+ data[i].depId + ');" value="Delete"></input></td> </tr>');
					}
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function editDepartment(id) {
			
			$.ajax({
				type : "GET",
				url : "departments/edit/" + id,
				dataType : 'json',
				success : function(response) {
					
						
						
					 $("#depId").val(response.depId),
					 $("#depName").val(response.depName), 
					 $("#depCode").val(response.depCode), 
					 $("#depDesc").val(response.depDesc)
					 
					 
					const div = document.getElementById("panelTitle");
					div.innerHTML = "Edit Department Form";
					$('#departmentPanel').show();
					$('#saveDepartment').hide();
					$('#updateDepartment').show();
					$('#addNewDepartment').show();
					$('#idfield').show();
					
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function newDepartmentbtn()
		{
			const div = document.getElementById("panelTitle");
			div.innerHTML = "Create Department Form";
			$('#departmentPanel').show();
			$('#saveDepartment').show();
			$('#updateDepartment').hide();
			$('#addNewDepartment').hide();
			$('#idfield').hide();
			$('#departmentForm')[0].reset()
		}
		
		function updateDepartmentbtn() {

			$.ajax({
				type : "PATCH",
				url : "updateDepartment",
				data : {
					depId : $("#depId").val(),
					depName : $("#depName").val(),
					depCode : $("#depCode").val(),
					depDesc : $("#depDesc").val()
				},
				success : function(result) {
					
					getAllrecord();
					$('#departmentPanel').hide();
					$('#saveDepartment').hide();
					$('#updateDepartment').hide();
					$('#addNewDepartment').show();
					$('#idfield').hide();
					$('#departmentForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function deleteDepartment(id) {
			$.ajax({
				type : "DELETE",
				url : "departments/" + id,
				success : function(response) {
					getAllrecord();
					$('#departmentPanel').hide();
					$('#saveDepartment').hide();
					$('#updateDepartment').hide();
					$('#addNewDepartment').show();
					$('#idfield').hide();
					$('#departmentForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		
	</script>