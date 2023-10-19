# Docket-creation

The form data such as name, startTime, endTime, etc., from the form submitted by the user. Additionally, the supplier and purchaseOrder fields in the form dropdowns should be populated from the data in the CSV file.

index.jsp file contains the HTML form. The suppliers' data is populated in the dropdown using JSTL (<c:forEach>). The purchase order dropdown will be populated dynamically using JavaScript, and the JavaScript code for this part is included in the script.js file. You would include the TypeScript code in script.ts, and then compile it to JavaScript (script.js) using a TypeScript compiler.

Make sure to replace ${purchaseOrders} with the actual data sent from the server. Also, include the compiled JavaScript file script.js in your index.jsp file.
