/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arman
 */
public class AnimalModel {
     private String color;
     private String especie;
     private String tipo_Animal;
     private String tipo_Alimento;
     private double peso;
     private String habitad;
     private String altura;
     private int id; // Asegúrate de que tienes un campo para id


     public AnimalModel(){
     }

    public AnimalModel(String color, String especie, String tipo_Animal, String tipo_Alimento, double peso, String habitad, String altura, int id) {
        this.color = color;
        this.especie = especie;
        this.tipo_Animal = tipo_Animal;
        this.tipo_Alimento = tipo_Alimento;
        this.peso = peso;
        this.habitad = habitad;
        this.altura = altura;
        this.id = id;
    }
     
     
     
 // Getter and Setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter and Setter for especie
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    // Getter and Setter for tipoAnimal
    public String getTipoAnimal() {
        return tipo_Animal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipo_Animal = tipoAnimal;
    }

    // Getter and Setter for tipoAlimento
    public String getTipoAlimento() {
        return tipo_Alimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipo_Alimento = tipoAlimento;
    }

    // Getter and Setter for peso
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Getter and Setter for habitad
    public String getHabitad() {
        return habitad;
    }

    public void setHabitad(String habitad) {
        this.habitad = habitad;
    }

    // Getter and Setter for altura
    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AnimalModel{" + "color=" + color + ", especie=" + especie + ", tipo_Animal=" + tipo_Animal + ", tipo_Alimento=" + tipo_Alimento + ", peso=" + peso + ", habitad=" + habitad + ", altura=" + altura + ", id=" + id + '}';
    }
    
     
 
    }

