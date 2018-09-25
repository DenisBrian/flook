package br.com.flook.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.DialogNodeOutputOptionsElement;
import com.ibm.watson.developer_cloud.conversation.v1.model.DialogRuntimeResponseGeneric;
import com.ibm.watson.developer_cloud.conversation.v1.model.ExampleCollection;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.ListExamplesOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.OutputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.RuntimeIntent;

import javafx.util.Pair;

/**
 * Servlet implementation class BotServlet
 */
@WebServlet("/botServlet")
public class BotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<Pair<String, String>> conversa = new ArrayList<Pair<String, String>>();

	public BotServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pergunta = request.getParameter("pergunta");
		String start = request.getParameter("start");
		HttpSession session = request.getSession();

		if (start == "") {
			conversa = new ArrayList<Pair<String, String>>();
			session.setAttribute("service", null);
			session.setAttribute("context", null);
		}

		Object ctxSession = session.getAttribute("context");
		Object srvSession = session.getAttribute("service");

		Conversation service = null;
		if (srvSession == null)
			service = WatsonIBM();
		else
			service = (Conversation) srvSession;

		Context context = null;
		if (ctxSession == null)
			context = new Context();
		else
			context = (Context) ctxSession;

		String workspaceId = "34349454-2196-4471-8736-fb0d42979888";

		MessageResponse resp = null;

		if (context.getConversationId() == null)
			resp = startConversationAPI(service, workspaceId, pergunta);
		else
			resp = conversationAPI(service, workspaceId, pergunta, context);

		String resposta = gerarResposta(resp);

		context = resp.getContext();

		Pair<String, String> dialogo = new Pair<>(pergunta, resposta);
		conversa.add(dialogo);
		request.setAttribute("items", conversa);
		request.setAttribute("start", "F");
		session.setAttribute("service", service);
		session.setAttribute("context", context);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public static Conversation WatsonIBM() {
		Conversation service = new Conversation("2018-09-20");
		service.setUsernameAndPassword("7882e3d3-ae6e-4e5a-bbed-cb35427fdf51", "2hmrrVvERh6z");

		return service;
	}

	public static MessageResponse startConversationAPI(Conversation service, String workspaceId, String input) {
		MessageOptions options = new MessageOptions.Builder(workspaceId).build();
		MessageResponse response = service.message(options).execute();
		return response;
	}

	public static MessageResponse conversationAPI(Conversation service, String workspaceId, String inputText,
			Context context) {

		InputData input = new InputData.Builder(inputText).build();
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).context(context).build();
		MessageResponse response = service.message(options).execute();
		return response;
	}

	public static String gerarResposta(MessageResponse resp) {
		List<RuntimeIntent> responseIntents = resp.getIntents();

		if (responseIntents.size() > 0) {
			System.out.println("Detected intent: #" + responseIntents.get(0).getIntent());
		}

		String resposta = "";

		OutputData out = resp.getOutput();
		List<String> responseText = out.getText();

		int size = responseText.size();
		if (responseText.size() > 0) {
			for (int x = 0; x < size; x++) {
				resposta += "<p>" + responseText.get(x) + "</p>";
			}
		}

		List<DialogRuntimeResponseGeneric> dialogs = resp.getOutput().getGeneric();

		if (dialogs != null) {
			for (DialogRuntimeResponseGeneric dialog : dialogs) {

				char t = dialog.getResponseType().charAt(0);
				if (t == 'o') {
					resposta += "<p><b>" + dialog.getTitle() + "</b></p>";
					for (DialogNodeOutputOptionsElement option : dialog.getOptions()) {
						resposta += "<p> <a href='#' class='chat-option'>" + option.getLabel() + "</a> </p>";
					}
				}
			}
		}

		return resposta;
	}

}
