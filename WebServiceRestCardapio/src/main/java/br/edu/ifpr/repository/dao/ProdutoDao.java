package br.edu.ifpr.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr._util.exceptions.ExceptionDAO;
import br.edu.ifpr.repository.entity.Categoria;
import br.edu.ifpr.repository.entity.Produto;


public class ProdutoDao {
	
	private EntityManager entityManager;

	public ProdutoDao(){
		entityManager = HibernateUtil.getEntityManager();
	}
	
	public Produto merge(Produto prod) throws ExceptionDAO{
		try{
			entityManager.getTransaction().begin();
			Produto prodRetorno = (Produto) entityManager.merge(prod);
			entityManager.getTransaction().commit();
			return prodRetorno;
		}catch(RuntimeException erro){ 
			erro.printStackTrace();
			throw new ExceptionDAO();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> list(){
		try{
			entityManager.getTransaction().begin();
			List<Produto> produtos = entityManager.createQuery("from Produto").getResultList();
			
			for(Produto cat : produtos){
				System.out.println(cat);
			}
			entityManager.getTransaction().commit();
			return produtos;
		}finally{
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listPorCategoria(Categoria cat) throws ExceptionDAO{
		try{
			entityManager.getTransaction().begin();
			List<Produto> produtos = entityManager.createQuery("from Produto p where p.cat = :cat ")
					.setParameter("cat", cat)
					.getResultList();
			
			for(Produto prod : produtos){
				System.out.println(prod + " print teste");
			}
			entityManager.getTransaction().commit();
			return produtos;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO();
		}
	}
	
	public Produto find(long id){
		try{
			entityManager.getTransaction().begin();
			return entityManager.find(Produto.class, id);
		}finally{
			entityManager.getTransaction().commit();
			//session.close();
		}
	}
	
	public boolean updateCategoria(Produto prod, long id){
		try{
			entityManager.getTransaction().begin();
			entityManager.createQuery("UPDATE Categoria c set c.nome = ?1, c.descricao = ?2, c.qtd = ?3, c.valor = ?4, c.id_categoria = ?5 where c.id = ?6")
				.setParameter(1, prod.getNome())
				.setParameter(2, prod.getDescricao())
				.setParameter(3, prod.getQtd())
				.setParameter(4, prod.getValor())
				.setParameter(5, prod.getCat())
				.setParameter(6, id)
				.executeUpdate();
			entityManager.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}	
	}
	
	public boolean delete(Produto prod){
		try{
			entityManager.getTransaction().begin();
			entityManager.remove(prod);
			entityManager.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}
	}
	public static void main(String[] args) {
		/*
		CategoriaDao catDao = new CategoriaDao();
		Categoria cat = catDao.find(2);
		ProdutoDao prodDao = new ProdutoDao();
		prodDao.listPorCategoria(cat);
		*/
	}

}