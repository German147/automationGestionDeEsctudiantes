package com.germanBarrera.utils.web.components.estudiantes.enums;

public enum CourseEnum {
    AÑO_UNICO("AÑO UNICO"),
    PRIMER_AÑO("PRIMER AÑO"),
    SEGUNDO_AÑO("SEGUNDO AÑO");

    private final String curso;


    CourseEnum(String curso) {
        this.curso = curso;
    }

    public String getCurso(){
        return this.curso;
    }
}
