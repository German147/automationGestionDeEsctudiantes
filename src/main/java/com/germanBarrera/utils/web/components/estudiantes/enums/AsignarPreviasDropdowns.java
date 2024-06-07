package com.germanBarrera.utils.web.components.estudiantes.enums;

public enum AsignarPreviasDropdowns {

    CURSO("#divPrincipal #ddlGraaniTeduc"),
    PLAN_DE_ESTUDIO("#divPrincipal #ddlPlanEstudio1"),
    ESPACIO_CURRICULAR("#divPrincipal #ddlAsignatura1"),
    ADEUDA_POR("#divPrincipal #ddlAdeudaPor"),
    TERCER_MATERIA("#divPrincipal #ddlEsTercerMateria");

    private final String cssLocator;

    AsignarPreviasDropdowns(String cssLocator) {
        this.cssLocator = cssLocator;
    }

    public String getCssLocator() {
        return this.cssLocator;
    }
}
