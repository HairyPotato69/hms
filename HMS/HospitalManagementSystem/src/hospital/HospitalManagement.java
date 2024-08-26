package hospital;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//import javafx.scene.text.Text;
import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class HospitalManagement extends Application{
	private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private ArrayList<Lab> labList = new ArrayList<Lab>();
	private ArrayList<Facility> facilityList = new ArrayList<Facility>();
	private ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
	private ArrayList<Staff> staffList = new ArrayList<Staff>();
	
	private Font titleFont = new Font("Courier", 32);
	private Font textFont = new Font("Courier", 20);
	private Stage primaryStage;
	private Scene sceneMain, sceneDoctor, scenePatient, sceneMedicine, sceneLaboratories, sceneFacilities, sceneStaff;
	private Scene[] sceneList;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		sceneMain = mainMenu();
		
		sceneDoctor = doctorMenu();
		scenePatient = doctorMenu();
		sceneMedicine = doctorMenu();
		sceneLaboratories = doctorMenu();
		sceneFacilities = doctorMenu();
		sceneStaff = doctorMenu();
		sceneList = new Scene[]{
				sceneDoctor, 
				scenePatient, 
				sceneMedicine, 
				sceneLaboratories, 
				sceneFacilities, 
				sceneStaff};
		primaryStage.setTitle("Hospital Management System");
		primaryStage.setScene(sceneMain);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private Scene mainMenu() {
		BorderPane parentPane = new BorderPane();
		parentPane.setTop(titlePane());
		parentPane.setCenter(selectionPane());
		
		return new Scene(parentPane, 800, 600);
	}
	
	private Scene doctorMenu() {
		BorderPane parentPane = new BorderPane();
		
		parentPane.setLeft(CRUDButtons());
		parentPane.setCenter(addDoctor());
		
		return new Scene(parentPane, 800,600);
	}
	
	private VBox selectionPane() {
		int[][] positions = {
				{0,0}, {0,1}, {0,2},
				{1,0}, {1,1}, {1,2},
				{2,0}, {2,1}, {2,2}
		};
		
		VBox vPane = new VBox();
		
		GridPane selectionPane = new GridPane();
		selectionPane.setAlignment(Pos.CENTER);
		selectionPane.setPadding(new Insets(15));
		selectionPane.setHgap(20);
		selectionPane.setVgap(20);
		
		Label callToAction = new Label("Make your choice");
		callToAction.setFont(textFont);
		callToAction.setStyle("-fx-font-weight: bold;");
		
		Button doctorBtn = new Button("Doctor"); 
		Button patientBtn = new Button("Patient"); 
		Button medicineBtn = new Button("Medicine"); 
		Button laboratoriesBtn = new Button("Laboratories"); 
		Button facilitiesBtn = new Button("Facilities"); 
		Button staffBtn = new Button("Staff");
		
		Button[] buttonList = { doctorBtn, patientBtn, medicineBtn, laboratoriesBtn, facilitiesBtn, staffBtn};
		
		for (int index = 0; index < buttonList.length; index++) {
			final int currentIndex = index; 
			
			buttonList[index].setPrefHeight(50);
			buttonList[index].setPrefWidth(200);
			
			buttonList[index].setOnAction(e -> primaryStage.setScene(sceneList[currentIndex]));
			
			selectionPane.add(buttonList[index], positions[index][0], positions[index][1]);
			GridPane.setHalignment(buttonList[index], HPos.CENTER);
		}
		
		vPane.getChildren().addAll(callToAction, selectionPane);
		vPane.setAlignment(Pos.CENTER);
		return vPane;
	}
	private VBox titlePane() {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		String currentDate = LocalDate.now().format(dateFormatter);
		String currentTime = LocalTime.now().format(timeFormatter);
		
		VBox titleBox = new VBox();
		HBox title = new HBox();
		HBox dateAndTime = new HBox();
		
		Label titleLabel = new Label("Hospital Management System");
		titleLabel.setFont(titleFont);
		titleLabel.setStyle("-fx-font-weight: bold;");
		
		title.getChildren().add(titleLabel);
		title.setAlignment(Pos.CENTER);
		
		Label date = new Label(currentDate);
		date.setFont(textFont);
		Label time = new Label(currentTime);
		time.setFont(textFont);
		
		dateAndTime.getChildren().addAll(date,time);
		dateAndTime.setSpacing(40);
		dateAndTime.setAlignment(Pos.CENTER);
		
		
		titleBox.getChildren().addAll(title, dateAndTime);
		titleBox.setPadding(new Insets(20));
		titleBox.setAlignment(Pos.CENTER);
		
		return titleBox;
		
	}
	private VBox CRUDButtons() {
		VBox sideBar = new VBox(10);
		Button addBtn = new Button("Add"); 
		Button readBtn = new Button("Read"); 
		Button returnBtn = new Button("Return");
//		Button updateBtn = new Button("Update"); 
//		Button deleteBtn = new Button("Delete"); 
//		, updateBtn, deleteBtn
		Button[] btnList = {addBtn, readBtn, returnBtn};
		for(Button button: btnList) {
			button.setPrefWidth(200);
			button.setPrefHeight(50);
			sideBar.getChildren().add(button);
		}
		
		returnBtn.setOnAction(e->primaryStage.setScene(sceneMain));
		
		sideBar.setPadding(new Insets(20));
		sideBar.setAlignment(Pos.CENTER);
		
		return sideBar;
	}
	

	private BorderPane addDoctor() {
		BorderPane actionPane = new BorderPane();
		
		HBox title = new HBox();
		GridPane form = new GridPane();
		form.setAlignment(Pos.CENTER_LEFT);
		form.setVgap(15);
		actionPane.setPadding(new Insets(40));
		
		Label titleLabel = new Label("Add doctor");
		titleLabel.setFont(titleFont);
		titleLabel.setStyle("-fx-font-weight: bold;");
		
		title.getChildren().add(titleLabel);
		title.setAlignment(Pos.CENTER);
		
		Label id = new Label("Id: ");
		Label name = new Label("Name: ");
		Label specialist = new Label("Specialist: ");
		Label workTime = new Label("Work Time: ");
		Label qualification = new Label("Qualification: ");
		Label roomNo = new Label("Room Number: ");
		
		Label[] labels = {id, name, specialist, workTime, qualification, roomNo};
		
		TextField idTf = new TextField();
		TextField nameTf = new TextField();
		TextField specialistTf = new TextField();
		TextField workTimeTf = new TextField();
		TextField qualificationTf = new TextField();
		TextField roomTf = new TextField();
		
		TextField[] textField = {idTf, nameTf, specialistTf, workTimeTf, qualificationTf, roomTf};
		
		for (int index = 0; index < 6; index++) {
			labels[index].setFont(textFont);
			textField[index].setFont(textFont);
			form.add(labels[index], 0, index);
			form.add(textField[index], 1, index);
		}
		
		Button submitBtn = submitButton();
		
		
		actionPane.setTop(title);
		actionPane.setCenter(form);
		actionPane.setBottom(submitBtn);
		BorderPane.setAlignment(submitBtn, Pos.TOP_CENTER);
		return actionPane;
	}
	
	private Button submitButton() {
		Button submitBtn = new Button("Submit");
		submitBtn.setPrefWidth(200);
		submitBtn.setPrefHeight(50);
		return submitBtn;
	}
	
}

