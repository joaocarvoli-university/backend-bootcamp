package br.ufc.mandacaru;

import br.ufc.mandacaru.model.*;
import br.ufc.mandacaru.config.ThymeleafConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TemplateEngine templateEngine = (TemplateEngine) getServletContext().getAttribute(ThymeleafConfig.TEMPLATE_ENGINE_ATTR);
		IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);
		WebContext context = new WebContext(webExchange);

		Address address = new Address("Rua Zacarias Carlos de Melo" , "63700-000");
		Person person = new Person(1, "Almada", address);
		context.setVariable("person", person);
		templateEngine.process("hello", context, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
