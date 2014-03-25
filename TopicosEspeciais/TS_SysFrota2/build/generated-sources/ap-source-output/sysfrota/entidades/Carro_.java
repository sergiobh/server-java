package sysfrota.entidades;

import java.util.Calendar;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Carro.class)
public abstract class Carro_ {

	public static volatile SingularAttribute<Carro, Calendar> dataDeAquisicao;
	public static volatile SingularAttribute<Carro, Long> id;
	public static volatile SingularAttribute<Carro, String> cor;
	public static volatile SingularAttribute<Carro, String> chassi;
	public static volatile ListAttribute<Carro, Caracteristica> caracteristicas;
	public static volatile SingularAttribute<Carro, String> placa;
	public static volatile SingularAttribute<Carro, Short> ano;
	public static volatile SingularAttribute<Carro, Modelo> modelo;
	public static volatile SingularAttribute<Carro, Integer> quilometragem;

}

