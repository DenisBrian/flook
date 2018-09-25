package br.com.flook.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.DialogNodeOutputOptionsElement;
import com.ibm.watson.developer_cloud.conversation.v1.model.DialogRuntimeResponseGeneric;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.OutputData;

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
		MessageResponse resp = null;
		Map context = new HashMap();

		String pergunta = request.getParameter("pergunta");
		resp = conversationAPI(pergunta, context);

		String resposta = resp.getOutput().getText().get(0);
		
		List<DialogRuntimeResponseGeneric> dialogs = resp.getOutput().getGeneric();

		for (DialogRuntimeResponseGeneric dialog : dialogs) {
			
			char t = dialog.getResponseType().charAt(0);
			if (t == 'o') {
				resposta += "<p>" + dialog.getTitle() + "</p>";
				
				for(DialogNodeOutputOptionsElement option: dialog.getOptions()) {
					resposta +=  "<p>" + option.getLabel() + "</p>";					
				}				
			}			
		}
		
		Pair<String, String> dialogo = new Pair<>(pergunta, resposta);
		//context = resp.getContext();
		
		conversa.add(dialogo);
		request.setAttribute("items", conversa);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public static MessageResponse conversationAPI(String input, Map context) {
		Conversation service = new Conversation("2018-08-08");
		service.setUsernameAndPassword("7882e3d3-ae6e-4e5a-bbed-cb35427fdf51", "2hmrrVvERh6z");
		InputData inputData = new InputData.Builder().text(input).build();
		MessageRequest newMessage = new MessageRequest();
		newMessage.setInput(inputData);
		String workspaceId = "34349454-2196-4471-8736-fb0d42979888";
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(inputData).build();
		MessageResponse response = service.message(options).execute();
		System.out.println(response);
		return response;
	}

}
