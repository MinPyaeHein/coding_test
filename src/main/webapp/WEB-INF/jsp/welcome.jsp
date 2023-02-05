<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
	<div class="col-lg-6 mx-auto">
	<div class="panel panel-primary">
		<div class="panel-heading">Department Create Form</div>
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
									<label for="name">Description</label> <input type="text"
										class="form-control" id="desc" name="desc"
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
	
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Description</th>
							
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
			
			$('#saveDepartment').show();
			$('#updateDepartment').hide();
			$('#idfield').hide();

			$('#saveDepartment').click(function() {
				$.ajax({
					type : "POST",
					url : "insertDepartment",
					data : {

						depId : $("#depId").val(),
						depName : $("#depName").val(),
						desc : $("#desc").val()
					},
					success : function(result) {
						getAllrecord();
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
										+ '</td> <td>' + data[i].desc
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
					 $("#desc").val(response.desc)
					 
					$('#saveDepartment').hide();
					$('#updateDepartment').show();
					$('#idfield').show();
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function updateDepartmentbtn() {

			$.ajax({
				type : "PATCH",
				url : "updateDepartment",
				data : {
					depId : $("#depId").val(),
					depName : $("#depName").val(),
					desc : $("#desc").val()
				},
				success : function(result) {
					
					getAllrecord();
					
					$('#saveDepartment').show();
					$('#updateDepartment').hide();
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
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		
	</script>