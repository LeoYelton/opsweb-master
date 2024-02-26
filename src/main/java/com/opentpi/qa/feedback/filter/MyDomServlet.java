package com.opentpi.qa.feedback.filter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;


@SuppressWarnings("serial")
public class MyDomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        String tmp = "";
        if (data != null) {
            try {
                SAXReader reader = new SAXReader();
                Document document = reader.read(new InputSource(new StringReader(data)));
                Element root = document.getRootElement();
                Element test = root.element("foo");
                tmp = test.getText();
                resp.getWriter().println(tmp);
            } catch (Exception e) {
                resp.getWriter().println(e);
            }
        }
    }
}