package sysfrota.entidades;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Caracteristica.class)
public abstract class Caracteristica_ {

	public static volatile SingularAttribute<Caracteristica, Long> id;
	public static volatile SingularAttribute<Caracteristica, String> nome;

}

