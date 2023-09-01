package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.service.NegocioException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addErrorMessage;
import static com.algaworks.curso.jpa2.util.jsf.FacesUtil.addSuccessMessage;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

    @Inject
    private CadastroFabricanteService cadastroFabricanteService;

    @Getter @Setter
    private Fabricante fabricante;

    public void salvar() {
        try {
            cadastroFabricanteService.salvar(fabricante);
            limpar();
            addSuccessMessage("Fabricante salvo com sucesso!");
        } catch (NegocioException e) {
            addErrorMessage(e.getMessage());
        }
    }

    @PostConstruct
    public void init() {
        limpar();
    }

    private void limpar() {
        fabricante = new Fabricante();
    }

}
