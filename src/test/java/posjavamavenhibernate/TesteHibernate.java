package posjavamavenhibernate;

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
	

	@Test
	public void testeUpdate(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(2L , UsuarioPessoa.class);
		
		pessoa.setIdade(10);
		pessoa.setNome("Nome atualizado 2");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
		
	}

}
