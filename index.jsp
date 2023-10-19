<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Docket</title>
</head>
<body>
    <form action="createDocket" method="post">
        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Start Time:</label>
        <input type="text" name="startTime" required><br>

        <label>End Time:</label>
        <input type="text" name="endTime" required><br>

        <label>No. of Hours:</label>
        <input type="text" name="hours" required><br>

        <label>Rate per Hour:</label>
        <input type="text" name="rate" required><br>

        <label>Supplier Name:</label>
        <select name="supplier">
            <c:forEach var="supplier" items="${suppliers}">
                <option value="${supplier['supplier_name']}">${supplier['supplier_name']}</option>
            </c:forEach>
        </select><br>

        <label>Purchase Order:</label>
        <select name="purchaseOrder">
            <!-- This dropdown will be populated dynamically using JavaScript -->
        </select><br>

        <input type="submit" value="Submit">
    </form>

    <script src="script.js"></script>
</body>
</html>
