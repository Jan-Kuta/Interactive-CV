package com.cutesystems.CV.view;

import org.vaadin.spring.annotation.VaadinUI;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Title("CV - Administration")
@Theme("custom")
@Widgetset("com.cutesystems.CV.CVWidgetset")
@VaadinUI(path = "/admin")
public class AdminUI extends UI{

	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest request) {
		Label content = new Label("<h1>Admin Pages</h1><h2>TBD</h2><a href=\"http://localhost:8080/cv\">jdi na životopis</a>");
		content.setContentMode(ContentMode.HTML);
		content.setStyleName("about");
		setContent(content);		
		
	}

}
