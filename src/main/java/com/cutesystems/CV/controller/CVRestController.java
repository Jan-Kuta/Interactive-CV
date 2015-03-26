package com.cutesystems.CV.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cutesystems.CV.model.Education;
import com.cutesystems.CV.model.Person;
import com.cutesystems.CV.model.Skill;
import com.cutesystems.CV.model.SkillGroup;
import com.cutesystems.CV.model.WorkExperience;

@RestController
public class CVRestController {
	@Autowired
	RedisTemplate<String, Person> personRepo;

	@RequestMapping("/person/{name}")
	Person getPerson(@PathVariable String name) {
		return this.personRepo.opsForValue().get(name);
	}

	@RequestMapping(value = "/storePerson", method = RequestMethod.POST)
	String setPerson(@ModelAttribute Person person) {
		this.personRepo.opsForValue().set(
				person.getFirstname() + person.getLastname(), person);
		return "OK";
	}

	@RequestMapping(value = "/init")
	String initPerson() {
		try {
			// Czech
			Person me = new Person("d.m.yyyy", "11.1.1985", "Jan", "Kuta",
					"Žežická 39, Ústí nad Labem, 400 07",
					"Rooseveltova 627, Nejdek, 362 21", "+420 775 246 369",
					"jan.kuta@email.cz", "B",
					"http://cz.linkedin.com/pub/jan-kuta/60/a09/84b",
					"Images/me.png");
			
			SkillGroup itSkills = new SkillGroup("IT dovednosti");
			itSkills.addSkills(new Skill("Java Spring", "<b>Spring Boot<b><hr /><ul><li>Zatím jsem nepoužil v žádném opravdovém projektu</li><li>Oproti klasickému springu odpadává zdlouhavá konfigurace (vyšší produktivita)</li><li>Implementován backend tohoto životopisu</li></ul>", 0.58f, true));
			itSkills.addSkills(new Skill("Java SE", "<b>Java - Standard Edition<b><hr /><ul><li>Tvorba utilit pro potřeby End to End monitoringu aplikací a služeb</li><li>Proof of concept - Home Credit: End to End monitoring internetového bankovnictví pomocí Selenia</li></ul>", 0.84f, true));
			itSkills.addSkills(new Skill("Vaadin framework", "<b>Vaadin framework<b><hr /><ul><li>Java framework pro tvorbu UI (pro vykreslení UI se používá GWT)</li><li>Odpadá nutnost řešit HTML/CSS/JavaScript</li><li>Implementován frontend tohoto životopisu</li><li>Použit pro tvorbu portletů v Liferay (vlastní projekt)</li><li>Tvořím vlastní komponentu pro tvorbu a editaci jednoduchých SVG obrázků (vlastní projekt)</li></ul>", 0.65f, true));			
			itSkills.addSkills(new Skill("Liferay", "<b>Liferay<b><hr /><ul><li>Open-source podnikový portál založený na jazyce Java</li><li>Stavím na něm svůj webový portál (vlastní projekt)</li><li>Pomocí Service Builderu se může v IDE generovat datový model</li><li>Existuje mnoho rozšíření</li></ul>", 0.3f, true));
			itSkills.addSkills(new Skill("Javascript", "<b>JavaScript<b><hr /><ul><li>Prošel jsem základy jQuery a Angular JS</li><li>Implementoval jsem svou diplomovou práci</li><li>Tvořím vlastní komponentu pro tvorbu a editaci jednoduchých SVG obrázků (vlastní projekt)</li></ul>", 0.5f, true));
			itSkills.addSkills(new Skill("Perl", "<b>Perl<b><hr /><ul><li>Tvorba utilit pro potřeby End to End monitoringu aplikací a služeb</li></ul>", 0.91f, true));
			itSkills.addSkills(new Skill("Python", "<b>Python<b><hr /><ul><li>Tvorba utilit pro potřeby End to End monitoringu aplikací a služeb</li></ul>", 0.4f, true));
			itSkills.addSkills(new Skill("VB Script", "<b>VB Script<b><hr /><ul><li>Úprava funkcionalit v systému OmniTracker (Systém pro řízení a správu procesů)</li></ul>", 0.48f, true));
			itSkills.addSkills(new Skill("PL/SQL", "<b>PL/SQL<b><hr /><ul><li>Tvorba balíků pro korelaci a agregaci dat pro potřeby End to End monitoringu aplikací a služeb</li></ul>", 0.86f, true));
			itSkills.addSkills(new Skill("Oracle", "<b>Oracle<b><hr /><ul><li>Správa databáze pro End to End monitoring aplikací a služeb (tvorba nových tabulek a pohledů)</li></ul>", 0.5f, true));
			itSkills.addSkills(new Skill("Reporting", "<b>Reporting<b><hr /><ul><li>Tvorba business reportů</li><li>Birt reports, Crystal reports, Pentaho reporting</li></ul>", 0.9f, true));
			itSkills.addSkills(new Skill("Datové integrace", "<b>Datové integrace<b><hr /><ul><li>Pentaho data integration</li><li>Automatická aktualizace CMDB pro Vodafone (tvorba ETL scriptů)</li></ul>", 0.45f, true));
			me.addSkillGroups(itSkills);

			SkillGroup languageSkills = new SkillGroup("Jazyky");
			languageSkills.addSkills(new Skill("Angličtina", "<b>Angličtina<b><hr /><ul><li>porozumění / psaní (B2)</li><li>mluvený projev (B1)</li></ul>", 0.65f, true));
			languageSkills.addSkills(new Skill("Němčina", "<b>Němčina<b><hr /><ul><li>porozumění (B1)</li><li>mluvený projev/psaní (A2)</li></ul>", 0.25f, true));
			me.addSkillGroups(languageSkills);

			me.addEducation(new Education("Univerzita Karlova v Praze",
					"Matematicko-fyzikální fakulta", "Informatika", null, 2004,
					2005));
			me.addEducation(new Education(
					"Univerzita Jana Evangelisty Purkyně v Ústí nad Labem",
					"Přírodovědecká fakulta",
					"Informační systémy (Bc.)",
					"Vývoj softwaru pro řešení parciálních diferenciálních rovnic v 1D",
					2005, 2008));
			me.addEducation(new Education(
					"Technická univerzita v Liberci",
					" Fakulta mechatroniky, informatiky a mezioborových studií",
					"Informační technologie (Ing.)",
					"Tvorba webové komponenty pro práci s digitálními mapami",
					2008, 2011));

			WorkExperience we = new WorkExperience("yyyy/mm",
					"FCC průmyslové systémy s.r.o",
					"SNP 2443/8, 400 11 Ústí nad Labem", "http://www.fccps.cz",
					"Externí programátor", "DPP", "2010/10", "2011/02");
			we.addLiabilitiy("Vývoj SW pro modul ADAM-4500 od firmy Advantech (jazyk C)");
			we.addLiabilitiy("Výroba datových XML-souborů pro zařízení na kontrolu výroby výlisků ve firmě VALEO AUTOKLIMATIZACE k.s., Rakovník");
			me.addWorkExpirience(we);

			we = new WorkExperience("yyyy/mm","NextiraOne Czech / Dimension Data Czech",
					"Na Hřebenech II 1718/10, 140 00 Praha 4",
					"http://www.dimensiondata.com", "Expert", "HPP", "2011/03", "2014/11");
			we.addLiabilitiy("Administrace systému pro správu procesů (OMNITRACKER od firmy OMNINET): úprava formulářů a úprava funkcionalit ve VBScriptu");
			we.addLiabilitiy("Tvorba utilit pro potřeby E2E monitoringu aplikací a služeb (C#, Java, PL/SQL)");
			we.addLiabilitiy("Tvorba business reportů (openreports, databázové pohledy)");
			we.addLiabilitiy("Tvorba scriptů pro potřeby monitorovacích nástrojů (Perl)");
			me.addWorkExpirience(we);

			we = new WorkExperience("yyyy/mm","Vlastní projekt",
					null,
					null, null, null, "2014/12", null);
			we.addLiabilitiy("Webový portál postavený na Liferay");
			we.addLiabilitiy("Backend: Spring Boot");
			we.addLiabilitiy("Frontend: Portlety vytvořené pomocí Vaadin frameworku");
			we.addLiabilitiy("Studium potřebných technologií");
			me.addWorkExpirience(we);
			
			me.addOtherStuff("Zájmy",
					"Outdoorové aktivity (cyklistika, lezení, turistika, běžky), knihy");

			this.personRepo.opsForValue().set("JanKuta", me);

			// English
			me = new Person("d.m.yyyy", "11.1.1985", "Jan", "Kuta",
					"Žežická 39, Ústí nad Labem, 400 07",
					"Rooseveltova 627, Nejdek, 362 21", "+420 775 246 369",
					"jan.kuta@email.cz", "B",
					"http://cz.linkedin.com/pub/jan-kuta/60/a09/84b",
					"Images/me.png");
			itSkills = new SkillGroup("IT skills");
			itSkills.addSkills(new Skill("Java Spring", "", 0.65f, true));
			itSkills.addSkills(new Skill("Vaadin framework", "", 0.72f, true));
			itSkills.addSkills(new Skill("PL/SQL", "", 0.86f, true));
			me.addSkillGroups(itSkills);

			languageSkills = new SkillGroup("Language skills");
			languageSkills.addSkills(new Skill("English", "", 0.6f, true));
			languageSkills.addSkills(new Skill("Germany", "", 0.35f, true));
			me.addSkillGroups(languageSkills);

			me.addEducation(new Education("Charles University in Prague",
					"Faculty of Mathematics and Physics", "Computer science", null, 2004,
					2005));
			me.addEducation(new Education(
					"Univerzita Jana Evangelisty Purkyně v Ústí nad Labem",
					"Přírodovědecká fakulta",
					"Informační systémy (Bc.)",
					"Vývoj softwaru pro řešení parciálních diferenciálních rovnic v 1D",
					2005, 2008));
			me.addEducation(new Education(
					"Technická univerzita v Liberci",
					" Fakulta mechatroniky, informatiky a mezioborových studií",
					"Informační technologie (Ing.)",
					"Tvorba webové komponenty pro práci s digitálními mapami",
					2008, 2011));

			we = new WorkExperience("yyyy/mm",
					"FCC průmyslové systémy s.r.o",
					"SNP 2443/8, 400 11 Ústí nad Labem", "www.fccps.cz",
					"Externí programátor", "DPP", "2010/10", "2011/02");
			we.addLiabilitiy("Vývoj SW pro modul ADAM-4500 od firmy Advantech (jazyk C)");
			we.addLiabilitiy("Výroba datových XML-souborů pro zařízení na kontrolu výroby výlisků ve firmě VALEO AUTOKLIMATIZACE k.s., Rakovník");
			me.addWorkExpirience(we);

			we = new WorkExperience("yyyy/mm","NextiraOne Czech / Dimension Data Czech",
					"Na Hřebenech II 1718/10, 140 00 Praha 4",
					"www.dimensiondata.com", "Expert", "HPP", "2011/03", "2014/11");
			we.addLiabilitiy("Administrace systému pro správu procesů (OMNITRACKER od firmy OMNINET): úprava formulářů a úprava funkcionalit ve VBScriptu");
			we.addLiabilitiy("Tvorba utilit pro potřeby E2E monitoringu aplikací a služeb (C#, Java, PL/SQL)");
			we.addLiabilitiy("Tvorba business reportů (openreports, databázové pohledy)");
			we.addLiabilitiy("Tvorba scriptů pro potřeby monitorovacích nástrojů (Perl)");
			me.addWorkExpirience(we);

			me.addOtherStuff("Hobbies",
					"Outdoorové aktivity (cyklistika, lezení, turistika, běžky), knihy");

			this.personRepo.opsForValue().set("JanKuta_en", me);
		} catch (ParseException e) {
			return "FAILED: " + e.getMessage();
		}
		return "OK";
	}

}
