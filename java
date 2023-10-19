import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createDocket")
public class CreateDocketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String CSV_FILE_PATH = "/path/to/your/supplier_data.csv";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Map<String, String>> suppliersData = readCSVFile(CSV_FILE_PATH);
        request.setAttribute("suppliers", suppliersData);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String hours = request.getParameter("hours");
        String rate = request.getParameter("rate");
        String supplier = request.getParameter("supplier");
        String purchaseOrder = request.getParameter("purchaseOrder");

        // Create docket or save the data as needed (this is a simplified example)
        // You would typically store the data in a database

        // Forward to a confirmation page
        Docket docket = new Docket(name, startTime, endTime, hours, rate, supplier, purchaseOrder);
        request.setAttribute("docket", docket);

        RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
        dispatcher.forward(request, response);
    }

    private List<Map<String, String>> readCSVFile(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (headers == null) {
                    headers = values;
                } else {
                    Map<String, String> row = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        row.put(headers[i], values[i]);
                    }
                    data.add(row);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}

