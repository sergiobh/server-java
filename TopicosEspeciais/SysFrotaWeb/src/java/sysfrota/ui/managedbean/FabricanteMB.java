package sysfrota.ui.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sysfrota.entidades.Fabricante;
import sysfrota.persistence.dao.FabricanteDAO;

@ManagedBean
@SessionScoped
public class FabricanteMB implements Serializable {

    private static final String PAGINA_EDICAO = "/fabricanteEdit.xhtml";
    private static final String PAGINA_LISTAGEM = "/fabricanteList.xhtml";
    private Fabricante fabricante;
    private List<Fabricante> lista;
    private FabricanteDAO fabricanteDAO = new FabricanteDAO();

    public FabricanteMB() {
    }

    @PostConstruct
    private void atualizar() {
        fabricante = new Fabricante();
        lista = fabricanteDAO.listarTodos();
    }

    public String editar(Fabricante fabricante) {
        this.fabricante = fabricanteDAO.carregarPeloId(fabricante.getId());
        return PAGINA_EDICAO;
    }

    public String criar() {
        this.fabricante = new Fabricante();
        return PAGINA_EDICAO;
    }

    public String salvar() {
        fabricanteDAO.salvar(fabricante);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "O fabricante foi salvo com sucesso!", null));
        return irParaListagem();
    }

    public String remover(Fabricante f) {
        fabricanteDAO.remover(f);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "O fabricante foi removido com sucesso!", null));
        return irParaListagem();
    }

    public String irParaListagem() {
        atualizar();
        return PAGINA_LISTAGEM;
    }

    public String cancelar() {
        return irParaListagem();
    }
//getters & setters

    public List<Fabricante> getLista() {
        return lista;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
