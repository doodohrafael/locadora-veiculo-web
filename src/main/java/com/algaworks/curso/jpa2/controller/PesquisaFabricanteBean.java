package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FabricanteDAO fabricanteDAO;

    @Getter @Setter
    private List<Fabricante> fabricantes = new ArrayList<>();

    @Getter @Setter
    private Fabricante fabricanteSelecionado;

    @PostConstruct
    public void inicializar() {
        fabricantes = fabricanteDAO.buscarTodos();
    }

    public void excluir() {
        try {
            fabricanteDAO.excluir(fabricanteSelecionado);
            fabricantes.remove(fabricanteSelecionado);
            addSuccessMessage("Fabricante excluído com sucesso!");
        } catch (NegocioException e) {
            addErrorMessage(e.getMessage());
        }
    }

}
