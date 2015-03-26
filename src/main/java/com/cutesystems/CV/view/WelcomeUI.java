package com.cutesystems.CV.view;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.vaadin.spring.annotation.VaadinUI;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;
import org.vaadin.virkki.paperstack.PaperStack;

import com.cutesystems.CV.model.Education;
import com.cutesystems.CV.model.Person;
import com.cutesystems.CV.model.Skill;
import com.cutesystems.CV.model.SkillGroup;
import com.cutesystems.CV.model.WorkExperience;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;

@Title("CV - Jan Kuta")
@Theme("custom")
@Widgetset("com.cutesystems.CV.CVWidgetset")
@VaadinUI
public class WelcomeUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8645881L;

	@Autowired
	RedisTemplate<String, Person> personRepo;

	@Override
	protected void init(VaadinRequest request) {

		Person ja = this.personRepo.opsForValue().get("JanKuta");
		PaperStack paper = new PaperStack();
		paper.setPaperColor("#c9a975", "#946a4e");
		paper.addComponent(new CVView(ja));
		paper.addComponent(new About());

		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponent(paper);
		layout.setSizeFull();

		layout.setComponentAlignment(paper, Alignment.TOP_CENTER);

		paper.setSizeFull();
		paper.setWidth("740px");
		paper.setHeight("950px");

		setContent(layout);
		/*
		 * CVView cv = new CVView(ja); VerticalLayout layout = new
		 * VerticalLayout(); layout.addComponent(cv); layout.setWidth("100%");
		 * 
		 * layout.setComponentAlignment(cv, Alignment.TOP_CENTER);
		 * 
		 * cv.setWidth("740px"); //cv.setHeight("900px");
		 * 
		 * setContent(cv);
		 */
		Notification notif = new Notification("Vítejte, doufám, že se vám můj interaktivní životopis líbí", "Nezapomeňte se podívat na další list.\nNajeďte myší na jednotlivé dovednosti, abyste se dozvěděli více podrobností.", Type.TRAY_NOTIFICATION);
		notif.setPosition(Position.TOP_LEFT);
		notif.show(getPage());
	}

}

class About extends MVerticalLayout {

	private static final long serialVersionUID = 1L;

	public About() {
		Label info = new Label();
		info.setValue("<h1>Informace o t&eacute;to aplikaci</h1>"
				+ "<h3><strong>Na čem je postavena</strong></h3>"
				+ "<ul>"
				+ "	<li>Z&aacute;kladem je Backend postaven&yacute; na frameworku <a href=\"http://projects.spring.io/spring-boot/\" target=\"_blank\">Spring Boot</a></li>"
				+ "	<li>Objektov&yacute; model obsahuje tř&iacute;du Osoba, kter&aacute; v sobě obsahuje ve&scaron;ker&eacute; informace, kter&eacute; jsou potřeba pro vygenerov&aacute;n&iacute; životopisu</li>"
				+ "	<li>Instance osoby je serializov&aacute;na do odlehčen&eacute;ho uloži&scaron;tě <a href=\"http://redis.io\"target=\"_blank\">Redis</a>&nbsp;</li>"
				+ "	<li>Pro instanci&nbsp;osoby se pomoc&iacute; frameworku <a href=\"http://vaadin.com/home\"target=\"_blank\">Vaadin</a> vykresluje uživatelsk&eacute; rozhran&iacute;</li>"
				+ "</ul>"
				+ "<h3><strong>Můžete se pod&iacute;vat na k&oacute;d a otestovat</strong></h3>"
				+ "<ul>"
				+ "	<li>Zdrojov&yacute; k&oacute;d aplikace naleznete v m&eacute;m repository na <a href=\"https://github.com/Jan-Kuta/Interactive-CV.git\" target=\"_blank\">GitHubu</a></li>"
				+ "	<li>Je potřeba nainstalovat a spustit <a href=\"http://redis.io/download\"target=\"_blank\">Redis Server</a></li>"
				+ "	<li>Zkompilujte widgetSet (\"mvn vaadin:compile\")</li>"
				+ "	<li>Spusťte aplikaci jako obyčejnou Java aplikaci</li>"
				+ "	<li>Pokusn&aacute; data se do uloži&scaron;tě vygeneruj&iacute; pomoc&iacute; tohoto odkazu:&nbsp;<a href=\"http://localhost:8080/init\"target=\"_blank\">localhost:8080/init</a></li>"
				+ "	<li>Uživatlesk&eacute; rozhran&iacute; naleznete na&nbsp;adrese:&nbsp;<a href=\"http://localhost:8080/cv\"target=\"_blank\">localhost:8080/cv</a></li>"
				+ "   <li>Použil jsem container <a href=\"https://vaadin.com/directory#addon/paperstack\" target=\"_blank\">PaperStack</a>&nbsp;s efektem ot&aacute;čen&iacute; str&aacute;nek (Vaadin add-on)</li>"
				+ "	<li>V&scaron;imněte si tooltipu i jednotliv&yacute;ch dovednost&iacute;</li>"
				+ "</ul>"
				+ "<h3><strong>Co by se dalo zlep&scaron;it</strong></h3>"
				+ "<ul>"
				+ "	<li>Vyře&scaron;it, proč se v uživatlsk&eacute;m rozhran&iacute; při změně velikosti objevuj&iacute; b&iacute;l&eacute; č&aacute;ry</li>"
				+ "	<li>Vytvořit administr&aacute;torsk&eacute; rozhran&iacute; pro editaci osoby</li>"
				+ "	<li>Zabezpečit administr&aacute;torsk&eacute; rozhran&iacute; heslem (lze použ&iacute;t Spring security)</li>"
				+ "	<li>Naimplementovat internacionalizaci</li>" + "</ul>");
		info.setContentMode(ContentMode.HTML);
		info.setStyleName("about");
		info.setSizeFull();
		addComponent(info);
	}
}

class CVView extends GridLayout {

	private static final long serialVersionUID = 12345678L;

	public CVView(Person person) {
		super(2, 6);

		// setWidth("100%");
		setSizeFull();
		setColumnExpandRatio(0, 1);
		setColumnExpandRatio(1, 2);

		// FirstColumn
		Header header = new Header(person);
		this.addComponent(header, 0, 0);
		setComponentAlignment(header, Alignment.MIDDLE_CENTER);

		this.addComponent(new Foto(person), 0, 1);

		this.addComponent(new AboutMeView(person), 0, 2);

		this.addComponent(new SkillView(person.getSkillGroups()), 0, 3, 0, 4);

		// Second column
		this.addComponent(new EducationView(person.getEducation()), 1, 0, 1, 1);

		this.addComponent(new WorkView(person.getWorkExpirience()), 1, 2, 1, 3);

		this.addComponent(new OtherStuffView(person.getOtherStuff()), 1, 4);

		// Footer
		this.addComponent(new Footer(), 0, 5, 1, 5);

		setRowExpandRatio(1, 1);
		getComponent(0, 1).setHeight("100%");

		setRowExpandRatio(3, 1);
		getComponent(0, 3).setHeight("100%");

		setRowExpandRatio(4, 14);
		getComponent(1, 4).setHeight("100%");
	}
}

// @VaadinComponent

class Header extends Label {
	private static final long serialVersionUID = 1L;

	public Header(Person person) {
		super(person.getFirstname() + " " + person.getLastname());

		setStyleName("header");
	}
}

class Foto extends MVerticalLayout {
	private static final long serialVersionUID = 1L;

	private Embedded foto;

	public Foto(Person person) {
		super();

		File fotoFile = new File(VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath()
				+ "/" + person.getFotoUrl());
		foto = new Embedded();
		foto.setImmediate(false);
		foto.setSource(new FileResource(fotoFile));
		foto.setType(1);
		// setMimeType("image/png");
		addComponent(foto);

		setStyleName("header");
		setSizeFull();
	}
}

class AboutMeView extends MVerticalLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutMeView(Person person) {
		super();
		setStyleName("inverse");

		// Date of birth
		Label birth = new Label();
		birth.setContentMode(ContentMode.HTML);
		birth.setValue(FontAwesome.ASTERISK.getHtml() + " "
				+ person.getBirthDateStr());
		this.addComponent(birth);

		// Phone
		Label phone = new Label();
		phone.setContentMode(ContentMode.HTML);
		phone.setValue(FontAwesome.PHONE.getHtml() + " " + person.getPhone());
		this.addComponent(phone);

		// Email
		Link email = new Link(person.getEmail(), new ExternalResource("mailto:"
				+ person.getEmail()));
		email.setDescription("Napište mi e-mail");
		email.setIcon(FontAwesome.ENVELOPE);
		this.addComponent(email);

		// Licence
		Label drivingLicence = new Label();
		drivingLicence.setContentMode(ContentMode.HTML);
		drivingLicence.setValue(FontAwesome.CAR.getHtml() + " "
				+ person.getDriverLicence());
		this.addComponent(drivingLicence);

		// Address
		Label address = new Label();
		address.setContentMode(ContentMode.HTML);
		address.setValue(FontAwesome.GLOBE.getHtml() + " "
				+ person.getTemporarryAddress());
		this.addComponent(address);

		// LinkedIn

		Link linkedin = new Link(" LinkedIn profile", new ExternalResource(
				person.getLinkedinAccount()));
		linkedin.setDescription("Navštivte můj účet");
		linkedin.setIcon(FontAwesome.LINKEDIN_SQUARE);
		linkedin.setTargetName("_blank");
		this.addComponent(linkedin);

	}

}

class SkillView extends FormLayout {

	/**
		 * 
		 */
	private static final long serialVersionUID = 3L;

	public SkillView(List<SkillGroup> skillGroups) {
		this.setMargin(true);
		setStyleName("inverse");
		this.setSizeFull();
		for (SkillGroup group : skillGroups) {
			Label skillGroup = new Label(group.getGroupName());
			skillGroup.setStyleName("large");
			addComponent(skillGroup);
			for (Skill skill : group.getSkills()) {
				ProgressBar skillBar = new ProgressBar(skill.getLevel());
				skillBar.setCaption(skill.getName());
				skillBar.setWidth("100px");
				skillBar.setDescription(skill.getDescription());
				addComponent(skillBar);
			}
		}
	}

}

class EducationView extends MVerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public EducationView(List<Education> educationList) {
		Label education = new Label("Vzdělání");
		education.setStyleName("huge");
		addComponent(education);
		for (Education edu : educationList) {
			String value = "<p>" + edu.getStart() + " - " + edu.getEnd()
					+ "<br />";
			value += "<b>" + edu.getSchoolName() + "</b>";
			value += ", " + edu.getFaculty() + "<br />";
			value += edu.getField() + "<br />";
			if (edu.getLeavingPaper() != null)
				value += "<i>Téma závěrečné práce:</i> "
						+ edu.getLeavingPaper();

			value += "</p>";
			Label content = new Label(value);
			content.setContentMode(ContentMode.HTML);
			addComponent(content);
		}
	}
}

class WorkView extends MVerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	private static String createLink(String url) {
		return "<a href=\"" + url + "\" target=\"_blank\" >"
				+ url.replace("http://", "") + "</a>";
	}

	public WorkView(List<WorkExperience> works) {
		Label workExp = new Label("Pracovní zkušenosti");
		workExp.setStyleName("huge");
		addComponent(workExp);
		addComponent(new Label(" "));
		for (WorkExperience work : works) {
			String value = work.setStartStr() + " - "
					+ (work.getEnd() != null ? work.getEndStr() : "nyní")
					+ "<br />";
			value += (work.getJobName() != null ? ("<i>" + work.getJobName() + "</i> - ")
					: "");
			value += "<b>" + work.getCompanyName() + "</b>";
			value += work.getEmploymentType() != null ? (" ("
					+ work.getEmploymentType() + ")<br />") : "";
			if (work.getCompanyAddress() != null) {
				value += work.getCompanyAddress();
				if (work.getCompanyWeb() != null) {
					value += ", " + createLink(work.getCompanyWeb());
				}
				value += "<br />";
			} else {
				if (work.getCompanyWeb() != null) {
					value += createLink(work.getCompanyWeb());
				}
				value += "<br />";
			}
			value += "<ul>";
			for (String liability : work.getLiabilities()) {
				value += "<li>" + liability + "</li>";
			}
			value += "</ul>";

			Label content = new Label(value);
			content.setContentMode(ContentMode.HTML);
			addComponent(content);
		}
	}
}

class OtherStuffView extends MVerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;

	public OtherStuffView(Map<String, String> stuff) {
		for (String key : stuff.keySet()) {
			Label header = new Label(key);
			header.setStyleName("huge");
			addComponent(header);
			addComponent(new Label(stuff.get(key)));

		}
	}
}

class Footer extends MHorizontalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 78L;

	public Footer() {
		String realPath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"/";
		
		this.setStyleName("footer");
		this.setHeight("70px");
		this.setWidth("100%");

		Embedded vaadinLogo = new Embedded();
		vaadinLogo.setImmediate(false);
		vaadinLogo
				.setSource(new FileResource(
						new File(realPath+"Images/vaadin-logo.png")));
		vaadinLogo.setType(1);
		addComponent(vaadinLogo);
		this.setComponentAlignment(vaadinLogo, Alignment.MIDDLE_CENTER);

		Embedded springLogo = new Embedded();
		springLogo.setImmediate(false);
		springLogo
				.setSource(new FileResource(
						new File(realPath+"Images/SpringIO.png")));
		springLogo.setType(1);
		addComponent(springLogo);
		this.setComponentAlignment(springLogo, Alignment.MIDDLE_CENTER);

		Embedded redisLogo = new Embedded();
		redisLogo.setImmediate(false);
		redisLogo
				.setSource(new FileResource(
						new File(realPath+"Images/redis.png")));
		redisLogo.setType(1);
		addComponent(redisLogo);
		this.setComponentAlignment(redisLogo, Alignment.MIDDLE_CENTER);

	}
}
