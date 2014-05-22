package sysfrota.ui.managedbean;

import sysfrota.persistence.dao.ModeloDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sysfrota.entidades.Fabricante;
import sysfrota.entidades.Modelo;
import sysfrota.persistence.dao.FabricanteDAO;

@ManagedBean
@SessionScoped
public class ModeloMB {

    private static final String PAGINA_EDICAO = "/modeloEdit.xhtml";
    private static final String PAGINA_LISTAGEM = "/modeloList.xhtml";
    Modelo modelo;
    List<Modelo> listaModelos;
    ModeloDAO modeloDAO = new ModeloDAO();
    FabricanteDAO fabricanteDAO = new FabricanteDAO();
    List<Fabricante> listaFabricantes;

    public ModeloMB() {
    }

    @PostConstruct
    private void atualizar() {
        modelo = new Modelo();
        listaModelos = modeloDAO.listarTodos();
        listaFabricantes = fabricanteDAO.listarTodos();
    }

    public String editar(Modelo modelo) {
        atualizar();
        this.modelo = modeloDAO.carregarPeloId(modelo.getId());
        return PAGINA_EDICAO;
    }

    public String criar() {
        this.modelo = new Modelo();
        return PAGINA_EDICAO;
    }

    public String remover(Modelo c) {
        modeloDAO.remover(c);
        return irParaListagem();
    }

    public String salvar() {
        modeloDAO.salvar(modelo);
        return irParaListagem();
    }

    public String cancelar() {
        return irParaListagem();
    }

    public String irParaListagem() {
        atualizar();
        return PAGINA_LISTAGEM;
    }
//getters & setters

    public List<Modelo> getListaModelos() {
        return listaModelos;
    }

    public List<Fabricante> getListaFabricantes() {
        return listaFabricantes;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
