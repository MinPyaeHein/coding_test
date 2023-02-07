<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
	<div class="col-lg-6 mx-auto">
	<div class="panel panel-primary" id="staffPanel">
		<div class="panel-heading" id="panelTitle"></div>
		<div class="panel-body">
			<form id="staffForm" name="staffForm">
			
						<div class="row" id="idfield">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="id">ID</label> <input type="text"
										readonly="readonly" class="form-control" id="staffId" name="staffId">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Staff Name</label> <input type="text"
										class="form-control" id="name" name="name"
										placeholder="Enter Staff Name">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Email</label> <input type="text"
										class="form-control" id="email" name="email"
										placeholder="Enter Email">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Password</label> <input type="text"
										class="form-control" id="password" name="password"
										placeholder="Enter Password">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Confirm Password</label> <input type="text"
										class="form-control" id="confirm_password" name="confirm_password"
										placeholder="Enter Confrim Password">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group" id="groupDiv">
									<select id="groupId" class="form-control chosen-select" name="groupId">
									</select>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<label for="id">Please Select Departments</label>
								<div class="form-group" id="deptDiv">
									
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<label for="id">Please Select Pages</label>
								<div class="form-group" id="pageDiv">
									
								</div>
							</div>
						</div>
						
						
						<div class="row" id="idCreatedAt">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="id">Updated At</label> <input type="text"
										readonly="readonly" class="form-control" id="createAt" name="createAt">
								</div>
							</div>
						</div>
						
						
						<div class="row" id="idUpdatedAt">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="id">Created At</label> <input type="text"
										readonly="readonly" class="form-control" id="updateAt" name="updateAt">
								</div>
							</div>
						</div>

						
						<div class="row">
							<div class="col-lg-10">
								<button type="button" id="saveStaff" class="btn btn-primary">Create</button>
								<button type="button" id="updateStaff" onclick="updateStaffbtn();" class="btn btn-primary">Update</button>
							</div>
						</div>
					
			</form>
		</div>
	</div>
	</div>
	</div>
	
	<button type="button" id="addNewStaff" onclick="newStaffbtn();" class="btn btn-success">Add New</button>
	
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
						<thead>
							<tr>
							
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Group</th>
								<th scope="col">Email</th>
								<th scope="col">Status</th>
								<th scope="col">Departments</th>
								<th scope="col">Pages</th>
								<th scope="col">Created At</th>
								<th scope="col">Updated At</th>
								<th scope="col"></th>
								<th scope="col"></th>
							
							</tr>
						</thead>
						<tbody id="tbl_StaffList">
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
			
			const div = document.getElementById("panelTitle");
			div.innerHTML = "Create Staff Form";
			
			$('#staffPanel').hide();
			$('#saveStaff').hide();
			$('#updateStaff').hide();
			$('#addNewStaff').show();
			$('#idUpdatedAt').hide();
			$('#idCreatedAt').hide();
			$('#idfield').hide();
			$('#staffForm')[0].reset();
			$('#saveStaff').click(function() {
				
				$.ajax({
					type : "POST",
					url : "insertStaff",
					data : {
						staffId : $("#staffId").val(),
						groupId: $("#groupId").val(),
						pages: getCheckedBoxes("pages"),
						departments: getCheckedBoxes("departments"),
						name : $("#name").val(),
						email : $("#email").val(),
						password : $("#password").val()
					},
					success : function(result) {
						
						getAllrecord();
						
						console.log($("#pages").val())
						console.log($("#departments").val())
						
						
						$('#addNewStaff').show();
						$('#staffPanel').hide();
						$('#saveStaff').hide();
						$('#updateStaff').hide();
						$('#staffForm')[0].reset()
						
					},
					error : function(err) {
						alert("error is" + err)
					}
				});
			});

		});
		
		function getCheckedBoxes(chkboxName) {
			  var checkboxes = document.getElementsByName(chkboxName);
			  var checkboxesChecked = [];
			 
			  for (var i=0; i<checkboxes.length; i++) {
			    
			     if (checkboxes[i].checked) {
			        checkboxesChecked.push(checkboxes[i].value);
			     }
			  }
			
			  return checkboxesChecked.length > 0 ? checkboxesChecked : null;
		}

		function getAllrecord() {
			$.ajax({
				type : "GET",
				url : "getStaffList",
				success : function(response) {
					data = response

					$('.tr').remove();
					
					for (i = 0; i < data.length; i++) {
						$("#tbl_StaffList").append(
								'<tr class="tr"> <td>' + data[i].staffId
										+ '</td> <td>' + data[i].name
										+ '</td> <td>' + data[i].group.groupName
										+ '</td> <td>' + data[i].email
										+ '</td> <td>' + data[i].accountStatus
										+ '</td> <td>' + data[i].createAt
										+ '</td> <td>' + data[i].updateAt
										+ '</td> <td><input type="button" class="btn btn-warning" onclick="editStaff('
										+ data[i].staffId
										+ ');"  value="Edit"></input>'
										+ '</td> <td> <input type="button" class="btn btn-danger" onclick="deleteStaff(' 
										+ data[i].staffId + ');" value="Delete"></input></td> </tr>');
					}
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function editStaff(id) {
			
			$.ajax({
				type : "GET",
				url : "staff/edit/" + id,
				dataType : 'json',
				success : function(response) {
					
					 $("#staffId").val(response.staffId);
					 $("#name").val(response.name);
					 $("#email").val(response.email);
					 $("#password").val(response.password); 
					 $("#updateAt").val(response.updateAt);
					 $("#createAt").val(response.createAt);
					 $("#accountStatus").val(response.accountStatus);
					 
				
					const div = document.getElementById("panelTitle");
					div.innerHTML = "Edit Staff Form";
					
					$('#staffPanel').show();
					$('#saveStaff').hide();
					$('#updateStaff').show();
					$('#addNewStaff').show();
					$('#idUpdatedAt').show();
					$('#idCreatedAt').show();
					$('#idfield').show();
					
 					prepareGroup(response.group.groupId);
 					preparePage(response.pages);
					prepareDept(response.departments);
					 
			
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		

		
		function newStaffbtn()
		{
			const div = document.getElementById("panelTitle");
			div.innerHTML = "Create Staff Form";
			$('#staffPanel').show();
			$('#saveStaff').show();
			$('#updateStaff').hide();
			$('#addNewStaff').hide();
			$('#idUpdatedAt').hide();
			$('#idCreatedAt').hide();
			$('#idfield').hide();
			$('#staffForm')[0].reset()
			
			preparePage();
			prepareGroup();
			prepareDept();
		}
		
		function updateStaffbtn() {

			$.ajax({
				type : "PATCH",
				url : "updateStaff",
				data : {
					staffId : $("#staffId").val(),
					name : $("#name").val(),
					email : $("#email").val(),
					password : $("#password").val()
				},
				success : function(result) {
					
					getAllrecord();
					$('#staffPanel').hide();
					$('#saveStaff').hide();
					$('#updateStaff').hide();
					$('#addNewStaff').show();
					$('#idfield').hide();
					$('#staffForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function deleteStaff(id) {
			$.ajax({
				type : "DELETE",
				url : "staff/" + id,
				success : function(response) {
					getAllrecord();
					$('#staffPanel').hide();
					$('#saveStaff').hide();
					$('#updateStaff').hide();
					$('#addNewStaff').show();
					$('#idfield').hide();
					$('#staffForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		
		function prepareGroup(params)
		{
			
			$.ajax({
				type : "GET",
				url : "getGroupList",
				success: function(data) {
					$("#groupId").html("");
					var select =  document.getElementById("groupId");

					 $("#groupDiv").html("");
					 
					  for (i = 0; i < data.length; i++) {
						
						  var option = document.createElement("option");
						 
					        option.value = data[i].groupId;
					        option.text = data[i].groupName.charAt(0).toUpperCase() + data[i].groupName.slice(1);
					        if(data[i].groupId == params)
					        	{
					        	option.selected  = true;
					        	}
					        select.appendChild(option);  
						    
					  }
					  
					  	var label = document.createElement("label");
					    label.innerHTML = "Choose your group: "
					    label.htmlFor = "groupId";
					    document.getElementById('groupDiv').appendChild(label).appendChild(select);
					},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		
		function prepareDept(params)
		{
			
			$.ajax({
				type : "GET",
				url : "getDeptlList",
				success: function(data) {
				
					
					 $("#deptDiv").html("");
					  for (i = 0; i < data.length; i++) {
						  var checkbox = document.createElement('input');
						    checkbox.type = 'checkbox';
						    checkbox.id = 'departments';
						    checkbox.name = 'departments';
						    checkbox.value = data[i].depId;
						    if(typeof params !== "undefined"){
						    if(params.includes(data[i].depId.toString()))
						    	{
						    		checkbox.checked = true;
						    	}
						    }
						    
						    var label = document.createElement('label')
						    label.htmlFor = 'departments';
						    label.appendChild(document.createTextNode(data[i].depName));

						    var container = document.getElementById('deptDiv');
						    container.appendChild(checkbox);
						    container.appendChild(label);
						    
					  }
					},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function preparePage(params)
		{
		

			$.ajax({
				type : "GET",
				url : "getPageList",
				success: function(data) {
					
					  $("#pageDiv").html("");
					  for (i = 0; i < data.length; i++) {
						  var checkbox = document.createElement('input');
						    checkbox.type = 'checkbox';
						    checkbox.id = 'pages';
						    checkbox.name = 'pages';
						    checkbox.value = data[i].pageId;
						    if(typeof params !== "undefined"){
						    if(params.includes(data[i].pageId.toString()))
					    	{
					    		checkbox.checked = true;
					    	}
						    }
						    
						    var label = document.createElement('label');
						    label.htmlFor = 'pages';
						    label.appendChild(document.createTextNode(data[i].pageName));

						    var container = document.getElementById('pageDiv');
						    container.appendChild(checkbox);
						    container.appendChild(label);
					  }
					},
				error : function(err) {
					alert("error is" + err)
				}
			});
			
			
		}
		
		
	</script>