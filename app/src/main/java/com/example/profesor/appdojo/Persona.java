package com.example.profesor.appdojo;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 *@author Alumnos
 * @version 1.0
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String telefono;
    private String url;
    private Bitmap img;
    //arraybytes # bitmap

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    /**
     *
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param telefono telefono de la persona
     * @param url url de la Img
     * @param bImagen
     */
    public Persona(String nombre,String apellido, String telefono,String url,Bitmap bImagen)
    {
        this.apellido=apellido;
        this.nombre=nombre;
        this.img=bImagen;
        this.url=url;
        this.telefono=telefono;
    }

    public static List<Persona> obtenerListaPersona(String persona)
    {
        List<Persona> lista = new ArrayList<Persona>();

        String[] lineas = persona.split("\\\n");

        for (String linea: lineas)
        {
            String[] datos = linea.split(";");

            Persona unaPersona = new Persona(datos[0],datos[1],datos[2], datos[3], null );

            lista.add(unaPersona);
        }


        return lista;
    }
}
