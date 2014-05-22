package sysfrota.ui.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import sysfrota.entidades.Fabricante;
import sysfrota.persistence.dao.FabricanteDAO;

@FacesConverter(value = "fabricanteConverter")
public class FabricanteConverter implements Converter {

    FabricanteDAO fabricanteDAO = new FabricanteDAO();

    @Override
    public Fabricante getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Fabricante f = fabricanteDAO.carregarPeloId(Long.valueOf(value));
            return f;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Fabricante) value).getId().toString();
        } else {
            return null;
        }
    }
}
