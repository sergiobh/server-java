package sysfrota.entidades;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Modelo.class)
public abstract class Modelo_ {

	public static volatile SingularAttribute<Modelo, Long> id;
	public static volatile SingularAttribute<Modelo, Short> ano;
	public static volatile SingularAttribute<Modelo, String> nome;
	public static volatile SingularAttribute<Modelo, Fabricante> fabricante;

}

