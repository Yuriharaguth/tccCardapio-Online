package br.edu.ifpr.repository.dao;

import javax.persistence.EntityManager;

import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr.repository.entity.Conta;
import br.edu.ifpr.repository.entity.Mesa;

public class ContaDao {
	
	private EntityManager entityManager;

	public ContaDao(){
		entityManager = HibernateUtil.getEntityManager();
	}
	
	//salva a conta nova
	public Conta merge(Conta conta){
		try{
			entityManager.getTransaction().begin();
			Conta contaRetorno = (Conta) entityManager.merge(conta);
			entityManager.getTransaction().commit();
			return contaRetorno;
		}catch(RuntimeException erro){ 
			System.out.println("ERRO MERGE!");
			throw erro;
		}
		finally{
			//session.close();
		}
	
	}
	
	//busca a conta atual da mesa referente
	public Conta findContaAtual(Mesa mesa){
		try{
			entityManager.getTransaction().begin();;
			Conta conta = (Conta) entityManager.createQuery("from Conta p where p.mesa = ?1 and p.ativo = 1L")
				.setParameter(1, mesa)
				.getSingleResult();
			entityManager.getTransaction().commit();
			return conta;
		}catch (Exception e) {
			System.out.println("Deu ruim CONTA_DAO");
			e.getMessage();
			return null;
		}
	}
	
	//desativa a conta
	public boolean desativarConta(Conta conta ){
		try{
			entityManager.getTransaction().begin();;
			entityManager.createQuery("UPDATE Conta c set c.ativo = 0  where c.id = ?1")
				.setParameter(1, conta)
				.executeUpdate();
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	//desativa a conta
	public boolean desativarContaMesa(Mesa mesa ){
		try{
			entityManager.getTransaction().begin();;
			entityManager.createQuery("UPDATE Conta c set c.ativo = 0  where c.mesa = ?1")
				.setParameter(1, mesa)
				.executeUpdate();
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		ContaDao cDao = new ContaDao();
		
		Mesa mesa = new Mesa();
		mesa.setId(1L);
		
		cDao.desativarContaMesa(mesa);
		
		
		
		System.out.println(conta);
	}
}
