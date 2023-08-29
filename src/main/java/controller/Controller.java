package controller;

import java.sql.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.util.ArrayList;
import java.util.List;
import model.*;
import view.*;
import view.GenericTableModel;
import java.util.Calendar;

public class Controller {
    private static Client clientSelecionado = null;
    private static Specie specieSelecionado = null;
    private static Animal animalSelecionado = null;
    private static Vet vetSelecionado = null;
    private static Consult consultSelecionado = null;
    private static Exam examSelecionado = null;
    private static JTextField clientSelecionadoTextField = null;
    private static JTextField specieSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField vetSelecionadoTextField = null;    
    private static JTextField consultSelecionadoTextField = null;

    
    public static void setTextFields(JTextField cliente, JTextField specie, JTextField animal, JTextField vet, JTextField consult){
        clientSelecionadoTextField = cliente;
        specieSelecionadoTextField = specie;
        animalSelecionadoTextField = animal;
        vetSelecionadoTextField = vet;
        consultSelecionadoTextField = consult;
    }
    
    public static void setTableModel(JTable table, GenericTableModel tableModel){
        table.setModel(tableModel);
    }
    
    public static Client getClientSelecionado(){
        return clientSelecionado;
    }
    
    public static Specie getSpecieSelecionado(){
        return specieSelecionado;
    }
    
    public static Animal getAnimalSelecionado(){
        return animalSelecionado;
    }
    
    public static Vet getVetSelecionado(){
        return vetSelecionado;
    }
    
    public static Consult getConsultSelecionado(){
        return consultSelecionado;
    }
    
    public static Exam getExamSelecionado(){
        return examSelecionado;
    }
    
    public static void setSelected(Object selected){
        if (selected instanceof Client){
            clientSelecionado = (Client)selected;
            clientSelecionadoTextField.setText(clientSelecionado.getClientName());
            animalSelecionadoTextField.setText("");
        } else if (selected instanceof Specie){
            specieSelecionado = (Specie)selected;
            specieSelecionadoTextField.setText(specieSelecionado.getSpecieName());
        } else if (selected instanceof Animal){
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getAnimalName());
        } else if (selected instanceof Vet){
            vetSelecionado = (Vet)selected;
            vetSelecionadoTextField.setText(vetSelecionado.getVetName());
        } else if (selected instanceof Consult){
            consultSelecionado = (Consult)selected;
            consultSelecionadoTextField.setText(String.valueOf(consultSelecionado.getConsultId()));
        } else if (selected instanceof Exam){
            examSelecionado = (Exam)selected;
        }
    }
    
    public static void jRadioButtonClientSelect(JTable table){
        setTableModel(table, new ClientTableModel(ClientDAO.getInstance().retrieveAll()));
    }
    
    public static boolean jRadioButtonAnimalSelect(JTable table){
        if (getClientSelecionado() != null){
            setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByClient(getClientSelecionado().getClientId())));
            return true;
        } else {
            setTableModel(table, new AnimalTableModel(new ArrayList()));
            return false;
        }
    }
    
    public static void jRadioButtonSpecieSelect(JTable table){
        setTableModel(table, new SpecieTableModel(SpecieDAO.getInstance().retrieveAll()));
    }
    
    public static void jRadioButtonVetSelect(JTable table){
        setTableModel(table, new VetTableModel(VetDAO.getInstance().retrieveAll()));
    }
    
    public static void selectConsults(JTable table){
        setTableModel(table, new ConsultTableModel(ConsultDAO.getInstance().retrieveAll()));
    }
    
    public static void selectExams(JTable table){
        setTableModel(table, new ExamTableModel(ExamDAO.getInstance().retrieveByConsult(getConsultSelecionado().getConsultId())));
    }
    
    public static void getClientBySimilarNameBuscar(JTable table, String nomeParcial){
        ((GenericTableModel)table.getModel()).addListOfItems(ClientDAO.getInstance().retrieveBySimilarName(nomeParcial));
    }
    
    public static void getAnimalBySimilarNameBuscar(JTable table, String nomeParcial){
        ((GenericTableModel)table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(nomeParcial, getClientSelecionado().getClientId()));
    }
    
    public static void getSpecieBySimilarNameBuscar(JTable table, String nomeParcial){
        ((GenericTableModel)table.getModel()).addListOfItems(SpecieDAO.getInstance().retrieveBySimilarName(nomeParcial));
    }
    
    public static void getVetBySimilarNameBuscar(JTable table, String nomeParcial){
        ((GenericTableModel)table.getModel()).addListOfItems(VetDAO.getInstance().retrieveBySimilarName(nomeParcial));
    }
    
    public static void getExamBySimilarDescriptionBuscar(JTable table, String descricaoParcial){
        ((GenericTableModel)table.getModel()).addListOfItems(ExamDAO.getInstance().retrieveBySimilarDescription(descricaoParcial));
    }
    
    public static Client saveClient(){
        Client client = ClientDAO.getInstance().create("", "", "", "", "", "");
        return client;
    }
    
    public static Animal saveAnimal(){
        Animal animal = AnimalDAO.getInstance().create("", 0, "", getClientSelecionado(), getSpecieSelecionado());
        return animal;
    }
    
    public static Specie saveSpecie(){
        Specie specie = SpecieDAO.getInstance().create("");
        return specie;
    }
    
    public static Vet saveVet(){
        Vet vet = VetDAO.getInstance().create("", "", "", "", "", "");
        return vet;
    }
    
    public static Consult saveConsult(){
        Consult consult = ConsultDAO.getInstance().create(Calendar.getInstance(),8,"",Controller.getAnimalSelecionado(),Controller.getVetSelecionado(),false);
        return consult;
    }
    
     public static Exam saveExam(){
        Exam exam = ExamDAO.getInstance().create("", getConsultSelecionado());
        return exam;
    }
    
    public static boolean deleteClient(){
        List<Animal> animals = AnimalDAO.getInstance().retrieveByClient(getClientSelecionado().getClientId());
        if (animals.isEmpty()) {
            ClientDAO.getInstance().delete(getClientSelecionado().getClientId());
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean deleteSpecie(){
        List<Animal> animals = AnimalDAO.getInstance().retrieveBySpecie(getSpecieSelecionado().getSpecieId());
        if (animals.isEmpty()) {
            SpecieDAO.getInstance().delete(getSpecieSelecionado().getSpecieId());
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean deleteAnimal(){
        List<Consult> consults = ConsultDAO.getInstance().retrieveByAnimal(getAnimalSelecionado().getAnimalId());
        if (consults.isEmpty()){
            AnimalDAO.getInstance().delete(getAnimalSelecionado().getAnimalId());
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean deleteVet(){
        List<Consult> consults = ConsultDAO.getInstance().retrieveByVet(getVetSelecionado().getVetId());
        if (consults.isEmpty()){
            VetDAO.getInstance().delete(getVetSelecionado().getVetId());
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean deleteConsult(){
        List<Consult> consults = ExamDAO.getInstance().retrieveByConsult(getConsultSelecionado().getConsultId());
        if (consults.isEmpty()){
            ConsultDAO.getInstance().delete(getConsultSelecionado().getConsultId());
            return true;
        } else {
            return false;
        }
    }
    
    public static void deleteExam(){
        ExamDAO.getInstance().delete(getExamSelecionado().getExamId());
    }
    
    public static void filterConsults(JTable table, JToggleButton todos, JToggleButton hoje, JToggleButton vet){
        if (table.getModel() instanceof ConsultTableModel){
            String where = "";
            if(!(todos.isSelected()) && (hoje.isSelected()) && (!(vet.isSelected()))){
                where = "WHERE consult_date >= " + new Date((Calendar.getInstance()).getTimeInMillis());
            } else if (!(todos.isSelected()) && (!(hoje.isSelected())) && (vet.isSelected())){
                where = "WHERE id_vet = " + getVetSelecionado().getVetId();
            } else if (!(todos.isSelected()) && ((hoje.isSelected())) && (vet.isSelected())) {
                 where = "WHERE consult_date = date('now') and id_vet = " + getVetSelecionado().getVetId();
            }
             String query = "SELECT * FROM consult " + where + " ORDER BY consult_date, consult_time";
            ((GenericTableModel) table.getModel()).addListOfItems(ConsultDAO.getInstance().retrieve(query));
        }
    }
}
