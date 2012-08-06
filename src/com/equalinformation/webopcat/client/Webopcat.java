package com.equalinformation.webopcat.client;

import com.equalinformation.webopcat.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/** 
 * Author: Bhim Upadhyaya
 * Created: 08/06/2012
 * Last Modified: 08/06/2012
 * Related Event: MIT 6.18s, July 23-27, 2012.
 */

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Webopcat implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	public void onModuleLoad() {
		//Commands
	    Command cmd = new Command() {
	        public void execute() {
	          Window.alert("Under construction!");
	        }
	      };
		 
      
		//Menu
	      
	    //Examples  
	    MenuBar examplesMenu = new MenuBar(true);
	    examplesMenu.addItem("ABS", cmd);
	    examplesMenu.addItem("ATM", cmd);
	    examplesMenu.addItem("Cell Cycle", cmd);
	    examplesMenu.addItem("Order System", cmd);
	    examplesMenu.addItem("Travel Management", cmd);
	    
	    //File options
		MenuBar fileMenu = new MenuBar(true);
		fileMenu.addItem("New", cmd);
		fileMenu.addItem("Open", cmd);
		fileMenu.addItem("Close", cmd);
		fileMenu.addItem("Save", cmd);
		fileMenu.addItem("Save As", cmd);
		fileMenu.addItem("Examples", examplesMenu);

		
		//Edit options
		MenuBar editMenu = new MenuBar(true);
		editMenu.addItem("Undo", cmd);
		editMenu.addItem("Redo", cmd);
		editMenu.addItem("Cut", cmd);
		editMenu.addItem("Copy", cmd);
		editMenu.addItem("Paste", cmd);
		
		//Toolbars Options
		MenuBar toolBarsMenu = new MenuBar(true);
		toolBarsMenu.addItem("Standard", cmd);
		toolBarsMenu.addItem("Components", cmd);
		
		//View options
		MenuBar viewMenu = new MenuBar(true);
		viewMenu.addItem("Zoom in", cmd);
		viewMenu.addItem("Zoom out", cmd);
		viewMenu.addItem("Tool bars", toolBarsMenu);
		
		// Make a new menu bar, adding a few cascading menus to it.
		MenuBar menu = new MenuBar();
		menu.addItem("System", fileMenu);
		menu.addItem("Edit", editMenu);
		menu.addItem("View", viewMenu);
		menu.addItem("Notation", cmd);
		menu.addItem("Operation", cmd);
		menu.addItem("Generation", cmd);
		menu.addItem("Help", cmd);
		
		
		// Add it to the root panel.
		RootPanel.get().add(menu);

	      
	}

	/**
	 * This is the entry point method.
	 */
/*	public void onModuleLoad() {
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			*//**
			 * Fired when the user clicks on the sendButton.
			 *//*
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			*//**
			 * Fired when the user types in the nameField.
			 *//*
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			*//**
			 * Send the name from the nameField to the server and wait for a response.
			 *//*
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}*/
}
