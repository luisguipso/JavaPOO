package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, Pessoa> pessoa;
	public static volatile SingularAttribute<Pedido, Date> data;
	public static volatile SingularAttribute<Pedido, Double> valorTotal;
	public static volatile SingularAttribute<Pedido, Long> id;

}

