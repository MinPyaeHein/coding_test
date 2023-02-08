<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
	<div class="col-lg-6 mx-auto">
	<div class="panel panel-primary" id="loanPanel">
		<div class="panel-heading" id="panelTitle"></div>
		<div class="panel-body">
			<form id="loanForm" name="loanForm">
				
		
					
						<div class="row" id="idfield">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="id">ID</label> <input type="text"
										readonly="readonly" class="form-control" id="loanId" name="loanId">
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Address</label> <input type="text"
										class="form-control" id="address" name="address"
										placeholder="Enter Address">
								</div>
							</div>
						</div>
	
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Apply Date</label> <input type="date"
										class="form-control" id="applyDate" name="applyDate"
										placeholder="Enter Apply Date">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Period</label> 
									 <input type="text"
										class="form-control" id="period" name="period"
										placeholder="Enter Period">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Loan Type</label>
									<select name="loanType" id="loanType" class="form-control">
  										<option value="yearly">Yearly</option>
  										<option value="monthly">Monthly</option>
  										<option value="weekly">Weekly</option>
  										<option value="daily">Daily</option>
									</select>
								</div>
							</div>
						</div>
						
							
						<div class="row">
							<div class="col-lg-10">
								<div class="form-group">
									<label for="name">Amount</label> <input type="text"
										class="form-control" id="amount" name="amount"
										placeholder="Enter Loan Type">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-10">
								<button type="button" id="saveLoan" class="btn btn-primary">Create</button>
								<button type="button" id="updateLoan" onclick="updateLoanbtn();" class="btn btn-primary">Update</button>
							</div>
						</div>
					
			</form>
		</div>
	</div>
	</div>
	</div>
	
	<button type="button" id="addNewLoan" onclick="newLoanbtn();" class="btn btn-success">Add New</button>
	
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Loan Type</th>
								<th scope="col">Period</th>
								<th scope="col">Amount</th>
								<th scope="col">Address</th>
								<th scope="col">Apply Date</th>
								<th scope="col">Staff</th>
								<th scope="col">Department</th>
							</tr>
						</thead>
						<tbody id="tbl_LoanList">
					</tbody>
				</table>
			</div>
		</div>
</div>

	<%@ include file="common/footer.jspf"%>

	<script>
		var data = "";
		
	    $(".date").datepicker({
	        format: "dd/mm/yyyy",
	      });
	    
		$(document).ready(function() {

			getAllrecord();
			
			$('#addNewLoan').show();
			$('#loanPanel').hide();
			$('#saveLoan').click(function() {
				$.ajax({
					type : "POST",
					url : "insertLoan",
					data : {
						loanId : $("#loanId").val(),
						loanType : $("#loanType").val(),
						period : $("#period").val(),
						amount : $("#amount").val(),
						address : $("#address").val(),
						applyDate : $("#applyDate").val()
					},
					success : function(result) {
						getAllrecord();
						
						$('#loanPanel').hide();
						$('#addNewLoan').show();
						$('#loanForm')[0].reset()
						
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
				url : "getLoanList",
				success : function(response) {
					data = response

					$('.tr').remove();
					
					for (i = 0; i < data.length; i++) {
						$("#tbl_LoanList").append(
				
								'<tr class="tr"> <td>' + data[i].loanId
										+ '</td> <td>' + data[i].loanType
										+ '</td> <td>' + data[i].period
										+ '</td> <td>' + data[i].amount
										+ '</td> <td>' + data[i].address
										+ '</td> <td>' + data[i].applyDate
										+ '</td> <td>' + data[i].staff.name
										+ '</td> <td>' + data[i].department.depName
										+ '</td> <td><input type="button" class="btn btn-warning" onclick="editLoan('
										+ data[i].loanId
										+ ');"  value="Edit"></input>'
										+ '</td> <td> <input type="button" class="btn btn-danger" onclick="deleteLoan(' 
										+ data[i].loanId + ');" value="Delete"></input></td> </tr>');
					}
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function editLoan(id) {
			
			$.ajax({
				type : "GET",
				url : "loan/edit/" + id,
				dataType : 'json',
				success : function(response) {
						
						$("#loanId").val(response.loanId),
						$("#loanType").val(response.loanType),
						$("#period").val(response.period),
						$("#amount").val(response.amount),
						$("#address").val(response.address),
						$("#applyDate").val(response.applyDate)
 
					const div = document.getElementById("panelTitle");
					div.innerHTML = "Edit Loan Form";
					$('#loanPanel').show();
					$('#saveLoan').hide();
					$('#updateLoan').show();
					$('#addNewLoan').show();
					$('#idfield').show();
					
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		function newLoanbtn()
		{
			const div = document.getElementById("panelTitle");
			div.innerHTML = "Create Loan Form";
			$('#loanPanel').show();
			$('#saveLoan').show();
			$('#updateLoan').hide();
			$('#addNewLoan').hide();
			$('#idfield').hide();
			$('#loanForm')[0].reset()
		}
		
		function updateLoanbtn() {

			$.ajax({
				type : "PATCH",
				url : "updateLoan",
				data : {
					loanId : $("#loanId").val(),
					loanType : $("#loanType").val(),
					period : $("#period").val(),
					amount : $("#amount").val(),
					address : $("#address").val(),
					applyDate : $("#applyDate").val()
				},
				success : function(result) {
					
					getAllrecord();
					$('#loanPanel').hide();
					$('#saveLoan').hide();
					$('#updateLoan').hide();
					$('#addNewLoan').show();
					$('#idfield').hide();
					$('#loanForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
	  
	  
		
		function deleteLoan(id) {
			$.ajax({
				type : "DELETE",
				url : "loan/" + id,
				success : function(response) {
					getAllrecord();
					$('#loanPanel').hide();
					$('#saveLoan').hide();
					$('#updateLoan').hide();
					$('#addNewLoan').show();
					$('#idfield').hide();
					$('#loanForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});
		}
		
		
	</script>