package sysfrota.entidades;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Fabricante.class)
public abstract class Fabricante_ {

	public static volatile SingularAttribute<Fabricante, Long> id;
	public static volatile SingularAttribute<Fabricante, String> nome;

}

