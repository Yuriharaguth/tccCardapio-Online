package br.edu.ifpr.produto.dao;

import java.util.List;

import org.hibernate.Session;

import br.edu.ifpr._config.HibernateUtil;
import br.edu.ifpr.produto.pojo.Produto;

public class ProdutoDao {
	
	private Session session;

	public ProdutoDao(){
		session = HibernateUtil.getSession().openSession();
	}

	public boolean create(Produto prod){
		try{
			session.beginTransaction();
			session.save(prod);
			session.getTransaction().commit();
			return true;
			
		}finally{
			//session.close();
		}
	}
	
	public Produto merge(Produto prod){
		try{
			session.beginTransaction();
			Produto prodRetorno = (Produto) session.merge(prod);
			session.getTransaction().commit();
			return prodRetorno;
		}catch(RuntimeException erro){ 
			System.out.println("ERRO MERGE!");
			throw erro;
		}
		finally{
			//session.close();
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> list(){
		try{
			session.beginTransaction();
			List<Produto> produtos = session.createQuery("from Produto").getResultList();
			
			for(Produto cat : produtos){
				System.out.println(cat);
			}
			session.getTransaction().commit();
			return produtos;
		}finally{
			//session.close();
		}
	}
	
	public Produto find(long id){
		try{
			session.beginTransaction();
			return session.get(Produto.class, id);
		}finally{
			session.getTransaction().commit();
			//session.close();
		}
	}
	
	public boolean updateCategoria(Produto prod, long id){
		try{
			session.beginTransaction();
			//session.update(arg0, arg1);
			session.createQuery("UPDATE Categoria c set c.nome = ?1, c.descricao = ?2, c.qtd = ?3, c.valor = ?4, c.id_categoria = ?5 where c.id = ?6")
				.setParameter(1, prod.getNome())
				.setParameter(2, prod.getDescricao())
				.setParameter(3, prod.getQtd())
				.setParameter(4, prod.getValor())
				.setParameter(5, prod.getCat())
				.setParameter(6, id)
				.executeUpdate();
			session.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}	
	}
	
	public boolean delete(Produto prod){
		try{
			session.beginTransaction();
			session.delete(prod);
			session.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}
	}
	public static void main(String[] args) {
		/*
		CategoriaDao catDao = new CategoriaDao();
		Categoria cat = catDao.find(2);
		Produto prod = new Produto("Suco","bebida gelada", 8, 50,cat);
		ProdutoDao prodDao = new ProdutoDao();
		prodDao.create(prod);
		*/
		//ProdutoDao prodDao = new ProdutoDao();
		//prodDao.list();
	}

}
