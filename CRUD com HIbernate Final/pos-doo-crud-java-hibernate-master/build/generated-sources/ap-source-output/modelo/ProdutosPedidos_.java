package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProdutosPedidos.class)
public abstract class ProdutosPedidos_ {

	public static volatile SingularAttribute<ProdutosPedidos, Double> valorTotalproduto;
	public static volatile SingularAttribute<ProdutosPedidos, Produto> produto;
	public static volatile SingularAttribute<ProdutosPedidos, Pedido> pedido;
	public static volatile SingularAttribute<ProdutosPedidos, Long> id;
	public static volatile SingularAttribute<ProdutosPedidos, Integer> quantidade;
	public static volatile SingularAttribute<ProdutosPedidos, Double> valorUnitario;

}

