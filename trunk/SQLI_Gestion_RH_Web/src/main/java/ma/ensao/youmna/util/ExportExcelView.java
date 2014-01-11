package ma.ensao.youmna.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.model.Competence;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.model.Diplome;
import ma.ensao.youmna.model.Technologie;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExportExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HSSFSheet collabSheet = workbook.createSheet("Collaborateur");
		HSSFSheet diplomeSheet = workbook.createSheet("Diplome");
		HSSFSheet compSheet = workbook.createSheet("Competence");
		HSSFSheet techSheet = workbook.createSheet("Technologie");
		HSSFSheet compteSheet = workbook.createSheet("Compte");

		setExcelHeaderCollab(collabSheet);
		setExcelHeadeDiplo(diplomeSheet);
		setExcelHeaderComp(compSheet);
		setExcelHeaderTech(techSheet);
		setExcelHeaderCompte(compteSheet);

		List<Compte> compteList = (List<Compte>) model.get("compteList");
		setExcelRowsCompte(compteSheet, compteList);

		List<Technologie> techList = (List<Technologie>) model.get("techList");
		setExcelRowsTech(techSheet, techList);

		List<Competence> compList = (List<Competence>) model.get("competList");
		setExcelRowsCompet(compSheet, compList);

		List<Diplome> dipList = (List<Diplome>) model.get("dipList");
		setExcelRowsDip(diplomeSheet, dipList);

		List<Collaborateur> collabList = (List<Collaborateur>) model
				.get("collabList");
		setExcelRowsCollab(collabSheet, collabList);

	}

	private void setExcelRowsCollab(HSSFSheet collabSheet,
			List<Collaborateur> collabList) {
		int record = 1;
		for (Collaborateur collab : collabList) {
			HSSFRow excelRow = collabSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(collab.getMatricule());
			excelRow.createCell(1).setCellValue(collab.getNom());
			excelRow.createCell(2).setCellValue(collab.getPrenom());
			excelRow.createCell(3).setCellValue(collab.getAbreviation());
			excelRow.createCell(4).setCellValue(collab.getMgrhAncien());
			excelRow.createCell(5).setCellValue(collab.getMgrhActuel());
			excelRow.createCell(6).setCellValue(collab.getSexe());
			excelRow.createCell(7).setCellValue(collab.getSite());
			excelRow.createCell(8).setCellValue(collab.getBu());
			excelRow.createCell(9).setCellValue(collab.getDateEmbauche());
			excelRow.createCell(10).setCellValue(collab.getMoisBap());
			excelRow.createCell(11).setCellValue(collab.getDateDepart());
			excelRow.createCell(12).setCellValue(collab.isAncienColl());
			excelRow.createCell(13).setCellValue(collab.isParticipeSi());
			excelRow.createCell(14).setCellValue(collab.getDateSi());
			excelRow.createCell(15).setCellValue(collab.getPosteActuel3());
			excelRow.createCell(16).setCellValue(collab.getSalaireActuel());
			excelRow.createCell(17).setCellValue(collab.getCompte().getLogin());

		}
	}

	private void setExcelRowsDip(HSSFSheet diplomeSheet, List<Diplome> dipList) {
		int record = 1;
		for (Diplome diplome : dipList) {
			HSSFRow excelRow = diplomeSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(diplome.getId());
			excelRow.createCell(1).setCellValue(diplome.getCollaborateur().getMatricule());
			excelRow.createCell(2).setCellValue(diplome.getNom());
			excelRow.createCell(3).setCellValue(diplome.getDiplomeType());
			excelRow.createCell(4).setCellValue(diplome.getEcole());
			excelRow.createCell(5).setCellValue(diplome.getEcoleType());
			excelRow.createCell(6).setCellValue(diplome.getPromotion());

	}
	}

	private void setExcelRowsCompet(HSSFSheet compSheet,
			List<Competence> compList) {
		int record = 1;
		for (Competence competence : compList) {
			HSSFRow excelRow = compSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(competence.getId());
			excelRow.createCell(1).setCellValue(competence.getTechnologie().getId());
			excelRow.createCell(2).setCellValue(competence.getCompetence());
			excelRow.createCell(3).setCellValue(competence.getNiveauExpertise());

	}

	}

	private void setExcelRowsTech(HSSFSheet techSheet,
			List<Technologie> techList) {
		int record = 1;
		for (Technologie technologie : techList) {
			HSSFRow excelRow = techSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(technologie.getId());
			excelRow.createCell(1).setCellValue(technologie.getCollaborateur().getMatricule());
			excelRow.createCell(2).setCellValue(technologie.getTechnologie());

	}

	}

	private void setExcelRowsCompte(HSSFSheet compteSheet,
			List<Compte> compteList) {
		int record = 1;
		for (Compte compte : compteList) {
			HSSFRow excelRow = compteSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(compte.getLogin());
			excelRow.createCell(1).setCellValue(compte.getPassword());
			excelRow.createCell(2).setCellValue(compte.getEmail());

	}

	}

	private void setExcelHeaderCompte(HSSFSheet compteSheet) {
		HSSFRow excelHeader = compteSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Login");
		excelHeader.createCell(1).setCellValue("Password");
		excelHeader.createCell(2).setCellValue("Email");

	}

	private void setExcelHeaderTech(HSSFSheet techSheet) {
		HSSFRow excelHeader = techSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.createCell(1).setCellValue("Matricule");
		excelHeader.createCell(2).setCellValue("Technologie");

	}

	private void setExcelHeaderComp(HSSFSheet compSheet) {
		HSSFRow excelHeader = compSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.createCell(1).setCellValue("Id techno");
		excelHeader.createCell(2).setCellValue("Competence");
		excelHeader.createCell(3).setCellValue("Niveau d'expertise");

	}

	private void setExcelHeadeDiplo(HSSFSheet diplomeSheet) {
		HSSFRow excelHeader = diplomeSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.createCell(1).setCellValue("Matricule");
		excelHeader.createCell(2).setCellValue("Titre");
		excelHeader.createCell(3).setCellValue("Diplome type");
		excelHeader.createCell(4).setCellValue("Ecole");
		excelHeader.createCell(5).setCellValue("Ecole Type");
		excelHeader.createCell(6).setCellValue("promotion");

	}

	private void setExcelHeaderCollab(HSSFSheet collabSheet) {
		HSSFRow excelHeader = collabSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Matricule");
		excelHeader.createCell(1).setCellValue("Nom");
		excelHeader.createCell(2).setCellValue("Prenom");
		excelHeader.createCell(3).setCellValue("Abreviation");
		excelHeader.createCell(4).setCellValue("Manager ancien");
		excelHeader.createCell(5).setCellValue("Manager actuel");
		excelHeader.createCell(6).setCellValue("Sexe");
		excelHeader.createCell(7).setCellValue("Site");
		excelHeader.createCell(8).setCellValue("Bu");
		excelHeader.createCell(9).setCellValue("Date embauche");
		excelHeader.createCell(10).setCellValue("Mois bap");
		excelHeader.createCell(11).setCellValue("Date depart");
		excelHeader.createCell(12).setCellValue("Ancien collaborateur");
		excelHeader.createCell(13).setCellValue("Participe SI");
		excelHeader.createCell(14).setCellValue("Date SI");
		excelHeader.createCell(15).setCellValue("Poste actuel");
		excelHeader.createCell(16).setCellValue("Salaire");
		excelHeader.createCell(17).setCellValue("Compte login");
	}

}
