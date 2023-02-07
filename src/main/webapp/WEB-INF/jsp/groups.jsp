<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
	<div class="col-lg-6 mx-auto">
	<div class="panel panel-primary" id="groupPanel">
		<div class="panel-heading" id="panelTitle"></div>
		<div class="panel-body">
			<form id="groupForm" name="groupForm">
				
					
						<div class="row" id="idfield">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="id">ID</label> <input type="text"
										readonly="readonly" class="form-control" id="groupId" name="groupId">
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Group Name</label> <input type="text"
										class="form-control" id="groupName" name="groupName"
										placeholder="Enter Group Name">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Code</label> <input type="text"
										class="form-control" id="groupCode" name="groupCode"
										placeholder="Enter Group Code">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<button type="button" id="saveGroup" class="btn btn-primary">Create</button>
								<button type="button" id="updateGroup" onclick="updateGroupbtn();" class="btn btn-primary">Update</button>
							</div>
						</div>
					
			</form>
		</div>
	</div>
	</div>
	</div>
	
	<button type="button" id="addNewGroup" onclick="newGroupbtn();" class="btn btn-success">Add New</button>
	
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Code</th>
								<th scope="col"></th>
								<th scope="col"></th>
							
							</tr>
						</thead>
						<tbody id="tbl_GroupList">
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
			
			$('#addNewGroup').show();
			$('#groupPanel').hide();
			$('#saveGroup').click(function() {
				$.ajax({
					type : "POST",
					url : "insertGroup",
					data : {
						groupId : $("#groupId").val(),
						groupName : $("#groupName").val(),
						groupCode : $("#groupCode").val()
					},
					success : function(result) {
						getAllrecord();
						
						$('#groupPanel').hide();
						$('#addNewGroup').show();
						$('#groupForm')[0].reset()
						
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
				url : "getGroupList",
				success : function(response) {
					data = response

					$('.tr').remove();
					
					for (i = 0; i < data.length; i++) {
						$("#tbl_GroupList").append(
								'<tr class="tr"> <td>' + data[i].groupId
										+ '</td> <td>' + data[i].groupName
										+ '</td> <td>' + data[i].groupCode
										+ '</td> <td><input type="button" class="btn btn-warning" onclick="editGroup('
										+ data[i].groupId
										+ ');"  value="Edit"></input>'
										+ '</td> <td> <input type="button" class="btn btn-danger" onclick="deleteGroup(' 
										+ data[i].groupId + ');" value="Delete"></input></td> </tr>');
					}
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function editGroup(id) {
			
			$.ajax({
				type : "GET",
				url : "group/edit/" + id,
				dataType : 'json',
				success : function(response) {
						
					 $("#groupId").val(response.groupId);
					 $("#groupName").val(response.groupName);
					 $("#groupCode").val(response.groupCode);
 
					const div = document.getElementById("panelTitle");
					div.innerHTML = "Edit Group Form";
					$('#groupPanel').show();
					$('#saveGroup').hide();
					$('#updateGroup').show();
					$('#addNewGroup').show();
					$('#idfield').show();
					
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function newGroupbtn()
		{
			const div = document.getElementById("panelTitle");
			div.innerHTML = "Create Group Form";
			$('#groupPanel').show();
			$('#saveGroup').show();
			$('#updateGroup').hide();
			$('#addNewGroup').hide();
			$('#idfield').hide();
			$('#groupForm')[0].reset()
		}
		
		function updateGroupbtn() {

			$.ajax({
				type : "PATCH",
				url : "updateGroup",
				data : {
					groupId : $("#groupId").val(),
					groupName : $("#groupName").val(),
					groupCode : $("#groupCode").val()
				},
				success : function(result) {
					
					getAllrecord();
					$('#groupPanel').hide();
					$('#saveGroup').hide();
					$('#updateGroup').hide();
					$('#addNewGroup').show();
					$('#idfield').hide();
					$('#groupForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function deleteGroup(id) {
			$.ajax({
				type : "DELETE",
				url : "group/" + id,
				success : function(response) {
					getAllrecord();
					$('#groupPanel').hide();
					$('#saveGroup').hide();
					$('#updateGroup').hide();
					$('#addNewGroup').show();
					$('#idfield').hide();
					$('#groupForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		
	</script>