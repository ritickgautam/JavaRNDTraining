<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User Home</title>
</head>
<body>
<c:import url="header.jsp"></c:import>
<c:import url="menu.jsp"></c:import>
<c:import url="footer.jsp"></c:import>
<c:if test="${param.act eq 'add' }">
		<h2>Inside Add Product</h2>
				<div class="panel-body">
			<form id="addProductForm" action="addProduct" class="form-horizontal"
				role="form">

				<div class="form-group">
					<label for="name" class="col-md-3 control-label">Product Name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="pname"
							placeholder="Product-Name">
					</div>
				</div>


				<div class="form-group">
					<label for="price" class="col-md-3 control-label">Price</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="price" 
							placeholder="Price">
					</div>
				</div>


				<div class="form-group">
					<label for="quantity" class="col-md-3 control-label">Quantity in Stock</label>
					<div class="col-md-9">
						<input type="number" class="form-control" name="quantity" 
							placeholder="Quantity in Stock">
					</div>
				</div>
				
				<div class="form-group">
					<label for="text" class="col-md-3 control-label">Vendor</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="vendor" 
							placeholder="Name of Vendor">
					</div>
				</div>
				
				<div class="form-group">
					<label for="warranty" class="col-md-3 control-label">Warranty</label>
					<div class="col-md-9">
						<input type="number" class="form-control" name="warranty" 
							placeholder="Warranty">
					</div>
				</div>

				
				<div class="form-group">
					<!-- Button -->
					<div class="col-md-offset-3 col-md-9">
					<button type="submit" form="addProductForm" value="Save">Save</button>
					</div>
				</div>
			</form>
		</div>
	</c:if>
<c:if test="${param.act eq 'show' }">
		<h2>Inside Show Product</h2>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>productId</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Vendor</th>
						<th>Quantity</th>
						<th>Warranty</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${sessionScope.products}"
						varStatus="c">
						<tbody>
							<tr>
								<td>${product.pid}</td>
								<td>${product.pName}</td>
								<td>${product.price}</td>
								<td>${product.vendor}</td>
								<td>${product.quantity}</td>
								<td>${product.warranty}</td>
								<td><a href="editProduct?act=${product.pid}">Edit | </a> <a
									href="deleteProduct?act=${product.pid}">Delete</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</c:if>
	
<c:if test="${param.act eq 'edit' }">
		<h2>Inside Add Product</h2>
				<div class="panel-body">
			<form id="editProductForm" action="update" class="form-horizontal"
				role="form">

				<div class="form-group">
					<label for="name" class="col-md-3 control-label">Product Name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="pname" value="${product.pName}"
							placeholder="Product-Name">
					</div>
				</div>


				<div class="form-group">
					<label for="price" class="col-md-3 control-label">Price</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="price" value="${product.price}"
							placeholder="Price">
					</div>
				</div>


				<div class="form-group">
					<label for="quantity" class="col-md-3 control-label">Quantity in Stock</label>
					<div class="col-md-9">
						<input type="number" class="form-control" name="quantity" value="${product.quantity}"
							placeholder="Quantity in Stock">
					</div>
				</div>
				
				<div class="form-group">
					<label for="text" class="col-md-3 control-label">Vendor</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="vendor" value="${product.vendor}"
							placeholder="Name of Vendor">
					</div>
				</div>
				
				<div class="form-group">
					<label for="warranty" class="col-md-3 control-label">Warranty</label>
					<div class="col-md-9">
						<input type="number" class="form-control" name="warranty" value="${product.warranty}"
							placeholder="Warranty">
					</div>
				</div>

				
				<div class="form-group">
					<!-- Button -->
					<div class="col-md-offset-3 col-md-9">
					
					<c:if test="${sessionScope.product.pid!=null}">
					<button type="submit" form="editProductForm"  name="b1" value="Update">Update</button>
					<button type="submit" form="editProductForm"  name="b2" value="Cancel">Cancel</button>
					
					</c:if>
					</div>
				</div>
			</form>
		</div>
	</c:if>
</body>
</html>