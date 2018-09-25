package br.com.flook.teste;

import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;

import javax.swing.JOptionPane;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.DialogNodeOutputOptionsElement;
import com.ibm.watson.developer_cloud.conversation.v1.model.DialogRuntimeResponseGeneric;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.OutputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.RuntimeIntent;

public class TesteChatBotWatson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogManager.getLogManager().reset();

		Conversation service = new Conversation("2018-09-20");
		service.setUsernameAndPassword("7882e3d3-ae6e-4e5a-bbed-cb35427fdf51", "2hmrrVvERh6z"); // replace with service
																								// password
		String workspaceId = "34349454-2196-4471-8736-fb0d42979888"; // replace with workspace ID

		// Start assistant with empty message.
		MessageOptions options = new MessageOptions.Builder(workspaceId).build();
		Context context = new Context();
		// Main input/output loop
		do {
			// Send message to Assistant service.
			MessageResponse response = service.message(options).execute();

			// If an intent was detected, print it to the console.
			List<RuntimeIntent> responseIntents = response.getIntents();
			if (responseIntents.size() > 0) {
				System.out.println("Detected intent: #" + responseIntents.get(0).getIntent());
			}

			// Print the output from dialog, if any.
			OutputData out = response.getOutput();
			List<String> responseText = out.getText();

			int size = responseText.size();
			if (responseText.size() > 0) {
				for (int x = 0; x < size; x++) {
					System.out.println(responseText.get(x));
				}
			}
			
			List<DialogRuntimeResponseGeneric> dialogs = out.getGeneric();
			
			if(dialogs != null) {
				for (DialogRuntimeResponseGeneric dialog : dialogs) {

					char t = dialog.getResponseType().charAt(0);
					if (t == 'o') {
						System.out.println("Titulo: " + dialog.getTitle());
						for (DialogNodeOutputOptionsElement option : dialog.getOptions()) {
							System.out.println(option.getLabel());
						}
					}
				}
			}

			// Update the stored context with the latest received from the dialog.
			context = response.getContext();

			// Prompt for next round of input.
			String inputText = JOptionPane.showInputDialog(null, "Enter a message");
			InputData input = new InputData.Builder(inputText).build();
			options = new MessageOptions.Builder(workspaceId).input(input).context(context).build();
		} while (true);
	}

}
