package posjavamavenhibernate;

import java.util.List;

import model.UsuarioPessoa;

import org.junit.Ignore;
import org.junit.Test;

import dao.DaoGeneric;

public class TesteHibernate {
	
	@Ignore
	public void testeHibernateUtil(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(43);
		pessoa.setLogin("teste");
		pessoa.setNome("Rudgieri Santoss");
		pessoa.setSenha("123s");
		pessoa.setSobrenome("Santoss");
		pessoa.setEmail("rudgieri.santos@hotmail.com");
		
		daoGeneric.salvar(pessoa);
		
		
	}
	
	@Ignore
	public void testeBuscar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(1L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	
	@Ignore
	public void testeBuscar2(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(2L , UsuarioPessoa.class);
		
		System.out.println(pessoa);
		
	}
	

	@Ignore
	public void testeUpdate(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(2L , UsuarioPessoa.class);
		
		pessoa.setIdade(10);
		pessoa.setNome("Nome atualizado 2");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	@Ignore
	public void testeDelete(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L , UsuarioPessoa.class);
		
		daoGeneric.deletarPorId(pessoa);
				
	}
	
	@Ignore
	public void testeConsultar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for(UsuarioPessoa usuarioPessoa : list){
			System.out.println(usuarioPessoa);
			System.out.println("-------------------------------------------------------------------");
		}
						
	}
	
	@Ignore
	public void testeQueryList(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Ignore
	public void testeQueryListMaxResult(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGeneric.getEntityManager()
				.createQuery(" from UsuarioPessoa order by nome")
				.setMaxResults(2)
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Ignore
	public void testeQueryListParameter(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		List<UsuarioPessoa> list = daoGeneric.
				getEntityManager().createQuery("from UsuarioPessoa where nome = :nome")
				.setParameter("nome", "Rudgieri Santoss").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQuerySomaIdade(){
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		Long somaIdade = (Long) daoGeneric.getEntityManager()
				.createQuery("select sum(u.idade) from UsuarioPessoa u ").getSingleResult();
		
		System.out.println("Soma de todas as idades é -> " +somaIdade);
		
	}
	

}
