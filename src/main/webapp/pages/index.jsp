<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Reports app</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" 
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
    crossorigin="anonymous">
  </head>
  <body>

	<div class="container">

		<h3 class="mb-3 pb-3 pt-3">ReportApplication</h3>
		
		

		<div>
    <form:form action="search" modelAttribute="search" method="POST">
        <table>
					<tr>
						<td>Plan Name:</td>
						<td><form:select path="planName">
								<form:option value="">-Select-</form:option>
								<form:options items="${names }" />
							</form:select></td>




						<td>Plan Status:</td>
						<td><form:select path="planStatus">
								<form:option value="">-Select-</form:option>
								<form:options items="${Status}" />
							</form:select></td>



						<td>Gender:</td>
						<td><form:select path="gender">
								<form:option value="">-Select-</form:option>
								<form:option value="Male">Male</form:option>
								<form:option value="Fe-Male">Fe-male</form:option>
							</form:select></td>
						<br />
					
						
								<tr>
						<td>StartDate:</td>
						<td><form:input path="planStartDate" type="date" /></td>

						<td>EndDate:</td>
						<td><form:input path="planEndDate" type="date" /></td>
						</tr>
					  

					<tr>
           		<td><input type="submit" value ="Search" class="btn btn-primary"></td>
           		</tr>
            
            </tr>
        </table>
        
    </form:form>
    
    <hr/>


<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Holder Name</th>
            <th>Gender</th>
            <th>Plan Name</th>
            <th>Plan Status</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Benefit Amount</th>
        </tr>
    </thead>
   
    <tbody>
    
    <c:forEach items="${plans}" var="plan">
    
    <tr>
    <td>${plan.citizenId }</td>
    <td>${plan.citizenName }</td>
    <td>${plan.gender}</td>
    <td>${plan.planName }</td>
    <td>${plan.planStatus }</td>
    <td>${plan.planStartDate}</td>
    <td>${plan.planEndDate}</td>
    <td>${plan.benefitAmt}</td>
    
    </tr>
    </c:forEach>
    <tr>
    
    <c:if test="${empty plans }">
    
    	<td colspan="8" style="text-aline: center">No record found</td>
    </c:if>
    
    
    </tr>
    
    
    
    </tbody>
    
    
</table>


			Export : <a href="excel">Excel</a> <a href="pdf">pdf</a>
</div>
</div>


	
	
	<script 
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
    crossorigin="anonymous"></script>
  </body>
</html>
